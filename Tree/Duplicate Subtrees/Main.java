import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * An approach to this problem is splitting the solution into two steps.
 * One step iterates and keeps tracking of the subtrees through a
 * hashmap to spot duplicate subtrees. The second step, for each possible
 * duplicate subtree, that is, for each root that has been found previously
 * in the first step, checks if the two subtrees are identical (the subtree
 * stored in the hashmap and the current node).
 * 
 * This approach is relatively expensive since the second step has to
 * re-iterate the whole sub-tree again and again when the first step
 * tells so. Therefore, there is a similar approach without doing the
 * iterative step again and again. I will talk about it in the remainder
 * of this text.
 * 
 * What if we represent a subtree (or a tree) with a canonical form like
 * a String form? Doing this, we can check in plain text whether two
 * trees are equal or not. With a map, we could check if there is
 * another substree already seen, but there is a problem with this
 * data structure; how do I keep track of the duplicate subtrees
 * already added to the list? I mean, assume that you have three duplicate
 * subtrees, the first tree is stored in the map. The second subtree
 * is found as duplicate and added to the resulting list. Similarly,
 * the third duplicate subtree is found as duplicate and added to the
 * list as well. We have a problem here.
 * 
 * To avoid the previous problem, we can change the map to a map.
 * Mapping the subtree to a number of occurrences. In this case, returning
 * to the three duplicate subtrees, the second subtree sees that there is
 * only only occurrence of the duplicate subtree. Thus, adding the
 * subtree to the list and increasing the occurrences by 1. The third
 * subtree sees that there are two ocurrences of the subtree and now that
 * there is no need to add the same subtree to the list. The solution is 
 * created based on this idea.
 * 
 * I want to point out the important fact of hashing correctly the 
 * subtrees. I mean, making sure that two different (not duplicate) subtrees 
 * do not hash to the same string. This can generate errors inside the
 * algorithm and of course, resulting in wrong computations.
 * 
 * @author      Rubén Barragán
 * @version     1.0
 */
public class Main {
    public static void main(String[] args) {
       
        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.left.left = new Node(4);
        // root.left.right = new Node(3);
        // root.left.right.left = new Node(1);
        // root.left.right.right = new Node(3);
        // root.left.right.right.right = new Node(3);
        // root.left.right.right.right.right = new Node(1);
        // root.right = new Node(3);
        // root.right.right = new Node(1);

         /*
        *        0
        *       / \
        *      0   0
        *     /     \
        *    0       0
        *             \
        *              0
        *
        */
        Node root = new Node(0);
        root.left = new Node(0);
        root.left.left = new Node(0);
        root.right = new Node(0);
        root.right.right = new Node(0);
        root.right.right.right = new Node(0);

        for(Node n : findDuplicateSubtrees(root)) {
            System.out.print(n.val + ", ");
        }
    }

    public static List<Node> findDuplicateSubtrees(Node root) {
        HashMap<String, Integer> map = new HashMap<>();
        LinkedList<Node> result = new LinkedList<>();
        inOrderTraversal(root, map, result);
        return result;
    }

    public static String inOrderTraversal(Node root, HashMap<String, Integer> map, LinkedList<Node> res) {
        if (root == null) 
            return ".";  
        String treeHash = root.val + inOrderTraversal(root.left, map, res) + inOrderTraversal(root.right, map, res);
        if(!map.containsKey(treeHash)) {
            map.put(treeHash, 1);
        } else {
            if(map.get(treeHash) == 1) {
                res.add(root);
            }
            map.put(treeHash, map.get(treeHash) + 1);
        }
        return treeHash;
    }
}

class Node {
    int val;
    Node left;
    Node right;
    Node(int x) {
        val = x;
    }
}