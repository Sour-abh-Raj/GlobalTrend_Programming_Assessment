class TreeNode {
    TreeNode[] children = new TreeNode[26];
    boolean isEndOfWord;
}

public class Tree {

    private TreeNode root;

    public Tree() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TreeNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TreeNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Tree Tree = new Tree();
        Tree.insert("apple");
        System.out.println(Tree.search("apple"));
        System.out.println(Tree.search("app"));
        System.out.println(Tree.startsWith("app"));
        Tree.insert("app");
        System.out.println(Tree.search("app"));
    }
}
