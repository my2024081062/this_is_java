package com.mjc813.cookies.models.recipe;

import com.mjc813.cookies.models.common.IdName;
import com.mjc813.cookies.models.cookie.CookieDto;
import com.mjc813.cookies.models.ingredient.IngredientDto;
import com.mjc813.cookies.models.ingredient.IngredientInterface;

import java.math.BigDecimal;

public interface Recipe {
    Long getId();
    void setId(Long id);

    IdName getCookie();
    void setCookie(IdName cookie);

    Long getCookieId() ;
    void setCookieId(Long cookieId);

    IngredientInterface getIngredient() ;
    void setIngredient(IngredientInterface ingredient);

    Long getIngredientId() ;
    void setIngredientId(Long ingredientId) ;

    RecipeUnit getUnit() ;
    void setUnit(RecipeUnit unit) ;

    BigDecimal getWeight() ;
    void setWeight(BigDecimal weight);

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
