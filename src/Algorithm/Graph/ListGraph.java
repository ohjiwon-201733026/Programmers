package Algorithm.Graph;

import java.util.ArrayList;

public class ListGraph {
    private ArrayList<ArrayList<Integer>> listGraph;

    // 그래프 초기화
    public ListGraph(int initSize){
        this.listGraph=new ArrayList<ArrayList<Integer>>(); // 그래프 생성
        // ex) initSize = 3
        // listGraph[0]
        // listGraph[1] -> 2 -> 3
        // listGraph[2] -> 1 -> 3 -> 4
        // listGraph[3] -> 1 -> 2 -> 4 -> 5

        for(int i=0;i<initSize+1;++i){
            listGraph.add(new ArrayList<Integer>());
        }
    }
    // 그래프 리턴
    public ArrayList<ArrayList<Integer>> getListGraph()
    {
        return this.listGraph;
    }
    // 특정 노트 return
    public ArrayList<Integer> getNode(int i){
        return this.listGraph.get(i);
    }
    // 그래프 추가 (양방향) , x - y
    public void put(int x, int y){
        listGraph.get(x).add(y);
        listGraph.get(y).add(x);
    }
    // 그래프 추가 (단방향), x -> y
    public void putSingle(int x, int y){
        listGraph.get(x).add(y);
    }

    public void printGraphToAdjList(){
        for(int i=1;i<listGraph.size();++i){
            System.out.print("정점 "+i+"의 인접리스트");

            for(int j=0;j<listGraph.get(i).size();j++){
                System.out.println("->"+listGraph.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int initSize=6;
        ListGraph adjList = new ListGraph(initSize);

        adjList.put(1, 2);
        adjList.put(1, 3);
        adjList.put(2, 3);
        adjList.put(2, 4);
        adjList.put(3, 4);
        adjList.put(3, 5);
        adjList.put(4, 5);
        adjList.put(4, 6);

        adjList.printGraphToAdjList();

    }
}
