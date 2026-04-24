package com.mjc813.cookies.models.attach;

import com.mjc813.cookies.models.common.IdName;
import com.mjc813.cookies.models.cookie.CookieDto;
import com.mjc813.cookies.models.cookie.CookieEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AttachEntity implements Attach {
    @Id
    private Long id;
    @Column(name = "file_name", length = 200, nullable = false)
    private String fileName;

    @Column(name = "size", nullable = false)
    private Long size;

    @Column(name = "ext", length = 10, nullable = false)
    private String ext;

    @Column(name = "stored_name", length = 500, nullable = false)
    private String storedName;

    @Column(name = "path", length = 100, nullable = false)
    private String path;

    @Transient
    private Long cookieId;

    @JoinColumn(name = "cookieId", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CookieEntity cookie;

    @Override
    public Long getCookieId() {
        if (this.cookie == null) {
            this.cookie = new CookieEntity();
        }
        if (this.cookieId == null) {
            this.cookieId = this.cookie.getId();
        }
        return this.cookie.getId();
    }
    @Override
    public void setCookieId(Long cookieId) {
        if (this.cookie == null) {
            this.cookie = new CookieEntity();
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
            this.cookie = new CookieEntity();
        }
        this.cookie.copyMembers(cookie,true);
        this.cookieId = cookie.getId();
    }
}
