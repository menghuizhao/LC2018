/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        if (root == null) {
            return paths;
        }
        
        String path = "";
        buildPath(root, path, paths);
        return paths;
    }
    
    private void buildPath(TreeNode node, String path, List<String> result) {
        path = path + "->" + Integer.toString(node.val);
        if (node.left == null && node.right == null) {
            result.add(path.substring(2));
            return;
        }
        
        if (node.left != null) {
            buildPath(node.left, path, result);
        }
        
        if (node.right != null) {
            buildPath(node.right, path, result);
        }
    }
}