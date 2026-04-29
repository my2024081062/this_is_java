package com.mjc813.swim.models.teacher;

import com.mjc813.swim.models.swimPool.SwimPoolEntity;
import com.mjc813.swim.models.swimPool.SwimPoolInterface;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "teacher")
public class TeacherEntity implements TeacherInterface{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 5, nullable = false)
    private String name;

    @Column(name = "main",length = 5, nullable = false)
    private String main;

    @Column(name = "birth_year")
    private Integer birthYear;

    @Transient
    private Long swimPoolId;

    @JoinColumn(name = "swim_pool_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER) //casCade도 잘 설정 해야함
    private SwimPoolEntity swimPool;

    @Override
    public Long getSwimPoolId() {
        if(this.swimPool == null){
            this.swimPool =  new SwimPoolEntity();
        }
        if(this.swimPool.getId() != null){
            this.swimPoolId = this.swimPool.getId();
        }
        return this.swimPool.getId();
    }
    @Override
    public void setSwimPoolId(Long swimPoolId) {
        if(this.swimPool == null){
            this.swimPool = new SwimPoolEntity();
        }
        this.swimPool.setId(swimPoolId);
        this.swimPoolId = swimPoolId;
    }

    @Override
    public void setSwimPool(SwimPoolInterface swimPool) {
        if(swimPool == null){
            return;
        }
        if(this.swimPool == null){
            this.swimPool = new SwimPoolEntity();
        }
        this.swimPool.copyMembers(swimPool,true);
        this.swimPoolId = swimPool.getId();
    }

}
