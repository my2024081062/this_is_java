package com.mjc813.CheckQuestion;

public class MemberService extends Member {
    public MemberService() {
        super("홍길동", "hong", "12345", 18);
    }

    public boolean login(String id, String password){
        return id.equals(this.id) && password.equals(this.password);
    }
    public void logout(String id){
        System.out.println(id.equals(this.id) ? id + "님이 로그아웃 되었습니다.": "");
    }
}
