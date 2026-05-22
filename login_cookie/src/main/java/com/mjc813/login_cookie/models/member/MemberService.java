package com.mjc813.login_cookie.models.member;

import com.mjc813.login_cookie.common.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberJpaRepository memberJpaRepository;

    public MemberDto insertMember(MemberDto memberDto,boolean isAdmin) {
        MemberEntity insertBefore = (MemberEntity) new MemberEntity().mapper(memberDto,true);
        insertBefore.setId(null);
        insertBefore.setCreateAt(LocalDateTime.now());
        if ( isAdmin ) {
            insertBefore.setValidEmail(true);
            insertBefore.setRole(Role.USER);
        } else {
            insertBefore.setValidEmail(false);
            insertBefore.setRole(Role.GUEST);
            insertBefore.setValidText(Util.getRandomAllString(12));
        }

        MemberEntity insertAfter = memberJpaRepository.save(insertBefore);

        MemberDto result = (MemberDto) new MemberDto().mapper(insertAfter,true);
        return result;
    }

    public MemberDto findById(Long id) {
        MemberEntity found = memberJpaRepository.findById(id).orElseThrow();
        MemberDto result = (MemberDto) new MemberDto().mapper(found,true);
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
        MemberDto found = this.findById(memberDto.getId());

        MemberEntity updateBefore = (MemberEntity) new MemberEntity().mapper(found,true);
        updateBefore.mapper(memberDto,false);

        MemberEntity updateAfter = memberJpaRepository.save(updateBefore);

        MemberDto result = (MemberDto) new MemberDto().mapper(updateAfter,true);
        return result;
    }
}
