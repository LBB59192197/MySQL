package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by DELL on 2018/7/20.
 */
public class FileWriterTester {
   private void IO() {
       String fileName = "E:\\数据库.dox";
       try {
           FileWriter writer = new FileWriter(fileName);
           writer.write("数据库\n");
           writer.write("This is my ");
           writer.write("you can");
           writer.flush();
           //writer.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
   private void  reaer2Control(){
       try {
           FileInputStream input = new FileInputStream("数据库.dox");
           int content = -1;
           try {
               while ((content = input.read()) != -1) {
                   char c = (char) content;
                   System.out.println(c);

               }
           } catch (IOException e) {
               e.printStackTrace();
           }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
   }
    public static void main(String [] args){
       FileWriterTester  TT=new FileWriterTester();
       TT.reaer2Control();
    }

}
