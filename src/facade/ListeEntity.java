package facade;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import facade.annotations.FieldLabel;
import facade.utils.Constantes;
import facade.utils.FileUtils;
import facade.utils.StringUtils;

public class ListeEntity {
    private Field field;

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
    public String getFieldLabel() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
        Annotation annote=getField().getAnnotation(FieldLabel.class);
        String help=StringUtils.majStart(getField().getName());
        if(annote==null){
            return help;
        }
        return annote.annotationType().getMethod("value").invoke(annote).toString();
    }
    public String getStructure() throws Exception{
        File file=new File(Constantes.LISTEHEADER_FILE);
        String content=FileUtils.getContentOfFile(file);
        content=content.replace("[headervalue]", getFieldLabel());
        return content;
    }
    public String getListeElementStructure() throws FileNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
        File file=new File(Constantes.LISTELEMENT_FILE);
        String content=FileUtils.getContentOfFile(file);
        content=content.replace("[field-name]", StringUtils.majStart(getField().getName()));
        return content;
    }
}
