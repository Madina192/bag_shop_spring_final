package com.bookStore.bookStore.config;


/*import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;*/

/*@Configuration
@EnableWebMvc*/
public class SecurityConfig {

    /*SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception{
        security.formLogin()
                .loginPage("/login").permitAll().and()
                .formLogin()
                .failureForwardUrl("/register")
                .defaultSuccessUrl("/", true)
                .permitAll().and()
                .authorizeHttpRequests((request) -> request

                        .requestMatchers("/*", "/login*", "/register*", "/css/**", "/images/**","/js/**").permitAll()
                        .anyRequest().authenticated()
                ).logout(LogoutConfigurer::permitAll);
        return security.build();
    }*/
}
