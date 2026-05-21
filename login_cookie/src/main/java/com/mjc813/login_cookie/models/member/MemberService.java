package com.mjc813.login_cookie.models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberJpaRepository memberJpaRepository;

    public MemberDto insertMember(MemberDto memberDto) {
        MemberEntity insertBefore = (MemberEntity) new MemberEntity().mapper(memberDto,true);
        insertBefore.setId(null);
        insertBefore.setCreateAt(LocalDateTime.now());
        insertBefore.setValidEmail(false);

        MemberEntity insertAfter = memberJpaRepository.save(insertBefore);

        MemberDto result = (MemberDto) new MemberDto().mapper(insertAfter,true);
        return result;
    }

    public MemberDto findById(Long id) {
        MemberEntity find = memberJpaRepository.findById(id).orElseThrow();
        MemberDto result = (MemberDto) new MemberDto().mapper(find,true);
        return result;
    }

    public List<MemberDto> findAll() {
        List<MemberEntity> memberEntities = memberJpaRepository.findAll();
        List<MemberDto> memberDtos = memberEntities.stream()
                .map(
                member -> (MemberDto) new MemberDto().mapper(member,true))
                .toList();
        return memberDtos;
    }

    public MemberDto updateMember(MemberDto memberDto) {
        MemberDto existing = this.findById(memberDto.getId());

        MemberEntity updateBefore = (MemberEntity) new MemberEntity().mapper(existing,true);
        updateBefore.mapper(memberDto,false);

        MemberEntity updateAfter = memberJpaRepository.save(updateBefore);

        MemberDto result = (MemberDto) new MemberDto().mapper(updateAfter,true);
        return result;
    }
}
