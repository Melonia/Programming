package arithmetic_operation;

import java.util.Scanner;

public class N10869 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
       
        int a,b;
        a=input.nextInt();
        b=input.nextInt();
        
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b); //�� ���
        System.out.println(a%b); //�������� ���
    }
}
/*
����
�� �ڿ��� A�� B�� �־�����. �̶�, A+B, A-B, A*B, A/B(��), A%B(������)�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 

�Է�
�� �ڿ��� A�� B�� �־�����. (1 �� A, B �� 10,000)

���
ù° �ٿ� A+B, ��° �ٿ� A-B, ��° �ٿ� A*B, ��° �ٿ� A/B, �ټ�° �ٿ� A%B�� ����Ѵ�.
*/