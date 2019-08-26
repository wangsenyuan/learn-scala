package set0000.set200.set210.p212;

import set0000.set200.set200.p208.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by senyuanwang on 15/5/19.
 */
public class Solution1 {

    static int[] dx = new int[] {-1, 0, 0, 1};
    static int[] dy = new int[] {0, -1, 1, 0};

    public static void visit(char[][] board, boolean[][] checked, int i, int j, Trie trie, String path,
        Set<String> result) {
        if (trie.search(path)) {
            result.add(path);
            //            return;
        }

        if (!trie.startsWith(path)) {
            return;
        }

        for (int k = 0; k < 4; k++) {
            int x = dx[k] + i;
            int y = dy[k] + j;
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !checked[x][y]) {
                checked[x][y] = true;
                visit(board, checked, x, y, trie, path + board[x][y], result);
                checked[x][y] = false;
            }
        }
    }

    public static List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        boolean[][] checked = new boolean[board.length][board[0].length];
        Set<String> result = new HashSet<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                checked[i][j] = true;
                visit(board, checked, i, j, trie, "" + board[i][j], result);
                checked[i][j] = false;
            }
        }

        List<String> list = new ArrayList<String>(result.size());
        for (String str : result) {
            list.add(str);
        }
        return list;
    }

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'},};

        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(findWords(board, words));
    }
}
