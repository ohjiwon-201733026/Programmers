package Algorithm.Graph;

public class Dijkstra {

    public static void main(String[] args) {
        int V=5,E=8;
        int [][] adj={{0,4,3,5,0},{0,0,0,5,0},{2,0,0,0,6},{0,0,4,0,0},{0,0,0,2,0}};
        int [] d=new int [V];
        for(int i=0;i<V;++i) d[i]=Integer.MAX_VALUE;
        boolean [] check=new boolean[V];
        d[0]=0;

        for(int i=0;i<V-1;++i){
            
            // 최소값 찾기
            int min=Integer.MAX_VALUE;
            int index=-1;

            for(int j=0;j<V;++j){
                if(!check[j] && min>d[j]){// 아직 처리 안된 d가 가장 작은 값
                    index=j;
                    min=d[j];
                }
            }

            // 아직 처리x &&  min이랑 연결되고 && start~min+min~j < start~j 이면
            for(int j=0;j<V;++j){
                if(!check[j] && adj[index][j]!=0 && min+adj[index][j]<d[j]){
                    d[j]=min+adj[index][j];
                }
            }

            check[index]=true;
        }

        for(int i=0;i<d.length;++i){
            System.out.print(d[i]+" ");
        }
    }
    
}
