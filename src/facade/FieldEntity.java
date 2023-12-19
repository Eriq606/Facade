package facade;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import facade.annotations.FieldHelp;
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
    private String getFieldHelp() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
        Annotation annote=getField().getAnnotation(FieldHelp.class);
        String help="";
        if(annote==null){
            return help;
        }
        return FieldHelp.class.getMethod("value").invoke(annote).toString();
    }
    public String getStructure() throws Exception{
        File file=new File(Constantes.COMPONENTS_DIR+getForm().getFile());
        String structure=FileUtils.getContentOfFile(file);
        structure=structure.replace("[field]", getField().getName());
        structure=structure.replace("[fieldmaj]", StringUtils.majStart(getField().getName()));
        structure=structure.replace("[fieldhelp]", getFieldHelp());
        structure=structure.replace("[inputstep]", getForm().getStepString());
        return structure;
    }
}
