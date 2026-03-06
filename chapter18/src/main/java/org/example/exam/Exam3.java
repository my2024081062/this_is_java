package org.example.exam;

import java.io.*;

public class Exam3 implements Exam{
    @Override
    public void run() {
        InputStream is = null;
        try{
            is = new FileInputStream("./test1.db");
            while (true){
                int data = is.read();
                if(data == -1){
                    break;
                }
                System.out.println(data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try{
                assert is != null;
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try{
            is = new FileInputStream("./test2.db");
            byte[] data = new byte[100];
            while (true){
                int num = is.read(data);
                if(num == -1){
                    break;
                }
                for (int i = 0; i < num; i++) {
                    System.out.println(data[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try{
                assert is != null;
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        String originalFileName = "./origin.jpg";
        String targetFileName = "./copy.jpg";
        OutputStream os = null;
        try{
            is = new FileInputStream(originalFileName);
            os = new FileOutputStream(targetFileName);
            byte[] data = new byte[1024];
            while (true){
                int num = is.read(data);
                if(num == -1){
                    break;
                }
                os.write(data,0,num);
            }
            os.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try{
                assert os != null;
                os.close();
                assert is != null;
                is.close();
                System.out.println("복사 완료");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
