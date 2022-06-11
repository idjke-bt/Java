package com.yf.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YangFeng
 * @create 2022-05-13 20:01
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        for(int i=0; i<list.size(); i++){
            if(list.get(i).val>p.val)
                return list.get(i);
        }
        return null;
    }

    public void inOrder(TreeNode root, List<TreeNode> list){
        if(root==null)
            return;
        if(root.left!=null)
            inOrder(root.left, list);
        list.add(root);
        if(root.right!=null)
            inOrder(root.right,list);
    }

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
       int index = nums.length/2;
       int val = nums[index];
       int move=0;
       for(int i=0; i<nums.length; i++){
           move += Math.abs(nums[i]-val);
       }
       return move;
    }

    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m*n;
        int mid, num; //先判断mid是第几小，然后用二分法找到第k小
        while (left<right){
            mid = (left+right)/2;
            num = 0;
            for(int i=1; i<=m; i++)
                num += Math.min(mid/i, n);

            if(num >= k){
                right=mid;
            }else {
                left = mid+1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int kthNumber = solution.findKthNumber(3, 3, 5);
        System.out.println(kthNumber);
    }


}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        val = x;
    }
}

