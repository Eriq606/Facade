import java.io.File;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

import facade.FieldEntity;
import facade.FormAttr;

public class App {
    static class Emp{
        String nom;
        double salaire;
        LocalDateTime embauche;
        boolean married;
    }
    public static void main(String[] args) throws Exception {
        File fichier=new File("data/formfield_type.json");
        String content="";
        try(Scanner scanner=new Scanner(fichier)){
            while(scanner.hasNextLine()){
                content+=scanner.nextLine()+"\n";
            }
        }
        HashMap<String, LinkedTreeMap<String, Object>> liste=new GsonBuilder().create().fromJson(content, HashMap.class);
        System.out.println(liste.get("int").get("step"));

        Field[] fields=Emp.class.getDeclaredFields();
        FieldEntity[] entities=new FieldEntity[fields.length];
        for(int i=0;i<entities.length;i++){
            entities[i]=new FieldEntity();
            entities[i].setField(fields[i]);
            entities[i].setForm(new FormAttr(liste.get(fields[i].getType().getSimpleName())));
        }
        
    }
}
