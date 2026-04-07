package com.mjc813.cafe_kios.models.product;

import com.mjc813.cafe_kios.models.category.CategoryEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDto implements Product{
    private Integer id;
    private String name;
    private Integer price;
    private CategoryEntity category;
    private String picture;

}
