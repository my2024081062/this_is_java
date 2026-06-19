package com.example.jwt_start.model.music;

import com.example.jwt_start.common.LoginException;
import com.example.jwt_start.common.Mjc813Exception;
import com.example.jwt_start.common.ResponseCode;
import com.example.jwt_start.model.member.IMember;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MusicService {
	@Autowired
	private MusicJpaRepository musicJpaRepository;

	public MusicDto insert(MusicDto insertDto) throws LoginException, Mjc813Exception {
		IMember signedMember = this.authenticateAndGetSignedMember();
		if (signedMember == null) {
			throw new LoginException("is not valid member");
		}
		MusicEntity musicEntity = (MusicEntity)new MusicEntity().copyMembers(insertDto, true);
		musicEntity.setId(null);
		musicEntity.setCreateId(signedMember.getSignId());
		musicEntity.setCreateDt(LocalDateTime.now());
		MusicEntity saved = this.musicJpaRepository.save(musicEntity);
		MusicDto musicDto = (MusicDto)new MusicDto().copyMembers(saved, true);
		return musicDto;
	}

	public MusicDto findById(Long id) throws Mjc813Exception {
//		MusicEntity musicEntity = this.musicJpaRepository.findById(id).orElseThrow();
//		if(musicEntity.getDeleteId() == null){
//			MusicDto find = (MusicDto)new MusicDto().copyMembers(musicEntity, true);
//			return find;
//		}
//		return null;
//		repository에서 null인지 체크하게 하면 좋다.
		Optional<MusicEntity> musicEntity = this.musicJpaRepository.findByIdAndDeleteIdIsNull(id);
		if (musicEntity.isEmpty()) {
			throw new Mjc813Exception(ResponseCode.DATA_NOT_FOUND_ERROR,"data is not exist");
		}
		MusicDto result = (MusicDto)new MusicDto().copyMembers(musicEntity.get(), true);
		return result;
	}

	public List<MusicDto> findAll() throws Mjc813Exception {
//		List<MusicEntity> musicEntities = this.musicJpaRepository.findAll();
//		AtomicBoolean isContainNull = new AtomicBoolean(false);
//		//하나라도 null이면 isContainNull을 true
//		musicEntities.stream().map(MusicEntity::getDeleteId).forEach(deleteId -> {if(deleteId == null)
//			isContainNull.set(true);
//		});
//		//null인게 하나라도 있으니 null 리턴
//		if(isContainNull.get()) {
//			return null;
//		}
//		List<MusicDto> result = musicEntities.stream().map( item -> (MusicDto)new MusicDto().copyMembers(item, true)).toList();
//		return result;

//		repository에서 null인지 체크하게 하면 좋다.
		IMember signedMember = this.authenticateAndGetSignedMember();
		if ( signedMember == null ) {
			throw new Mjc813Exception(ResponseCode.AUTHORIZATION_ERROR, "authorize is now allow for findAll");
		}
		List<MusicEntity> musicEntities = this.musicJpaRepository.findAllByDeleteIdIsNull();
		if(musicEntities.isEmpty()) {
			throw new Mjc813Exception(ResponseCode.DATA_NOT_FOUND_ERROR,"data is not exist");
		}
		List<MusicDto> result = musicEntities.stream()
				.map(musicEntity -> (MusicDto) new MusicDto().copyMembers(musicEntity,true))
				.toList();
		return result;
	}

	public MusicDto update(MusicDto musicDto) throws Mjc813Exception{
		MusicDto findDto = this.findById(musicDto.getId());
		IMember signedMember = this.authenticateAndGetSignedMember();

        if (signedMember != null) {
            findDto.setUpdateId(signedMember.getSignId());
        }
        findDto.setUpdateDt(LocalDateTime.now());
		findDto.copyMembers(musicDto, false);

		MusicEntity updateEntity = (MusicEntity)new MusicEntity().copyMembers(findDto, true);
		MusicEntity saved = this.musicJpaRepository.save(updateEntity);
		MusicDto result = (MusicDto)new MusicDto().copyMembers(saved, true);
		return result;
	}

	public MusicDto delete(Long musicId) throws Mjc813Exception {
//		this.musicJpaRepository.deleteById(found.getId());
		MusicDto findDto = this.findById(musicId);
		IMember signedMember = this.authenticateAndGetSignedMember();

		if (signedMember != null) {
			findDto.setDeleteId(signedMember.getSignId());
		}
		findDto.setDeleteDt(LocalDateTime.now());

		MusicEntity deleteEntity = (MusicEntity) new MusicEntity().copyMembers(findDto, true);
		MusicEntity deleted = this.musicJpaRepository.save(deleteEntity);
		MusicDto result = (MusicDto)new MusicDto().copyMembers(deleted, true);
		return result;
	}

	private @Nullable IMember authenticateAndGetSignedMember() throws Mjc813Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			throw new Mjc813Exception(ResponseCode.AUTHENTICATION_ERROR, "you need to authenticate");
		}
		IMember signedMember = (IMember) authentication.getPrincipal();
		return signedMember;
	}

	public boolean checkCreatedId(Long musicId) throws Mjc813Exception {
		IMember signedMember = this.authenticateAndGetSignedMember();
		MusicDto musicDto = this.findById(musicId);
        if(signedMember != null && musicDto.getCreateId().equals(signedMember.getSignId())) {
			return true;
		}
		return false;
	}
}
