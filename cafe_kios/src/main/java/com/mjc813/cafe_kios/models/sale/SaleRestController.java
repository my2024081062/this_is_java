package com.mjc813.cafe_kios.models.sale;

import com.mjc813.cafe_kios.ResponseCode;
import com.mjc813.cafe_kios.models.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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

    @PatchMapping
    public ResponseEntity<ApiResponse<SaleDto>> update(@RequestBody SaleDto saleDto) {
        SaleDto result = this.saleService.update(saleDto);
        ApiResponse<SaleDto> apiResponse = ApiResponse.make(ResponseCode.Success,"OK",result);
        return ResponseEntity.status(201).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SaleDto>> findById(@PathVariable Integer id) {
        SaleDto result = this.saleService.findById(id);
        ApiResponse<SaleDto> response = ApiResponse.make(ResponseCode.Success, "ok", result);
        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<SaleDto>> deleteById(@PathVariable Integer id) {
        SaleDto result = this.saleService.deleteById(id);
        ApiResponse<SaleDto> response = ApiResponse.make(ResponseCode.Success, "ok", result);
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/prd/{productId}")
    public ResponseEntity<ApiResponse<Slice<SaleDto>>> findByProductEquals(@PathVariable Integer productId
        , @PageableDefault(page=0, sort="saleTime", direction = Sort.Direction.DESC, size=10) Pageable pageable
    ) {
        Slice<SaleDto> result = this.saleService.findByProductEquals(productId, pageable);
        ApiResponse<Slice<SaleDto>> response = ApiResponse.make(ResponseCode.Success, "ok", result);
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/date")
    public ResponseEntity<ApiResponse<Long>> sumPriceBySaleTimeAtBetween(@RequestParam LocalDate start,
                                                                         @RequestParam LocalDate end
    ) {
        Long result = this.saleService.sumPriceBySaleTimeAtBetween(start, end);
        ApiResponse<Long> response = ApiResponse.make(ResponseCode.Success, "ok", result);
        return ResponseEntity.status(200).body(response);
    }
}
