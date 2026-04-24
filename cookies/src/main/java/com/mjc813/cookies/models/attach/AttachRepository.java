package com.mjc813.cookies.models.attach;

import com.mjc813.cookies.models.cookie.CookieEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttachRepository extends JpaRepository<AttachEntity, Long> {
    @EntityGraph(attributePaths = {"cookie"})
    Optional<AttachEntity> findJoinAllById(Long id);

    Slice<AttachEntity> findAllByCookieEquals(CookieEntity cookie, Pageable pageable);
}
