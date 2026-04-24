package com.mjc813.cookies.biz_file;

import com.mjc813.cookies.models.attach.AttachDto;
import com.mjc813.cookies.models.attach.AttachService;
import com.mjc813.cookies.models.cookie.CookieDto;
import com.mjc813.cookies.models.cookie.CookieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CookieFileService {
    @Value("D:/cookie_upload")
    private String path;

    @Autowired
    private CookieService cookieService;

    @Autowired
    private FileUtil fileUtil;

    @Autowired
    private AttachService attachService;

    /**
     * List<MultipartFile> 첨부파일들을 AttachService insert 를 한다.
     * 중간에 에러 발생시에 전체 롤백할것인지, 에러난 파일은 건너뛰고 남은 거 계속 저장할것인지 정책으로 결정
     * @param cookieDto
     * @param multipartFiles
     * @return
     */
    @Transactional(rollbackFor = {IOException.class}) // 메소드에서 runtimeException 발생하면 롤백처리, IO는 일반 Exception 상속
    public List<AttachDto> insert(CookieDto cookieDto, List<MultipartFile> multipartFiles) throws IOException {
        if (cookieDto == null || cookieDto.getId() == null || multipartFiles == null || multipartFiles.size() <= 0){
            return null;
        }
        if(this.cookieService.findById(cookieDto.getId()) != null){
            return null;
        }
        List<AttachDto> result = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        try{
            for (MultipartFile multipartFile : multipartFiles) {
                String ext = this.fileUtil.getExtension(multipartFile.getOriginalFilename());
                String storeName = this.fileUtil.getRandomStoreFileName(50);

                AttachDto attachDto = AttachDto.builder()
                    .id(null)
                    .fileName(multipartFile.getOriginalFilename())
                    .ext(ext)
                    .size((int)multipartFile.getSize())
                    .storedName(storeName)
                    .cookieId(cookieDto.getId())
                    .path(String.valueOf(now.getYear())).build();
            AttachDto insert = this.attachService.insert(attachDto);
            this.fileUtil.copyFile(multipartFile,attachDto.getPath(),attachDto.getStoredName());
            result.add(insert);
            }
        } catch (IOException e){
            log.error(e.getMessage());
            result.forEach(
                attachDto -> this.fileUtil.deleteFile(attachDto.getPath() + "/" + attachDto.getStoredName())
            );
            throw e;
        }
        return result;
    }
}
