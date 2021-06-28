package Algorithm.Graph;

public class ArrGraph {

    private int [][] arrGraph;

    // 그래프 초기화
    public ArrGraph(int initSize){
        this.arrGraph=new int[initSize+1][initSize+1];
    }
    // 그래프 return
    public int [][] getGraph(){
        return this.arrGraph;
    }

    // 그래프 추가 (양방향)
    public void put(int x, int y){
        arrGraph[x][y]=arrGraph[y][x]=1;
    }

    // 그래프 추가 (단방향)
    public void putSingle(int x, int y){
        arrGraph[x][y]=1;
    }

    // 그래프 출력 (인접행렬)
    public void printGraphToAdjArr(){
        for(int i=0;i< arrGraph.length;++i){
            for(int j=0;j<arrGraph[i].length;j++){
                System.out.print(" "+arrGraph[i][j]);
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        int initSize = 6;
        ArrGraph adjArr = new ArrGraph(initSize);

        adjArr.put(1, 2);
        adjArr.put(1, 3);
        adjArr.put(2, 3);
        adjArr.put(2, 4);
        adjArr.put(3, 4);
        adjArr.put(3, 5);
        adjArr.put(4, 5);
        adjArr.put(4, 6);

        adjArr.printGraphToAdjArr();

    }
}
