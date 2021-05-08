package si.fri.tpo.pasjehodec.backend.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import si.fri.tpo.pasjehodec.backend.database.repositories.UserRepository;
import si.fri.tpo.pasjehodec.backend.security.filters.AuthenticationFilter;
import si.fri.tpo.pasjehodec.backend.security.filters.AuthorizationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImplementation userDetailsServiceImplementation;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${jwt.expiration-time}")
    private Integer expirationTime;
    @Value("${jwt.refresh-time}")
    private Integer refreshTime;
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/register", "/login")
//                    .permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .addFilter(new AuthenticationFilter(authenticationManager(), expirationTime ,jwtSecret, refreshTime))
//                .addFilter(new AuthorizationFilter(authenticationManager(), jwtSecret, userDetailsServiceImplementation))
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("**").permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImplementation).passwordEncoder(bCryptPasswordEncoder);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
