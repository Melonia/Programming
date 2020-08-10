package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class N1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<Integer>();
		String expr = bf.readLine();
		
		String[] s =  expr.split("-");
		
		int add = 0;
		for(int i = 0; i < s.length; i++) {
			String[] s2 = s[i].split("[+]");
			for(int j = 0; j < s2.length; j++)
				list.add(Integer.parseInt(s2[j]));
			if(i==0&&s2[0].charAt(0)!='-') {
				add = sum(list);
				list.clear();
			}
		}
		
		System.out.println(add-sum(list));
		
	}
	static int sum(List<Integer> list) {
		int sum=0;
		for(int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}
}

/*
����
�����̴� ����� +, -, �׸��� ��ȣ�� ������ ���̰� �ִ� 50�� ���� �������. �׸��� ���� �����̴� ��ȣ�� ��� ������.

�׸��� ���� �����̴� ��ȣ�� ������ �ļ� �� ���� ���� �ּҷ� ������� �Ѵ�.

��ȣ�� ������ �ļ� �� ���� ���� �ּҷ� ����� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� �־�����. ���� ��0��~��9��, ��+��, �׸��� ��-�������� �̷���� �ְ�, ���� ó���� ������ ���ڴ� �����̴�. �׸��� �����ؼ� �� �� �̻��� �����ڰ� ��Ÿ���� �ʰ�, 5�ڸ����� ���� ���ӵǴ� ���ڴ� ����. ���� 0���� ������ �� �ִ�.

���
ù° �ٿ� ������ ����Ѵ�.
*/