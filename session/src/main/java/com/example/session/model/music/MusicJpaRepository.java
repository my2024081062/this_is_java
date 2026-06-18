package com.example.session.model.music;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MusicJpaRepository extends JpaRepository<MusicEntity, Long> {
    Optional<MusicEntity> findByIdAndDeleteIdIsNull(long id);
    List<MusicEntity> findAllByDeleteIdIsNull();
}
