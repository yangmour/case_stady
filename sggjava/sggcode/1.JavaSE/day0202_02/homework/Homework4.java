public class Homework4 {
	public static void main(String[] args){
		/**
		1. ��������int���ͱ���a1��a2,�ֱ�ֵ10,11,�жϱ����Ƿ�Ϊż��,ƴ��������
		2. ��������int���ͱ���a3��a4,�ֱ�ֵ12,13,�жϱ����Ƿ�Ϊ����,ƴ��������
		*/
		
		//1.
		int a1 = 10;
		int a2 = 11;
		System.out.println(a1 + "�Ƿ�Ϊż��:" + (a1 % 2 == 0));
		System.out.println(a2 + "�Ƿ�Ϊż��:" + (a2 % 2 == 0));

		int a3 = 12;
		int a4 = 13;
		System.out.println(a1 + "�Ƿ�Ϊ����:" + (a3 % 2 != 0));
		System.out.println(a2 + "�Ƿ�Ϊ����:" + (a4 % 2 != 0));
		
	}
}