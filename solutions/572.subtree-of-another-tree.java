/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
 *
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 *
 * algorithms
 * Easy (52.00%)
 * Likes:    9021
 * Dislikes: 607
 * Total Accepted:    1.3M
 * Total Submissions: 2.5M
 * Testcase Example:  '[3,4,5,1,2]\n[4,1,2]'
 *
 * Given the roots of two binary trees root and subRoot, return true if there
 * is a subtree of root with the same structure and node values of subRoot and
 * false otherwise.
 * 
 * A subtree of a binary tree tree is a tree that consists of a node in tree
 * and all of this node's descendants. The tree tree could also be considered
 * as a subtree of itself.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the root tree is in the range [1, 2000].
 * The number of nodes in the subRoot tree is in the range [1, 1000].
 * -10^4 <= root.val <= 10^4
 * -10^4 <= subRoot.val <= 10^4
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isIdentical(TreeNode root, TreeNode subRoot){
        if(root ==null && subRoot==null){
            return true;
        }
        if(root == null || subRoot==null){
            return false;
        }
        if(root.val==subRoot.val ){
            return isIdentical(root.left, subRoot.right) && isIdentical(root.right, subRoot.right);
        }
        return false;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null){
            return true;
        }
        if(root==null){
            return false;
        }

        if(root.val==subRoot.val){
            if(isIdentical(subRoot, subRoot)){
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
// @lc code=end

