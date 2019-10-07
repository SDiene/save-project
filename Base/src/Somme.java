import java.util.Scanner;
public class Somme {
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.print("Bonjour ");
	if(args.length==2) {
		System.out.println(args[0]+ " "+ args[1]);
		System.out.println(" Nous allons faire la somme de deux entiers entre a et b");
		int a,b,r;
        System.out.print("Donner moi la valeur de a : ");
        a=in.nextInt();
        System.out.print("Donner moi la valeur de b : ");
        b=in.nextInt();
        r=a+b;
        System.out.print("la somme de " +a+ " + " +b+ " donne "+ r);
	}
	else {
		System.out.print("Error seul deux arguments sont possibles");
	}
	
	}
		
}
