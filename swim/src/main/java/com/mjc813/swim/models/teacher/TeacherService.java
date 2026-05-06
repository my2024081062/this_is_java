package com.mjc813.swim.models.teacher;

import com.mjc813.swim.models.swimPool.SwimPoolDto;
import com.mjc813.swim.models.swimPool.SwimPoolEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public TeacherDto insert(TeacherDto insertDto) {
        TeacherEntity teacherEntity = (TeacherEntity) new TeacherEntity().copyMembers(insertDto,true);
        teacherEntity.setId(null);
        TeacherEntity save = this.teacherRepository.save(teacherEntity);

        TeacherDto result = (TeacherDto) new TeacherDto().copyMembers(save,true);
        return result;
    }

    public TeacherDto findById(Long id) {
        TeacherEntity find = this.teacherRepository.findJoinAllById(id).orElseThrow();

        TeacherDto result = (TeacherDto) new TeacherDto().copyMembers(find,true);

        return result;
    }

    public TeacherDto update(TeacherDto updateDto) {
//        TeacherEntity find = this.teacherRepository.findById(updateDto.getId()).orElseThrow();
//
//        TeacherEntity updateEntity = (TeacherEntity) new TeacherEntity().copyMembers(find,true);

        TeacherDto find = this.findById(updateDto.getId());
        TeacherEntity updateEntity = (TeacherEntity) find.copyMembers(updateDto,true);
        updateEntity.copyMembers(updateDto,false);

        TeacherEntity save = this.teacherRepository.save(updateEntity);

        TeacherDto result = (TeacherDto) new TeacherDto().copyMembers(save,true);
        return result;
    }

    public TeacherDto deleteById(Long id) {
        TeacherDto find = this.findById(id);
        this.teacherRepository.deleteById(id);
        return find;
    }

    public Slice<TeacherDto> findAllByName(String name, Pageable pageable) {
        Slice<TeacherEntity> slc = this.teacherRepository.findAllByName(name, pageable);
        List<TeacherDto> list = slc.stream()
            .map(entity -> (TeacherDto) new TeacherDto().copyMembers(entity,true))
            .toList();
        Slice<TeacherDto> result = new SliceImpl<>(list,slc.getPageable(),slc.hasNext());

        return result;
    }
}
