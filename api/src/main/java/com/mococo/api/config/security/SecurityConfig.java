//package com.mococo.api.config.security;
//
//import static org.springframework.http.HttpMethod.GET;
//import static org.springframework.http.HttpMethod.OPTIONS;
//import static org.springframework.http.HttpMethod.POST;
//
//import java.util.Arrays;
//import java.util.List;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.CorsUtils;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
///*
//@Configuration
//@EnableWebSecurity*/
//public class SecurityConfig {
//
//  //  private final UserDetailsService userDetailsService;
//
//    @Value("${origin.ip}")
//    private String origin;
//
//    private final String[] Url = {
//        "/v3/api-docs/**",
//        "/swagger-ui/**",
//        "/swagger-ui.html",
//         "/swagger-ui-custom.html",
//         "/swagger-ui/**",
//         "/accounts/**",
//    };
//
//
//    /**
//     * WebSecurityConfigurerAdapter deprecated로 인한 설정 최신화 참고 https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
//     */
//
//        @Bean
//        protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
//            http
//                    .csrf().disable()
//                    .httpBasic().disable()
//                    .formLogin().disable()
//                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//            http
//                    .authorizeRequests()
//                    .antMatchers(Url).permitAll()
//                    .anyRequest().authenticated();
//
//            return http.build();
//     }
////    @Bean
////    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
////        return http
////            .headers(headers -> headers.cacheControl().disable())
////
////            .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
////
/////*            .httpBasic(AbstractHttpConfigurer::disable)
////
////            .formLogin(AbstractHttpConfigurer::disable)*/
////
////                .formLogin().disable()
////
////            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
////
////            .csrf(AbstractHttpConfigurer::disable)
////
////            .authorizeRequests(request ->
////                request.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
////                    .antMatchers("/","/accounts/join","/accounts/login", "/images/**").permitAll()
////                    .anyRequest().authenticated()
////            )
////
////
////            .logout(logout ->
////                logout.logoutRequestMatcher(new AntPathRequestMatcher("/accounts//logout"))
////                    .logoutSuccessUrl("/")
////            )
////
////            .exceptionHandling(exception ->
////                exception.authenticationEntryPoint((request, response, authException) ->
////                    response.sendRedirect("/accounts/login")
////                )
////            )
////            .build();
////    }
//
////    @Bean
////    public WebSecurityCustomizer configure() {
////        return (web) -> web.ignoring()
////            .antMatchers("/error")
////            .antMatchers("/h2/**")
////            .antMatchers(swaggerUrl)
////
////            ;
////    }
//
//  /*  @Bean
//    public AuthenticationManager authenticationManager(AuthenticationManagerBuilder auth) throws Exception {
//        return auth.userDetailsService(userDetailsService)
//            .passwordEncoder(bCryptPasswordEncoder()).and().build();
//    }
//*/
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
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
