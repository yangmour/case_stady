public class Exercise3{
	public static void main(String[] args){
		// ��һ��
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
		
		// �ڶ���
		System.out.println("------------");
		int i = 1;
		int j = i++; //1
		int k = i++ * ++j + ++i * j++;
		//		2      2 4   4 2 12
		System.out.println("i = " + i); //4
		System.out.println("j = " + j); //4
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
		int result = ++i/--i;
		System.out.println("result="+result); //�����쳣
		
	}
}