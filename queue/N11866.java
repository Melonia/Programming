package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue3 que = new Queue3(N);
		
		//큐에 사람들의 번호를 삽입
		for(int i = 1; i <= N; i++) {
			que.enque(i);
		}
		
		System.out.print("<");
		while(que.size()>1) { //마지막 번호는 ,가 없으므로 구분하기 위한 조건
			for(int i = 0; i < K-1; i++) {
				que.enque(que.deque()); //K번째를 제외하고는 전부 큐에서 나온 것을 다시 넣는다.
			}
			System.out.print(que.deque()+", ");
		}
		System.out.print(que.deque()+">");
	}
}
class Queue3{
	
	private int max;
	private int num;
	private int[] que;
	
	Queue3(int capacity){
		max = capacity;
		num = 0;
		try {
			que = new int[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	int enque(int x) {
		if(num >= max)
			return -1;
		return que[num++] = x;
	}
	int deque() {
		if(num <= 0)
			return -1;
		int x = que[0];
		for(int i = 0; i < num-1; i++)
			que[i] = que[i+1];
		num--;
		return x;
	}
	int size() {
		return num;
	}
}
/*
문제
요세푸스 문제는 다음과 같다.

1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000)

출력
예제와 같이 요세푸스 순열을 출력한다.
*/