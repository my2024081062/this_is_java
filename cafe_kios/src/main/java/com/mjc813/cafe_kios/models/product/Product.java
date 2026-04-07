package com.mjc813.cafe_kios.models.product;

import com.mjc813.cafe_kios.models.category.CategoryEntity;
import com.mjc813.cafe_kios.models.category.IdName;

public interface Product extends IdName {
	Integer getPrice();
	void setPrice(Integer price);

    CategoryEntity getCategory();
	void setCategory(CategoryEntity category);

	String getPicture();
	void setPicture(String picture);
    //이거 없으면 Service 가서 직접 다 쳐야함
	default Product copyMembers(Product src) {
        if(src !=null){
            if ( src.getId() != null ) {
                this.setId(src.getId());
            }
            if ( src.getName() != null ) {
                this.setName(src.getName());
            }
            if( src.getPrice() != null){
                this.setPrice(src.getPrice());
            }
            if( src.getCategory() != null){
                this.setCategory(src.getCategory());
            }
            if( src.getPicture() != null){
                this.setPicture(src.getPicture());
            }
        }
        return this;
	}
}
