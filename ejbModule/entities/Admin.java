package entities;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String nomAdmin, String passwordAdmin, String email) {
		super();
		this.nomAdmin = nomAdmin;
		this.passwordAdmin = passwordAdmin;
		this.email = email;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idAdmin;
	private String nomAdmin;
	private String passwordAdmin;
	private String email;
	public Long getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getNomAdmin() {
		return nomAdmin;
	}
	public void setNomAdmin(String nomAdmin) {
		this.nomAdmin = nomAdmin;
	}
	public String getPasswordAdmin() {
		return passwordAdmin;
	}
	public void setPasswordAdmin(String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
