package facade.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
}
