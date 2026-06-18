package com.example.my_login_spring_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class MyWebSecurityConfig {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public MyAuthFilter myAuthFilter() {
        return new MyAuthFilter();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider(userDetailsService);
        dao.setPasswordEncoder(passwordEncoder);
        return dao;
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        //cors 설정, 다른 사이트 주소에서 어떤 것을 허용하고, 불허하는 설정 (메소드,헤더,인증정보 설정)
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOriginPatterns(List.of("*"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PATCH", "DELETE", "OPTIONS")); // 메소드 허용
        corsConfiguration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type")); //헤더 허용
        corsConfiguration.setAllowCredentials(true); //인증 정보 허용
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //filterChain은 체인처럼 연속으로 작동하는 메소드, 체인을 걸어주듯이 매개변수를 리턴해줘야한다. (다음 필터에서 실행하게)
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(httpSecurityCorsConfigurer ->
                        httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource()))
                .headers(header->
                        header.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
                        authorizationManagerRequestMatcherRegistry
                                .requestMatchers("/").permitAll() //permitAll 이 주소는 인증,인가가 필요없다.
                                .requestMatchers("/signup").permitAll()
                                .requestMatchers("/signin").permitAll()
                                .requestMatchers("/api/v1/auth/**").permitAll()
                                .requestMatchers("/js/**").permitAll()
                                .requestMatchers("/css/**").permitAll()
                                .anyRequest().authenticated() //anyRequest() 위 설정한 주소 이외의 모든 주소
                                                            //authenticated 이 주소는 인증,인가가 필요하다.
                                                            //hasAnyAuthority 이 주소는 인증,인가가 필요하고, role이 같아야한다.
                        )
                .authenticationProvider(daoAuthenticationProvider())
                .addFilterBefore(myAuthFilter(), UsernamePasswordAuthenticationFilter.class);
        //마지막에 filterChain을 다음 단계에서 실행 할 수 있도록 return
        return http.build();
    }

}
