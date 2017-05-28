package GestionBancaire;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.Date;

abstract public class Compte {
	
	protected int code;
	protected double solde;

	
	//protected Transaction[] transaction;
	protected ArrayList<Transaction> transaction;
	
	//public static final int nbTransact = 100;
	//private int nbLigneReel;
	
	public Compte(double solde,int code)
	{
		this.solde = solde;
		this.code = code;
		//this.nbLigneReel = -1;
		//this.transaction = new Transaction[nbTransact];
		transaction = new ArrayList<Transaction>();
	}
	
	
        public double getSolde() {
            return solde;
        }
        
	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public void deposer(double montant)
	{
		Transaction t = new Transaction(new Date(), 0, montant);
		addTransaction(t);
		this.solde += montant;
	}
	
	public void retirer(double montant)
	{
		Transaction t = new Transaction(new Date(), 1, montant);
		addTransaction(t);
		this.solde -= montant;
	}
	
	abstract public String toString();
	
	public void addTransaction(Transaction t)
	{
		transaction.add(t);
	}
	
	

	public void afficher()
	{
		System.out.println(this.transaction.size());
		
		Iterator<Transaction> it =  transaction.iterator();
		while(it.hasNext() )
		{
			System.out.println(it.next());
		}
	}
}
