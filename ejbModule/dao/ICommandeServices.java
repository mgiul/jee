package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import entities.*;



@Remote
public interface ICommandeServices {
	public ArrayList<LigneCommande> getAllCommandes();
}
