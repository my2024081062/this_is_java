package com.example.jwt_start.biz;

import com.example.jwt_start.common.ComResponseDto;
import com.example.jwt_start.common.LoginException;
import com.example.jwt_start.common.ResponseCode;
import com.example.jwt_start.jwt.JwtUtils;
import com.example.jwt_start.model.auth.AuthTokenDto;
import com.example.jwt_start.model.auth.SignInDto;
import com.example.jwt_start.model.auth.SignUpDto;
import com.example.jwt_start.model.member.IMember;
import com.example.jwt_start.model.member.MemberDto;
import com.example.jwt_start.model.member.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class SessionRestController {

    private final MemberService memberService;

    private final AuthenticationManager authenticationManager;

    private final JwtUtils  jwtUtils;

    @PostMapping("/sign_up")
    public ResponseEntity<ComResponseDto<IMember>> signUp(@RequestBody SignUpDto singUpDto) {
        MemberDto memberDto = (MemberDto) new MemberDto().mapper(singUpDto,true);

        MemberDto result = this.memberService.insertMember(memberDto,false);

        return ResponseEntity.status(201).body(
                ComResponseDto.make(ResponseCode.SUCCESS, "ok" ,result)
        );
    }

    @PostMapping("/sign_in")
    public ResponseEntity<ComResponseDto<AuthTokenDto>> signIn(@RequestBody SignInDto signInDto
            , HttpSession session) throws LoginException {
//        Boolean isSign = this.authService.signMember(signInDto);
//        if ( isSign ) {
//            // 정상적으로 로그인(사인인) 되면 세션을 만든다 세션ID를 쿠키에 클라이언트로 응답한다.
//            // 이 클라이언트 해당 쿠키를 가지고 다음에 계속 요청한다.
//            session.setAttribute("MJC_LOGIN", signInDto);
//            session.setMaxInactiveInterval(3600);
//            return ResponseEntity.status(200).body(
//                    ComResponseDto.make(ResponseCode.SUCCESS, isSign)
//            );
//        } else {
//            return ResponseEntity.status(500).body(
//                    ComResponseDto.make(ResponseCode.AUTHENTICATION_ERROR, isSign)
//            );
//        }

        Authentication auth = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInDto.getSignId(),signInDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(auth);

//        session.setAttribute("MJC_LOGIN", signInDto);
//        session.setMaxInactiveInterval(3600);

        String accessToken = this.jwtUtils.generateAccessToken(signInDto.getSignId());
        String refreshToken = this.jwtUtils.generateRefreshToken(signInDto.getSignId());
        AuthTokenDto authTokenDto = new AuthTokenDto(accessToken,refreshToken);
        return ResponseEntity.status(200).body(
                ComResponseDto.make(ResponseCode.SUCCESS, "ok" ,authTokenDto)
        );
    }

    @GetMapping("/signout")
    public ResponseEntity<ComResponseDto<Boolean>> signOut(HttpSession httpSession) {
        httpSession.invalidate();
        return ResponseEntity.status(200).body(
                ComResponseDto.make(ResponseCode.SUCCESS, true)
        );
    }
}
