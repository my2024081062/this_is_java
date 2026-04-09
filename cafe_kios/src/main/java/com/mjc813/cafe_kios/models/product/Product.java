package com.mjc813.cafe_kios.models.product;

import com.mjc813.cafe_kios.models.category.*;

public interface Product{
    Integer getId();
    void setId(Integer id);

    String getName();
    void setName(String name);

	Integer getPrice();
	void setPrice(Integer price);

    Category getCategory();
	void setCategory(Category category);

	String getPicture();
	void setPicture(String picture);
    //이거 없으면 Service 가서 직접 다 쳐야함
	default Product copyMembers(Product src,Boolean doCopy ) {
        if(src !=null){
            if ( doCopy || src.getId() != null ) {
                this.setId(src.getId());
            }
            if ( doCopy || src.getName() != null ) {
                this.setName(src.getName());
            }
            if( doCopy || src.getPrice() != null){
                this.setPrice(src.getPrice());
            }
            if( doCopy || src.getCategory() != null){
                this.getCategory().copyMembers(src.getCategory(),doCopy);
            }
            if( doCopy || src.getPicture() != null){
                this.setPicture(src.getPicture());
            }
        }
        return this;
	}
}
