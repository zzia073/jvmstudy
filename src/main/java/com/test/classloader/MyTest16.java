package com.test.classloader;

import java.io.*;

/**
 * @author ：fei
 * @date ：Created in 2019/8/26 0026 17:18
 */
public class MyTest16 extends ClassLoader {
    private String classLoaderName;
    private final String fileExtension = ".class";

    public MyTest16(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    public static void main(String[] args) throws Exception {
        MyTest16 myTest16 = new MyTest16("load1");
        //在父类中loadClass会调用findClass
        Class<?> aClass = myTest16.loadClass("com.test.classloader.MyParent1");
        Object o = aClass.newInstance();
        System.out.println(o.getClass());
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classByteArray = getClassByteArray(name);
        return defineClass(classByteArray, 0, classByteArray.length);
    }
    private byte[] getClassByteArray(String className) {
        String fileClassName = className.replace(".", "/");
        fileClassName = fileClassName.concat(fileExtension);
        FileInputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            inputStream = new FileInputStream(new File(fileClassName));
            byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            while ((i = inputStream.read()) != -1){
                byteArrayOutputStream.write(i);
            }
            return byteArrayOutputStream.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                byteArrayOutputStream.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
