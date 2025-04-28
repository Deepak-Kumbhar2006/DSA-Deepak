package problems;

//import javax.swing.tree.TreeNode;
//import org.w3c.dom.Node;

import com.sun.source.tree.Tree;

import javax.sound.sampled.Line;
import java.util.*;

public class BFS {

    // Binary Tree Level Order Traversal
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

//    Average of Levels in Binary Tree
    // Space Complexity O(n) , Run time = 2 ms
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root==null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.remove();
                sum += currentNode.val;
                if (currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if (currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(sum/size);
        }
        return result;
    }

//    Spcae Complexity = O(n)  , Run time = 2ms
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root==null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.remove();
                currentLevel.add(currentNode.val);
                if (currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if (currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
            double sum = 0;
            for (int i = 0; i < currentLevel.size(); i++) {
                sum += currentLevel.get(i);
            }
            result.add(sum/currentLevel.size());
        }
        return result;
    }

 // Find Successor
    public TreeNode findSuccessor(TreeNode root, int key){
        if (root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.remove();
            if (currentNode.left!=null){
                queue.offer(currentNode.left);
            }
            if (currentNode.right!=null){
                queue.offer(currentNode.right);
            }
            if (currentNode.val==key){
                break;
            }
        }
        return queue.peek();
    }

    // 103 : Binary Tree ZigZag LevelOrder Traversal

    /*
       Normal Order :  remove from front, add in back
       Reverse Order : Remove From back, add in front
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        boolean reverse = false;
        while(!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> levels = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                if (reverse) {
                    TreeNode currentNode = deque.pollLast();
                    levels.add(currentNode.val);
                    if (currentNode.right != null) {
                        deque.addFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        deque.addFirst(currentNode.left);
                    }
                } else {
                    TreeNode currentNode = deque.pollFirst();
                    levels.add(currentNode.val);
                    if (currentNode.left != null) {
                        deque.addLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        deque.addLast(currentNode.right);
                    }
                }
            }
            reverse = !reverse;
                result.add(levels);
        }
        return result;
    }
//    https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
    public Node connect(Node root) {
        if (root==null){
            return null;
        }
        Node leftmost = root;
        while(leftmost.left!=null){
            Node current = leftmost;
            while(current!=null){
                current.left.next = current.right;
                if (current.next != null){
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

//    https://leetcode.com/problems/binary-tree-right-side-view/
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root==null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if (currentNode.right!=null){
                    queue.add(currentNode.right);
                }
                if (i==(levelSize-1)){
                    ans.add(currentNode.val);
                }
            }
        }
        return ans;
    }

//    https://leetcode.com/problems/cousins-in-binary-tree/
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return (
                (level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy))
        );
    }
    TreeNode findNode(TreeNode node, int x){
        if (node==null){
            return null;
        }
        if (node.val==x){
            return node;
        }
        TreeNode n = findNode(node.left, x);
        if (n!=null){
            return n;
        }
        return findNode(node.right, x);
    }

    boolean isSibling(TreeNode node, TreeNode x, TreeNode y){
        if (node==null){
            return false;
        }
        return (
                (node.left == x && node.right==y) || (node.left==y&&node.right==x) || isSibling(node.left, x, y) || isSibling(node.right, x, y)
        );
    }

    int level(TreeNode node, TreeNode x, int lev){
        if (node==null){
            return 0;
        }

        if (node==x){
            return lev;
        }

        int l = level(node.left, x, lev+1);
        if (l != 0){
            return l;
        }
        return level(node.right, x, lev+1);
    }

    // https://leetcode.com/problems/symmetric-tree/
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left==null && right==null){
                continue;
            }
            if (left == null || right == null){
                return false;
            }
            if (left.val!= right.val){
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}
