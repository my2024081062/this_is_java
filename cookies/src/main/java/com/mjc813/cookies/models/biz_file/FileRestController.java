package com.mjc813.cookies.models.biz_file;

import com.mjc813.cookies.models.common.ApiResponse;
import com.mjc813.cookies.models.common.ResponseCode;
import com.mjc813.cookies.models.cookie.CookieDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/")
public class FileRestController {

    @PostMapping("/upload")
    public ResponseEntity<ApiResponse<String>> upload(@RequestPart CookieDto cookieDto
    ,  @RequestPart List<MultipartFile> multipartFiles) {
        log.info("upload cookies dto{}", cookieDto);
        multipartFiles.forEach(multipartFile -> {
                log.info("upload cookies file dto{}", multipartFile);
            }
        );
        return ResponseEntity.status(200).body(
            ApiResponse.make(ResponseCode.upload_ok,"ok","success")
        );
    }
}
