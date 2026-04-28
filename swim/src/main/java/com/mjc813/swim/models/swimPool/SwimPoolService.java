package com.mjc813.swim.models.swimPool;

import com.mjc813.swim.models.teacher.TeacherDto;
import com.mjc813.swim.models.teacher.TeacherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwimPoolService {
    @Autowired
    public SwimPoolRepository swimPoolRepository;

    public SwimPoolDto insert(SwimPoolDto swimPoolDto) {
        SwimPoolEntity swimPoolEntity = (SwimPoolEntity) new SwimPoolEntity().copyMembers(swimPoolDto,true);
        swimPoolEntity.setId(null);
        SwimPoolEntity save = this.swimPoolRepository.save(swimPoolEntity);

        SwimPoolDto result = (SwimPoolDto) new SwimPoolDto().copyMembers(save,true);

        return result;
    }

    public SwimPoolDto update(SwimPoolDto updateDto) {
        SwimPoolEntity find = this.swimPoolRepository.findById(updateDto.getId()).orElseThrow();

        SwimPoolEntity updateEntity = (SwimPoolEntity) new SwimPoolEntity().copyMembers(find,true);
        updateEntity.copyMembers(updateEntity,false);

        SwimPoolEntity save = this.swimPoolRepository.save(updateEntity);

        SwimPoolDto result = (SwimPoolDto) new SwimPoolDto().copyMembers(save,true);
        return result;
    }

    public SwimPoolDto findById(Long id) {
        SwimPoolEntity find = this.swimPoolRepository.findById(id).orElseThrow();

        SwimPoolDto result = (SwimPoolDto) new SwimPoolDto().copyMembers(find,true);

        return result;
    }

    public SwimPoolDto deleteById(Long id) {
        SwimPoolDto find = this.findById(id);
        this.swimPoolRepository.deleteById(id);
        return find;
    }
}
