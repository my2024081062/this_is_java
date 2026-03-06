package org.example.exam;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Exam2 implements Exam{
    public void run(){
        OutputStream os = null;
        try {
            os = new FileOutputStream("./test1.db");
            os.write(10);
            os.write(20);
            os.write(30);
            os.flush();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(os != null){
                    os.close();
                }
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        try{
            os = new FileOutputStream("./test2.db");
            byte[] array = {10,20,30};
            os.write(array);
            os.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try{
                os.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try{
            os = new FileOutputStream("./test3.db");
            byte[] array = {10,20,30,40,50};
            os.write(array,1,3);
            os.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try{
                os.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
