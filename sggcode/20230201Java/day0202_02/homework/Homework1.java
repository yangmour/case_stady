public class Homework1 {
	public static void main(String[] args){
		
		/**
		1. 定义类 Homework1
		2. 定义 main方法
		3. 定义2个double类型变量x、y，x赋值为100.8，y赋值为20.6
		4. 定义新变量add，保存变量x，y的和并打印到控制台
		5. 定义新变量sub，保存变量x，y的差并打印到控制台
		6. 定义新变量mul，保存变量x，y的积并打印到控制台
		7. 定义新变量div，保存变量x，y的商并打印到控制台
		*/
		
		double x=100.8,y=20.6;
		
		double add = x + y;
		System.out.println("和:" + add);
		double sub = x - y;
		System.out.println("差:" + sub);
		double mul = x * y;
		System.out.println("积:" + mul);
		double div = x / y;
		System.out.println("商:" + div);
		
		
	}
}