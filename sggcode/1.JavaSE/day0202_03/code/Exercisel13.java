public class Exercisel13 {
	public static void main(String[] args){
		int a = 1;
		int b = 2;
		
		System.out.println("����ǰ��ֵ��a = " + a + ",b = "+ b);
		
		// 0001
		// 0010
		// 0011
		a = a ^ b;
		// 0011
		// 0010
		// 0001
		b = a ^ b;
		// 0011
		// 0001
		// 0010
		a = a ^ b;
		
		System.out.println("�������ֵ��a = " + a + ",b = "+ b);

		
	}
}