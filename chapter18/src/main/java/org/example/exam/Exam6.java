package org.example.exam;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Exam6 implements Exam{
    @Override
    public void run() {

    }
    private void write(String str){
        OutputStream os = null;
        Writer writer = null;
        try{
            os = new FileOutputStream("./test6.txt");
            writer = new OutputStreamWriter(os, StandardCharsets.UTF_8);
            writer.write(str);
            writer.flush();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        finally {
            try {
                assert os!=null;
                os.close();
                assert writer!=null;
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private String reader(){
        InputStream is =null;
        Reader reader = null;
        char[] data = new char[100];
        int num = 0;
        try{
            is = new FileInputStream("./test6.txt");
            reader = new InputStreamReader(is,StandardCharsets.UTF_8);
            num = reader.read(data);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        finally {
            try {
                assert is!=null;
                is.close();
                assert reader!=null;
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return new String(data,0,num);
    }
}
