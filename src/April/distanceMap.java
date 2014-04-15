package April;

import java.util.LinkedList;
import java.util.Queue;

public class distanceMap {

	public int[][] generateMap(int[][] A) {
		int height = A.length;
		int width = A[0].length;
		Queue<Node> queue = new LinkedList<Node>();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (A[i][j] == 0) {
					queue.add(new Node(i, j));
				}
			}
		}

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node == null) {
				continue;
			}
			int curr_dis = node.distance;
			Node left = set(A, curr_dis, node.x - 1, node.y);
			Node right = set(A, curr_dis, node.x + 1, node.y);
			Node up = set(A, curr_dis, node.x , node.y-1);
			Node down = set(A, curr_dis, node.x, node.y+1);
			addIntoQueue(queue,left);
			addIntoQueue(queue,right);
			addIntoQueue(queue,up);
			addIntoQueue(queue,down);
		}
		return A;
	}

	private void addIntoQueue(Queue<Node> queue, Node left) {
		if(left!=null){
			queue.add(left);
		}
		
	}

	private Node set(int[][] A, int curr_dis, int x, int y) {
		if(x<0 || y<0){
			return null;
		}
		int curr_val=A[x][y];
		if(curr_val<=curr_dis+1){
			return null;
		}else{
			A[x][y]=curr_dis+1;
			Node node=new Node(x,y);
			node.distance=curr_dis+1;
			return node;
		}
	}

	private class Node {
		int distance;
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
			distance = 0;
		}
	}
}
