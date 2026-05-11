package com.mjc813.swim.models.swimPool;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SwimPoolDto implements  SwimPoolInterface{
    private Long id;
    private String name;
    private String tel;
    private String addr1;
    private String addr2;
    private String lanes;
    private String size;
}
