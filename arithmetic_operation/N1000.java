package arithmetic_operation;

import java.util.Scanner;

public class N1000 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        
        int a,b;
        a=input.nextInt();
        b=input.nextInt();
        
        System.out.println(a+b);
    }
}
/*
����
�� ���� A�� B�� �Է¹��� ����, A+B�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� A�� B�� �־�����. (0 < A, B < 10)

���
ù° �ٿ� A+B�� ����Ѵ�.
*/