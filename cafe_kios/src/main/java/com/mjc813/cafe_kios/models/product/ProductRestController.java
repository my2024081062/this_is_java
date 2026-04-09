package com.mjc813.cafe_kios.models.product;

import com.mjc813.cafe_kios.ResponseCode;
import com.mjc813.cafe_kios.models.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/V1/product")
public class ProductRestController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse<ProductDto>> insert(@RequestBody ProductDto productDto){
        ProductDto result = this.productService.insert(productDto);
        ApiResponse<ProductDto> apiResponse = ApiResponse.<ProductDto>builder()
            .code(ResponseCode.Success)
            .message("OK")
            .responseData(result)
            .build();
        return ResponseEntity.status(201).body(apiResponse);
    }

    @PatchMapping
    public ResponseEntity<ApiResponse<ProductDto>> update(@RequestBody ProductDto newDto) {
        ProductDto result = this.productService.update(newDto);
        ApiResponse<ProductDto> apiResponse = ApiResponse.make(ResponseCode.Success,"OK",result);
        return ResponseEntity.status(200).body(apiResponse);
    }
}
