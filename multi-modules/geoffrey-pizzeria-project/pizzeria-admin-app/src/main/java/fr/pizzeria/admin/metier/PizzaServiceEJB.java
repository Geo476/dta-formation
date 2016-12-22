package fr.pizzeria.admin.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Pizza;



@Stateless
public class PizzaServiceEJB {

	@PersistenceContext(unitName="pizza-db") private EntityManager em;
	
	
	
	
	public PizzaServiceEJB(){
		

		
	
		
		
	}
	
	
	public List<Pizza> findAllPizzas() {
		
	TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);
		
		return query.getResultList();
		
		
	}
	
	
/*public List<Pizza> findAll(){
		
		return findAllPizzas();
	}*/
	
	
}
