/*
package com.algoritms.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
*//*
    static class Solution {
        public List<Integer> postorder(Node root) {
            List<Integer> postorderList = new ArrayList<>();

            List<Node> queue = new ArrayList<>();
            queue.add(root);

            for (Node node : root.children) {
                queue.add(node);
            }
            for (Node node : root.children) {
                queue.addAll(postorderList(node));
            }
            return postorderList;
        }
    }

    private static addNode();

    public static void main(String[] args) {
        Node six = new Node(6, new ArrayList<>());
        Node five = new Node(5, new ArrayList<>());

        List<Node> threeNodeList = new ArrayList<>();
        threeNodeList.add(five);
        threeNodeList.add(six);

        Node three = new Node(3, threeNodeList);

        Node two = new Node(2, new ArrayList<>());
        Node four = new Node(4, new ArrayList<>());

        List<Node> rootNodeList = new ArrayList<>();
        rootNodeList.add(three);
        rootNodeList.add(two);
        rootNodeList.add(four);

        Node root = new Node(1, rootNodeList);

        Solution solution = new Solution();
        List<Integer> list = solution.postorder(root);

        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

}
*/
