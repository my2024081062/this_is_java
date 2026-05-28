package com.example.my_login_session.models.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

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

	public MusicDto findById(Long id) {
		MusicEntity musicEntity = this.musicJpaRepository.findById(id).orElseThrow();
		if(musicEntity.getDeleteId() == null){
			MusicDto find = (MusicDto)new MusicDto().copyMembers(musicEntity, true);
			return find;
		}
		return null;
	}

	public List<MusicDto> findAll() {
		List<MusicEntity> musicEntities = this.musicJpaRepository.findAll();
		AtomicBoolean isContainNull = new AtomicBoolean(false);
		//하나라도 null이면 isContainNull을 true
		musicEntities.stream().map(MusicEntity::getDeleteId).forEach(deleteId -> {if(deleteId == null)
			isContainNull.set(true);
		});
		//null인게 하나라도 있으니 null 리턴
		if(isContainNull.get()) {
			return null;
		}
		List<MusicDto> result = musicEntities.stream().map( item -> (MusicDto)new MusicDto().copyMembers(item, true)).toList();
		return result;
	}

	public MusicDto update(MusicDto musicDto, String signId) {
		MusicDto found = this.findById(musicDto.getId());
		if(found == null){
			return null;
		}
		MusicEntity updated = (MusicEntity)new MusicEntity().copyMembers(found, true);
		updated.copyMembers(musicDto, false);
		updated.setUpdateId(signId);
		updated.setUpdateDt(LocalDateTime.now());

		MusicEntity saved = this.musicJpaRepository.save(updated);
		MusicDto result = (MusicDto)new MusicDto().copyMembers(saved, true);
		return result;
	}

	public MusicDto delete(Long musicId, String signId) {
		MusicDto found = this.findById(musicId);
		if(found == null){
			return null;
		}
		found.setDeleteId(signId);
		found.setDeleteDt(LocalDateTime.now());
//		this.musicJpaRepository.deleteById(found.getId());
		MusicEntity delete = (MusicEntity)new MusicEntity().copyMembers(found, true);
		MusicEntity deleted = this.musicJpaRepository.save(delete);
		MusicDto result = (MusicDto)new MusicDto().copyMembers(deleted, true);
		return result;
	}
}
