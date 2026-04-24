package com.mjc813.cookies.biz.file;

import com.mjc813.cookies.biz_file.FileUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestFileUtil {
    private FileUtil fileUtil = new FileUtil();

    @Test
    public void testGetExtension() {
        String ext1 = this.fileUtil.getExtension("1111");
        assertThat(ext1).isNotNull();
        assertThat(ext1).isEqualTo("");

        String ext2 = this.fileUtil.getExtension("1111.122.jpg");
        assertThat(ext2).isNotNull();
        assertThat(ext2).isEqualTo("jpg");

        String ext3 = this.fileUtil.getExtension("ab.1111.122.JPEG");
        assertThat(ext3).isNotNull();
        assertThat(ext3).isEqualTo("jpeg");
    }

    @Test
    public void testDirectories(){

    }
}
