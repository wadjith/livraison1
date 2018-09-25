package cm.objis.wtt.pharmacie.presentation;

import java.util.Scanner;

import cm.objis.wtt.pharmacie.metier.ProduitMetier;

/**
 * @author WTT: WADJI TCHAGANG Thierry
 * @version 1.0
 * La classe principale de notre application
 *
 */
public class Pharmacie {

	private static ProduitMetier pm = new ProduitMetier();
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("########################################################################");
		System.out.println("BIENVENUE DANS NOTRE APPLICATION DE GESTION DES PRODUITS PHARMACEUTIQUES");
		System.out.println("########################################################################");
		
		char rep = 'q';
		System.out.println("Les op�rations de notre applcation sont les suivantes:");
		System.out.println("e: Enregistrer un produit");
		System.out.println("r: Rechecher un produit par mot cl�");
		System.out.println("l: Lister tous les produits");
		System.out.println("q: Quitter l'application");
		do{
			System.out.println("Choisir l'op�ration que vous voulez effectuer.");
			System.out.print("e= Enregistrer - r= Recherccher - l= Lister - q= Quitter :");
			rep = sc.nextLine().charAt(0);
			switch(rep){
			case 'e':
				enregistreProduit();
				break;
			case 'r':
				rechercheProduit();
				break;
			case 'l':
				listeProduit();
				break;
			case 'q':
				sc.close();
				System.out.println("Aurevoir");
				break;
			default :
				System.out.println("l'op�ration choisie n'existe pas");		
			}
			
			
		}while(rep != 'q');

	}
	
	/**
	 * Proc�dure d'enregistrement des produits 
	 */
	private static void enregistreProduit(){
		System.out.println("################################");
		System.out.println("  ENREGISTREMENT DE PRODUIT  ");
		System.out.println("################################");
		
		Scanner sc = new Scanner(System.in);
		// Je r�cup�re les propri�t�s du Produit
		System.out.print("R�ference: ");
		String ref = sc.nextLine();
		System.out.print("Libelle: ");
		String libelle = sc.nextLine();
		System.out.print("Prix: ");
		double prix = Double.parseDouble(sc.nextLine());
		System.out.print("Quantit�: ");
		int qte = Integer.parseInt(sc.nextLine());
		
		// j'enregistre le nouveau produit
		String p = pm.enregistreProduit(ref, libelle, prix, qte);
		System.out.println("Le produit enregistr� est le suivant");
		System.out.println(p);
		System.out.println("########## FIN ENREGISTREMENT ########");
		System.out.println();
		
	}
	/**
	 * Proc�dure de recherche d'un produit par mot cl�
	 */
	private static void rechercheProduit(){
		System.out.println("################################");
		System.out.println("   RECHERCHE DE PRODUIT   ");
		System.out.println("################################");
		System.out.print("Entrer le mot cl�: ");
		String motcle = sc.nextLine();
		
		//Je rechercche les produits correspondants
		String reponse = pm.rechercheProduit(motcle);
		System.out.println("Le r�sultat de la recherche: ");
		System.out.println(reponse);
		System.out.println("######## FIN RECHERCHE #########");
		System.out.println();
		
	}
	/**
	 * Proc�dure de liste des produits
	 */
	private static void listeProduit(){
		System.out.println("################################");
		System.out.println("   LISTE DE TOUS LES PRODUITS   ");
		System.out.println("################################");
		System.out.println(pm.listeProduit());
		System.out.println("########### FIN LISTE ##########");
		System.out.println();
		
	}

}
