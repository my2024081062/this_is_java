package com.mjc813.cafe_kios.models.sale;

import com.mjc813.cafe_kios.models.category.IdName;
import com.mjc813.cafe_kios.models.product.ProductEntity;

import java.time.LocalDateTime;

public interface Sale {
    Integer getId();
    void setId(Integer id);

    ProductEntity getProductId();
    void setProductId(ProductEntity productId);

    Integer getQty();
    void setQty(Integer qty);

    Integer getPrice();
    void setPrice(Integer price);

    LocalDateTime getSaleTime();
    void setSaleTime(LocalDateTime saleTime);

    default Sale copyMembers(Sale src){
        if(src !=null){
            if( src.getId() != null){
                this.setId(src.getId());
            }
            if( src.getProductId() != null){
                this.setProductId(src.getProductId());
            }
            if( src.getQty() != null){
                this.setQty(src.getQty());
            }
            if( src.getPrice() != null){
                this.setPrice(src.getPrice());
            }
            if( src.getSaleTime() != null){
                this.setSaleTime(src.getSaleTime());
            }
        }
        return this;
    }
}
