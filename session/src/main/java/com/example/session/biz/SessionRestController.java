package com.example.session.biz;

import com.example.session.common.ComResponseDto;
import com.example.session.common.LoginException;
import com.example.session.common.ResponseCode;
import com.example.session.model.auth.SignInDto;
import com.example.session.model.auth.SignUpDto;
import com.example.session.model.member.IMember;
import com.example.session.model.member.MemberDto;
import com.example.session.model.member.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/auth")
public class SessionRestController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private AuthService authService;

    @PostMapping("/sign_up")
    public ResponseEntity<ComResponseDto<IMember>> signUp(@RequestBody SignUpDto singUpDto) {
        MemberDto memberDto = (MemberDto) new MemberDto().mapper(singUpDto,true);

        MemberDto result = this.memberService.insertMember(memberDto,false);

        return ResponseEntity.status(201).body(
                ComResponseDto.make(ResponseCode.SUCCESS, "ok" ,result)
        );
    }

    @PostMapping("/sign_in")
    public ResponseEntity<ComResponseDto<Boolean>> signin(@RequestBody SignInDto signInDto
            , HttpSession session) throws LoginException {
        Boolean isSign = this.authService.signMember(signInDto);
        if ( isSign ) {
            // 정상적으로 로그인(사인인) 되면 세션을 만든다 세션ID를 쿠키에 클라이언트로 응답한다.
            // 이 클라이언트 해당 쿠키를 가지고 다음에 계속 요청한다.
            session.setAttribute("MJC_LOGIN", signInDto);
            session.setMaxInactiveInterval(3600);
            return ResponseEntity.status(200).body(
                    ComResponseDto.make(ResponseCode.SUCCESS, isSign)
            );
        } else {
            return ResponseEntity.status(500).body(
                    ComResponseDto.make(ResponseCode.AUTHENTICATION_ERROR, isSign)
            );
        }
    }

    @GetMapping("/signout")
    public ResponseEntity<ComResponseDto<Boolean>> signout(HttpSession httpSession) {
        httpSession.invalidate();
        return ResponseEntity.status(200).body(
                ComResponseDto.make(ResponseCode.SUCCESS, true)
        );
    }
}
