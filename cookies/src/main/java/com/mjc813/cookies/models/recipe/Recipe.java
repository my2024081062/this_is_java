package com.mjc813.cookies.models.recipe;

import com.mjc813.cookies.models.cookie.CookieDto;
import com.mjc813.cookies.models.ingredient.IngredientDto;

import java.math.BigDecimal;

public interface Recipe {
    Long getId();
    void setId(Long id);

    CookieDto getCookie();
    public void setCookie(CookieDto cookie);

    public Long getCookieId() ;
    public void setCookieId(Long cookieId);

    public IngredientDto getIngredient() ;
    public void setIngredient(IngredientDto ingredient);

    public Long getIngredientId() ;
    public void setIngredientId(Long ingredientId) ;

    public RecipeUnit getUnit() ;
    public void setUnit(RecipeUnit unit) ;

    public BigDecimal getWeight() ;
    public void setWeight(BigDecimal weight);

    default Recipe copyMembers(Recipe src,Boolean doCopy){
        if(src == null){
            return this;
        }
        else {
            if(doCopy || src.getId() != null){
                this.setId(src.getId());
            }
            if(doCopy || src.getCookieId() != null){
                this.setCookieId(src.getCookieId());
                this.getCookie().copyMembers(src.getCookie(),doCopy);
            }
            if(doCopy || src.getIngredientId() != null){
                this.setIngredientId(src.getIngredientId());
                this.getIngredient().copyMembers(src.getIngredient(),doCopy);
            }
            if(doCopy || src.getUnit() != null){
                this.setUnit(src.getUnit());
            }
            if(doCopy || src.getWeight() != null){
                this.setWeight(src.getWeight());
            }
        }
        return this;
    }
}
