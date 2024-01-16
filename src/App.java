import java.io.File;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import facade.Form;
import facade.utils.Constantes;
import facade.utils.FileUtils;

public class App {
    public static void main(String[] args) throws Exception {
        String targetJar=args[0];
        String classPackage;
        String viewName;
        int typeView;
        String titleView;
        try(Scanner scanner=new Scanner(System.in)){
            System.out.print("Classe de reference: ");
            classPackage=scanner.next();
            System.out.print("Nom de la vue: ");
            viewName=scanner.next();
            System.out.print("Type de la vue:\n1) Formulaire\n2) Liste en tableau\n3) Formulaire et liste\n>");
            typeView=scanner.nextInt();
            scanner.nextLine();
            System.out.print("Titre de la vue: ");
            titleView=scanner.nextLine();
        }
        Form form;
        String structure="";
        switch(typeView){
            case Constantes.FORM_ID:
                form=Form.constructForm(titleView, targetJar, classPackage);
                structure=form.getStructureFormulaire();
                break;
            case Constantes.LISTE_ID:
                form=Form.constructListe(titleView, targetJar, classPackage);
                structure=form.getStructureListe();
                break;
            case Constantes.FORMLISTE_ID:
                form=Form.constructFormListe(titleView, targetJar, classPackage);
                structure=form.getStructureFormListe();
                break;
        }
        // Document doc=Jsoup.parse(structure);
        File fichier=FileUtils.writeNewFile(viewName, structure);
        fichier.createNewFile();
    }
}
