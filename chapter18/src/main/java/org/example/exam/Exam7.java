package org.example.exam;

import java.io.*;

public class Exam7 implements Exam{
    @Override
    public void run() {
        FileInputStream fis1 = null;
        FileOutputStream fos1 = null;

        FileInputStream fis2 = null;
        FileOutputStream fos2 = null;

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            String originalFilePath1 = Exam7.class.getResource("./origin.jpg").getPath();
            String targetFilePath1 = "./copy.jpg";
            fis1 = new FileInputStream(originalFilePath1);
            fos1 = new FileOutputStream(targetFilePath1);

            String originalFilePath2 = Exam7.class.getResource("./origin.jpg").getPath();
            String targetFilePath2 = "./copy.jpg";

            fis2 = new FileInputStream(originalFilePath2);
            fos2 = new FileOutputStream(targetFilePath2);
            bis = new BufferedInputStream(fis2);
            bos = new BufferedOutputStream(fos2);

            //24번줄

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
