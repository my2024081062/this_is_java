package com.mjc813.cafe_kios.models.category;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryDto implements Category {
    private Integer id;
    private String name;
}
