package exerciceClasse;
import java.util.Scanner;
public class exo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=0,b=0;
		System.out.println("                Nbr qui informe si le produit sera negative ou pas");
		System.out.print("Donner moi un nombre : ");
		Scanner sc = new Scanner(System.in);
		a=sc.nextInt();
		System.out.print("Donner moi un nombre : ");
		b=sc.nextInt();
		if (a<0 && b>0) {
			System.out.println("Le produit de "+a+ " et " +b+" sera negative");
		}
		else if(a>0 && b<0) {
			System.out.println("Le produit de "+a+ " et " +b+" sera negative");
		}
		else {
			System.out.println("Le produit sera positive");
		}
	}
	
}
