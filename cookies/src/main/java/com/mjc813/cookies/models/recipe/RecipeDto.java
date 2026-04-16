package com.mjc813.cookies.models.recipe;

import com.mjc813.cookies.models.ingredient.IngredientDto;
import com.mjc813.cookies.models.ingredient.IngredientInterface;
import lombok.*;
import com.mjc813.cookies.models.cookie.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeDto implements Recipe{
    private Long id;

    private CookieDto cookie;
    private Long cookieId;

    private IngredientDto ingredient;
    private Long ingredientId;

    private RecipeUnit unit;

    private BigDecimal weight;

    @Override
    public Long getCookieId() {
        if ( this.cookie == null ) {
            this.cookie = new CookieDto();
        }
        if( this.cookie.getId() != null ) {
            this.cookieId = this.cookie.getId();
        }
        return this.cookie.getId();
    }

    @Override
    public void setCookieId(Long cookieId) {
        if ( this.cookie == null ) {
            this.cookie = new CookieDto();
        }
        this.cookie.setId(cookieId);
        this.cookieId = cookieId;
    }

    @Override
    public void setCookie(CookieDto cookie) {
        if ( cookie == null ) {
            return;
        }
        if ( this.cookie == null ) {
            this.cookie = new CookieDto();
        }
        this.cookie.copyMembers(cookie, true);
    }

    @Override
    public Long getIngredientId() {
        if ( this.ingredient == null ) {
            this.ingredient = new IngredientDto();
        }
        if( this.ingredient.getId() != null ) {
            this.ingredientId = this.ingredient.getId();
        }
        return this.ingredient.getId();
    }

    @Override
    public void setIngredientId(Long ingredientId) {
        if ( this.ingredient == null ) {
            this.ingredient = new IngredientDto();
        }
        this.ingredient.setId(ingredientId);
        this.ingredientId = ingredientId;
    }

    @Override
    public void setIngredient(IngredientInterface ingredient) {
        if ( ingredient == null ) {
            return;
        }
        if ( this.ingredient == null ) {
            this.ingredient = new IngredientDto();
        }
        this.ingredient.copyMembers(ingredient, true);
    }
}
