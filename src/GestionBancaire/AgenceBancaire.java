package GestionBancaire;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AgenceBancaire {
	private int Code;
	private String nom;
	private ArrayList<Client> clients;
	
	public AgenceBancaire(int code,String nom)
	{
		this.Code = code;
		this.nom = nom;
		this.clients = new ArrayList<Client>();
	}
	
	public Client getClient(int cin)
	{
		
		Iterator<Client> it =  clients.iterator();
		Client client;
		while(it.hasNext())
		{
			client = it.next();
			if(client.getCIN() == cin)
			{
				return client;
			}
		}
		return null;
	}
	
	public void addClient(Client client)
	{
		clients.add(client);
	}
	
	public void removeClient(int cin)
	{
		Iterator<Client> it =  clients.iterator();
		boolean trouver = false;
		Client client;
		while(it.hasNext() && !trouver)
		{
			client = it.next();
			if(client.getCIN() == cin)
			{
				trouver = true;
				it.remove();
			}
		}
	}
	
	public void printClients()
	{
		Collections.sort(clients);
		
		Iterator<Client> it =  clients.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
