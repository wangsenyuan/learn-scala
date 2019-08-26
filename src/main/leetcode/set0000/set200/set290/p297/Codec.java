package set0000.set200.set290.p297;

import common.TreeNode;

public class Codec {

    private void serialize(TreeNode root, StringBuilder sb) {
        sb.append("(");

        if (root != null) {
            sb.append(root.val);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        sb.append(")");
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 2) {
            //only ()
            return null;
        }
        data = data.substring(1, data.length() - 1);
        int i = data.indexOf("(");
        int val = Integer.parseInt(data.substring(0, i));

        int level = 0;
        int j = i;

        for (; j < data.length(); j++) {
            if (data.charAt(j) == '(') {
                level++;
            } else if (data.charAt(j) == ')') {
                level--;
            }
            if (level == 0) {
                break;
            }
        }

        TreeNode root = new TreeNode(val);
        root.left = deserialize(data.substring(i, j + 1));
        root.right = deserialize(data.substring(j + 1));

        return root;
    }
}
