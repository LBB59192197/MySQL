package io;

import java.io.*;
import java.io.File;
/**
 * Created by DELL on 2018/7/20.
 */
public class FileTools {
    /**
     * copy文件
     * @param src
     * @param desc
     */
    public static void copy(String src, String desc) {
        InputStream fis=null;
        OutputStream fid=null;
        try {
            fis=new FileInputStream(src);
            fid=new FileOutputStream(desc);
            int content=-1;

                while((content = fis.read())!=-1) {
                    fid.write(content);
                }


        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fis.close();
            fid.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 剪切操作
     * @param src 源文件
     * @param desc 目标文件
     *             将源文件内容复制到目标文件，同时删除源文件
     */
    public static void cut(String src,String desc)throws IOException{



    }

    /**
     * 删除文件
     * @param src 需要删除的文件
     */
    public static void delte(String src) throws FileNotFoundException {
        File file=new File(src);
        if(file.exists()){
            boolean d=file.delete();
        if(d){
            System.out.print("删除成功");
        }else{
            System.out.print("删除失败");
        }
        }

    }

    /**
     * 拷贝文件夹
     * @param srcFolder 源文件夹
     * @param desFolder 目标文件夹
     *                  将原文件夹所有数据复制到目标文件夹。
     */
    public static void copyFolder(String srcFolder,String desFolder) {

    }
    /**
     * 剪切文件夹
     * @param srcFolder 源文件夹
     * @param desFolder 目标文件夹
     *                  将原文件夹所有数据复制到目标文件夹。同时删除源文件夹
     */
    public static void cutFolder(String srcFolder,String desFolder) {

    }



}
