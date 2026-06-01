package com.example.my_login_session.models.music;

import com.example.my_login_session.common.Mjc813Exception;
import com.example.my_login_session.common.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MusicService {
	@Autowired
	private MusicJpaRepository musicJpaRepository;

	public MusicDto insert(MusicDto insertDto, String signId) {
		MusicEntity musicEntity = (MusicEntity)new MusicEntity().copyMembers(insertDto, true);
		musicEntity.setId(null);
		musicEntity.setCreateId(signId);
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
		List<MusicEntity> musicEntities = this.musicJpaRepository.findAllByDeleteIdIsNull();
		if(musicEntities.isEmpty()) {
			throw new Mjc813Exception(ResponseCode.DATA_NOT_FOUND_ERROR,"data is not exist");
		}
		List<MusicDto> result = musicEntities.stream()
				.map(musicEntity -> (MusicDto) new MusicDto().copyMembers(musicEntity,true))
				.toList();
		return result;
	}

	public MusicDto update(MusicDto musicDto, String signId) throws Mjc813Exception{
		MusicDto updateDto = this.findById(musicDto.getId());
		MusicEntity updateEntity = (MusicEntity)new MusicEntity().copyMembers(updateDto, true);
		updateEntity.copyMembers(musicDto, false);
		updateEntity.setUpdateId(signId);
		updateEntity.setUpdateDt(LocalDateTime.now());

		MusicEntity saved = this.musicJpaRepository.save(updateEntity);
		MusicDto result = (MusicDto)new MusicDto().copyMembers(saved, true);
		return result;
	}

	public MusicDto delete(Long musicId, String signId) throws Mjc813Exception {
		MusicDto found = this.findById(musicId);
//		this.musicJpaRepository.deleteById(found.getId());
		MusicEntity deleting = (MusicEntity)new MusicEntity().copyMembers(found, true);
		deleting.setDeleteId(signId);
		deleting.setDeleteDt(LocalDateTime.now());
		MusicEntity deleted = this.musicJpaRepository.save(deleting);
		MusicDto result = (MusicDto)new MusicDto().copyMembers(deleted, true);
		return result;
	}
}
