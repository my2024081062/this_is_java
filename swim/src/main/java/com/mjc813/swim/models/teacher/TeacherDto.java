package com.mjc813.swim.models.teacher;

import com.mjc813.swim.models.swimPool.SwimPoolDto;
import com.mjc813.swim.models.swimPool.SwimPoolEntity;
import com.mjc813.swim.models.swimPool.SwimPoolInterface;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherDto implements TeacherInterface {
    private Long id;
    private String name;
    private String main;
    private Integer birthYear;
    private Long swimPoolId;
    private SwimPoolDto swimPool;

    @Override
    public Long getSwimPoolId() {
        if(this.swimPool == null){
            this.swimPool =  new SwimPoolDto();
        }
        if(this.swimPool.getId() != null){
            this.swimPoolId = this.swimPool.getId();
        }
        return this.swimPool.getId();
    }
    @Override
    public void setSwimPoolId(Long swimPoolId) {
        if(this.swimPool == null){
            this.swimPool = new SwimPoolDto();
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
            this.swimPool = new SwimPoolDto();
        }
        this.swimPool.copyMembers(swimPool,true);
        this.swimPoolId = swimPool.getId();
    }
}
