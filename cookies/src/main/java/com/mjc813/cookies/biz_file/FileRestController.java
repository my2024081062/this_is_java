package com.mjc813.cookies.biz_file;

import com.mjc813.cookies.models.attach.AttachDto;
import com.mjc813.cookies.models.common.ApiResponse;
import com.mjc813.cookies.models.common.ResponseCode;
import com.mjc813.cookies.models.cookie.CookieDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/file")
public class FileRestController {
    @Autowired
    CookieFileService cookieFileService;

    @PostMapping("/upload")
    public ResponseEntity<ApiResponse<String>> upload(@RequestPart CookieDto cookieDto
    ,  @RequestPart List<MultipartFile> multipartFiles) {
        log.info("upload cookies dto {}", cookieDto);
        multipartFiles.forEach(multipartFile ->
                log.info("upload cookies file dto{}", multipartFile)
        );
        try {
            List<AttachDto> result = this.cookieFileService.insert(cookieDto,multipartFiles);
        }
        catch (IOException e){
            log.error(e.toString());
            return ResponseEntity.status(400).body(
                ApiResponse.make(ResponseCode.insert_failed,"error","error of file")
            );
        }
        return ResponseEntity.status(201).body(
            ApiResponse.make(ResponseCode.upload_ok,"ok","success")
        );
    }
}
