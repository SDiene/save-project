package model;
import java.util.*;

public class AfficheEmployer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonDAO perd = new PersonDAO();
		Person pers = new Person();
		Scanner sc = new Scanner(System.in);
		System.out.print("Saisir un nom : ");
		String name = sc.next();
		System.out.print("Saisir un phone : ");
		String phone = sc.next();
		System.out.print("Saisir un profession : ");
		String profession = sc.next();
		pers.setName(name);
		pers.setPhone(phone);
		pers.setProfession(profession);
		perd.addPerson(pers);
		//System.out.println(pers.getName());
		sc.close();
	}

}
