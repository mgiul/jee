package dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import entities.Client;



@Remote
public interface IClientServices {
	
	public Long AddClient(Client client);
	public Client getClient(Long id_cl);
	public void removeClient(Long id_cl);
	public void updateClient(Client client);
	public Client authenticate(String login, String password);
}
