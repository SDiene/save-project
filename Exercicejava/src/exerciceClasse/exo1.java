package exerciceClasse;
import java.util.Scanner;
public class exo1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=0;
		System.out.print("Donner moi un nombre : ");
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		if(n<0) {
			System.out.print("Ce nombre est inf à 0");
		}
		else if(n>0) {
			System.out.print("Ce nombre est Sup à 0");
		}
		else {
			System.out.println("Ce nombre est Null");
		}
	}

}
