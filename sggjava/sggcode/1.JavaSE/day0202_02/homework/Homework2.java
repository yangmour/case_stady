public class Homework2 {
	public static void main(String[] args){
		/**
		1. 定义类 Homework2
		2. 定义 main方法
		3. 定义2个int类型变量x、y，x赋值为100，y赋值为200
		4. 定义新变量add，保存变量x，y的和并打印到控制台
		5. 定义新变量sub，保存变量x，y的差并打印到控制台
		6. 定义新变量mul，保存变量x，y的积并打印到控制台
		7. 定义新变量div，保存变量x，y的商并打印到控制台
		*/
		
		int x = 100,y = 200;
		int add = x + y;
		System.out.println("和:" + add);
		int sub = x - y;
		System.out.println("差:" + sub);
		int mul = x * y;
		System.out.println("积:" + mul);
		int div = x / y;
		System.out.println("商:" + div);
		
	}
}