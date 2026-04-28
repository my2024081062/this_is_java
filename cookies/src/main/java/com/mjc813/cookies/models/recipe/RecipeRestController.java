package com.mjc813.cookies.models.recipe;

import com.mjc813.cookies.models.common.ApiResponse;
import com.mjc813.cookies.models.common.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping
    public ResponseEntity<ApiResponse<RecipeDto>> updateRecipe(@RequestBody RecipeDto recipeDto) {
        RecipeDto data = this.recipeService.updateRecipe(recipeDto);

        return ResponseEntity.status(200).body(
            ApiResponse.make(ResponseCode.update_ok,"ok",data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<RecipeDto>> findById(@PathVariable Long id) {
        RecipeDto result = this.recipeService.findById(id);
        return ResponseEntity.status(200).body(
            ApiResponse.make(ResponseCode.select_ok, "ok", result)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<RecipeDto>> deleteRecipe(@PathVariable Long id) {
        RecipeDto result = this.recipeService.deleteById(id);
        return ResponseEntity.status(200).body(
            ApiResponse.make(ResponseCode.delete_ok,"ok",result));
    }

    @GetMapping("/cookie/{cookieId}")
    public ResponseEntity<ApiResponse<Slice<RecipeDto>>> findAllByCookieEquals(@PathVariable Long cookieId
        , @PageableDefault(size = 10,page = 0,sort = "id",direction = Sort.Direction.DESC) Pageable pageable){
        Slice<RecipeDto> result = this.recipeService.findAllByCookieEquals(cookieId,pageable);
        return ResponseEntity.status(200).body(
            ApiResponse.make(ResponseCode.select_ok, "ok", result));
    }

    @GetMapping("/ingredient/{ingredientId}")
    public ResponseEntity<ApiResponse<Slice<RecipeDto>>> findByIngredient(@PathVariable Long ingredientId
        , @PageableDefault(size = 10,page = 0,sort = "id",direction = Sort.Direction.DESC) Pageable pageable){
        Slice<RecipeDto> result = this.recipeService.findByIngredient(ingredientId,pageable);
        return ResponseEntity.status(200).body(
            ApiResponse.make(ResponseCode.select_ok, "ok", result));
    }
}
