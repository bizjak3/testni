package si.fri.tpo.pasjehodec.backend.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import si.fri.tpo.pasjehodec.backend.database.repositories.UserRepository;
import si.fri.tpo.pasjehodec.backend.security.filters.AuthenticationFilter;
import si.fri.tpo.pasjehodec.backend.security.filters.AuthorizationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
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
        // to je "produkcijska" verzija
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/register/**", "/docs/**")
                    .permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new AuthenticationFilter(authenticationManager(), jwtSecret, expirationTime , refreshTime))
                .addFilter(new AuthorizationFilter(authenticationManager(), jwtSecret, userDetailsServiceImplementation))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // to je testna/razvojna verzija brez varnosti (načeloma ne uporabljaj)
//        http.cors().and().csrf().disable().authorizeRequests()
//                .antMatchers("**").permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImplementation).passwordEncoder(bCryptPasswordEncoder);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        var configuration = new CorsConfiguration().applyPermitDefaultValues();
        configuration.addAllowedMethod("PUT");
        configuration.addAllowedMethod("DELETE");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
