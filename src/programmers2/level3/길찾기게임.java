package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 길찾기게임 {

    @Test
    public void test(){
        int [][] nodeinfo=new int [][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        int [][] answer=solution(nodeinfo);
        int [][] result=new int [][]{{7,4,6,9,1,8,5,2,3},{9,6,5,8,1,4,3,2,7}};
        for(int i=0;i<answer.length;++i){
            for(int j=0;j<answer[0].length;++j){
                Assertions.assertEquals(answer[i][j],result[i][j]);
            }
        }
    }


    public int [][] solution(int [][] nodeinfo){
        PriorityQueue<Node> q=new PriorityQueue<>();
        for (int i=0;i<nodeinfo.length;++i) {
            q.add(new Node(i+1,nodeinfo[i][0],nodeinfo[i][1]));
        }

        Node root=q.poll();
        while(!q.isEmpty()){
            Node child=q.poll();
            buildTree(root,child);
        }
        
        // 전위 순회
        preoOrder(root);
        afterOrder(root);


        int [][] answer=new int [2][nodeinfo.length];
        for(int i=0;i<pre.size();++i){
            answer[0][i]=pre.get(i);
            answer[1][i]=after.get(i);
        }

        return answer;

    }
    static ArrayList<Integer> pre=new ArrayList<>();
    static ArrayList<Integer> after=new ArrayList<>();
    public void preoOrder(Node root){
        if(root==null) return;
        pre.add(root.idx);
        preoOrder(root.left);
        preoOrder(root.right);
    }

    public void afterOrder(Node root){
        if(root==null) return;
        afterOrder(root.left);
        afterOrder(root.right);
        after.add(root.idx);
    }

    public void buildTree(Node parent, Node child){

        if(parent.x>child.x){
            if(parent.left==null) parent.left=child;
            else buildTree(parent.left,child);
        }
        else if(parent.x<child.x){
            if(parent.right==null) parent.right=child;
            else buildTree(parent.right,child);
        }
    }

    public class Node implements Comparable<Node>{
        int idx;
        int x,y;
        Node left,right;

        public Node(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if(o.y==this.y) return this.x-o.x;
            return o.y-this.y;
        }
    }
}
