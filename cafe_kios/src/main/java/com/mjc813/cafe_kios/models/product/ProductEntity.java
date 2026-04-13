package com.mjc813.cafe_kios.models.product;

import com.mjc813.cafe_kios.models.category.Category;
import com.mjc813.cafe_kios.models.category.CategoryDto;
import com.mjc813.cafe_kios.models.category.CategoryEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity(name = "product")
@NamedEntityGraph(name = "ProductEntity.fetchCategory", attributeNodes = {
    @NamedAttributeNode(value = "category")
})
public class ProductEntity implements Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @JoinColumn(name = "category_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private CategoryEntity category  = new CategoryEntity();

    @Column(length = 500, nullable = true)
    private String picture;

    @Override
    public void setCategory(Category category) {
        this.category.copyMembers(category,true);
    }
}
