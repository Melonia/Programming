package for_statement;

import java.util.Scanner;

public class N10871 {
    public static void main(String[] args){
    	Scanner scan = new Scanner(System.in);
        int num,var;
        num = scan.nextInt();
        var = scan.nextInt();
        
        int[] x = new int[num];
        for(int i=0;i<num;i++){
            x[i] = scan.nextInt();
        }
        for(int i=0;i<num;i++) {
        	if(x[i]<var) {
        		System.out.print(x[i]+" ");
        	}
        }
    }
}
/*
����
���� N���� �̷���� ���� A�� ���� X�� �־�����. �̶�, A���� X���� ���� ���� ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� N�� X�� �־�����. (1 �� N, X �� 10,000)

��° �ٿ� ���� A�� �̷�� ���� N���� �־�����. �־����� ������ ��� 1���� ũ�ų� ����, 10,000���� �۰ų� ���� �����̴�.

���
X���� ���� ���� �Է¹��� ������� �������� ������ ����Ѵ�. X���� ���� ���� ��� �ϳ� �����Ѵ�.
*/