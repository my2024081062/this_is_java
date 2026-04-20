package com.mjc813.cookies.models.attach;

import com.mjc813.cookies.models.common.IdName;
import com.mjc813.cookies.models.cookie.CookieEntity;

public interface Attach {
    Long getId();
    void setId(Long id);

    String getFileName();
    void setFileName(String fileName);

    Long getSize();
    void setSize(Long size);

    String getExt();
    void setExt(String ext);

    String getStoredName();
    void setStoredName(String storedName);

    String getPath();
    void setPath(String path);

    Long getCookieId();
    void setCookieId(Long cookieId);

    IdName getCookie();
    void setCookie(IdName cookie);

    default Attach copyMembers(Attach src,Boolean doCopy){
        if(src == null){
            return this;
        }
        if(doCopy || src.getId() != null){
            this.setId(src.getId());
        }
        if(doCopy || src.getFileName() != null){
            this.setFileName(src.getFileName());
        }
        if(doCopy || src.getSize() != null){
            this.setSize(src.getSize());
        }
        if(doCopy || src.getExt() != null){
            this.setExt(src.getExt());
        }
        if(doCopy || src.getStoredName() != null){
            this.setStoredName(src.getStoredName());
        }
        if(doCopy || src.getPath() != null){
            this.setPath(src.getPath());
        }
        if(doCopy || src.getCookieId() != null){
            this.setCookieId(src.getCookieId());
            this.getCookie().copyMembers(src.getCookie(), doCopy);
        }
        return this;
    }
}
