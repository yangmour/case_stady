public class Exercise3{
	public static void main(String[] args){
		// 第一题
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
		
		// 第二题
		System.out.println("------------");
		int i = 1;
		int j = i++; //1
		int k = i++ * ++j + ++i * j++;
		//		2      2 4   4 2 12
		System.out.println("i = " + i); //4
		System.out.println("j = " + j); //4
		System.out.println("k = " + k); //12
		
		// 第三题
		System.out.println("------------");
		i = 1;
		j = i++;
		k = i++ * ++j + --i * j--;
		    //2 * 2 + 2*2
		System.out.println("i = " + i); //2
		System.out.println("j = " + j); //1
		System.out.println("k = " + k); //8
		
		System.out.println("-------------"); 
		i = 1;
		// i=2     i=3   i=4   i= 5
		j = ++i + i++ * ++i + i++; 
		// 2+2 * 4 + 4  8 
		System.out.println("i = " + i); // 5
		System.out.println("j = " + j); //14
		
		// 第四题
		System.out.println("------------");
		i = 0;
		        //1 / 0
		int result = ++i/--i;
		System.out.println("result="+result); //算数异常
		
	}
}