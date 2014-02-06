package February;

import java.util.HashMap;

public class CopyWithRandomPointer {

	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode newHead = null;
		RandomListNode tmp = head;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		while (tmp != null) {
			RandomListNode newTmp = new RandomListNode(tmp.label);
			map.put(tmp, newTmp);
			if (newHead == null) {
				newHead = newTmp;
			}
			tmp = tmp.next;
		}
		tmp = head;
		while (tmp != null) {
			RandomListNode newTmp = map.get(tmp);
			if (tmp.random != null) {
				RandomListNode random = tmp.random;
				RandomListNode newRandom = map.get(random);
				newTmp.random = newRandom;
			}
		}
		return newHead;
	}
}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};