package com.mjc813.cookies.models.cookie;

import com.mjc813.cookies.models.category.*;
import com.mjc813.cookies.models.common.ApiResponse;
import com.mjc813.cookies.models.common.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cookie")
public class CookieRestController {
    @Autowired
    private CookieService CcookieService;

    @PostMapping
    public ResponseEntity<ApiResponse<CookieDto>> insert(@RequestBody CookieDto insertDto) {
        CookieDto result = this.CcookieService.insert(insertDto);
        return ResponseEntity.status(201).body(
//				ApiResponse.<CookieDto>builder()
//						.responseCode(ResponseCode.insert_ok)
//						.message("ok")
//						.responseData(result)
//						.build()
            ApiResponse.make(ResponseCode.insert_ok, "ok", result)
        );
    }

    @PatchMapping
    public ResponseEntity<ApiResponse<CookieDto>> update(@RequestBody CookieDto insertDto) {
        CookieDto result = this.CcookieService.update(insertDto);
        return ResponseEntity.status(200).body(
            ApiResponse.make(ResponseCode.update_ok, "ok", result)
        );
    }

    @GetMapping("/name-search")
    public ResponseEntity<ApiResponse<Slice<CookieDto>>> searchByName(@RequestParam String name,
                                                                      @PageableDefault(size = 10,page = 0, sort="id", direction = Sort.Direction.DESC)Pageable pageable){
        Slice<CookieDto> result = this.CcookieService.findByNameContains(name,pageable);
        return ResponseEntity.status(200).body(
            ApiResponse.make(ResponseCode.select_ok,"ok",result));
    }
}
