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

		
		
		for(Integer intKey:map.keySet()){//map에서는 자동으로 정렬되어 있다. 
	 					   //map.keySet메소드로 key들을 불러온다.
			list.add(intKey);
			
		}
		
		Collections.sort(list);
		
		int[] set = new int[testCase];
		int k = 0;
		
		for(Integer intKey:list) {
			set[k] = map.get(intKey);  //map.get(key)로 키에 대한 값을 불러온다.
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
문제
두 전봇대 A와 B 사이에 하나 둘씩 전깃줄을 추가하다 보니 전깃줄이 서로 교차하는 경우가 발생하였다. 합선의 위험이 있어 이들 중 몇 개의 전깃줄을 없애 전깃줄이 교차하지 않도록 만들려고 한다.

예를 들어, <그림 1>과 같이 전깃줄이 연결되어 있는 경우 A의 1번 위치와 B의 8번 위치를 잇는 전깃줄, A의 3번 위치와 B의 9번 위치를 잇는 전깃줄, A의 4번 위치와 B의 1번 위치를 잇는 전깃줄을 없애면 남아있는 모든 전깃줄이 서로 교차하지 않게 된다.



전깃줄이 전봇대에 연결되는 위치는 전봇대 위에서부터 차례대로 번호가 매겨진다. 전깃줄의 개수와 전깃줄들이 두 전봇대에 연결되는 위치의 번호가 주어질 때, 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에는 두 전봇대 사이의 전깃줄의 개수가 주어진다. 전깃줄의 개수는 100 이하의 자연수이다. 둘째 줄부터 한 줄에 하나씩 전깃줄이 A전봇대와 연결되는 위치의 번호와 B전봇대와 연결되는 위치의 번호가 차례로 주어진다. 위치의 번호는 500 이하의 자연수이고, 같은 위치에 두 개 이상의 전깃줄이 연결될 수 없다.

출력
첫째 줄에 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 출력한다.
*/