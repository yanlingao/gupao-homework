package com.ayl.gupao.homework.proxy_pattern.custom;

import java.io.*;

/**
 * @author AYL    3/21/2018 1:21 AM
 */
public class MyClassLoader extends ClassLoader {
    private String classPath;

    public MyClassLoader() {
        String classPath = MyProxy.class.getResource("").getPath();
        System.out.println("myclassloader classpath:" + classPath);
        this.classPath = classPath;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {

        String path = classPath + File.separatorChar + name + ".class";
        File file = new File(path);
        FileInputStream fileInputStream = null;
        ByteArrayOutputStream outputStream = null;
        try {
             fileInputStream = new FileInputStream(file);
             outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while((len = fileInputStream.read(buffer)) != -1){
                outputStream.write(buffer,0, len);
            }

            byte[] classDate = outputStream.toByteArray();

            String classPackagePath = MyProxy.class.getPackage().getName() + "." + name;
            return defineClass(classPackagePath, classDate, 0, classDate.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
