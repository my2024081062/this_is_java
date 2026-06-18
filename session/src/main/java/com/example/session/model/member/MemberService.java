package com.example.session.model.member;

import com.example.session.common.Mjc813Exception;
import com.example.session.common.ResponseCode;
import com.example.session.common.Util;
import com.example.session.conf.LSHPasswordEncoder;
import com.example.session.model.music.MusicDto;
import com.example.session.model.music.MusicEntity;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MemberService implements UserDetailsService {
    @Autowired
    private MemberJpaRepository memberJpaRepository;

    @Autowired
    private LSHPasswordEncoder passwordEncoder;

    public MemberDto insertMember(MemberDto memberDto, boolean isAdmin) {
        MemberEntity insertBefore = (MemberEntity) new MemberEntity().mapper(memberDto,true);
        insertBefore.setId(null);
        insertBefore.setCreateAt(LocalDateTime.now());
        insertBefore.setPassword(passwordEncoder.encoder().encode(memberDto.getPassword()));
        if ( isAdmin ) {
            insertBefore.setValidEmail(true);
            insertBefore.setRole(Role.USER);
            insertBefore.setValidText(Util.getRandomAllString(12));
        } else {
            insertBefore.setValidEmail(false);
            insertBefore.setRole(Role.GUEST);
            insertBefore.setValidText(Util.getRandomAllString(12));
        }

        MemberEntity insertAfter = this.memberJpaRepository.save(insertBefore);

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
        updateBefore.setUpdateAt(LocalDateTime.now());

        MemberEntity updateAfter = memberJpaRepository.save(updateBefore);

        MemberDto result = (MemberDto) new MemberDto().mapper(updateAfter,true);
        return result;
    }

    public MemberDto delete(Long id) throws Mjc813Exception {
//		this.musicJpaRepository.deleteById(found.getId());
        MemberDto findDto = this.findById(id);
        findDto.setDeleteAt(LocalDateTime.now());

        MemberEntity deleteEntity = (MemberEntity) new MemberEntity().mapper(findDto, true);
        MemberEntity deleted = this.memberJpaRepository.save(deleteEntity);
        MemberDto result = (MemberDto)new MemberDto().mapper(deleted, true);
        return result;
    }

    public MemberDto findBySignId(String signId) {
        Optional<MemberEntity> bySignId = this.memberJpaRepository.findBySignId(signId);
        if ( bySignId.isPresent() ) {
            MemberEntity member = bySignId.get();
            MemberDto result = (MemberDto)new MemberDto().mapper(member, true);
            return result;
        } else {
            return null;
        }
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return this.findBySignId(username);
    }

    public boolean isMine(Long id) throws Mjc813Exception {
        IMember signedMember = this.authenticateAndGetSignedMember();
        if(signedMember != null && Objects.equals(signedMember.getId(), id)) {
            return true;
        }
        return false;
    }

    private @Nullable IMember authenticateAndGetSignedMember() throws Mjc813Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            throw new Mjc813Exception(ResponseCode.AUTHENTICATION_ERROR, "you need to authenticate");
        }
        IMember signedMember = (IMember) authentication.getPrincipal();
        return signedMember;
    }
}
