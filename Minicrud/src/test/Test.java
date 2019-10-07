package test;

import controlleur.ControlleurService;
import entitie.Service;

public class Test {
	public static void main(String[] args) {
		ControlleurService ss = new ControlleurService();
		//ss.save(new Service (1, "Data Analyst"));
		//ss.update(new Service (1, "digital"));
		//ss.delete(2);
		Service s = ss.getService(1);
		System.out.println("ID : "+s.getId()+ "Libelle: "+s.getLibelle());
	}
}
