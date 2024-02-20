package le_projet.menu_interactif_fonctions_heritage_flux;

/*
#	Auteur   : Nicolas Lazarte
#	Section  : TP3
#	Fichier  : CteEpargne.java
#	Class    : CpteEpargne
*/
import java.util.*;
import java.io.*;
// complétez la classe selon sa description dans l'énoncé
// cette classe doit implémenter l'interface Serializable comme de la classe
// Compte
public class CpteEpargne extends Compte implements Serializable {
     // ================ Declaration des Attributs ===============
	protected double taux; 
        Compte compte;
     // ================ Le constructeur ===============
         
	protected CpteEpargne(String numero, String type) {
            super(numero, type);
            compte.typeCpte = "Epargne";
            taux = controleTaux();
	 }

 // Completez  la méthode selon sa decription dans l'énoncé
	protected double controleTaux() {
	 double tmp = 0.0;
         Scanner emplacement = new Scanner(System.in);
         System.out.println("Selectionner le taux d'emplacement pour le Compte Epargne : ");
         tmp = emplacement.nextDouble();
         while (tmp > 0){
             System.out.println("Le taux de " + tmp + " est accepte");
         }if(tmp < 0){
             System.out.println("Taux refusee parce que l'emplacement est negatif");
         }
         tmp = this.taux;
         return tmp;
	}
 // Completez  la méthode selon sa decription dans l'énoncé
        @Override
	public void afficherCpte()   {
            System.out.println("Le taux d'emplacement est " + taux + "%");
            compte.val_courante = compte.val_courante * taux; 
            System.out.println("La valeur courante est " + compte.val_courante);
		
	}
	public double quelTaux()	{
		return taux;
	}
}