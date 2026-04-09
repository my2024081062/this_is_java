package com.mjc813.cafe_kios.models.category;

import com.mjc813.cafe_kios.ResponseCode;
import com.mjc813.cafe_kios.models.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/V1/category")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryDto>> insert(@RequestBody CategoryDto newDto){
        CategoryDto result = this.categoryService.insert(newDto);
        ApiResponse<CategoryDto> apiResponse = ApiResponse.make(ResponseCode.Success,"OK",result);
        return ResponseEntity.status(201).body(apiResponse);
    }

    @PatchMapping
    public ResponseEntity<ApiResponse<CategoryDto>> update(@RequestBody CategoryDto newDto){
        CategoryDto result = this.categoryService.update(newDto);
        ApiResponse<CategoryDto> apiResponse = ApiResponse.make(ResponseCode.Success,"OK",result);
        return ResponseEntity.status(201).body(apiResponse);
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryDto>> delete(@PathVariable Integer id) {
       CategoryDto result = this.categoryService.deleteById(id);
       ApiResponse<CategoryDto> apiResponse = ApiResponse.make(ResponseCode.Success,"OK",result);
       return ResponseEntity.status(201).body(apiResponse);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<CategoryDto>> findById(@PathVariable Integer id) {
        CategoryDto result = this.categoryService.findById(id);
        return ResponseEntity.status(201).body(
            ApiResponse.make(ResponseCode.Success, "ok", result)
        );
    }
}
