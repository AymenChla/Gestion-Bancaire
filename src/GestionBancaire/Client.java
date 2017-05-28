package GestionBancaire;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Comparable;

public class Client implements Comparable<Client>{
	
	private int CIN;
	private String nom;
	private String prenom;
	private String image;
	private ArrayList<Compte> comptes;
	
	public int getCIN() {
		
		return CIN;
	}
	
	
		
	public void setCIN(int cIN) {
		CIN = cIN;
	}

	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public ArrayList<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(ArrayList<Compte> comptes) {
		this.comptes = comptes;
	}

	public Compte getCompte(int code)
	{
		
		Iterator<Compte> it =  comptes.iterator();
		Compte compte;
		while(it.hasNext())
		{
			compte = it.next();
			if(compte.getCode() == code)
			{
				return compte;
			}
		}
		return null;
	}
	
	public Client(int CIN , String nom , String prenom)
	{
		this.CIN = CIN;
		this.nom = nom;
		this.prenom = prenom;
		comptes = new ArrayList<Compte>();
	}
	
	public void addCompteEpargne(int code, double SoldeInitial,double tauxInteret)
	{
		Compte compte = new CompteCourant(code,SoldeInitial,tauxInteret);
		comptes.add(compte);
	}

	public void addCompteCourant(int code,double SoldeInitial,double decouvertAutorise)
	{
		Compte compte = new CompteCourant(code,SoldeInitial,decouvertAutorise);
		comptes.add(compte);
	}
	
	public void printCompte()
	{
		Iterator<Compte> it = comptes.iterator();
		if(comptes.size() == 0)
			System.out.println("aucun compte");
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
	
	public void printReleve()
	{
		Iterator<Compte> it = comptes.iterator();
		Iterator<Transaction> itTrans;
		while(it.hasNext())
		{
			Compte compte = it.next();
			System.out.println(compte);
			itTrans = compte.transaction.iterator();
			while(itTrans.hasNext())
			{
				System.out.println(itTrans.next());
			}
		}
	}

	@Override
	public int compareTo(Client client) {
		
		if(client != null)
		{
			double soldetotal1=0;
			Iterator<Compte> it = this.comptes.iterator();
			while(it.hasNext())
			{
				soldetotal1 += it.next().solde;
			}
			
			double soldetotal2=0;
			it = client.comptes.iterator();
			while(it.hasNext())
			{
				soldetotal2 += it.next().solde;
			}
			
			//pour ordre croissant
			 return (int) (soldetotal1 - soldetotal2);
			
		}
		return -3;
	}


	public String toString()
	{
		return "nom: " + this.nom + " cin: " +this.CIN + " nombre comptes: " + this.comptes.size();
	}
}