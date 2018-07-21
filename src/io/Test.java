package io;

import java.io.FileNotFoundException;

/**
 * Created by DELL on 2018/7/20.
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        FileTools fileTools=new FileTools();
        String src="E:\\3.jpg";
        String desc="E:\\3-1.jpg";
        FileTools.copy(src,desc);
        FileTools.delte(src);


    }
}
