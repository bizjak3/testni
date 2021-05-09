package si.fri.tpo.pasjehodec.backend.security.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import si.fri.tpo.pasjehodec.backend.constants.JwtConstants;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserType;
import si.fri.tpo.pasjehodec.backend.security.UserDetailsServiceImplementation;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthorizationFilter extends BasicAuthenticationFilter {

    private final String jwtSecret;
    private final UserDetailsServiceImplementation userDetailsServiceImplementation;

    public AuthorizationFilter(AuthenticationManager authenticationManager, String jwtSecret, UserDetailsServiceImplementation userDetailsServiceImplementation) {
        super(authenticationManager);
        this.jwtSecret = jwtSecret;
        this.userDetailsServiceImplementation = userDetailsServiceImplementation;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(JwtConstants.AUTHORIZATION_HEADER_NAME);
        if (header == null || !header.startsWith(JwtConstants.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(JwtConstants.AUTHORIZATION_HEADER_NAME);
        if (token != null) {
            token = token.replace(JwtConstants.TOKEN_PREFIX, "");
            String user = JWT.require(Algorithm.HMAC512(jwtSecret.getBytes()))
                    .build()
                    .verify(token.replace(JwtConstants.TOKEN_PREFIX, ""))
                    .getSubject();

            if (user != null) {
                var userEntity = userDetailsServiceImplementation.loadUserByUsername(user);
                var authorities = new ArrayList<GrantedAuthority>();
                if(userEntity.getIsAdmin())
                    authorities.add(new SimpleGrantedAuthority(UserType.ADMIN));
                if(userEntity.getIsDogOwner())
                    authorities.add(new SimpleGrantedAuthority(UserType.DOG_OWNER));
                if(userEntity.getIsServiceWorker())
                    authorities.add(new SimpleGrantedAuthority(UserType.SERVICE_WORKER));

                return new UsernamePasswordAuthenticationToken(
                        userEntity,
                        null,
                        authorities);
            }
            return null;
        }
        return null;
    }
}
