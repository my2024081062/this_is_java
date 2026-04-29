package com.mjc813.swim.models.swimPool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SwimPoolService {
    @Autowired
    public SwimPoolRepository swimPoolRepository;

    public SwimPoolDto insert(SwimPoolDto insertDto) {
        log.debug("insert swimPoolDto: {}", insertDto);

        SwimPoolEntity swimPoolEntity = (SwimPoolEntity) new SwimPoolEntity().copyMembers(insertDto,true);
        swimPoolEntity.setId(null);
        SwimPoolEntity save = this.swimPoolRepository.save(swimPoolEntity);

        SwimPoolDto result = (SwimPoolDto) new SwimPoolDto().copyMembers(save,true);

        log.debug("result swimPoolDto: {}", result);
        return result;
    }

    public SwimPoolDto update(SwimPoolDto updateDto) {
//        SwimPoolEntity find = this.swimPoolRepository.findById(updateDto.getId()).orElseThrow();
//
//        SwimPoolEntity updateEntity = (SwimPoolEntity) new SwimPoolEntity().copyMembers(find,true);
        log.debug("update swimPoolDto: {}", updateDto);
        SwimPoolDto find = this.findById(updateDto.getId());
        SwimPoolEntity updateEntity = (SwimPoolEntity) find.copyMembers(updateDto,true);
        updateEntity.copyMembers(updateDto,false);

        SwimPoolEntity save = this.swimPoolRepository.save(updateEntity);

        SwimPoolDto result = (SwimPoolDto) new SwimPoolDto().copyMembers(save,true);
        log.debug("result swimPoolDto: {}", result);
        return result;
    }

    public SwimPoolDto findById(Long id) {
        SwimPoolEntity find = this.swimPoolRepository.findById(id).orElseThrow();

        SwimPoolDto result = (SwimPoolDto) new SwimPoolDto().copyMembers(find,true);

        return result;
    }

    public SwimPoolDto deleteById(Long id) {
        log.debug("delete id: {}", id);
        SwimPoolDto find = this.findById(id);
        this.swimPoolRepository.deleteById(id);
        log.debug("result swimPoolDto: {}", find);
        return find;
    }

    public List<SwimPoolDto> findAll() {
        List<SwimPoolEntity> swimPoolEntities = this.swimPoolRepository.findAll();

        return swimPoolEntities.stream().map(
            swimPoolEntity -> (SwimPoolDto) new SwimPoolDto().copyMembers(swimPoolEntity,true)
        ).toList();
    }
}
