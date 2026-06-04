package com.example.my_login_spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MyPasswordEncoder {

    @Bean
    public PasswordEncoder passwordEncoder() {
        //한번 결정한 엔코더 변경금지
        return new BCryptPasswordEncoder();
    }
}
