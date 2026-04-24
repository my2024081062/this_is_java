package com.mjc813.cookies.biz_file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;

@Slf4j
@Component
public class FileUtil {
    @Value("${cookie.save-folder}")
    private String uploadPath;

    /**
     * dir존재 하면 true 리턴
     * @param dir 디렉존재 여부를 체크할 디렉토리 path문자열
     * @retrun
     */
    public boolean checkDirectory(String dir){
        if(dir == null)
            return false;
        File f = new File(dir);
        if(!f.exists())
            return false;
        return true;
    }

    /**
     * 디렉토리를 재귀적으로 생성해준다.
     * @param dir "d:/temp/a/b/c"
     * @return
     */
    public boolean makeRecursiveDir(String dir) throws IOException {
        if(dir == null)
            return false;
        Path path = Paths.get(dir);
        Files.createDirectories(path);
        return true;
    }
    /**
     * 디렉토리를 맨 마지막 디렉토리를 삭제해준다.
     * @param dir "d:/temp/a/b/c" => "d:/temp/a/b"
     * @return
     */
    public boolean deleteRecursiveDirectory(String dir) throws IOException {
        if ( dir == null ) {
            return false;
        }
        // 디렉토리 삭제하는 코딩
        Path path = Paths.get(dir);
        Files.deleteIfExists(path);
        return true;
    }

    public String getRandomStoreFileName(int length){
        String arrs = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rnd = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length; i++){
            int index = rnd.nextInt(arrs.length());
            sb.append(arrs.charAt(index));
        }
        return sb.toString();
    }


    public String getExtension(String fileName){
        if(fileName == null){
            return "";
        }
        int lastIndex = fileName.lastIndexOf(".");
        if(lastIndex == -1){
            return "";
        }
        return fileName.substring(lastIndex+1).toLowerCase();
    }

    public boolean deleteFile(String fileName){
        if(!this.checkDirectory(fileName)){
            return false;
        }
        try {
            Path path = Paths.get(fileName);
            Files.delete(path);
        } catch (IOException e) {
            log.error(e.getMessage());
            return  false;
        }
        return true;
    }

    /**
     * 디렉토리를 재귀적으로 생성해준다.
     * @param src 첨부 파일 객체
     * @param path 저장될 디렉토리
     * @param dest 저장될 파일 명
     * @return 저장될 바이트 수
     * @throws IOException
     */

    public boolean copyFile(MultipartFile src,String path ,String dest) throws IOException{
        if(src == null || path == null || dest == null){
            return false;
        }
        try {
            String fullPath = this.uploadPath + "/" + path;
            if(!this.checkDirectory(fullPath)){
                this.makeRecursiveDir(fullPath);
            }
            Path destPath = Paths.get(fullPath + "/" + dest);
            long lResult = Files.copy(src.getInputStream()
                , destPath
                , StandardCopyOption.REPLACE_EXISTING);
            if(lResult <= 0){
                return false;
            }
        } catch (IOException e) {
            log.error(e.toString());
            throw new RuntimeException(e);
        }
        return true;
    }
}
