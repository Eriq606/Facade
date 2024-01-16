package facade.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class FileUtils {
    public static String getContentOfFile(File file) throws FileNotFoundException{
        String content="";
        try(Scanner scanner=new Scanner(file)){
            while(scanner.hasNextLine()){
                content+=scanner.nextLine()+"\n";
            }
        }
        return content;
    }
    public static File writeNewFile(String fileName, String content) throws IOException{
        File file=new File(fileName);
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(file))){
            writer.write(content);
        }
        return file;
    }
    @SuppressWarnings({"rawtypes"})
    public static Class getClassInJar(String jarPath, String clazz) throws IOException, ClassNotFoundException{
        File jarFile=new File(jarPath);
        JarFile jar=new JarFile(jarFile);
        Class c;
        URL url=jarFile.toURI().toURL();
        try(URLClassLoader loader=new URLClassLoader(new URL[] {url}, Thread.currentThread().getContextClassLoader())){
            Enumeration<JarEntry> entries=jar.entries();
            while(entries.hasMoreElements()){
                JarEntry entry=entries.nextElement();
                String realName=entry.getRealName();
                if(realName.endsWith(".class")==false){
                    continue;
                }
                String fullName=realName.replaceAll("/", ".").substring(0, realName.length()-6);
                if(fullName.equals(clazz)==false){
                    continue;
                }
                c=loader.loadClass(fullName);
                return c;
            }
            return null;
        }finally{
            jar.close();
        }
    }
}
