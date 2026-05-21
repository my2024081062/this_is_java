package com.mjc813.login_cookie.models.member;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity(name = "member")
@Table(name = "member")
public class MemberEntity implements IMember{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sign_id", length = 20, nullable = false)
    private String signId;

    @Column(name = "password", length = 200, nullable = false)
    private String password;

    @Column(name = "email", length = 200, nullable = false,unique = true)
    private String email;

    @Column(name = "valid_email", nullable = false)
    private Boolean validEmail;

    @Column(name = "create_at", nullable = false)
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @Column(name = "delete_at")
    private LocalDateTime deleteAt;
}
