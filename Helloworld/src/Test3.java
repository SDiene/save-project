import java.util.Scanner;
public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Pour declarer une constante en java on fait un final suivie d'une valeur
		// Calculer la puissance d'un nombre
		int X,n, E=1;
		System.out.print("Donner moi le nombre de X : ");
		Scanner sc= new Scanner(System.in);
		X=sc.nextInt();
		System.out.print("Donner moi le nombre de n : ");
		n=sc.nextInt();
		for(int i=0; i<X; i++) {
			E=X*X;
			
		}
		System.out.println(+X+ " à la puissance "+n+ " = "+ E);
	}

}
