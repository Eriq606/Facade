package facade;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import facade.annotations.FieldHelp;
import facade.annotations.FieldLabel;
import facade.annotations.SelectInput;
import facade.utils.Constantes;
import facade.utils.FileUtils;
import facade.utils.StringUtils;

public class FieldEntity {
    private Field field;
    private FormAttr form;
    public Field getField() {
        return field;
    }
    public void setField(Field field) {
        this.field = field;
    }
    public FormAttr getForm() {
        return form;
    }
    public void setForm(FormAttr form) {
        this.form = form;
    }
    private String getFieldLabel() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
        Annotation annote=getField().getAnnotation(FieldLabel.class);
        String help=StringUtils.majStart(getField().getName());
        if(annote==null){
            return help;
        }
        return annote.annotationType().getMethod("value").invoke(annote).toString();
    }
    private String getFieldHelp() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
        Annotation annote=getField().getAnnotation(FieldHelp.class);
        String help="";
        if(annote==null){
            return help;
        }
        return annote.annotationType().getMethod("value").invoke(annote).toString();
    }
    public String getStructure() throws Exception{
        String fileToUse=getForm().getFile();
        Annotation selectInput=getField().getAnnotation(SelectInput.class);
        if(selectInput!=null){
            fileToUse=Constantes.SELECTINPUT_FILE;
        }
        File file=new File(Constantes.COMPONENTS_DIR+fileToUse);
        String structure=FileUtils.getContentOfFile(file);
        structure=structure.replace("[field]", getField().getName());
        structure=structure.replace("[fieldmaj]", getFieldLabel());
        structure=structure.replace("[fieldhelp]", getFieldHelp());
        structure=structure.replace("[inputstep]", getForm().getStepString());
        structure=structure.replace("[inputtype]", getForm().getType());
        return structure;
    }
}
