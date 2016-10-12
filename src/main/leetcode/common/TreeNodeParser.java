package common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangsenyuan on 12/10/2016.
 */

public interface TreeNodeParser {
    default TreeNode parseAsTreeNode(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("[")) {
            str = str.substring(1);
        }
        if (str.endsWith("]")) {
            str = str.substring(0, str.length() - 1);
        }

        String[] ss = str.split(",");
        List<TreeNode> nodes = new ArrayList<>();
        List<TreeNode> nextLevel = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        nodes.add(root);
        int j = 0;
        boolean left = false;
        for (int i = 1; i < ss.length; i++) {
            String s = ss[i];
            TreeNode node = null;
            if (!"null".equals(s)) {
                int x = Integer.parseInt(s);
                node = new TreeNode(x);
                nextLevel.add(node);
            }

            if (!left) {
                nodes.get(j).left = node;
                left = true;
                continue;
            }
            left = false;
            nodes.get(j).right = node;
            j++;
            if (j == nodes.size()) {
                List<TreeNode> tmp = nodes;
                nodes = nextLevel;
                nextLevel = tmp;
                nextLevel.clear();
                j = 0;
            }
        }

        return root;
    }
}
