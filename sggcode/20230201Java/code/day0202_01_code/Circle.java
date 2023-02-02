/**
练习：两个double类型的变量分别存储两个圆的半径，半径值自己定
		求两个圆的周长和面积，圆周率暂时都用1.14159
*/

class Circle{
	public static void main(String[] args){
		double r1 = 10;
		double r2 = 20;
		double pi = 3.14159;
		
		double s1 = pi * r1 * r1;
		double c1 =  2 * pi * r1;
								
		double s2 = pi * r2 * r2;
		double c2 =  2 * pi * r2;
		System.out.println("圆1的面积：" + s1);
		System.out.println("圆1的周长：" + c1);
		System.out.println("圆2的面积：" + s2);
		System.out.println("圆2的周长：" + c2);
		
	}
}
