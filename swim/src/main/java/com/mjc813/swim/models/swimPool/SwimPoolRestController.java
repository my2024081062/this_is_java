package com.mjc813.swim.models.swimPool;

import com.mjc813.swim.models.common.ApiResponse;
import com.mjc813.swim.models.common.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/swim_pool")
public class SwimPoolRestController {
    @Autowired
    public SwimPoolService swimPoolService;

    @PostMapping
    public ResponseEntity<ApiResponse<SwimPoolDto>> insert(@RequestBody SwimPoolDto swimPoolDto) {
        SwimPoolDto result = swimPoolService.insert(swimPoolDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(
            ApiResponse.make(ResponseCode.insert_ok,"ok",result)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SwimPoolDto>> findById(@PathVariable Long id) {
        SwimPoolDto result = swimPoolService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
            ApiResponse.make(ResponseCode.select_ok,"ok",result)
        );
    }

    @PatchMapping
    public ResponseEntity<ApiResponse<SwimPoolDto>> update(@RequestBody SwimPoolDto swimPoolDto) {
        SwimPoolDto result = swimPoolService.update(swimPoolDto);
        return ResponseEntity.status(HttpStatus.OK).body(
            ApiResponse.make(ResponseCode.update_ok,"ok",result)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<SwimPoolDto>> deleteById(@PathVariable Long id) {
        SwimPoolDto result = swimPoolService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
            ApiResponse.make(ResponseCode.delete_ok,"ok",result)
        );
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<SwimPoolDto>>> findAll() {
        List<SwimPoolDto> result = swimPoolService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(
            ApiResponse.make(ResponseCode.select_ok,"ok",result)
        );
    }
}
