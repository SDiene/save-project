import java.util.Scanner;
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Calculer la surface et le perimetre d'un cercle
		int n,i=0,sp=0, si=0;
		for(i=0;i<3;i++) {
		System.out.print("Donner moi une valeur: ");
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		if(n%2==0) {
			sp=n+sp;
		}else {
			si=si+n;
		}
			
		}
		System.out.println("La somme des nombre pair est de :" +sp);
		System.out.println("La somme des nombres impair est de: "+ si);
		
	}

}
