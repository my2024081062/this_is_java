package com.mjc813.cafe_kios.models.sale;

import com.mjc813.cafe_kios.ResponseCode;
import com.mjc813.cafe_kios.models.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/V1/sale")
public class SaleRestController {
    private final SaleService saleService;

    @PostMapping
    public ResponseEntity<ApiResponse<SaleDto>> insert(@RequestBody SaleDto saleDto){
        SaleDto result = this.saleService.insert(saleDto);
        ApiResponse<SaleDto> apiResponse = ApiResponse.make(ResponseCode.Success,"OK",result);
        return ResponseEntity.status(201).body(apiResponse);
    }
}
