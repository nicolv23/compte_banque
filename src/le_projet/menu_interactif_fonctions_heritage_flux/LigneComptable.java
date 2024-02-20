package le_projet.menu_interactif_fonctions_heritage_flux;

/*
#	Auteur   : Nicolas Lazarte 
#	Section  : Projet, TP3
#	Fichier  : LigneComptable.java
#	Class    : LigneComptable
*/

import java.io.*;
import java.text.*;
import java.util.*;
public class LigneComptable implements Serializable {
     // ================ Declaration des Attributs ===============
	private double valeur;
	private String date;
	private String motif;
	private String mode;
        Compte compte; 
  // ================ Les constructeurs ===============
    // compléter le constructeur selon la décription de l'énoncé
	public LigneComptable(double valeur) {
           this.valeur = valeur;
           if(valeur > compte.val_courante){
               System.out.println("Valeur creditee");
               this.valeur = valeur + compte.val_courante;
                
                
           } else if(valeur < compte.val_courante){
               System.out.println("Valeur debitee");
               this.valeur = compte.val_courante - valeur;
           }
           this.motif = controleMotif();
           this.mode = controleMode();
           this.date = controleDate();
	}
// ================ Les accesseurs ===============
       public double quelleValeur() {
		return valeur ;
	}
	public String quelMotif(){
		return motif ;
	}
	public String quelMode(){
		return mode ;
	}
	public String quelleDate(){
		return date ;
	}
       // ================ Les autres méthodes ===============
	private String controleDate() {
                Scanner lectureClavier = new Scanner(System.in);
		int nb = 0;
		Date d = null;
		SimpleDateFormat formatIn=new SimpleDateFormat("dd/MM/yyyy"); 
		String sdate;
		while (d == null){
	   	try {
       	          System.out.print("Entrer une date (jj/mm/aaaa): ");
	     	  d = formatIn.parse(lectureClavier.next());
                }
	    	catch(ParseException p) {
		    nb++;
		    if (nb  >= 3) d = new Date();
	     }
	   }
    	sdate = formatIn.format(d); 
    	return sdate;
	}
 // Completez  la méthode selon sa decription dans l'énoncé
	private String controleMode() {
            String tmpS = "";
            Scanner lecture = new Scanner(System.in);
            System.out.println("Quelle mode de paiement voulez-vous utiliser (CB/Virement/Cheque)?: ");
            tmpS = lecture.next();
            while (!"CB".equals(tmpS) || !"V".equals(tmpS) || !"C".equals(tmpS)) {
                switch (tmpS) {
                    case "CB":
                        System.out.println("CB");
                        break;
                    case "V":
                        System.out.println("Virement");
                        break;
                    case "C":
                        System.out.println("Cheque");
                        break;
                    default:
                        System.out.println("Veuillez saisir un choix valide");
                        System.out.println("Repetition de la boucle");
                        break;
                }
            }
		tmpS = this.mode;
		return tmpS;
	}
        // Completez  la méthode selon sa decription dans l'énoncé
	private String controleMotif() {  
		String tmpS = "";
                Scanner motif = new Scanner(System.in);
                System.out.println("Selectionnez le motif de paiement (Salaire/Loyer/Alimentation/Divers) : ");
                tmpS = motif.next();
                while(!"S".equals(tmpS) || !"L".equals(tmpS) || !"A".equals(tmpS) || !"D".equals(tmpS)){
                    switch (tmpS){
                        case "S":
                            System.out.println("Salaire");
                            break;
                        case "L":
                            System.out.println("Loyer");
                            break;
                        case "A":
                            System.out.println("Alimentation");
                            break;
                        case "D":
                            System.out.println("Divers");
                            break;
                        default:
                            System.out.println("Veuillez saisir un choix valide");
                            System.out.println("Retour a la boucle");
                    }
                }
                tmpS = this.motif;
		return tmpS;
	}
        // Completez  la méthode selon sa decription dans l'énoncé
        public void afficherLigne() {
        if (valeur > compte.val_courante) {
            System.out.println("Le mode de paiement sera en " + mode);
            System.out.println("Le motif du paiement est de " + motif);
            System.out.println("La date du paiement effectue est le " + date);
        } 
        else {
            System.out.println("Montant restant " + valeur);
        }
    }}
