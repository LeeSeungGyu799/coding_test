/////////////////////////////////////////////////////////////////////////////////////////////
//기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
//아래 표준 입출력 예제 필요시 참고하세요.
//표준 입력 예제
//int a;
//double b;
//char g;
//String var;
//long AB;
//a = sc.nextInt();                           // int 변수 1개 입력받는 예제
//b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
//g = sc.nextByte();                          // char 변수 1개 입력받는 예제
//var = sc.next();                            // 문자열 1개 입력받는 예제
//AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
//표준 출력 예제
//int a = 0;                            
//double b = 1.0;               
//char g = 'b';
//String var = "ABCDEFG";
//long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;

/*
사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
*/
class Solution {
	static int subTreeSize;
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
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			int v = sc.nextInt(); // v = 정점의 개수
			int e = sc.nextInt(); // e = 간선의 개수
			int[] target = new int[2];
			for (int i = 0; i < 2; i++) {
				target[i] = sc.nextInt(); // target = 타겟 정점
			}

			// 1. 정점의 가장 가까운 공통조상을 구하기
			// 방법 -> 입력받을 때 parent[] 만든다? -> v개 만들어두면 될듯?
			// 목표 노드의 ArrayList 비교, 같은값이 나오면 가장 첫번째 값이 공통조상 -> 아니었음
			// 2. 공통조상 기준 서브트리의 크기를 구한다.
			// 공통조상 기준으로 dfs를 한번 돌린다

			int[] parent = new int[v+1];
			ArrayList<Integer>[] child = new ArrayList[v + 1];

			for (int i = 1; i <= v; i++) {
			    child[i] = new ArrayList<>();
			} // 초기화
			
			for (int i = 0; i < e; i++) {
				int tempParent = sc.nextInt();
				int tempChild = sc.nextInt();
				parent[tempChild] = tempParent;
				child[tempParent].add(tempChild);
			}
			
			// parent[자식노드]에는 본인의 부모노드가 들어가있다.
			// child[부모노드] 엔 arrayList로 자식노드들이 들어가있다

			// 제일 가까운 정점은 어떻게 구하지..
			// 타겟에서 최상위노드 1까지 쭈우욱 arrayList에 넣고, 타겟 2에서 다시 체크하면서 가장 먼저 만나는게 공통노드
			
			int sameParentResult = 0;
			ArrayList<Integer> targetOneAllParent = new ArrayList<>();
			
			int temp = target[0];
			while(temp != 0) {
				targetOneAllParent.add(temp);
				temp = parent[temp];
			} // 최상위노드까지의 부모트리
			
			temp = target[1];
			
			while(temp != 0) {
				if(targetOneAllParent.contains(temp)) {
					sameParentResult = temp;
					break;
				}
				temp = parent[temp];
			}
			
			// 이제 sameParentResult로 dfs를 굴리자.
			subTreeSize = 0;
			dfs(sameParentResult, child);
			
			System.out.println("#" + test_case + " " + sameParentResult + " " + subTreeSize);
		}
	}
	
	static void dfs(int node, ArrayList<Integer>[] child) {
		subTreeSize++;
		if(child[node] == null) { 
			// 아래에 그 머냐 노드가 없으면 return하기 엥 그런거 저장한적없는데
			// child 배열을 추가하도록 합시다

			return;
		}
		
		for(int i = 0; i < child[node].size(); i++) {
			dfs(child[node].get(i), child);
		}
	}
}