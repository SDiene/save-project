package exerciceClasse;
import java.util.Scanner;
public class exo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A,B,C;
		int D; 
		Scanner sc = new Scanner(System.in);
		System.out.print("Donner moi un nombre a A: ");
		A=sc.nextInt();
		System.out.print("Donner moi un nombre a B: ");
		B=sc.nextInt();
		System.out.print("Donner m1oi un nombre a C: ");
		C=sc.nextInt();
		D=C;
		C=B;
		B=A;
		A=D;
		
		System.out.println("La nouvelle valeur de A est :"+A);
		System.out.println("La nouvelle valeur de B est :"+B);
		System.out.println("La nouvelle valeur de C est :"+C);
				
	}

}
