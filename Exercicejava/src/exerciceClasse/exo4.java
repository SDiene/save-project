package exerciceClasse;
import java.util.Scanner;
public class exo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age=0;
		System.out.print("Donner votre age : ");
		 Scanner sc = new Scanner(System.in);
		 age = sc.nextInt();
		 if (age==6 || age==7 ) {
			System.out.println("Vous étes poussin");
		} else if(age==8 || age==9) {
			System.out.println("Vous étes Pupille");
		} else if(age==10 || age==11) {
			System.out.println("Vous etes Minime");
		}
		 else if(age==12){
			System.out.println("Vous etes cadet");
		}
		else {
			System.out.println("Vous en'etes pas définit sur la liste");
		}
		 
	}

}
