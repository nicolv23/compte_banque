package le_projet.menu_interactif_fonctions_heritage_flux;

/*
#	Section  : Projet
#	Fichier  : TesDate.java
#	Class    : TestDate
*/
import java.util.*;
import java.text.*;
public class TestDate {
	public static void main(String [] arg)   {
		int nb = 0;
		SimpleDateFormat formatIn=new SimpleDateFormat("dd/mm/yyyy"); 
        Date date1, date2;
		String s = null;
        Scanner lectureClavier = new Scanner(System.in);
		while (s == null){
	   	try {
                  System.out.print("Entrer une date (dd/mm/aaaa): ");
	              date1 = formatIn.parse(lectureClavier.next());
                  s = formatIn.format(date1); 
                  System.out.println("--"+s+"--");
                }
	        catch( ParseException p) {
		    nb++;
		    if (nb  >= 2) {
                       date1 = new Date();
                       s = formatIn.format(date1); 
                       System.out.println("--"+s+"--");
		    }
  	        }
	    }
	}
}
	