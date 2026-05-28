package com.example.my_login_session.models.music;

import com.example.my_login_session.common.ComResponseDto;
import com.example.my_login_session.common.ResponseCode;
import com.example.my_login_session.models.member.IMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/music")
public class MusicRestController {
	@Autowired
	private MusicService musicService;

	@PostMapping("")
	public ResponseEntity<ComResponseDto<MusicDto>> insert(Model model, @RequestBody MusicDto insertDto) {
//		IMember signedMember = (IMember)model.getAttribute("signedMember");
		// Model 클래스에 "signedMember" 키에 해당하는 MemberDto 가 존재하는지 찾는다.
		IMember signedMember = (IMember)model.getAttribute("signedMember");
		if (signedMember == null || signedMember.getRole().equals("GUEST")) {
			return ResponseEntity.status(500).body(
					ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null));
		}

		MusicDto result = this.musicService.insert(insertDto,signedMember.getSignId());
		return ResponseEntity.status(201).body(
				ComResponseDto.make(ResponseCode.SUCCESS, result)
		);

	}

	@GetMapping("/{musicId}")
	public ResponseEntity<ComResponseDto<MusicDto>> findById(@PathVariable Long musicId) {
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
	public ResponseEntity<ComResponseDto<List<MusicDto>>> findAll(
//			HttpServletRequest request
			@SessionAttribute(name = "MJC_LOGIN", required = false) String signId
	) {
		try {
			if (signId != null) {
				// 로그인 되어 있음
				List<MusicDto> result = this.musicService.findAll();
				if(result == null) {
					return ResponseEntity.status(500).body(
							ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
					);
				}
				return ResponseEntity.status(200).body(
						ComResponseDto.make(ResponseCode.SUCCESS, result)
				);
			} else {
				// 로그인 안되어 있음
				return ResponseEntity.status(500).body(
						ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
				);
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body(
					ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
			);
		}
	}

	@PatchMapping
	public ResponseEntity<ComResponseDto<MusicDto>> update(Model model, @RequestBody MusicDto insertDto) {
		IMember signedMember = (IMember)model.getAttribute("signedMember");
		if (signedMember == null) {
			return ResponseEntity.status(500).body(
					ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
			);
		}
		if(signedMember.getRole().equals("ADMIN") || signedMember.getSignId().equals(insertDto.getCreateId())) {
			MusicDto result = this.musicService.update(insertDto,signedMember.getSignId());
			if(result == null) {
				return ResponseEntity.status(500).body(
						ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
				);
			}
			return ResponseEntity.status(201).body(
					ComResponseDto.make(ResponseCode.SUCCESS, result)
			);
		}
		return ResponseEntity.status(500).body(
				ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
		);
	}

	@DeleteMapping("/{musicId}")
	public ResponseEntity<ComResponseDto<MusicDto>> delete(Model model, @PathVariable Long musicId) {
		IMember signedMember = (IMember)model.getAttribute("signedMember");
		if (signedMember == null) {
			return ResponseEntity.status(500).body(
					ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
			);
		}
		if(signedMember.getRole().equals("ADMIN") || signedMember.getSignId().equals(String.valueOf(musicId))) {
			MusicDto result = this.musicService.delete(musicId,signedMember.getSignId());
			if(result == null) {
				return ResponseEntity.status(500).body(
						ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
				);
			}
			return ResponseEntity.status(201).body(
					ComResponseDto.make(ResponseCode.SUCCESS, result)
			);
		}
		return ResponseEntity.status(500).body(
				ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
		);
	}


}
