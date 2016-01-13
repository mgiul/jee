package dao;

import javax.ejb.Local;

import entities.Admin;
import entities.Client;



@Local
public interface IAdminServices {
	public Long AddAdmin(Admin admin);
	public Admin getAdmin(Long id_ad);
	public void removeAdmin(Long id_ad);
	public void updateAdmin(Admin admin);
	public Admin authenticate(String login, String password);

}
