package com.mjc813.cafe_kios.models.product;

import com.mjc813.cafe_kios.ResponseCode;
import com.mjc813.cafe_kios.models.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/V1/product")
public class ProductRestController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse<ProductDto>> insert(@RequestBody ProductDto productDto){
        ProductDto result = this.productService.insert(productDto);
        ApiResponse<ProductDto> apiResponse = ApiResponse.make(ResponseCode.Success,"OK",result);
        return ResponseEntity.status(201).body(apiResponse);
    }

    @PatchMapping
    public ResponseEntity<ApiResponse<ProductDto>> update(@RequestBody ProductDto newDto) {
        ProductDto result = this.productService.update(newDto);
        ApiResponse<ProductDto> apiResponse = ApiResponse.make(ResponseCode.Success,"OK",result);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDto>> delete(@PathVariable Integer id) {
        ProductDto result = this.productService.deleteById(id);
        ApiResponse<ProductDto> apiResponse = ApiResponse.make(ResponseCode.Success,"OK",result);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<ProductDto>> findById(@PathVariable Integer id) {
        ProductDto result = this.productService.findById(id);
        ApiResponse<ProductDto> apiResponse = ApiResponse.make(ResponseCode.Success,"OK",result);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<Slice<ProductDto>>> findByNameContains(@RequestParam String name, Pageable pageable){
        Slice<ProductDto> slice = this.productService.findByNameContains(name,pageable);
        ApiResponse<Slice<ProductDto>> apiResponse = ApiResponse.make(ResponseCode.Success,"OK",slice);
        return ResponseEntity.status(200).body(apiResponse);
    }
}
