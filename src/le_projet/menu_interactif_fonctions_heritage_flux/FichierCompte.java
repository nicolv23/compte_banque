package le_projet.menu_interactif_fonctions_heritage_flux;

/*
#	Auteur : Nicolas Lazarte 
#	Section  : Projet, TP3
#	Fichier  : FichierCompte.java
#	Class    : FichierCompte
*/

import java.io.*;
import java.util.ArrayList;
public class FichierCompte extends Compte implements Serializable {
  protected String nomDuFichier = "Compte.dat";
  protected ObjectOutputStream fWo; 
  protected ObjectInputStream fRo;  
  ListeCompte listeCompte = null;
  private char mode;
 /*
  Ecrire les méthodes ouvrir(String s), fermer(),lire(), ecrire(ListeCompte tmp)
  selon leur description dans l'énoncé
  */
  
public FichierCompte(String numero, String type) {
      super(numero, type);
	}

public boolean ouvrir (String s) throws FileNotFoundException, IOException {
    try {
        FileInputStream ouvrir = new FileInputStream(nomDuFichier); 
        System.out.println("Ouverture du fichier " + nomDuFichier);
        ouvrir.read();
        ouvrir.close();
        } catch (IOException e) {
            System.out.println("Message d'erreur de l'ouverture du fichier" + nomDuFichier);
        }
        return true;
    }

public void ecrire(ListeCompte tmp, ArrayList<ListeCompte> listeComptes) throws Exception {
    try {
        FileOutputStream ecriture = new FileOutputStream(nomDuFichier);
        fWo = new ObjectOutputStream(ecriture);
        tmp = new ListeCompte(numéroCpte, typeCpte);
        fWo.writeObject(tmp);
        try{
            fWo = new ObjectOutputStream (ecriture);
        listeComptes = new ArrayList<>();
        for(int i = 0; i < listeComptes.size(); i++){
            fWo.writeUTF(listeComptes.get(i).toString());
        fWo.close();
        }} catch (IOException l){
            System.out.println("Erreur d'ecriture dans le Arraylist " + listeComptes);
        }
    } catch (IOException e){
        System.out.println("Erreur d'ecriture");
    }
}

public void lire () throws Exception {
    try {
        FileInputStream lecture = new FileInputStream(nomDuFichier);
        fRo = new ObjectInputStream(lecture);
        ListeCompte liste = new ListeCompte(numéroCpte, typeCpte);
        fRo.readObject();
        fRo.close();
    } catch(IOException | ClassNotFoundException e){
        System.out.println("Impossible de lire le fichier " + nomDuFichier);
    }
}

public boolean fermer (String s) throws FileNotFoundException, IOException {
    try {
        FileOutputStream fermer = new FileOutputStream(nomDuFichier);
        System.out.println("Effacement du contenu de l'ancien fichier: " + nomDuFichier);
        fermer.close();
    } catch (IOException e){
        System.out.println("Erreur de fermeture du fichier " + nomDuFichier);
    }
    return true;
}

public void ecrireListe(ArrayList<ListeCompte> listeComptes) throws Exception {
    try{
        FileOutputStream liste = new FileOutputStream(nomDuFichier);
        fWo = new ObjectOutputStream (liste);
        listeComptes = new ArrayList<>();
        for(int i = 0; i < listeComptes.size(); i++){
            fWo.writeUTF(listeComptes.get(i).toString());
        }
        fWo.close();
    } catch (IOException e){
        System.out.println("Erreur d'ecriture du ArrayList " + listeComptes);
    }
    }
}