public class Exercise3{
	public static void main(String[] args){
		
		// �ڶ��⽻������ֵ
		//����1
		int a = 1;
		int b = 2;
		int temp = a;
		a = b;
		b = temp;
		System.out.println("a = " + a + ",b = " + b);
		//����2
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a = " + a + ",b = " + b);

		System.out.println("-------------");
		
		// ������
		//1.����һ����������ֵΪһ����λ������������1234
		int num = 1234;
        
		//2.ͨ��������������λ��ʮλ����λ��ǧλ
		int ge = num%10;
		int shi = num/10%10;
		int bai = num/100%10;
		int qian = num/1000;
		
		System.out.println(num + "�����λ����λ�ϵ������ǣ�" + ge);
		System.out.println(num + "�����λ��ʮλ�ϵ������ǣ�" + shi);
		System.out.println(num + "�����λ����λ�ϵ������ǣ�" + bai);
		System.out.println(num + "�����λ��ǧλ�ϵ������ǣ�" + qian);
		
		// ������
		System.out.println("------------");
		int i = 1;
		int j = i++; //1
		int k = i++ * ++j + ++i * j++;
		//		2      2 4   4 2 12
		System.out.println("i = " + i); //4
		System.out.println("j = " + j); //3
		System.out.println("k = " + k); //12
		
		// ������
		System.out.println("------------");
		i = 1;
		j = i++;
		k = i++ * ++j + --i * j--;
		    //2 * 2 + 2*2
		System.out.println("i = " + i); //2
		System.out.println("j = " + j); //1
		System.out.println("k = " + k); //8
		
		// ������
		System.out.println("-------------"); 
		i = 1;
		// i=2     i=3   i=4   i= 5
		j = ++i + i++ * ++i + i++; 
		// 2+2 * 4 + 4  8 
		System.out.println("i = " + i); // 5
		System.out.println("j = " + j); //14
		
		// ������
		System.out.println("------------");
		i = 0;
		        //1 / 0
		//int result = ++i/--i;
		// System.out.println("result="+result); //�����쳣
		
		// �ڰ���
		// 8.1
		int x = 1,y = 1;
		System.out.println(x++ == 2 & ++y == 2); //f
		System.out.println("x = " + x + ",y = " + y); // x = 2 y=2
		
		// 8.2
		x = 1;y = 1;
		System.out.println(x++ == 2 && ++y == 2); //f
		System.out.println("x = " + x + ",y = " + y); //x = 2 y =1
		
		//�ھ��� 
		//9.1
		x = 1;y = 1;
        System.out.println(x++ == 1 | ++y == 1); //t
        System.out.println("x=" + x + ",y = " + y); //x=2 y=2
		//9.2
		x = 1;y = 1;
		System.out.println(x++ == 1 || ++y == 1); //t
		System.out.println("x = " + x + ",y = " + y); //x=2 y=1
		
		/**
		10����д�������ʽ
		int a = 85;
		int b = 45
		��1����д������ж�����a�Ƿ�������������
		��2����д�����a>b����a�ĸ�λ����3�ı���������
		��3����д������ж�a�Ƿ���[0,100]��Χ�ڵ�����
		��4����д������ж�a��b��һ��һ��������
		*/
		System.out.println(a % 2 != 0);
		System.out.println(!(a % 2 == 0));
		
		System.out.println(a>b && a%10%3 == 0);
		
		System.out.println(a>=0 && a <= 100);
		
		System.out.println(a<0 ^ a < 0);
		
		// 11.�ж����³�������н��
		//11.1
		boolean flag = false;
		System.out.println(flag == true ? "����" : "������"); // ������
		
		//11.2
		flag = false;
		System.out.println((flag = true) ? "����" : "������"); // ����
		
		// 11.3
		flag = false;
		System.out.println(flag ? "����" : "������"); // ������
		
		//11.4
		 flag = false;
    System.out.println(!flag ? "����" : "������"); // ����
		
		// 12���������������ֵ
		a = 3;
		b = 2;
		int c = 1;
		
		int max = a > b ? a : b;
		max = max > c ? max : c;
		System.out.println("max = " + max);
		
		
		
	}
}