package fr.pizzeria.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import fr.pizzeria.Exception.DeletePizzaException;
import fr.pizzeria.Exception.SavePizzaException;
import fr.pizzeria.Exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJdbc implements PizzaDao {

	
	//private List<Pizza> pizzas = new ArrayList<Pizza>();
	//Class.forName("com.mysql.jdbc.Driver");
	public  PizzaDaoJdbc() {
		
	//Connection connection;
	//Statement statement;
		
		
		
		
	}

	@Override
	public List<Pizza> findAllPizzas() {

		List<Pizza> pizzas = new ArrayList<>();
		Connection connection;
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria","root","");
					Statement statement = connection.createStatement();
					
					ResultSet resultats = statement.executeQuery("SELECT * FROM	pizza");

					while(resultats.next()) {

					Integer id = resultats.getInt("ID");
					String code = resultats.getString("REFERENCE");
					String name = resultats.getString("LIBELLE"); 
					BigDecimal price = resultats.getBigDecimal("PRIX");
					CategoriePizza cat = CategoriePizza.valueOf(resultats.getString("CATEGORIE"));

					pizzas.add(new Pizza(id, code, name, price.doubleValue(), cat));
					
					}
				
									
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		return pizzas;
		
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria","root","");
			Statement statement = connection.createStatement();
			
			PreparedStatement saveNewPizza = connection.prepareStatement("INSERT INTO pizza(ID,LIBELLE,REFERENCE,PRIX,URL_IMG,CATEGORIE) VALUES (?,?,?,?,?,?)");
			
			saveNewPizza.setInt(1,pizza.getId()+1);
			saveNewPizza.setString(2,pizza.getNom());
			saveNewPizza.setString(3,pizza.getCode());
			saveNewPizza.setDouble(4,pizza.getPrix());
			saveNewPizza.setString(5,"");
			saveNewPizza.setString(6,pizza.getCat().toString());
			
			saveNewPizza.execute();
			
			connection.close();
			//pizzas.add(pizza);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(PizzaDaoJdbc.class.getName()).severe(e.getMessage());
			//throw new SavePizzaException(e);
			e.printStackTrace();
		}
		
		
		
		//int nbPizzaInsere = statement.executeUpdate("INSERT INTO PIZZA(ID,REFERENCE,LIBELLE,PRIX,CATEGORIE) VALUES(1,'Regina',12.0)");

		System.out.println("pizza insérée");
		
		
		
		Pizza.nbPizzas++;
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		// TODO Auto-generated method stub
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria","root","");
			//Statement statement = connection.createStatement();
		
			PreparedStatement UpdatePizza = connection.prepareStatement("UPDATE pizza SET ID=?, LIBELLE=?, REFERENCE=?, PRIX=?, URL_IMG=?, CATEGORIE=? WHERE REFERENCE=?");
			
			UpdatePizza.setInt(1,pizza.getId());
			UpdatePizza.setString(2,pizza.getNom());
			UpdatePizza.setString(3,pizza.getCode());
			UpdatePizza.setDouble(4,pizza.getPrix());
			UpdatePizza.setString(5,"");
			UpdatePizza.setString(6,pizza.getCat().toString());
			UpdatePizza.setString(7,codePizza);
			
			UpdatePizza.executeUpdate();
			
			connection.close();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		
try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria","root","");
			//Statement statement = connection.createStatement();
		
			PreparedStatement DeletePizza = connection.prepareStatement("DELETE FROM pizza WHERE REFERENCE=?");
			DeletePizza.setString(1,codePizza);
			
			
			DeletePizza.execute();
			
			connection.close();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
			return true;
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
