package com.mjc813.cafe_kios.models.sale;

import com.mjc813.cafe_kios.models.product.Product;

import java.time.LocalDateTime;

public interface Sale {
    Integer getId();
    void setId(Integer id);

    Product getProduct();
    void setProduct(Product product);

    Integer getQty();
    void setQty(Integer qty);

    Integer getPrice();
    void setPrice(Integer price);

    LocalDateTime getSaleTime();
    void setSaleTime(LocalDateTime saleTime);

    default Sale copyMembers(Sale src, Boolean doCopy){
        if( src != null){
            if( doCopy || src.getId() != null){
                this.setId(src.getId());
            }
            if( doCopy || src.getProduct() != null){
                this.getProduct().copyMembers(src.getProduct(), doCopy);
            }
            if( doCopy || src.getQty() != null){
                this.setQty(src.getQty());
            }
            if( doCopy || src.getPrice() != null){
                this.setPrice(src.getPrice());
            }
            if( doCopy || src.getSaleTime() != null){
                this.setSaleTime(src.getSaleTime());
            }
        }
        return this;
    }
}
