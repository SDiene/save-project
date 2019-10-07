import java.util.Scanner;
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,i=1,s=0;
		System.out.print("saisir un nombre : ");
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		while(i<=n) {
			s=s+i;
			i++;
		}
		System.out.println("Somme reçoit : "+s);
		

	}
}