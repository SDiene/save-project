import java.util.Scanner;
public class PGCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// afficher le PGCD de deux entiers positif
		int var1,var2;
		System.out.print("Donner moi une premiere valeur : ");
		Scanner sc = new Scanner(System.in);
		var1=sc.nextInt();
		System.out.print("Donner moi une deuxieme valeur : ");
		var2=sc.nextInt();
		while(var1 > var2) {
			var1 = var1- var2;
		}
		while(var2 > var1) {
			var2 = var2 - var1;
		}
		System.out.println("Le PGCD est de "+ var1); 
	}

}
