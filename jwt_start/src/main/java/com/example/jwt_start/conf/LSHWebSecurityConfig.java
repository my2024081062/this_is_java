package com.example.jwt_start.conf;

import com.example.jwt_start.model.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.security.autoconfigure.web.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class LSHWebSecurityConfig{
    private final LSHPasswordEncoder lshEncoder;

    private final MemberService memberService;

    private final LSHAuthenticationFilter lshAuthenticationFilter;

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
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider
                = new DaoAuthenticationProvider(memberService);
        daoAuthenticationProvider.setPasswordEncoder(lshEncoder.encoder());
        return daoAuthenticationProvider;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration){
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                // 스프링 부트가 제공하는 기본 정적 리소스 경로 자동 허용
                // (css, js, images, webjars, favicon 등 포함)
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                // 만약 resources/static 밑에 커스텀 폴더가 있다면 추가 지정
                .requestMatchers("/custom/**");
    }

    @Bean
    public SecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(corsConfigurer ->
                        corsConfigurer
                                .configurationSource(this.corsConfigurationSource())
                )
                .headers(header ->
                        header
                                .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
                )
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
                        authorizationManagerRequestMatcherRegistry
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/signin").permitAll()
                                .requestMatchers("/signup").permitAll()
                                .requestMatchers("/api/v1/auth/**").permitAll()
                                .anyRequest().authenticated()
                        )
                .authenticationProvider(this.daoAuthenticationProvider())
                .addFilterBefore(lshAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
