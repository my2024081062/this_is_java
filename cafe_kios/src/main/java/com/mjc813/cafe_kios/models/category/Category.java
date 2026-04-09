package com.mjc813.cafe_kios.models.category;

public interface Category {
    Integer getId();
    void setId(Integer id);
    String getName();
    void setName(String name);

    default Category copyMembers(Category source, Boolean forced) {
        if (source == null) {
            return this;
        }
        if ( forced || source.getId() != null ) {
            this.setId(source.getId());
        }
        if ( forced || source.getName() != null ) {
            this.setName(source.getName());
        }
        return this;
    }
}
