package fr.pizzeria.admin.metier;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletException;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public class PizzaService  {

	private PizzaDao daoFactory;
	
	public PizzaService(){
		
	
	ResourceBundle bundle = ResourceBundle.getBundle("application");
	String daoConfig = bundle.getString("dao.impl");
	
	
	
	try {
		daoFactory = (PizzaDao) Class.forName(daoConfig).newInstance();
		
		
		
		
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
} 
	

	public List<Pizza> findAll(){
		
		return daoFactory.findAllPizzas();
	}
	
}


