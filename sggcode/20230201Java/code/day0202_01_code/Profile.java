
/**
学习打印数据类型
String类型
char类型
float单精度类型
double双精度类型
boolean类型
@author xiwen 
*/
public class Profile{
	/**
	@param args 传入的参数
	*/
	public static void main(String[] args){
		
		System.out.println("姓名:" + "希文");
		System.out.print("性别:");
		System.out.println('男');
		System.out.println(24);
		System.out.print("身高:");
		System.out.println(183.2f);
		System.out.print("体重:");
		System.out.println(129.1);
		System.out.print("是否是本专业:");
		System.out.println(true);
		
		// 变量方式保存输出
		System.out.println("--------变量方式输出----------");
		String name = "希文";
		char sex = '男';
		int age = 24;
		float height = 183.2f;
		Double weight = 129.1;
		boolean isMajor = true;
		System.out.println("姓名:" + name);
		System.out.print("性别:");
		System.out.println(sex);
		System.out.println(age);
		System.out.print("身高:");
		System.out.println(height);
		System.out.print("体重:");
		System.out.println(weight);
		System.out.print("是否是本专业:");
		System.out.println(isMajor);
		
	}
}