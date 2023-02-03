public class Homework4{
	public static void main(String[] args){
		double r1 = 10;
		double r2 = 20;
		final double PI = 3.14159;
		
		double s1 = PI * r1 * r1;
		double c1 =  2 * PI * r1;
								
		double s2 = PI * r2 * r2;
		double c2 =  2 * PI * r2;
		System.out.println("圆1的面积：" + s1);
		System.out.println("圆1的周长：" + c1);
		System.out.println("圆2的面积：" + s2);
		System.out.println("圆2的周长：" + c2);
		
	}
}