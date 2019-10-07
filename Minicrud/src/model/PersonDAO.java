package model;

import java.sql.*;

import model.Person;

public class PersonDAO {
	
	public PersonDAO() {
        ConnectionClass.get_connection();
    }
    
    public void addPerson(Person person) {
    	String SQL = "INSERT INTO `person`(`name`, `phone`, `profession`)VALUES(?,?,?)";
        
    	try (Connection connection = ConnectionClass.get_connection();PreparedStatement ps = connection.prepareStatement(SQL)){
    		
    		ps.setString(1, person.getName());
			ps.setString(2, person.getPhone());
			ps.setString(3, person.getProfession()); 
			
    		int executeUpdate = ps.executeUpdate();
			
			if(executeUpdate >=1){
				System.out.println("Employee is crated....");
			}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Person getPersonById(Integer personid) {
    	Person person = null;
		String SQL = "SELECT * FROM `person` WHERE idperson=?";
		try(Connection connection = ConnectionClass.get_connection();PreparedStatement ps = connection.prepareStatement(SQL)) {
			
			ps.setInt(1, personid);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String profession = rs.getString("profession");
				
				person = new Person();
				person.setName(name);
				person.setPhone(phone);
				person.setProfession(profession);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return person;
	}
}
