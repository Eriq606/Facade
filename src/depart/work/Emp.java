package depart.work;

import java.time.LocalDateTime;

import facade.annotations.FieldHelp;
import facade.annotations.FieldLabel;
import facade.annotations.NotAnInput;
import facade.annotations.SelectInput;

public class Emp {
    @FieldHelp("Votre nom restera confidentiel")
    private String nom;
    @NotAnInput
    private double salaire;
    @SelectInput
    private LocalDateTime embauche;
    @FieldLabel("Est marie")
    private boolean married;
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public double getSalaire() {
        return salaire;
    }
    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
    public LocalDateTime getEmbauche() {
        return embauche;
    }
    public void setEmbauche(LocalDateTime embauche) {
        this.embauche = embauche;
    }
    public boolean isMarried() {
        return married;
    }
    public void setMarried(boolean married) {
        this.married = married;
    }
    
}
