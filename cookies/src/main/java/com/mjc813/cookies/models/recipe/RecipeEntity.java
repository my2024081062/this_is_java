package com.mjc813.cookies.models.recipe;

import com.mjc813.cookies.models.common.IdName;
import com.mjc813.cookies.models.cookie.CookieEntity;
import com.mjc813.cookies.models.ingredient.IngredientEntity;
import com.mjc813.cookies.models.ingredient.IngredientInterface;
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
@NamedEntityGraph(name = "RecipeEntity.fetchCookieIngredient"
    , attributeNodes = {
        @NamedAttributeNode(value = "cookie"),
        @NamedAttributeNode(value = "ingredient", subgraph = "RecipeIngredient.fetchCategory")}
    , subgraphs = {
        @NamedSubgraph(name ="RecipeIngredient.fetchCategory", attributeNodes = {
            @NamedAttributeNode(value = "category")})
    }
)
public class RecipeEntity implements Recipe{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "cookie_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CookieEntity cookie;
    @Transient
    private Long cookieId;

    @JoinColumn(name = "ingredient_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private IngredientEntity ingredient;
    @Transient
    private Long ingredientId;

    @Column(name = "unit",length = 5, nullable = false)
    private RecipeUnit unit;

    @Column(name = "weight",nullable = false)
    private BigDecimal weight;

    @Override
    public Long getCookieId() {
        if ( this.cookie == null ) {
            this.cookie = new CookieEntity();
        }
        if( this.cookie.getId() != null ) {
            this.cookieId = this.cookie.getId();
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
    public void setCookie(IdName cookie) {
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
        if( this.ingredient.getId() != null ) {
            this.ingredientId = this.ingredient.getId();
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
    public void setIngredient(IngredientInterface ingredient) {
        if ( ingredient == null ) {
            return;
        }
        if ( this.ingredient == null ) {
            this.ingredient = new IngredientEntity();
        }
        this.ingredient.copyMembers(ingredient, true);
    }
}
