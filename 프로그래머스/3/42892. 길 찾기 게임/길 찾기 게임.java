import java.util.*;
class Solution {
    
    static class Node {
        int num, x, y;
        Node left, right; // 좌 우 리프
        Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    
    int[][] answer;
    int index;
    
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];

        Node[] nodes = new Node[nodeinfo.length];

        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(i + 1,nodeinfo[i][0],nodeinfo[i][1]); // 노드입력
        }

        // y가 가장 높은게 루트노드
        // y순서대로 정렬 + x 순서대로 정렬 (낮은것부터)
        Arrays.sort(nodes, (a, b) -> {
            if (a.y == b.y) {
                return Integer.compare(a.x, b.x);
            }
            return Integer.compare(b.y, a.y);
        });
        Node root = nodes[0];

        for (int i = 1; i < nodes.length; i++) {
            Node cur = root;
            Node target = nodes[i];

            while (true) {
                if (target.x < cur.x) { // 타겟이 왼쪽이면
                    if (cur.left == null) { 
                        cur.left = target; // 넣고
                        break;
                    }
                    cur = cur.left; // 찼으면 왼쪽으로
                } else {// 오른쪽이면
                    if (cur.right == null) {
                        cur.right = target; //넣고
                        break;
                    }
                    cur = cur.right; // 찼으면 오른쪽으로
                }
            }
        }
        
        index = 0;
        dfsPre(root);
        index = 0;
        dfsPost(root);

        return answer;
    }

    void dfsPre(Node node) { // 루 좌 우
        if (node == null) return;

        answer[0][index++] = node.num;
        dfsPre(node.left);
        dfsPre(node.right);
    }

    void dfsPost(Node node) { // 좌 우 루 
        if (node == null) return;

        dfsPost(node.left);
        dfsPost(node.right);
        answer[1][index++] = node.num;
    }
}
