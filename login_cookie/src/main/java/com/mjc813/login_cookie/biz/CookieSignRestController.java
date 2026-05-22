package com.mjc813.login_cookie.biz;

import com.mjc813.login_cookie.common.ComResponseDto;
import com.mjc813.login_cookie.common.ResponseCode;
import com.mjc813.login_cookie.models.auth.SignUpDto;
import com.mjc813.login_cookie.models.member.IMember;
import com.mjc813.login_cookie.models.member.MemberDto;
import com.mjc813.login_cookie.models.member.MemberEntity;
import com.mjc813.login_cookie.models.member.MemberService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/auth")
public class CookieSignRestController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MailService mailService;

    @PostMapping("/sign_up")
    public ResponseEntity<ComResponseDto<IMember>> signUp(@RequestBody SignUpDto singUpDto) {
        MemberDto memberDto = (MemberDto) new MemberEntity().mapper(singUpDto,true);

        this.memberService.insertMember(memberDto,false);

        try {
            this.mailService.sendHtmlEmail(memberDto);
        } catch (MessagingException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(500).body(
                    ComResponseDto.make(ResponseCode.SERVER_ERROR, "error" ,memberDto)
            );
        }
        return ResponseEntity.status(201).body(
                ComResponseDto.make(ResponseCode.SUCCESS, "ok" ,singUpDto)
        );
    }

    @GetMapping("/emailtest/{id}")
    public ResponseEntity<ComResponseDto<MemberDto>> emailTest(@PathVariable Long id) {
        MemberDto find = this.memberService.findById(id);
        try {
            this.mailService.sendHtmlEmail(find);
        } catch (MessagingException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(500).body(
                    ComResponseDto.make(ResponseCode.SERVER_ERROR, "error" , find)
            );
        }
        return ResponseEntity.status(200).body(
                ComResponseDto.make(ResponseCode.SUCCESS, "ok" ,find)
        );
    }
}
