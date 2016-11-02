package p449;

import common.TreeNode;
import common.TreeNodeParser;

/**
 * Created by wangsenyuan on 01/11/2016.
 */
public class Codec implements TreeNodeParser {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "N";
        }
        return root.val + "{" + serialize(root.left) + "}{" + serialize(root.right) + "}";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("N")) {
            return null;
        }
        int i = data.indexOf('{');
        int j = data.lastIndexOf('}');
        int value = Integer.parseInt(data.substring(0, i));
        TreeNode root = new TreeNode(value);

        int level = 0;
        int k = i;
        for (; k < j; k++) {
            if (data.charAt(k) == '{') {
                level++;
            } else if (data.charAt(k) == '}') {
                level--;
            }
            if (level == 0) {
                break;
            }
        }

        root.left = deserialize(data.substring(i + 1, k));
        root.right = deserialize(data.substring(k + 2, j));
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = codec.parseAsTreeNode("[2,1,3]");
        String data = codec.serialize(root);
        System.out.println(data);
        TreeNode node = codec.deserialize(data);
        System.out.println(node);
    }
}
