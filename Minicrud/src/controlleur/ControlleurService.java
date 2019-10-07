package controlleur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.DAOServices;
import entitie.Service;
import model.ConnectionClass;

public class ControlleurService implements DAOServices{
	Connection conn = ConnectionClass.get_connection();
	
	@Override
	public void save(Service s) {
		try {
			if(s.getLibelle() != null) {
			PreparedStatement pstm = conn.prepareStatement("INSERT INTO `services`(`libelle`) VALUES (?) ");
				pstm.setString(1, s.getLibelle());
				int i = pstm.executeUpdate();
				System.out.println(i+" Data Inserted Succesfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Service s) {
		try {
			if(s.getId() != 0) {
			PreparedStatement pstm = conn.prepareStatement("update `services` SET `libelle`=?' WHERE `id`=?");
				pstm.setString(1, s.getLibelle());
				pstm.setInt(2, s.getId());
				int i = pstm.executeUpdate();
				System.out.println(i+ " Data Update Succesfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		try {
			if(id != 0) {
			PreparedStatement pstm = conn.prepareStatement("DELETE FROM `services WHERE `id`=?");
				pstm.setInt(1, id);
				int i = pstm.executeUpdate();
				System.out.println(i+ " Data Delete Succesfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	public Service getService(int id) {
		Service service = null;
		try {
			PreparedStatement pstm = conn.prepareStatement("SELECT * FROM `services` WHERE id=?");
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				//service = new Service(rs.getInt(1), rs.getString(2));
				service = new Service(id, null);
				service = setId(rs.getInt(1)); // resultset de l'element qu'on a besoin ici c'est le 1
				service = setLibelle(rs.getString(2));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return service;
	}

	private Service setId(int int1) {
		return null;
	}

	private Service setLibelle(String string) {
		return null;
	}

	@Override
	public List<Service> getService() {
		
		List<Service> service = new ArrayList<>();
		return service;
	}

	@Override
	public void delete(Service s) {
		
	}

}
