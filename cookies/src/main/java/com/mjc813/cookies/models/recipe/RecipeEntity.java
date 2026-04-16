package com.mjc813.cookies.models.recipe;

import com.mjc813.cookies.models.category.CategoryEntity;
import com.mjc813.cookies.models.cookie.CookieDto;
import com.mjc813.cookies.models.cookie.CookieEntity;
import com.mjc813.cookies.models.ingredient.IngredientDto;
import com.mjc813.cookies.models.ingredient.IngredientEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "recipe")
public class RecipeEntity implements Recipe{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    @ManyToOne(fetch = FetchType.EAGER)
    private CookieEntity cookie;
    @Transient
    private Long cookieId;

    @JoinColumn
    @ManyToOne(fetch = FetchType.EAGER)
    private IngredientEntity ingredient;
    @Transient
    private Long ingredientId;

    @Column(length = 5)
    private RecipeUnit unit;

    @Column()
    private BigDecimal weight;

    @Override
    public Long getCookieId() {
        if ( this.cookie == null ) {
            this.cookie = new CookieEntity();
        }
        return this.cookie.getId();
    }

    @Override
    public void setCookieId(Long cookieId) {
        if ( this.cookie == null ) {
            this.cookie = new CookieEntity();
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
            this.cookie = new CookieEntity();
        }
        this.cookie.copyMembers(cookie, true);
    }

    @Override
    public Long getIngredientId() {
        if ( this.ingredient == null ) {
            this.ingredient = new IngredientEntity();
        }
        return this.ingredient.getId();
    }

    @Override
    public void setIngredientId(Long ingredientId) {
        if ( this.ingredient == null ) {
            this.ingredient = new IngredientEntity();
        }
        this.ingredient.setId(ingredientId);
        this.ingredientId = ingredientId;
    }

    @Override
    public void setIngredient(IngredientDto ingredient) {
        if ( ingredient == null ) {
            return;
        }
        if ( this.ingredient == null ) {
            this.ingredient = new IngredientEntity();
        }
        this.ingredient.copyMembers(ingredient, true);
    }
}
