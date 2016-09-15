package p211;

/**
 * Created by senyuanwang on 16/9/15.
 */
public class WordDictionary {
    private Trie trie = new Trie();

    // Adds a word into the data structure.
    public void addWord(String word) {
        trie.add(word.toCharArray(), 0);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return trie.search(word.toCharArray(), 0);
    }

    static class Trie {
        private Trie[] children;
        private boolean end;

        Trie() {
            this.children = new Trie[26];
        }

        public void add(char[] word, int i) {
            if (i == word.length) {
                end = true;
                return;
            }
            Trie child = children[word[i] - 'a'];
            if (child == null) {
                child = new Trie();
                children[word[i] - 'a'] = child;
            }
            child.add(word, i + 1);
        }

        public boolean search(char[] word, int i) {
            if (i == word.length) {
                return end;
            }

            if (word[i] != '.') {
                Trie child = children[word[i] - 'a'];
                if (child == null) {
                    return false;
                }
                return child.search(word, i + 1);
            }

            for (Trie child : children) {
                if (child == null) {
                    continue;
                }
                if (child.search(word, i + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        dict.addWord("bad");
        dict.addWord("mad");
        System.out.println(dict.search("pad"));
        System.out.println(dict.search("bad"));
        System.out.println(dict.search(".ad"));
        System.out.println(dict.search("..d"));
    }
}