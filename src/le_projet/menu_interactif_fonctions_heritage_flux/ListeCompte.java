package le_projet.menu_interactif_fonctions_heritage_flux;

/*
#	Auteur :
#	Section  : Projet, TP3
#	Fichier  : ListeCompte.java
#	Class    : ListeCompte
*/

import java.util.*;
import java.io.*;
public class ListeCompte extends Compte implements Serializable {
    // ================ Declaration des Attributs ===============
    //Declarer les attributs possibles
    // protected ListeCompte [] comptes = new ListeCompte[10];
    protected Map<String, String> comptes = new HashMap<>();
    protected Map<String, String> ligneComptable = new HashMap<>();
    int choix; CpteEpargne epargne;
  // ================ Les constructeurs ===============
    // compléter le constructeur selon la décription de l'énoncé	 
	public ListeCompte(String numero, String type)   {
		super(numero, type);
	}
       
        //Completez chaque méthode selon sa decription dans l'énoncé
	public void ajouteUnCompte(String t) {
            String numero = " ";
            Scanner client = new Scanner(System.in);
            System.out.println("Quelle type de compte voulez-vous creer? \n"
                    + "(E)pargne \n"
                    + "(A)utre : ");
            t = client.next();
            switch(t){
                case "e":
                case "E":
                    System.out.println("Quelle est le numero du Compte que vous voulez creer: ");
                    numero = client.next();
                    if (numero.contains(t)) {
                        System.out.println("Le compte: " + numero + " existe deja");
                        break;
                    } else {
                        t = "Epargne";
                        System.out.print("Première valeur créditée: ");
                        val_courante = client.nextDouble();
                        
                        comptes.put(numero, t);
                        comptes.values();
                        Set<String> donnees = comptes.keySet();
                        ArrayList<String> listeDonnees = new ArrayList<>(donnees);
                        listeDonnees.addAll(donnees);
                        System.out.println("Un compte Epargne a ete cree");
                        break;
                    }
                case "a":
                case "A":
                    System.out.println("Quelle est le numero du Compte que vous voulez creer: ");
                    numero = client.next();
                    if (numero.contains(t)) {
                        System.out.println(comptes.keySet());
                        break;
                    } else{
                        t = "Ordinaire";
                        System.out.print("Première valeur créditée :");
                        val_courante = client.nextDouble();
                        comptes.put(numero, t);
                        Set<String> donnees = comptes.keySet();
                        ArrayList<String> listeDonnees = new ArrayList<>(donnees);
                        listeDonnees.addAll(donnees);
                        System.out.println("Un compte ordinaire a ete cree");
                        break;
                    }
                default:
                    System.out.println("Valeur invalide");
        }
}
           
	public void ajouteUneLigne(String n) {
            creerLigne();
            afficherCpte();
	}
        
	public Compte quelCompte(String n){
		Compte c = new Compte();
                c.quelTypeDeCompte();
		
		return(c);
	}
	public void rechercheUnCompte (String n) {
            System.out.println(comptes.keySet());
            Scanner recherche = new Scanner(System.in);
            System.out.println("Veuillez écrire le numéro du compte recherché: ");
            n = recherche.next();
            if(comptes.keySet().contains(n)){
                System.out.println("Le compte no: " + n + " est un compte de type " + comptes.get(n));
                }
            else if(comptes.keySet().contains(n)){
                System.out.println("Le compte no: " + n + " est un compte de type " + comptes.get(n));
            }
            else if(!comptes.keySet().contains(n)){
                System.out.println("Le numero de compte " + n + " n'existe pas");
                }
        }
            
	
	public void supprimeUnCompte(String n) {
            System.out.println(comptes.keySet());
            Scanner supprimer = new Scanner(System.in);
            System.out.println("\nIndiquez le numero de compte que vous voulez supprimer: ");
            n = supprimer.next();
            if (comptes.keySet().contains(n)) {
                comptes.keySet().remove(n);
                System.out.println("Le numero de compte: " + n + " a ete supprime");
            } else {
                System.out.println("Le numero de compte " + n + " n'existe pas");
            }
        }

        
	public void afficheLesComptes() {
            System.out.println("========== Affichage de l'ensemble des comptes ==========\n");
            System.out.println("Le numero du compte est: " + comptes.keySet() + "\nLe type de compte est: " + comptes.values());
            }
        
        public void ecritureFichier (DataOutputStream tmp) throws Exception {
            tmp.writeUTF(comptes.keySet().toString());
            tmp.writeUTF(comptes.values().toString());
        }
        
        public void lireFichier (DataInputStream tmp) throws Exception {
            DataInputStream.readUTF((DataInput) tmp);
        }

        
      
      }
	
	


