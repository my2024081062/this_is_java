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

    public RecipeDto updateRecipe(RecipeDto updateRecipeDto) {
        RecipeEntity find = this.recipeRepository.findById(updateRecipeDto.getId()).orElseThrow();

        RecipeEntity updateRecipeEntity = (RecipeEntity) new RecipeEntity().copyMembers(find,true);
        updateRecipeEntity.copyMembers(updateRecipeDto,false);

        RecipeEntity save = recipeRepository.save(updateRecipeEntity);

        RecipeDto result = (RecipeDto) new RecipeEntity().copyMembers(save,true);
        return result;
    }

    public RecipeDto findById(Long id) {
        RecipeEntity findEntity = this.recipeRepository.findById(id).orElseThrow();
        RecipeDto result = (RecipeDto)new RecipeDto().copyMembers(findEntity, true);
        return result;
    }

    public RecipeDto deleteById(Long id) {
        RecipeDto findDto = this.findById(id);
        this.recipeRepository.deleteById(id);
        return findDto;
    }
}
