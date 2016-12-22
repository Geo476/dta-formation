package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pizza {

	
	@Id
	@Column (name="ID_PIZ")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="REFERENCE")
	private String code;
	
	@Column(name="LIBELLE")
	private String nom;
	
	@Column(name="PRIX")
	private double prix;
	
	@Enumerated(EnumType.STRING)
	@Column(name="CATEGORIE")
	private CategoriePizza cat;
	
	
	@Column(name="URL_IMG")
	private String url;
	
	
	public static int nbPizzas; 


	public Pizza() {
		super();
	}

	public Pizza(Integer id, String code, String nom, double prix,CategoriePizza cat, String url) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.cat = cat;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public static int getNbPizzas() {
		return nbPizzas;
	}

	public static void setNbPizzas(int nbPizzas) {
		Pizza.nbPizzas = nbPizzas;
	}

	public CategoriePizza getCat() {
		return cat;
	}

	public void setCat(CategoriePizza cat) {
		this.cat = cat;
	}

	public String toString() {
		
		return this.getCode() + "-> " + this.getNom() + " (" + this.getPrix() + " � - " + cat.getValue() + ")";
		
	}

	
	
}
