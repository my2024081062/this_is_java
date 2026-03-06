package org.example.exam;

import java.io.*;

public class Exam4 implements Exam{
    @Override
    public void run() {
        Writer writer = null;
        try {
            writer = new FileWriter("./test4.txt");
            char a = 'A';
            writer.write(a);
            char b = 'B';
            writer.write(b);
            char[] arr = {'C','D','E'};
            writer.write(arr);
            String str = "FGH";
            writer.write(str);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                assert writer!=null;
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Reader reader = null;
        try {
            reader = new FileReader("./test4.txt");
            while (true){
                int data = reader.read();
                if(data == -1) break;
                System.out.print((char) data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                assert reader!=null;
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        try {
            reader = new FileReader("./test4.txt");
            char[] data = new char[100];
            while (true){
                int num = reader.read(data);
                if(num == -1) break;
                for (int i = 0; i < num; i++) {
                    System.out.print(data[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                assert reader!=null;
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
