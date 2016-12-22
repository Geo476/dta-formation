package fr.pizzeria.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Commande {

	
	@Id
	@Column(name="ID_CMD")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ID_CMD;
	
	
	@Column(name="NUMERO_CMD")
	private String numero;
	
	@Column(name="DATE_CMD")
	private double date;
	
	
	@Column(name="STATUT")
	private String statut;
	
	
	@Column(name="LIVRAISON_ID")
	private String livreur;
	
	@Column(name="CLIENT_ID")
	private String client;
	
		
	@ManyToMany
	@JoinTable(name="cmd_pizza", joinColumns=
			@JoinColumn(name="CMD_ID",referencedColumnName="ID_CMD"),
				inverseJoinColumns=
			@JoinColumn(name="PIZZA_ID", referencedColumnName="ID_PIZ")
	)
	
	private Set<Pizza> pizzas;
	
	
	
	
}
