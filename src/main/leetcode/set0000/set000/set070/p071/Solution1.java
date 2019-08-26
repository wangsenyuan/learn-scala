package set0000.set000.set070.p071;

import java.util.Stack;

/**
 * Created by wangsenyuan on 7/21/16.
 */
public class Solution1 {
    public String simplifyPath(String path) {
        if (path == null) {
            return null;
        }

        int i = 0;
        int j = 0;

        Stack<String> stack = new Stack<>();

        for (j = 1; j < path.length(); j++) {
            char c = path.charAt(j);
            if (c != '/') {
                continue;
            }

            if (i + 1 == j) {
                i = j;
                continue;
            }

            updateStack(stack, path.substring(i + 1, j));

            i = j;
        }

        updateStack(stack, path.substring(i + 1, j));

        return joinStack(stack);
    }

    private String joinStack(Stack<String> stack) {
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");

        }

        if(sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }

    private void updateStack(Stack<String> stack, String s) {
        if (s.length() == 0) {
            return;
        }

        if (s.equals(".")) {
            return;
        }

        if (s.equals("..")) {
            if (stack.size() > 0) {
                stack.pop();
            }
            return;
        }

        stack.push(s);
    }
}
