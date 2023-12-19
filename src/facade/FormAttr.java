package facade;

import com.google.gson.internal.LinkedTreeMap;

public class FormAttr {
    private String file;
    private String type;
    private double step;
    public String getFile() {
        return file;
    }
    public void setFile(String file) {
        this.file = file;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getStep() {
        return step;
    }
    public String getStepString(){
        return String.valueOf(getStep());
    }
    public void setStep(double step) {
        this.step = step;
    }
    public FormAttr(LinkedTreeMap<String, Object> tree) {
        setFile(tree.get("file").toString());
        setType(tree.get("type").toString());
        setStep((double)tree.get("step"));
    }
    
}
