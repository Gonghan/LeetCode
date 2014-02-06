package February;

import java.util.HashMap;

public class CopyListWithRandom {
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
			if (tmp.next != null) {
				RandomListNode next = tmp.next;
				RandomListNode newNext = map.get(next);
				newTmp.next = newNext;
			}
			if (tmp.random != null) {
				RandomListNode random = tmp.random;
				RandomListNode newRandom = map.get(random);
				newTmp.random = newRandom;
			}
			tmp = tmp.next;
		}
		return newHead;
	}
}
