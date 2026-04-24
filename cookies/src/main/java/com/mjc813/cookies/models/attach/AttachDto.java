package com.mjc813.cookies.models.attach;

import com.mjc813.cookies.models.common.IdName;
import com.mjc813.cookies.models.cookie.CookieDto;
import com.mjc813.cookies.models.cookie.CookieEntity;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttachDto implements Attach {
    private Long id;
    private String fileName;
    private Integer size;
    private String ext;
    private String storedName;
    private String path;
    private Long cookieId;
    private CookieDto cookie;

    @Override
    public Long getCookieId() {
        if (this.cookie == null) {
            this.cookie = new CookieDto();
        }
        if (this.cookieId == null) {
            this.cookieId = this.cookie.getId();
        }
        return this.cookie.getId();
    }
    @Override
    public void setCookieId(Long cookieId) {
        if (this.cookie == null) {
            this.cookie = new CookieDto();
        }
        this.cookie.setId(cookieId);
        this.cookieId = cookieId;
    }

    @Override
    public void setCookie(IdName cookie) {
        if( cookie == null ) {
            return;
        }
        if( this.cookie == null ) {
            this.cookie = new CookieDto();
        }
        this.cookie.copyMembers(cookie,true);
        this.cookieId = cookie.getId();
    }
}
