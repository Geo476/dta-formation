package fr.pizzeria.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.Exception.DeletePizzaException;
import fr.pizzeria.Exception.SavePizzaException;
import fr.pizzeria.Exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJpa implements PizzaDao{

	private EntityManagerFactory EMF;
	
	
	public PizzaDaoJpa (){
		
		
		this.EMF = Persistence.createEntityManagerFactory("pizzeria-console");
		// TODO Auto-generated method stub

	}

	
	
	
	
	@Override
	public List<Pizza> findAllPizzas() {
		
		EntityManager em = EMF.createEntityManager();
		
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);
		
		
		
		
		
		// TODO Auto-generated method stub
		
		
		return query.getResultList();
	}

	
	
	
	
	
	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		


		
		EntityManager em = EMF.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(pizza);
		et.commit();
		em.close();
		
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		
		EntityManager em = EMF.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		
		int indice = findAllPizzas().stream().filter(p -> p.getCode().equals(codePizza)).findFirst().get().getId();
		Pizza p = em.find(Pizza.class, indice);
		
		if(p != null) {
			
			p.setCode(pizza.getCode());
			p.setNom(pizza.getNom());
			p.setPrix(p.getPrix());
			p.setCat(p.getCat());
			
		}
		
		et.commit();
		em.close();
		
		
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {

		EntityManager em = EMF.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		
		int indice = findAllPizzas().stream().filter(p -> p.getCode().equals(codePizza)).findFirst().get().getId();
		Pizza p = em.find(Pizza.class, indice);
		
		if(p != null) {
			
			em.remove(p);
		}
		
		et.commit();
		em.close();
		
		return false;
	}

	@Override
	public Optional<Pizza> findPizzaByCode(String codePizza) {
		Optional<Pizza> optPizza = findAllPizzas().stream()
				.filter(p -> p.getCode().equals(codePizza))
				.findAny();
			return optPizza;
		
	}

	@Override
	public boolean isCodeExist(String codePizza) {
		return findPizzaByCode(codePizza).isPresent();
		
	}

}
