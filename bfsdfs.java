package abhi1;

import java.util.*;

class TreeNode {
    int val;
    List<TreeNode> child = new ArrayList<>();
    int noc;
    boolean flag;

    TreeNode(int val, int N) {
        Scanner sc = new Scanner(System.in);
        this.val = val;
        this.noc = N;
        this.flag = false;
        for (int i = 0; i < this.noc; i++) {
            System.out.print("Enter Child " + (i + 1) + " of " + this.val + " : ");
            int c = sc.nextInt();
            System.out.print("Enter Number of child of " + c + " : ");
            int n = sc.nextInt();
            this.child.add(new TreeNode(c, n));
        }
    }
}

public class bfsdfs {
    static boolean searchFlag;
    static Scanner in;

    // DFS Preorder
    static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "  ");
            for (int i = 0; i < root.noc; i++) {
                preOrder(root.child.get(i));
            }
        }
    }

    // BFS
    static void BFS(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    root.flag = true;
    queue.add(root);
    
    recursiveBFS(root, queue);
}

static void recursiveBFS(TreeNode node, Queue<TreeNode> queue) {
    System.out.print(node.val + " ");
    
    for (int i = 0; i < node.noc; i++) {
        TreeNode child = node.child.get(i);
        if (child.flag == false) {
            child.flag = true;
            queue.add(child);
        }
    }
    
    if (!queue.isEmpty()) {
        TreeNode nextNode = queue.poll();
        recursiveBFS(nextNode, queue);
    }
}

    static void searchDFS(TreeNode root, int key) {
        if (root != null && searchFlag == false) {
            if (root.val == key) {
                searchFlag = true;
                System.out.print(root.val + " ");
                return;
            }
            for (int i = 0; i < root.noc; i++) {
                searchDFS(root.child.get(i), key);
            }
        }
    }

    public static void main(String[] args) {
        in = new Scanner(System.in);
        searchFlag = false;

        System.out.print("Enter Root Node: ");
        int rootVal = in.nextInt();
        System.out.print("Enter Total Number Of Childs of root: ");
        int N = in.nextInt();
        TreeNode root = new TreeNode(rootVal, N);

        System.out.println("\n DFS Preorder: ");
        preOrder(root);
        System.out.println("\n\n BFS: ");
        BFS(root);

        System.out.print("Enter destination : ");
        rootVal = in.nextInt();

        System.out.print("Path for : " + rootVal + " : ");
        searchDFS(root, rootVal);
    }
}
