public class Exercise3{
	public static void main(String[] args){
		
		// 第二题交换两个值
		//方案1
		int a = 1;
		int b = 2;
		int temp = a;
		a = b;
		b = temp;
		System.out.println("a = " + a + ",b = " + b);
		//方案2
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a = " + a + ",b = " + b);

		System.out.println("-------------");
		
		// 第三题
		//1.定义一个变量，赋值为一个四位数整数，例如1234
		int num = 1234;
        
		//2.通过运算操作求出个位，十位，百位，千位
		int ge = num%10;
		int shi = num/10%10;
		int bai = num/100%10;
		int qian = num/1000;
		
		System.out.println(num + "这个四位数个位上的数字是：" + ge);
		System.out.println(num + "这个四位数十位上的数字是：" + shi);
		System.out.println(num + "这个四位数百位上的数字是：" + bai);
		System.out.println(num + "这个四位数千位上的数字是：" + qian);
		
		// 第四题
		System.out.println("------------");
		int i = 1;
		int j = i++; //1
		int k = i++ * ++j + ++i * j++;
		//		2      2 4   4 2 12
		System.out.println("i = " + i); //4
		System.out.println("j = " + j); //3
		System.out.println("k = " + k); //12
		
		// 第五题
		System.out.println("------------");
		i = 1;
		j = i++;
		k = i++ * ++j + --i * j--;
		    //2 * 2 + 2*2
		System.out.println("i = " + i); //2
		System.out.println("j = " + j); //1
		System.out.println("k = " + k); //8
		
		// 第六题
		System.out.println("-------------"); 
		i = 1;
		// i=2     i=3   i=4   i= 5
		j = ++i + i++ * ++i + i++; 
		// 2+2 * 4 + 4  8 
		System.out.println("i = " + i); // 5
		System.out.println("j = " + j); //14
		
		// 第七题
		System.out.println("------------");
		i = 0;
		        //1 / 0
		//int result = ++i/--i;
		// System.out.println("result="+result); //算数异常
		
		// 第八题
		// 8.1
		int x = 1,y = 1;
		System.out.println(x++ == 2 & ++y == 2); //f
		System.out.println("x = " + x + ",y = " + y); // x = 2 y=2
		
		// 8.2
		x = 1;y = 1;
		System.out.println(x++ == 2 && ++y == 2); //f
		System.out.println("x = " + x + ",y = " + y); //x = 2 y =1
		
		//第九题 
		//9.1
		x = 1;y = 1;
        System.out.println(x++ == 1 | ++y == 1); //t
        System.out.println("x=" + x + ",y = " + y); //x=2 y=2
		//9.2
		x = 1;y = 1;
		System.out.println(x++ == 1 || ++y == 1); //t
		System.out.println("x = " + x + ",y = " + y); //x=2 y=1
		
		/**
		10、编写条件表达式
		int a = 85;
		int b = 45
		（1）编写并输出判断整数a是否是奇数的条件
		（2）编写并输出a>b并且a的个位数是3的倍数的条件
		（3）编写并输出判断a是否在[0,100]范围内的条件
		（4）编写并输出判断a和b是一正一负的条件
		*/
		System.out.println(a % 2 != 0);
		System.out.println(!(a % 2 == 0));
		
		System.out.println(a>b && a%10%3 == 0);
		
		System.out.println(a>=0 && a <= 100);
		
		System.out.println(a<0 ^ a < 0);
		
		// 11.判断如下程序的运行结果
		//11.1
		boolean flag = false;
		System.out.println(flag == true ? "成立" : "不成立"); // 不成立
		
		//11.2
		flag = false;
		System.out.println((flag = true) ? "成立" : "不成立"); // 成立
		
		// 11.3
		flag = false;
		System.out.println(flag ? "成立" : "不成立"); // 不成立
		
		//11.4
		 flag = false;
    System.out.println(!flag ? "成立" : "不成立"); // 成立
		
		// 12求三个整数的最大值
		a = 3;
		b = 2;
		int c = 1;
		
		int max = a > b ? a : b;
		max = max > c ? max : c;
		System.out.println("max = " + max);
		
		
		
	}
}