public class Homework3 {
	public static void main(String[] args){
		/**
		  3、强制类型转换练习，效果如图所示：
		（1）先声明两个byte类型的变量b1,b2,并分别赋值为10和20，求b1和b2变量的和，并将结果保存在byte类型的变量b3中，最后输出b3变量的值
		（2）先声明两个short类型的变量s1,s2,并分别赋值为1000和2000，求s1和s2变量的和，并将结果保存在short类型的变量s3中，最后输出s3变量的值
		（3）先声明1个char类型的变量c1赋值为'a'，再声明一个int类型的变量num赋值为5，求c1和num变量的和，并将结果将结果保存在char类型的变量letter中，最后输出letter变量的值。
		（4）先声明两个int类型的变量i1,i2，并分别赋值5和2，求i1和i2的商，并将结果保存在double类型的变量result中，最后输出result变量的值。如何得到结果2.5呢？
		*/
		
		//（1）先声明两个byte类型的变量b1,b2,并分别赋值为10和20，求b1和b2变量的和，并将结果保存在byte类型的变量b3中，最后输出b3变量的值
		byte b1 = 10,b2 = 20;
		byte b3 = (byte)(b1 + b2);
		System.out.println("和:" + b3);
		
		//（2）先声明两个short类型的变量s1,s2,并分别赋值为1000和2000，求s1和s2变量的和，并将结果保存在short类型的变量s3中，最后输出s3变量的值
		short s1 = 1000;
		short s2 = 2000;
		short s3 = (short) (s1 + s2);
		System.out.println("和:" + s3);
		
		//（3）先声明1个char类型的变量c1赋值为'a'，再声明一个int类型的变量num赋值为5，求c1和num变量的和，并将结果将结果保存在char类型的变量letter中，最后输出letter变量的值。
		char c1 = 'a';
		int num = 5;
		char letter = (char)(num + c1);
		System.out.println("letter = " + letter);
		
		//（4）先声明两个int类型的变量i1,i2，并分别赋值5和2，求i1和i2的商，并将结果保存在double类型的变量result中，最后输出result变量的值。如何得到结果2.5呢？
		int i1 = 5;
		int i2 = 2;
		double result = (double)i1 / i2;
		System.out.println("result = " + result);


		

	}
}