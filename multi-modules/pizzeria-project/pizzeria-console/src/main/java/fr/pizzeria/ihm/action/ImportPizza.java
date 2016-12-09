package fr.pizzeria.ihm.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.Exception.DeletePizzaException;
import fr.pizzeria.Exception.SavePizzaException;
import fr.pizzeria.Exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;



public class ImportPizza extends Action {

	
	private IhmUtil utils;
	public ImportPizza(IhmUtil utils){
		super();
		this.setDescription("6. Importer les données");
		this.utils = utils;
		
	};
	@Override
	
	
	
	public void do_action() {
		// TODO Auto-generated method stub
		
		Connection connection;

			
		
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria","root","");
			Statement statement = connection.createStatement();
		
		
			
			
			
			
/*PreparedStatement saveNewPizza = connection.prepareStatement("INSERT INTO pizza(ID,LIBELLE,REFERENCE,PRIX,URL_IMG,CATEGORIE) VALUES (?,?,?,?,?,?)");
			
			saveNewPizza.setInt(1,pizza.getId()+1);
			saveNewPizza.setString(2,pizza.getNom());
			saveNewPizza.setString(3,pizza.getCode());
			saveNewPizza.setDouble(4,pizza.getPrix());
			saveNewPizza.setString(5,"");
			saveNewPizza.setString(6,pizza.getCat().toString());
			
			saveNewPizza.execute();
			
			connection.close();
			
*/			
			/*
			
		public void importPizza() throw PizzaException {
			
			ResourceBundle bundle = ResourceBundle.getBundle("application");
			String choix = bundle.getString("dao.source");
			DaoFactory daoFactory = null;
			
			try {
			
				daoFactory = (daoFactory) Class.forName(choix).newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			PizzaDao tableau = daoFactory.getPizzaDao();
			
			List<Pizza> listPizzas = new PizzaDaoTableau().findAllPizzas();
				
			
			
		}
			*/
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	@Override
	public void describe_action() {
		// TODO Auto-generated method stub
		
	}
	
}
