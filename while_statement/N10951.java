package while_statement;

import java.util.Scanner;

public class N10951 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
         
        while(scan.hasNextInt()){
             int one = scan.nextInt();
             int two = scan.nextInt();
             System.out.println(one+two);     
         }
     }
}
/*
����
�� ���� A�� B�� �Է¹��� ����, A+B�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
�Է��� ���� ���� �׽�Ʈ ���̽��� �̷���� �ִ�.

�� �׽�Ʈ ���̽��� �� �ٷ� �̷���� ������, �� �ٿ� A�� B�� �־�����. (0 < A, B < 10)

���
�� �׽�Ʈ ���̽����� A+B�� ����Ѵ�.
*/