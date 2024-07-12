class TreeNode {
    TreeNode[] children;
    boolean isEndOfWord;
    
    public TreeNode() {
        this.children = new TreeNode[26];
        this.isEndOfWord = false;
    }
}

class Tree {
    private TreeNode root;
    
    public Tree() {
        root = new TreeNode();
    }
    
    public void insert(String word) {
        TreeNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TreeNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TreeNode node = searchPrefix(word);
        return node != null && node.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TreeNode node = searchPrefix(prefix);
        return node != null;
    }
    
    private TreeNode searchPrefix(String prefix) {
        TreeNode node = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}

public class TreeDemo {
    public static void main(String[] args) {
        Tree Tree = new Tree();
        
        Tree.insert("apple");
        Tree.insert("app");
        
        System.out.println(Tree.search("apple"));
        System.out.println(Tree.search("app"));
        System.out.println(Tree.startsWith("app"));
        System.out.println(Tree.search("banana"));
    }
}
