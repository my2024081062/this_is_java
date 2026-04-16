package com.mjc813.cookies.models.recipe;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeDto insertRecipe(RecipeDto insertRecipeDto) {
        RecipeEntity insertRecipeEntity = (RecipeEntity) new RecipeEntity().copyMembers(insertRecipeDto,true);
        insertRecipeEntity.setId(null);

        RecipeEntity save = recipeRepository.save(insertRecipeEntity);

        RecipeDto result = (RecipeDto) new RecipeEntity().copyMembers(save,true);
        return result;
    }
}
