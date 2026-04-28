package com.mjc813.swim.models.swimPool;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "swimPool")
public class SwimPoolEntity implements SwimPoolInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "tel", length = 20, nullable = false)
    private String tel;

    @Column(name = "addr1", length = 50, nullable = false)
    private String addr1;

    @Column(name = "addr2", length = 10, nullable = false)
    private String addr2;

    @Column(name = "line", length = 30, nullable = false)
    private String line;

    @Column(name = "size", length = 10, nullable = false)
    private String size;


}
