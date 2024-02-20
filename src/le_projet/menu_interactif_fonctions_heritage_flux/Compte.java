package le_projet.menu_interactif_fonctions_heritage_flux;

/*
#	Auteur   : Nicolas Lazarte
#	Section  : TP3
#	Fichier  : Compte.java
#	Class    : Compte
*/
import java.util.*;
import java.io.*;
public class Compte implements Serializable {
 // ================ Declaration des Attributs ===============
/*
•	typeCpte : String       // pour identifier le type de compte
•	val_courante : double    // la somme courant
•	numéroCpte : String   // numero de compte
•	ligne []: LigneComptable   // tableau ligne de compte qui permet contenir dix lignes comptables.
•	nbLigneRéel : int   // nombre de ligne
•	Les lignes comptables étant créées au fur et à mesure des opérations réalisées par    l’utilisateur, il est nécessaire de définir une variable (nbLigneRéel), qui compte le nombre de lignes comptables effectivement créées en cours d’exécution du programme.
•	NBLigne : int  // est un constant statique qui vaut  10  et  qui représente le nombre maximal de lignes comptables à traiter
 */
    protected String typeCpte;
    protected double val_courante;
    protected String numéroCpte;
    protected LigneComptable [] ligne = new LigneComptable[10];
    protected int nbLigneRéel;
    protected int NBLigne = 10;
    ListeCompte liste; LigneComptable lignes;
    CpteEpargne epargne;
    
  // ================ Les constructeurs ===============
    // compléter le constructeur selon la décription de l'énoncé
 public Compte (){
     this.numéroCpte = " ";
     this.typeCpte = controleType();
     this.val_courante = 0;
     this.nbLigneRéel = -1;
 }
  // compléter le constructeur selon la décription de l'énoncé
 public Compte(String numero, String type)  {
     this.numéroCpte = numero;
     this.typeCpte = type;
     this.val_courante = 0;
     this.nbLigneRéel = -1;  

 }
 
 
   // ================ Les accesseurs ===============
  // Enlevez le grand commentaire est completez chaque méthode selon
 // selon sa decription dans l'énoncé
 
 public LigneComptable[] quelleLigne(int n)	{
     Scanner lecture = new Scanner(System.in);
     System.out.println("Quelle ligne voulez-vous indiquer?: ");
     n = lecture.nextInt();
     System.out.println("La ligne " + n + " sera reservee");
     nbLigneRéel = lecture.nextInt();
     return ligne;
 }
	
 public int combienLignes(int nbLignes) {
	Scanner ligne = new Scanner(System.in);
        System.out.println("Combien de lignes voulez-vous reserver?: ");
        NBLigne = ligne.nextInt();
        return nbLignes;
 }

    
 public String quelTypeDeCompte() {
     String choix = " ";
     Scanner compte = new Scanner(System.in);
     do{
     System.out.println("Choissisez le type de Compte que vous voulez\n"
             + "1) (C)ourant\n"
             + "2) (E)pargne\n"
             + "3) (J)oint)\n"
             + "Faites votre choix: ");
     choix = compte.next(); 
     } while (!"C".equals(choix) && !"E".equals(choix) && !"J".equals(choix));
     System.out.print("Numéro du compte : ");
     numéroCpte = compte.nextLine();
     System.out.print("Première valeur créditée :");
     val_courante = compte.nextDouble();
     if(choix.equals("E")){
         System.out.print("Taux de placement : ");
         epargne.controleTaux();
         epargne.taux = compte.nextDouble();
     }
        return choix;}
     
 
     
     
		
 
 public String quelNumeroDeCompte(){
     Scanner numero = new Scanner(System.in);
     System.out.println("Indiquez le numero de compte: ");
     numéroCpte = numero.next();
     return numéroCpte;
 }
 public double quelleValeurCourante(){
     Scanner valeur = new Scanner(System.in);
     System.out.println("Quelle est la valeur que vous voulez ajouter au compte: ");
     val_courante = valeur.nextDouble();
     return val_courante;
 }
  // ================ Les autres méthodes ===============
 private String controleType()		{
    typeCpte = quelTypeDeCompte();
    return typeCpte;
 }
 private double controleValinit(){
     quelleValeurCourante();
     if(val_courante>0){
         System.out.println("Valeur courante accepte");
         System.out.println("Appuyez sur Entree pour continuer");
     }else if(val_courante<0){
         System.out.println("Valeur refusee, veuillez saisir une valeur qui est non negatif");
     }
     return val_courante;             
 }
 public void creerLigne(){
     combienLignes(NBLigne);
     for(int i = 0; i < ligne.length; i++ ){
         if(nbLigneRéel < NBLigne){
             Scanner lecture = new Scanner(System.in);
             System.out.println("Numéro du compte concerné: ");
             numéroCpte = lecture.next();
             System.out.println("La somme à créditer: ");
             val_courante = lecture.nextDouble();
             System.out.println(NBLigne);
             
     }
     else if(nbLigneRéel > NBLigne){
         System.out.println("Separation des lignes");
         decalerLesLignes();
     }
}
 }

 private void decalerLesLignes() {
		for(int i = 1; i < NBLigne ; i++)
		ligne[i-1] = ligne[i];
 }
 public void afficherCpte() {
     for(int i = 0; i < NBLigne; i++){
         System.out.println("Le numéro de compte est: " + numéroCpte);
         System.out.println("Le type de compte est: " + typeCpte);
         System.out.println("Nombre de lignes réels: " +nbLigneRéel);
         System.out.println("Valeur courante " + val_courante);
     }
 }

}