package com.mjc813.login_cookie.models.member;

import java.time.LocalDateTime;

public class MemberDto {
    private Long id;
    private String signId;
    private String password;
    private String email;
    private Boolean valid_email;
    private LocalDateTime create_at;
    private LocalDateTime update_at;
    private LocalDateTime delete_at;
}
