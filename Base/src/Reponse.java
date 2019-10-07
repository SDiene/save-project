import java.util.Scanner;
public class Reponse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char reponse= 'o';
		String prenom;
		while(reponse=='o') {
			System.out.print("Veiller entrer votre prenom : ");
			Scanner sc = new Scanner(System.in);
			prenom=sc.nextLine();
			reponse= ' ';
			while(reponse!='o' && reponse!='n') {
			System.out.println("Veiller entrer un nombre (o/n)");
			reponse=sc.nextLine().charAt(0);
			}
		}
		System.out.println("Au revoir !!!!");
	}

}
