package Spring.Security.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecConfig {

    @Bean
    public SecurityFilterChain toGetFilter(HttpSecurity req) throws Exception {
        req.csrf(csrf -> csrf.disable()) // Disable CSRF protection
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated()) // Authenticate all requests
                .formLogin(Customizer.withDefaults()) // Enable default form-based login
                .httpBasic(Customizer.withDefaults()) // Enable basic authentication
                .sessionManagement(session -> session.maximumSessions(1)); // Configure session management
        return req.build();
    }
}
