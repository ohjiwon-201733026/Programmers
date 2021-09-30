package Programmers.Lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;


public class 길찾기게임 {

    @Test
    public void test(){
        int [][] nodeinfo={{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        int [][] result={{7,4,6,9,1,8,5,2,3},{9,6,5,8,1,4,3,2,7}};
        int [][] answer=solution(nodeinfo);
        for(int i=0;i<2;++i){
            for(int a: answer[i]){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

    }
    static int [][] answer;
    static int i;
    public int [][] solution(int [][] nodeinfo){
        ArrayList<Node> nodeList=new ArrayList<>();
        for(int i=0;i< nodeinfo.length;++i){
            int [] node=nodeinfo[i];
            nodeList.add(new Node(node[0],node[1],i+1));
        }
        Collections.sort(nodeList);

        Node root=nodeList.get(0);
        // 트리 만들기
        for(int i=1;i<nodeList.size();++i){
            Node child=nodeList.get(i);
            connectNode(root,child);
        }
        System.out.println("===========");
        System.out.println(root);
        answer=new int [2][nodeList.size()];
        // 전위순회
        i=0;
        preOrder(answer,root);
        i=0;
        // 후위 순회
        postOrder(answer,root);


        return answer;
    }

    private void postOrder(int[][] arr, Node node) {
        if(node!=null){
            if(node.left!=null) postOrder(arr,node.left);
            if(node.right!=null) postOrder(arr,node.right);
            arr[1][i++]=node.val;
        }
    }

    private void preOrder(int[][] arr, Node node) {
        if(node!=null){
            arr[0][i++]=node.val;
            if(node.left!=null) preOrder(arr,node.left);
            if(node.right!=null) preOrder(arr,node.right);
        }
    }

    private void connectNode(Node parent, Node child) {

        if(parent.x>child.x){ // left
            if(parent.left==null) parent.left=child;
            else connectNode(parent.left,child);
        }
        else{ // right
            if(parent.right==null) parent.right=child;
            else connectNode(parent.right, child);
        }
    }


    static class Node implements Comparable<Node>{
        int x,y;
        int val;
        Node left;
        Node right;

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val=val;
        }

        @Override
        public String toString() {
            return "x=" + x + ", y=" + y ;
        }

        @Override
        public int compareTo(Node o) {
            return o.y-this.y;
        }
    }
}
