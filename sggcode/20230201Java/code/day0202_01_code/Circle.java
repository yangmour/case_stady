/**
��ϰ������double���͵ı����ֱ�洢����Բ�İ뾶���뾶ֵ�Լ���
		������Բ���ܳ��������Բ������ʱ����1.14159
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
		System.out.println("Բ1�������" + s1);
		System.out.println("Բ1���ܳ���" + c1);
		System.out.println("Բ2�������" + s2);
		System.out.println("Բ2���ܳ���" + c2);
		
	}
}
