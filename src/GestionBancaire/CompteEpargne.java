package GestionBancaire;
import java.util.Date;

public class CompteEpargne extends Compte implements Comparable{
	
	private double tauxInteret;
	
	public CompteEpargne(int code, double solde, double tauxInteret)
	{
		super(solde,code);
		this.tauxInteret = tauxInteret;
	}
	
	public void deposer(double montant)
	{
		Transaction t = new Transaction(new Date(), 0, montant);
		addTransaction(t);
		this.solde += montant + montant*this.tauxInteret;
	}
	
	public String toString()
	{
		return "code: " + this.code + "	solde: " + this.solde + " tauxInteret: "+this.tauxInteret;
	}
	
	public int compareTo(Object c)
	{
		if(c != null)
		{
			CompteEpargne cc;
			cc = (CompteEpargne) c;
			if(this.tauxInteret > cc.tauxInteret) return 1;
			else if(this.tauxInteret == cc.tauxInteret) return 0;
		}
		return -3;
	}
}
