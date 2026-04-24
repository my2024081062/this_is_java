package com.mjc813.cookies.models.attach;

import com.mjc813.cookies.models.cookie.CookieEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttachService {
    private final AttachRepository attachRepository;

    public AttachDto insert(AttachDto insertDto) {
        AttachEntity attachEntity = (AttachEntity) new AttachEntity().copyMembers(insertDto,true);
        attachEntity.setId(null);

        AttachEntity save = this.attachRepository.save(attachEntity);
        AttachDto result = (AttachDto) new AttachDto().copyMembers(save,true);

        return result;
    }

    public AttachDto update(AttachDto updateDto) {
        //1. 찾기
        AttachEntity find = this.attachRepository.findById(updateDto.getId()).orElseThrow();
        //2. 변경 전 찾은 객체로 copyMembers
        AttachEntity attachEntity = (AttachEntity) new AttachEntity().copyMembers(find,true);
        //3. null인것은 복사하지 않게 위해 false
        attachEntity.copyMembers(updateDto,false);

        AttachEntity save = this.attachRepository.save(attachEntity);
        AttachDto result = (AttachDto) new AttachDto().copyMembers(save,true);

        return result;
    }

    public AttachDto findById(Long id) {
        AttachEntity find = this.attachRepository.findJoinAllById(id).orElseThrow();
        AttachDto result = (AttachDto) new AttachDto().copyMembers(find,true);
        return result;
    }

    public AttachDto deleteById(Long id) {
        AttachDto find = this.findById(id);
        this.attachRepository.deleteById(find.getId());
        return find;
    }

    public Slice<AttachDto> findAllByCookieEquals(Long cookieId, Pageable pageable) {
        CookieEntity cookieEntity = CookieEntity.builder().id(cookieId).build();
        Slice<AttachEntity> slc = this.attachRepository.findAllByCookieEquals(cookieEntity,pageable);
        List<AttachDto> list = slc.stream()
            .map(t -> (AttachDto) new AttachDto().copyMembers(t,true))
            .toList();
        Slice<AttachDto> result = new SliceImpl<>(list,slc.getPageable(),slc.hasNext());
        return result;
    }
}
