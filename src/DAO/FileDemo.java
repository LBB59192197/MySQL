package DAO;

import java.io.File;

/**
 * Created by DELL on 2018/7/20.
 */
public class FileDemo {
    public static void main(String[] args){
        //加绝对路径
        File file=new File("a/b/c");
        String path=file.getAbsolutePath();
        System.out.println(path);
        //创建文件夹
        file.mkdirs();
        if(file.isDirectory()){
            System.out.println("目录");
        }
        if(file.isFile()){
            System.out.println("文件");
        }
        if(file.exists()){
            System.out.println("file exists: true");
        }else {
            System.out.println("file  exists:  false");
        }
    }
}
