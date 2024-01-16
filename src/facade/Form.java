package facade;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;

import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

import facade.annotations.NotAnInput;
import facade.utils.Constantes;
import facade.utils.FileUtils;

public class Form {
    private Class classe;
    private String title;
    private FieldEntity[] fields;
    private ListeEntity[] listeFields;
    public Class getClasse() {
        return classe;
    }
    public void setClasse(Class classe) {
        this.classe = classe;
    }
    public ListeEntity[] getListeFields() {
        return listeFields;
    }
    public void setListeFields(ListeEntity[] listeFields) {
        this.listeFields = listeFields;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public FieldEntity[] getFields() {
        return fields;
    }
    public void setFields(FieldEntity[] fields) {
        this.fields = fields;
    }
    public String getStructureFormulaire() throws Exception{
        File file=new File(Constantes.FORM_FILE);
        String structure=FileUtils.getContentOfFile(file);
        structure=structure.replace("[formtitle]", getTitle());
        String fieldStructs="";
        for(FieldEntity f:getFields()){
            fieldStructs+=f.getStructure()+"\n";
        }
        structure=structure.replace("[fields]", fieldStructs);
        return structure;
    }
    public String getStructureListe() throws Exception{
        File file=new File(Constantes.LISTE_FILE);
        String structure=FileUtils.getContentOfFile(file);
        structure=structure.replace("[listetitle]", getTitle());
        String fieldStructs="";
        String listElementStructs="";
        for(ListeEntity f:getListeFields()){
            fieldStructs+=f.getStructure()+"\n";
            listElementStructs+=f.getListeElementStructure()+"\n";
        }
        structure=structure.replace("[header]", fieldStructs);
        structure=structure.replace("[[list-element]]", listElementStructs);
        structure=structure.replace("[class-name]", getClasse().getName());
        return structure;
    }
    public String getStructureFormListe() throws Exception{
        File file=new File(Constantes.FORMLISTE_FILE);
        String structure=FileUtils.getContentOfFile(file);
        structure=structure.replace("[formtitle]", getTitle());
        String fieldStructs="";
        for(FieldEntity f:getFields()){
            fieldStructs+=f.getStructure()+"\n";
        }
        structure=structure.replace("[fields]", fieldStructs);
        structure=structure.replace("[listetitle]", getTitle());
        fieldStructs="";
        String listElementStructs="";
        for(ListeEntity f:getListeFields()){
            fieldStructs+=f.getStructure()+"\n";
            listElementStructs+=f.getListeElementStructure()+"\n";
        }
        structure=structure.replace("[header]", fieldStructs);
        structure=structure.replace("[[list-element]]", listElementStructs);
        structure=structure.replace("[class-name]", getClasse().getName());
        return structure;
    }
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Form constructForm(String title, String targetJar, String clazz) throws ClassNotFoundException, IOException{
        Form form=new Form();
        form.setTitle(title);
        Class classChosen=FileUtils.getClassInJar(targetJar, clazz);
        File file=new File(Constantes.FORMFIELD_JSON);
        String formJson=FileUtils.getContentOfFile(file);
        HashMap<String, LinkedTreeMap<String, Object>> jsonFile=new GsonBuilder().create().fromJson(formJson, HashMap.class);
        Field[] fields=classChosen.getDeclaredFields();
        LinkedList<FieldEntity> liste=new LinkedList<>();
        Annotation notInput;
        FieldEntity entity;
        for(int i=0;i<fields.length;i++){
            notInput=fields[i].getAnnotation(NotAnInput.class);
            if(notInput!=null){
                continue;
            }
            entity=new FieldEntity();
            entity.setField(fields[i]);
            entity.setForm(new FormAttr(jsonFile.get(fields[i].getType().getSimpleName())));
            liste.add(entity);
        }
        FieldEntity[] entities=new FieldEntity[liste.size()];
        for(int i=0;i<entities.length;i++){
            entities[i]=liste.get(i);
        }
        form.setFields(entities);
        return form;
    }
    @SuppressWarnings({"rawtypes"})
    public static Form constructListe(String title, String targetJar, String clazz) throws ClassNotFoundException, IOException{
        Form form=new Form();
        form.setTitle(title);
        Class classChosen=FileUtils.getClassInJar(targetJar, clazz);
        Field[] fields=classChosen.getDeclaredFields();
        LinkedList<ListeEntity> liste=new LinkedList<>();
        ListeEntity entity;
        for(int i=0;i<fields.length;i++){
            entity=new ListeEntity();
            entity.setField(fields[i]);
            liste.add(entity);
        }
        ListeEntity[] listeEntities=new ListeEntity[liste.size()];
        for(int i=0;i<listeEntities.length;i++){
            listeEntities[i]=liste.get(i);
        }
        form.setListeFields(listeEntities);
        form.setClasse(classChosen);
        return form;
    }
    @SuppressWarnings({"rawtypes"})
    public static Form constructFormListe(String title, String targetJar, String clazz) throws ClassNotFoundException, IOException{
        Form form=new Form();
        form.setTitle(title);
        Class classChosen=FileUtils.getClassInJar(targetJar, clazz);
        File file=new File(Constantes.FORMFIELD_JSON);
        String formJson=FileUtils.getContentOfFile(file);
        HashMap<String, LinkedTreeMap<String, Object>> jsonFile=new GsonBuilder().create().fromJson(formJson, HashMap.class);
        Field[] fields=classChosen.getDeclaredFields();
        LinkedList<FieldEntity> liste=new LinkedList<>();
        Annotation notInput;
        FieldEntity entity;
        for(int i=0;i<fields.length;i++){
            notInput=fields[i].getAnnotation(NotAnInput.class);
            if(notInput!=null){
                continue;
            }
            entity=new FieldEntity();
            entity.setField(fields[i]);
            entity.setForm(new FormAttr(jsonFile.get(fields[i].getType().getSimpleName())));
            liste.add(entity);
        }
        FieldEntity[] entities=new FieldEntity[liste.size()];
        for(int i=0;i<entities.length;i++){
            entities[i]=liste.get(i);
        }
        form.setFields(entities);
        LinkedList<ListeEntity> liste2=new LinkedList<>();
        ListeEntity entity2;
        for(int i=0;i<fields.length;i++){
            entity2=new ListeEntity();
            entity2.setField(fields[i]);
            liste2.add(entity2);
        }
        ListeEntity[] listeEntities=new ListeEntity[liste2.size()];
        for(int i=0;i<listeEntities.length;i++){
            listeEntities[i]=liste2.get(i);
        }
        form.setListeFields(listeEntities);
        form.setClasse(classChosen);
        return form;
    }
}
