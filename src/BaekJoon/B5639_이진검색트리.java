package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B5639_이진검색트리 {
    public static class Node{
        int num;
        Node left;
        Node right;

        public Node(int num) {
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals(""))
                break;
            buildTree(root,new Node(Integer.parseInt(input)));
        }

        postOrder(root);
    }

    public static void postOrder(Node root){
        if(root==null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.num);
    }

    public static void buildTree(Node parent, Node child){
        if(child.num<parent.num){
            if(parent.left==null) {
                parent.left=child;
                return;
            }
            else{
                buildTree(parent.left,child);
            }
        }
        else {
            if(parent.right==null){
                parent.right=child;
                return;
            }
            else{
                buildTree(parent.right,child);
            }
        }
    }
}
