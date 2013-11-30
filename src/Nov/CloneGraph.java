package Nov;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CloneGraphSolution s = new CloneGraphSolution();
		/*
		UndirectedGraphNode a0 = new UndirectedGraphNode(0);
		UndirectedGraphNode a1 = new UndirectedGraphNode(1);
		UndirectedGraphNode a2 = new UndirectedGraphNode(2);
		UndirectedGraphNode a3 = new UndirectedGraphNode(3);
		UndirectedGraphNode a4 = new UndirectedGraphNode(4);
		UndirectedGraphNode a5 = new UndirectedGraphNode(5);

		a0.neighbors.add(a1);
		a0.neighbors.add(a5);
		a1.neighbors.add(a2);
		a1.neighbors.add(a5);
		a2.neighbors.add(a3);
		a3.neighbors.add(a4);
		a3.neighbors.add(a4);
		a4.neighbors.add(a5);
		a4.neighbors.add(a5);
		*/
		UndirectedGraphNode a0 = new UndirectedGraphNode(0);
		a0.neighbors.add(a0);
		a0.neighbors.add(a0);
		UndirectedGraphNode tmp = s.cloneGraph(a0);
		System.out.println(tmp.label);
	}

}

// Definition for undirected graph.
class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

class CloneGraphSolution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		// visited old and new nodes are recorded in this map
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		return cloneGraph(node, map);

	}

	private UndirectedGraphNode cloneGraph(UndirectedGraphNode node,
			HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {

		if (node == null) {
			return null;
		}
		int label = node.label;
		UndirectedGraphNode newNode = new UndirectedGraphNode(label);

		if (map.containsKey(node)) {
			// already visited, get newNode from the map
			newNode = map.get(node);
			return newNode;
		} else {
			map.put(node, newNode);
		}

		if (node.neighbors.size() == 0) {
			// leaf node, just return, no need to care about the neighbors
			return newNode;
		}

		// depth first
		for (UndirectedGraphNode tmpnode : node.neighbors) {
			newNode.neighbors.add(cloneGraph(tmpnode, map));
		}
		return newNode;

	}
}