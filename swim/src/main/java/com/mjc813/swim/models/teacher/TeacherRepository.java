package com.mjc813.swim.models.teacher;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Long>{
    @EntityGraph(attributePaths = {"swimPool"})
    Optional<TeacherEntity> findJoinAllById(Long id);

    @EntityGraph(attributePaths = {"swimPool"})
    Slice<TeacherEntity> findAllByName(String name, Pageable pageable);
}
