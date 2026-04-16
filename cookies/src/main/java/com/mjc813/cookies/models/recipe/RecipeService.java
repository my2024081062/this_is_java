package com.mjc813.cookies.models.recipe;

import com.mjc813.cookies.models.cookie.CookieEntity;
import com.mjc813.cookies.models.cookie.CookieRepository;
import com.mjc813.cookies.models.ingredient.IngredientEntity;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final CookieRepository cookieRepository;

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

    public Slice<RecipeDto> findAllByCookieEquals(Long cookieId, Pageable pageable) {
        CookieEntity cookieEntity = CookieEntity.builder().id(cookieId).build();
        Slice<RecipeEntity> slc = this.recipeRepository.findAllByCookieEquals(cookieEntity,pageable);

        return this.getRecipeDtos(slc);
    }

    public Slice<RecipeDto> findAllByIngredient(Long ingredientId, Pageable pageable) {
        IngredientEntity ingredientEntity = IngredientEntity.builder().id(ingredientId).build();
        Slice<RecipeEntity> slc = this.recipeRepository.findAllByIngredient(ingredientEntity,pageable);

        return this.getRecipeDtos(slc);
    }

    private @NonNull Slice<RecipeDto> getRecipeDtos(Slice<RecipeEntity> slc) {
        List<RecipeDto> list = slc.getContent().stream()
            .map(t-> (RecipeDto) new RecipeEntity().copyMembers(t,true))
            .toList();

        Slice<RecipeDto> result = new SliceImpl<>(list, slc.getPageable(), slc.hasNext());
        return result;
    }
}
