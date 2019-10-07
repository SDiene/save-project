package dao;

import java.util.List;

import entitie.Service;

public interface DAOServices {
	public void save(Service s); 
	public void update(Service s); 
	public void delete(Service s); 
	public Service getService(int idS); 
	public List<Service> getService();
}
