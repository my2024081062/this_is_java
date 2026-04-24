package com.mjc813.cookies.models.attach;

import com.mjc813.cookies.models.common.ApiResponse;
import com.mjc813.cookies.models.common.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/attach")
@RequiredArgsConstructor
public class AttachRestController {
    private final AttachService attachService;

    @PostMapping
    public ResponseEntity<ApiResponse<AttachDto>> insert(@RequestBody AttachDto attachDto) {
        AttachDto insertDto = this.attachService.insert(attachDto);
        return ResponseEntity.status(201).body(
            ApiResponse.make(ResponseCode.insert_ok,"ok",insertDto));
    }

    @PatchMapping
    public ResponseEntity<ApiResponse<AttachDto>> update(@RequestBody AttachDto attachDto) {
        AttachDto updateDto = this.attachService.update(attachDto);
        return ResponseEntity.status(201).body(
            ApiResponse.make(ResponseCode.update_ok,"ok",updateDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<AttachDto>> delete(@RequestBody AttachDto attachDto) {
        AttachDto deleteDto = this.attachService.deleteById(attachDto.getId());
        return ResponseEntity.status(201).body(
            ApiResponse.make(ResponseCode.delete_ok,"ok",deleteDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AttachDto>> findById(@PathVariable Long id) {
        AttachDto findDto = this.attachService.findById(id);
        return ResponseEntity.status(200).body(
            ApiResponse.make(ResponseCode.insert_ok,"ok",findDto));
    }

    @GetMapping("/cookie/{cookieId}")
    public ResponseEntity<ApiResponse<Slice<AttachDto>>> findAllByCookieEquals(@PathVariable Long cookieId
        ,@PageableDefault(size = 10,page = 0,sort = "id",direction = Sort.Direction.DESC) Pageable pageable) {
        Slice<AttachDto> result = this.attachService.findAllByCookieEquals(cookieId, pageable);
        return ResponseEntity.status(200).body(
            ApiResponse.make(ResponseCode.select_ok,"ok",result));
    }
}
