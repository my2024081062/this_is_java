package com.example.session.model.member;

import com.example.session.common.ComResponseDto;
import com.example.session.common.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/member")
public class MemberRestController {
    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<ComResponseDto<MemberDto>> insertMember(@RequestBody MemberDto insertMember) {
        MemberDto memberDto = memberService.insertMember(insertMember,true);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                ComResponseDto.make(ResponseCode.SUCCESS,"ok",memberDto));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ComResponseDto<MemberDto>> findMemberById(@PathVariable Long id) {
        MemberDto memberDto = memberService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(
                ComResponseDto.make(ResponseCode.SUCCESS,"ok",memberDto));
    }

    @GetMapping("/find_all")
    public ResponseEntity<ComResponseDto<List<MemberDto>>> findAll(Model model) {
        Object obj = model.getAttribute("signedMember");
        if(obj instanceof IMember signedMember) {
            if(!signedMember.getRole().equals(Role.ADMIN)){
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
                        ComResponseDto.make(ResponseCode.AUTHENTICATION_ERROR,"error",null));
            }
        }
        List<MemberDto> memberDtos = memberService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(
                ComResponseDto.make(ResponseCode.SUCCESS,"ok",memberDtos));
    }


    @PatchMapping
    public ResponseEntity<ComResponseDto<MemberDto>> updateMember(@RequestBody MemberDto insertMember) {
        MemberDto memberDto = memberService.updateMember(insertMember);
        return ResponseEntity.status(HttpStatus.OK).body(
                ComResponseDto.make(ResponseCode.SUCCESS,"ok",memberDto));
    }
}
