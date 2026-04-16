package com.mjc813.cookies.models.recipe;

import com.mjc813.cookies.models.ingredient.IngredientDto;
import jakarta.persistence.Entity;
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

}
