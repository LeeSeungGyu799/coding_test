import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
*/
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * 아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다. 여러분이 작성한 코드를
		 * 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후, 이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때
		 * 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다. 따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		 * 단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
//System.setIn(new FileInputStream("res/input.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			// 열 체크 
			// 열의 0 전부 제거
			// 1 2 -> 1교착
			// 100x100 최대
			
			int n = Integer.parseInt(bf.readLine()); // 100
			ArrayList[] numList = new ArrayList[n];
			for(int i = 0; i < n; i++) 
				numList[i] = new ArrayList<Integer>();
			
			for(int i = 0; i < n; i++) {
				String s = bf.readLine();
				StringTokenizer st = new StringTokenizer(s);
				for(int j = 0; j < n; j++) {
					int target = Integer.parseInt(st.nextToken());
					if(target != 0)
						numList[j].add(target);
				}
			} // n번열 = numList[n]
			
			int answer = 0;
			
			for(int i = 0; i < n; i++) {
				if(numList[i].isEmpty() || numList[i].size() == 1) // 비었거나 하나면
					continue;
				for(int j = 0; j < numList[i].size()-1; j++) { // 두개이상이면
					if((int) numList[i].get(j) == 1 && (int) numList[i].get(j+1) == 2) { // 1 2
						answer++;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}