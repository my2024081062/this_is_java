package com.mjc813.swim.models.swimPool;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "swimPool")
@Table(name = "swimpool")
public class SwimPoolEntity implements SwimPoolInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "tel", length = 20)
    private String tel;

    @Column(name = "addr1", length = 200)
    private String addr1;

    @Column(name = "addr2", length = 200)
    private String addr2;

    @Column(name = "lanes", length = 200)
    private String lanes;

    @Column(name = "size", length = 50)
    private String size;


}
