package com.mjc813.cafe_kios.models.sale;

import com.mjc813.cafe_kios.models.product.Product;
import com.mjc813.cafe_kios.models.product.ProductEntity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name="sale")
public class SaleEntity implements Sale{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name="product_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity product;

    @Column(nullable = false)
    private Integer qty;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private LocalDateTime saleTime;

    @Override
    public void setProduct(Product src) {
        if(src == null){
            return;
        }
        this.product.copyMembers(src,true);
    }
}
