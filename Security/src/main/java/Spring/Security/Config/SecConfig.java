package Spring.Security.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;

@Configuration
public class SecConfig {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain toGetFilter(HttpSecurity req) throws Exception {
        req.csrf(csrf -> csrf.disable());
        req.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        req.httpBasic(Customizer.withDefaults());
        req.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return req.build();
    }

    @Bean
    public UserDetailsService user() {
        UserDetails user = User.builder()
                .username("Kishore Ram M")
                .password(encoder().encode("KRM143"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    public AuthenticationProvider  AP()
    {
        DaoAuthenticationProvider provider =  new DaoAuthenticationProvider();
        provider.setPasswordEncoder(PasswordEncoder);
        provider.setUserDetailsService();
        return  provider;
    }
}
