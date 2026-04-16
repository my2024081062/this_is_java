package com.mjc813.cookies.models.recipe;

import com.mjc813.cookies.models.common.ApiResponse;
import com.mjc813.cookies.models.common.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/V1/recipe")
@RequiredArgsConstructor
public class RecipeRestController {
    private final RecipeService recipeService;

    @PostMapping

    public ResponseEntity<ApiResponse<RecipeDto>> insertRecipe(@RequestBody RecipeDto recipeDto) {
        RecipeDto data = this.recipeService.insertRecipe(recipeDto);

        return ResponseEntity.status(200).body(
            ApiResponse.make(ResponseCode.insert_ok,"ok",data));
    }
}
