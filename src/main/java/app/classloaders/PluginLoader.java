package app.classloaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Ihar_Rubanovich on 2/23/2017.
 */
public class PluginLoader extends ClassLoader {
    private HashMap<String, byte[]> cacheData = new HashMap<String, byte[]>();

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] clazz = cacheData.get(name);
        if (clazz != null) {
            return defineClass(name, clazz, 0, clazz.length);
        }
        return super.findClass(name);
    }

    public void loadPlugin(String pathToPlugin, String packageName, String strPluginFileName) throws IOException, ClassNotFoundException {
        File file = new File(pathToPlugin);
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                if (f.getName().endsWith(".class")) {

                    byte[] classData = loadClassData(f);
                    if (classData != null) {
                        String name = packageName + "." + f.getName().replace('/', '.').substring(0, f.getName().length() - 6);
                        cacheData.put(name,loadClassData(f));
                    }
                }
            }
        }
    }

    private byte[] loadClassData(File file) throws IOException {
        long size = file.length();
        if (size <= 0)
            return null;
        else if (size > Integer.MAX_VALUE) {
            throw new IOException("Class size too long");
        }

        byte[] buffer = new byte[(int) size];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fis.read(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null)
                fis.close();
        }

        return buffer;
    }
}
