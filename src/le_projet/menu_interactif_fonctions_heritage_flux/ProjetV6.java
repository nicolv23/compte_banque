/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package le_projet.menu_interactif_fonctions_heritage_flux;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nicolas Lazarte
 */
public class ProjetV6 {
    //Completez la méthode main selon sa description dans l'énoncé
    public static void main (String [] argument) throws IOException, Exception {
		int choix = 0 ;
		String numeroLu = " ";
                String typeCompte = " "; FichierCompte fichier = new FichierCompte(numeroLu, typeCompte);
                ListeCompte comptes = null; CpteEpargne epargne = null;
                ArrayList<ListeCompte> listeComptes = new ArrayList<>();
                comptes = new ListeCompte(numeroLu, typeCompte);
                do{
                    choix = menuPrincipal();
                    switch (choix) {
                        case 1:
                            comptes.ajouteUnCompte(numeroLu);
                            //epargne.controleTaux();
                            listeComptes.add(comptes);
                            break;  
                        case 2:
                            if(listeComptes.isEmpty()){
                                System.out.println("La liste des comptes est vide");
                                break;
                            }else{
                                comptes.rechercheUnCompte(typeCompte);
                                break;
                            } 
                        case 3:
                            comptes.afficheLesComptes();
                            break;
                        case 4:
                            comptes.ajouteUneLigne(numeroLu);
                            break;
                        case 5:
                            comptes.supprimeUnCompte(numeroLu);
                            break;
                        case 6:
                            fichier.ouvrir("Compte.dat");
                            fichier.ecrire(comptes, listeComptes);
                            fichier.lire();
                            sortir(comptes);
                            break;
                        case 7:
                            alAide();
                            break;
                        case 8:
                            fichier.fermer("Compte.dat");
                            break;
                        default:
                            System.out.println("Donnée invalide, veuillez saisir une option à nouveau");
                            break;
                    }
                } while(choix != 6);
    }
 public static int menuPrincipal() {
	       int tmp;
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("\n===== MENU PRINCIPAL =====\n");
        System.out.println("1. Creation d'un compte");
        System.out.println("2. Affichage d'un compte");
        System.out.println("3. Affichage de tous les comptes");
        System.out.println("4. Ecrire une ligne comptable");
        System.out.println("5. Supprimer un compte ");
        System.out.println("6. Sortir");
        System.out.println("7. De l'aide");
        System.out.println("8. Effacer les donnees anterieures du fichier 'Compte.dat'");
        System.out.println();
        System.out.print("Votre choix : ");
        tmp = lectureClavier.nextInt();
        
        return tmp;
 }
  
    
        
        
 public static void sortir(ListeCompte comptes) throws IOException, Exception {
	System.out.println("Au revoir et a bientot!");
       /* FichierCompte fichier = new FichierCompte();
        fichier.ouvrir("Compte.dat");
        fichier.ecrire(comptes);
        fichier.lire(comptes);
        fichier.fermer(); */
	System.exit(0); 
 }
 public static void alAide( ) {
  System.out.println("\nOption 1. Pour creer un compte Courant entrer C ");
  System.out.println("          Pour creer un compte Joint entrer J ");
  System.out.println("          Pour creer un compte Epargne entrer E");
  System.out.print("            Puis, entrer le numero du compte, et"); 
  System.out.println(" sa premiere valeur creditee ");
  System.out.println("          Dans le cas d'un compte epargne, entrer le taux ");
  System.out.println("Option 2. Le systeme affiche les donnees du compte choisi ");
  System.out.println("Option 3. Ecrire une ligne comptable");
  System.out.println("Option 4. Pour quitter le programme");
  System.out.println("Option 5. Pour afficher de l'aide");
  System.out.println("Option 6. Sortir du Menu");
  System.out.println("Option 7. Affichage de l'aide\n");
} 
    
}
