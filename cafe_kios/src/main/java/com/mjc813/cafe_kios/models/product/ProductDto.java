package com.mjc813.cafe_kios.models.product;

import com.mjc813.cafe_kios.models.category.Category;
import com.mjc813.cafe_kios.models.category.CategoryDto;
import com.mjc813.cafe_kios.models.category.CategoryEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductDto implements Product{
    private Integer id;
    private String name;
    private Integer price;
    private CategoryDto category = new CategoryDto();
    private String picture;

    @Override
    public void setCategory(Category category) {
        this.category.copyMembers(category,true);
    }
}
