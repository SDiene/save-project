package entitie;

import java.util.Date;

public class Employee {
	private int id;
	private String matricule;
	private String nom; 
	private int telephone;
	private Date date_de_naissance;
	private int salaire;

	public Employee(int id, String matricule, String nom, int telephone, Date date_de_naissance, int salaire) {
		this.id = id;
		this.matricule = matricule;
		this.nom = nom;
		this.telephone = telephone;
		this.date_de_naissance = date_de_naissance;
		this.salaire = salaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public Date getDate_de_naissance() {
		return date_de_naissance;
	}

	public void setDate_de_naissance(Date date_de_naissance) {
		this.date_de_naissance = date_de_naissance;
	}

	public int getSalaire() {
		return salaire;
	}

	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}	
}
