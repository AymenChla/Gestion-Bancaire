package GestionBancaire;
import java.util.Date;

public class Transaction {
	
	private Date date;
	private int type;
	private double montant;
	
	public Transaction(Date date, int type, double montant)
	{
		this.date = date;
		this.type = type;
		this.montant = montant;
	}
	
	public String toString()
	{
		return "Date: " + date + " type: " + type + " montant: " + montant;
	}
	
	
}
