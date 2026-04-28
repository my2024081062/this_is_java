package com.mjc813.swim.models.swimPool;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwimPoolRepository extends JpaRepository<SwimPoolEntity,Long> {

}
