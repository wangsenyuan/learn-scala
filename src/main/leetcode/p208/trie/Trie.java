package p208.trie;

class TrieNode {
    private TrieNode[] children;
    private boolean end = false;
    // Initialize your data structure here.
    public TrieNode() {
        this.children = new TrieNode[26];
    }

    public void insert(char[] words, int i) {
        if (i >= words.length - 1) {
            this.end = true;
            return;
        }

        int j = i + 1;
        char nxt = words[j];
        TrieNode child = children[nxt - 'a'];
        if (child == null) {
            child = new TrieNode();
            children[nxt - 'a'] = child;
        }
        child.insert(words, j);
    }

    public boolean startsWith(char[] words, int i) {
        if(i >= words.length - 1) {
            return true;
        }
        int j = i + 1;
        char nxt = words[j];
        TrieNode child = children[nxt - 'a'];
        if(child == null) {
            return false;
        }
        return child.startsWith(words, j);
    }

    public boolean search(char[] words, int i) {
        if(i >= words.length - 1) {
            return this.end;
        }
        int j = i + 1;
        char nxt = words[j];
        TrieNode child = children[nxt - 'a'];
        if(child == null) {
            return false;
        }
        return child.search(words, j);
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word.toCharArray(), -1);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return root.search(word.toCharArray(), -1);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix.toCharArray(), -1);
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ab");
        System.out.println(trie.search("a"));
        System.out.println(trie.startsWith("a"));
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");