package if_statement;

import java.util.Scanner;

public class N9498 {
    public static void main(String[] args){
    	Scanner scan=new Scanner(System.in);

    	int score;
        score=scan.nextInt();
        
        char grade=score>=90?'A':score>=80?'B':score>=70?'C':score>=60?'D':'F'; //���� ������     
        System.out.println(grade);
    }
}
/*
����
���� ������ �Է¹޾� 90 ~ 100���� A, 80 ~ 89���� B, 70 ~ 79���� C, 60 ~ 69���� D, ������ ������ F�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� ������ �־�����. ���� ������ 0���� ũ�ų� ����, 100���� �۰ų� ���� �����̴�.

���
���� ������ ����Ѵ�.
*/