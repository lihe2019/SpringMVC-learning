package com.lihe.controller;

import org.junit.Test;

import java.util.ArrayDeque;

import java.util.Queue;

//Definition for a binary tree node.


public class test {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }


        int currentNumber = 0;
        TreeNode curNode = root;
        int res = 0;

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(curNode);
        currentNumber = 1;
        int currentNumber2 = 0;

        while (currentNumber != 0){
            currentNumber2 = 0;
//            System.out.println("cur number" + currentNumber);

            for (int i = 0; i < currentNumber; i++) {
//                System.out.println(i);
//                System.out.println(queue);
                curNode = queue.remove();
                if(curNode.left != null){
                    currentNumber2++;
                    queue.add(curNode.left);
//                    System.out.println("left");
                }
                if(curNode.right != null){
                    currentNumber2++;
                    queue.add(curNode.right);
//                    System.out.println("right");
                }
            }
            currentNumber = currentNumber2;
            res++;
        }

        return res;
    }


    public static void main(String[] args) {
        TreeNode t = new TreeNode(8);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);
        t.left = t1;
        t.right = t2;
        t2.left = t3;
        t2.right = t4;
        TreeNode root = t;
        int a = maxDepth(root);
        System.out.println(a);
    }

}
