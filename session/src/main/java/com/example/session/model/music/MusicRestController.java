package com.example.session.model.music;

import com.example.session.common.ComResponseDto;
import com.example.session.common.LoginException;
import com.example.session.common.Mjc813Exception;
import com.example.session.common.ResponseCode;
import com.example.session.model.member.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/music")
public class MusicRestController {
	@Autowired
	private MusicService musicService;

	@PostMapping("")
	@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	public ResponseEntity<ComResponseDto<MusicDto>> insert(@RequestBody MusicDto insertDto) throws LoginException, Mjc813Exception {
//		IMember signedMember = (IMember)model.getAttribute("signedMember");
		// Model 클래스에 "signedMember" 키에 해당하는 MemberDto 가 존재하는지 찾는다.

		MusicDto result = this.musicService.insert(insertDto);
		return ResponseEntity.status(201).body(
				ComResponseDto.make(ResponseCode.SUCCESS, result)
		);

	}

	@GetMapping("/{musicId}")
	public ResponseEntity<ComResponseDto<MusicDto>> findById(@PathVariable Long musicId) throws Mjc813Exception {
		MusicDto find = this.musicService.findById(musicId);
		if(find == null) {
			return ResponseEntity.status(500).body(
					ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null));
		}
		return ResponseEntity.status(200).body(
				ComResponseDto.make(ResponseCode.SUCCESS, find)
		);
	}

	@GetMapping("/all")
	@PreAuthorize("hasAnyAuthority('ADMIN,USER')")
	public ResponseEntity<ComResponseDto<List<MusicDto>>> findAll (
//			HttpServletRequest request
//			@SessionAttribute(name = "MJC_LOGIN", required = false) String signId
	) throws Mjc813Exception {
//		try {
//			if (signId != null) {
//				// 로그인 되어 있음
//				List<MusicDto> result = this.musicService.findAll();
//				return ResponseEntity.status(200).body(
//						ComResponseDto.make(ResponseCode.SUCCESS, result)
//				);
//			} else {
//				// 로그인 안되어 있음
//				return ResponseEntity.status(500).body(
//						ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
//				);
//			}
//		} catch (Mjc813Exception m8e){
//			throw m8e;
//		} catch (Exception e) {
//			return ResponseEntity.status(500).body(
//					ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
//			);
//		}
		List<MusicDto> findAll = this.musicService.findAll();
		return ResponseEntity.status(200).body(
				ComResponseDto.make(ResponseCode.SUCCESS, findAll)
		);
	}

	@PatchMapping
	@PreAuthorize("hasAnyAuthority('ADMIN') or @musicService.checkCreatedId(#updateDto.id)")
	public ResponseEntity<ComResponseDto<MusicDto>> update(@RequestBody MusicDto updateDto) throws Mjc813Exception{
//		IMember signedMember = (IMember)model.getAttribute("signedMember");

		MusicDto result = this.musicService.update(updateDto);
		return ResponseEntity.status(200).body(
				ComResponseDto.make(ResponseCode.SUCCESS, result)
		);
	}

	@DeleteMapping("/{musicId}")
	@PreAuthorize("hasAnyAuthority('ADMIN') or @musicService.checkCreatedId(#musicId)")
	public ResponseEntity<ComResponseDto<MusicDto>> delete(@PathVariable Long musicId
		,@AuthenticationPrincipal MemberDto signedMember
	) throws Mjc813Exception {
//		IMember signedMember = (IMember)model.getAttribute("signedMember");

//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		IMember signedMember = (IMember) authentication.getPrincipal();
		MusicDto result = this.musicService.delete(musicId);
		return ResponseEntity.status(200).body(
				ComResponseDto.make(ResponseCode.SUCCESS, result)
		);
	}
}
