package com.mococo.api.config.security;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.OPTIONS;
import static org.springframework.http.HttpMethod.POST;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


//    @Value("${origin.ip}")
//    private String origin;

    private final String[] Url = {
        "/v3/api-docs/**",
        "/swagger-ui/**",
        "/swagger-ui.html",
         "/swagger-ui-custom.html",
         "/swagger-ui/**",
         "/accounts/**",
         "/api/**",
         "/images/**",
         "/h2/**",
    };

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
            .headers(headers -> headers.cacheControl().disable())
            .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
/*            .httpBasic(AbstractHttpConfigurer::disable)*/

            .formLogin().disable()
            .cors().disable()
            .csrf().disable()

            .authorizeRequests(request ->
                request.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                    .antMatchers(Url).permitAll()
                    .anyRequest().authenticated()
            )


            .logout(logout ->
                logout.logoutRequestMatcher(new AntPathRequestMatcher("/accounts/logout"))
                    .logoutSuccessUrl("/")
            )

            .exceptionHandling(exception ->
                exception.authenticationEntryPoint((request, response, authException) ->
                    response.sendRedirect("/accounts/login")
                )
            )
            .build();
    }

//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationManagerBuilder auth) throws Exception {
//        return auth.userDetailsService(userDetailsService)
//            .passwordEncoder(bCryptPasswordEncoder()).and().build();
//    }
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(List.of(origin));
//        configuration.setAllowedMethods(List.of(GET.name(), POST.name(), OPTIONS.name()));
//        configuration.setAllowedHeaders(Arrays.asList("Accept", "Origin", "Host", "Content-Type", "User-Agent"));
//        configuration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
