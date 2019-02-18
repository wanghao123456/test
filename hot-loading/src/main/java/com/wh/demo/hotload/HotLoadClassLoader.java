package com.wh.demo.hotload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HotLoadClassLoader extends ClassLoader {

    private String path;

    public HotLoadClassLoader(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) {
        try {
            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInputStream.read(bytes);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
