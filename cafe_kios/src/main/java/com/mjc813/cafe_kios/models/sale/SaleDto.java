package com.mjc813.cafe_kios.models.sale;

import com.mjc813.cafe_kios.models.product.Product;
import com.mjc813.cafe_kios.models.product.ProductDto;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SaleDto implements Sale {
    private Integer id;
    private ProductDto product;
    private Integer qty;
    private Integer price;
    private LocalDateTime saleTime;


    @Override
    public void setProduct(Product src) {
        if(src == null){
            return;
        }
        this.product.copyMembers(src,true);
    }
}
