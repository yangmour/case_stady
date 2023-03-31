public class Exercisel14 {
	public static void main(String[] args){
		int a = 10;
		a = a + a>>2;
		System.out.println("a = " + a); // 5
		
		a = 10;
		a = a + (a>>2);
		System.out.println("a = " + a); //12
		
		a = 10;
		a += a>>2;
		System.out.println("a = " + a); //12
		
	}
}