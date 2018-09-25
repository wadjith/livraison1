package cm.objis.wtt.pharmacie.metier;

import java.util.Vector;

import cm.objis.wtt.pharmacie.domaine.Produit;

/**
 * @author WTT: WADJI TCHAGANG Thierry
 * @version 1.0
 * Cette classe pr�sente les diff�rentes op�rations que l'on peut effectuer sur les produits
 *
 */
public class ProduitMetier {
	
	/**
	 * Conserve les produits enregistr�s
	 */
	private Vector<Produit> listProduit;
	
	
	public ProduitMetier() {
		super();
		this.listProduit = new Vector<Produit>();
	}

	/**
	 * Enregistre les produits dans l'application et affiche le d�tail du produit enregist�.
	 * 
	 * @param ref: r�ference du Produit
	 * @param libelle: Libelle du Produit
	 * @param prix: Prix du produit
	 * @param qte: quantit� de produit
	 * @return String : D�tail sur le produit enregistr�
	 * 
	 * 
	 */
	public String enregistreProduit(String ref, String libelle, double prix, int qte){
		Produit p = new Produit(ref, libelle, prix, qte);
		this.listProduit.add(p);
		return this.detailProduit(p);
		
	}
	
	/**
	 * 
	 * @param p: un objet Produit
	 * @return: un String repr�sentant les d�tails sur le produit
	 */
	public String detailProduit(Produit p){
		return p.toString();
	}
	
	/**
	 * Recherche les produits dont le libelle contient le motcle.
	 * 
	 * @param motcle
	 * @return
	 * Une chaine de caract�re contenant la liste des produits retrouv�s.
	 */
	public String rechercheProduit(String motcle){
		
		Vector<Produit> result = new Vector<>();
		for (Produit p : listProduit) {
			if(p.getLibelle().contains(motcle)){
				result.add(p);
			}
		}
		return (result.size() > 0) ? result.toString() : "Aucun produit ne correspond � votre mot cl�";
	}
	
	public String listeProduit(){
		return this.listProduit.toString();
	}

}
