package si.fri.tpo.pasjehodec.backend.security.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import si.fri.tpo.pasjehodec.backend.constants.JwtConstants;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserType;
import si.fri.tpo.pasjehodec.backend.dtos.mappers.UserEntityMapper;
import si.fri.tpo.pasjehodec.backend.dtos.models.login_register.LoginDto;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final Integer expirationTime;
    private final String jwtSecret;
    private final Integer refreshTime;

    public AuthenticationFilter(AuthenticationManager authenticationManager, String jwtSecret, Integer expirationTime, Integer refreshTime) {
        super(authenticationManager);
        this.authenticationManager = authenticationManager;
        this.expirationTime = expirationTime;
        this.jwtSecret = jwtSecret;
        this.refreshTime = refreshTime;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            LoginDto loginDto = new ObjectMapper()
                    .readValue(request.getInputStream(), LoginDto.class);
            UserEntityMapper mapper = new UserEntityMapper();
            UserEntity userEntity = mapper.mapUserEntityFromLoginDto(loginDto);

            var authorities = new ArrayList<GrantedAuthority>();
            if(userEntity.getIsAdmin())
                authorities.add(new SimpleGrantedAuthority(UserType.ADMIN));
            if(userEntity.getIsDogOwner())
                authorities.add(new SimpleGrantedAuthority(UserType.DOG_OWNER));
            if(userEntity.getIsServiceWorker())
                authorities.add(new SimpleGrantedAuthority(UserType.SERVICE_WORKER));

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userEntity.getUsername(),
                            userEntity.getPassword(),
                            authorities
                    )
            );
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String token = JWT.create()
                .withSubject(((UserEntity) authResult.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
                .sign(Algorithm.HMAC512(jwtSecret.getBytes(StandardCharsets.UTF_8)));

        response.addHeader(
                JwtConstants.EXPOSE_HEADER_NAME,
                String.format("%s, %s", JwtConstants.AUTHORIZATION_HEADER_NAME, JwtConstants.REFRESH_TIME_HEADER_NAME)
        );
        response.addHeader(JwtConstants.AUTHORIZATION_HEADER_NAME, JwtConstants.TOKEN_PREFIX + token);
        response.addHeader(JwtConstants.REFRESH_TIME_HEADER_NAME, refreshTime.toString());

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
    }
}
