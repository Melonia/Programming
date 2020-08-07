package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class N2565 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<Integer>();
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		int testCase = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < testCase; i++){
			String s = bf.readLine();
			StringTokenizer st = new StringTokenizer(s);
			map.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}

		
		
		for(Integer intKey:map.keySet()){//map������ �ڵ����� ���ĵǾ� �ִ�. 
	 					   //map.keySet�޼ҵ�� key���� �ҷ��´�.
			list.add(intKey);
			
		}
		
		Collections.sort(list);
		
		int[] set = new int[testCase];
		int k = 0;
		
		for(Integer intKey:list) {
			set[k] = map.get(intKey);  //map.get(key)�� Ű�� ���� ���� �ҷ��´�.
			k++;
		}
		
		int[] dp = new int[testCase];
		
		int result = 1;

		for(int i = 0; i < testCase; i++){
			dp[i] = 1;
		}
		
		for(int i = 0; i < testCase-1; i++){
			for(int j = i+1; j < testCase; j++){
				if(set[j] > set[i] && dp[i] == dp[j]){
					dp[j] = dp[i] + 1;
				}
			}
		}
		
			
		result = max(dp);
		System.out.println(testCase-result);
	}
	static int max(int...values) {
		int max = 0;
		for(int value:values) {
			if(max<value) {
				max = value;
			}
		}
		return max;
	}
}

/*
����
�� ������ A�� B ���̿� �ϳ� �Ѿ� �������� �߰��ϴ� ���� �������� ���� �����ϴ� ��찡 �߻��Ͽ���. �ռ��� ������ �־� �̵� �� �� ���� �������� ���� �������� �������� �ʵ��� ������� �Ѵ�.

���� ���, <�׸� 1>�� ���� �������� ����Ǿ� �ִ� ��� A�� 1�� ��ġ�� B�� 8�� ��ġ�� �մ� ������, A�� 3�� ��ġ�� B�� 9�� ��ġ�� �մ� ������, A�� 4�� ��ġ�� B�� 1�� ��ġ�� �մ� �������� ���ָ� �����ִ� ��� �������� ���� �������� �ʰ� �ȴ�.



�������� �����뿡 ����Ǵ� ��ġ�� ������ ���������� ���ʴ�� ��ȣ�� �Ű�����. �������� ������ �����ٵ��� �� �����뿡 ����Ǵ� ��ġ�� ��ȣ�� �־��� ��, �����ִ� ��� �������� ���� �������� �ʰ� �ϱ� ���� ���־� �ϴ� �������� �ּ� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ��� �� ������ ������ �������� ������ �־�����. �������� ������ 100 ������ �ڿ����̴�. ��° �ٺ��� �� �ٿ� �ϳ��� �������� A������� ����Ǵ� ��ġ�� ��ȣ�� B������� ����Ǵ� ��ġ�� ��ȣ�� ���ʷ� �־�����. ��ġ�� ��ȣ�� 500 ������ �ڿ����̰�, ���� ��ġ�� �� �� �̻��� �������� ����� �� ����.

���
ù° �ٿ� �����ִ� ��� �������� ���� �������� �ʰ� �ϱ� ���� ���־� �ϴ� �������� �ּ� ������ ����Ѵ�.
*/