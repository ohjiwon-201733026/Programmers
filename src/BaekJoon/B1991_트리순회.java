package BaekJoon;

import java.util.Scanner;

public class B1991_트리순회 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Node root=new Node('A');

        for(int i=0;i<n;++i){
            char parent=sc.next().charAt(0);
            char left=sc.next().charAt(0);
            char right=sc.next().charAt(0);

            buildTree(root,parent,left,right);

        }

        preOrder(root);
        System.out.println();
        midOrder(root);
        System.out.println();
        postOrder(root);
    }

    public static void postOrder(Node root){
        if(root ==null )return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.c);
    }
    public static void midOrder(Node root){
        if(root==null) return;

        midOrder(root.left);
        System.out.print(root.c);
        midOrder(root.right);
    }
    public static void preOrder(Node root){

        if(root==null) return;
        System.out.print(root.c);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void buildTree(Node root, char parent, char left, char right){

        if(root==null) return;

        if(root.c==parent){
            if(left!='.') root.left=new Node(left);
            else root.left=null;
            if(right!='.') root.right=new Node(right);
            else root.right=null;
            return;
        }

        buildTree(root.left,parent,left,right);
        buildTree(root.right,parent,left,right);
    }


    public static class Node{
        char c;
        Node left;
        Node right;

        public Node(char c) {
            this.c = c;
        }
    }
}
