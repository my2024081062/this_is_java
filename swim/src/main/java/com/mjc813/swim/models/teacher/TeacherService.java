package com.mjc813.swim.models.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public TeacherDto update(TeacherDto updateDto) {
        TeacherEntity find = this.teacherRepository.findById(updateDto.getId()).orElseThrow();

        TeacherEntity updateEntity = (TeacherEntity) new TeacherEntity().copyMembers(find,true);
        updateEntity.copyMembers(updateEntity,false);

        TeacherEntity save = this.teacherRepository.save(updateEntity);

        TeacherDto result = (TeacherDto) new TeacherDto().copyMembers(save,true);
        return result;
    }

    public TeacherDto findById(Long id) {
        TeacherEntity find = this.teacherRepository.findJoinAllById(id).orElseThrow();

        TeacherDto result = (TeacherDto) new TeacherDto().copyMembers(find,true);

        return result;
    }

    public TeacherDto deleteById(Long id) {
        TeacherDto find = this.findById(id);
        this.teacherRepository.deleteById(id);
        return find;
    }
}
