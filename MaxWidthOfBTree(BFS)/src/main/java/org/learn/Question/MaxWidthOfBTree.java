
package org.learn.Question;
import java.util.LinkedList;
import java.util.Queue;

import org.learn.PrepareTree.Node;

public class MaxWidthOfBTree {
	public static void  maxWidthOfBTree(Node root) {
		if (root == null) {
			System.out.println("Queue is empty");
			return ;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		//level delimiter
		queue.offer(null);

		int maxWidth = 0;
		int level = 0;
		//default root level
		int localLevel = 0;
		int localWidth = 0;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			//Level change
			if (null == node) {
				if (!queue.isEmpty()) {
					//level delimiter
					queue.offer(null);
				}
				
				if(localWidth > maxWidth) {
					maxWidth = localWidth;
					level = localLevel;
				}
				//Reset the level sum for next level calculation
				localWidth = 0;		
				localLevel ++;
			} else {
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				localWidth ++;
			}
		}
		System.out.printf("Max Width %d is at level %d \n",maxWidth,level);
		return;
	}
}
