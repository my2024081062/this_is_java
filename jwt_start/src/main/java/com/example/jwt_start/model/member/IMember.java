package com.example.jwt_start.model.member;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface IMember extends UserDetails {
    Long getId();
    void setId(Long id);

    String getSignId();
    void setSignId(String signId);

    String getPassword();
    void setPassword(String password);

    String getEmail();
    void setEmail(String email);

    Boolean getValidEmail();
    void setValidEmail(Boolean validEmail);

    String getValidText();
    void setValidText(String validText);

    Role getRole();
    void setRole(Role role);

    LocalDateTime getCreateAt() ;
    void setCreateAt(LocalDateTime createAt);

    LocalDateTime getUpdateAt();
    void setUpdateAt(LocalDateTime updateAt);

    LocalDateTime getDeleteAt();
    void setDeleteAt(LocalDateTime deleteAt);

    default IMember mapper(IMember src, boolean isForced){
        if(src == null){
            return this;
        }
        if(isForced || src.getId() != null){
            this.setId(src.getId());
        }
        if(isForced || src.getSignId() != null){
            this.setSignId(src.getSignId());
        }
        if(isForced || src.getPassword() != null){
            this.setPassword(src.getPassword());
        }
        if(isForced || src.getEmail() != null){
            this.setEmail(src.getEmail());
        }
        if(isForced || src.getValidEmail() != null){
            this.setValidEmail(src.getValidEmail());
        }
        if(isForced || src.getValidText() != null){
            this.setValidText(src.getValidText());
        }
        if(isForced || src.getRole() != null){
            this.setRole(src.getRole());
        }
        if(isForced || src.getCreateAt() != null){
            this.setCreateAt(src.getCreateAt());
        }
        if(isForced || src.getUpdateAt() != null){
            this.setUpdateAt(src.getUpdateAt());
        }
        if(isForced || src.getDeleteAt() != null){
            this.setDeleteAt(src.getDeleteAt());
        }
        return this;
    }

    @Override
    default Collection<? extends GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(this.getRole().toString()));
        return authorities;
    }

    @Override
    default String getUsername(){
        return this.getSignId();
    }
}
