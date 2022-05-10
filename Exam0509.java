class GraphMatrix{
    boolean directed; //방향 그래프 여부
    int size; //정점의 개수
    int[][] edges; // new int [size][size];
    boolean[] visited;
    GraphMatrix(int size, boolean directed){
        this.size = size;
        this.directed = directed;
        this.edges = new int[size][size];
        this.visited = new boolean[this.size];
    }
    // 구현: 간선 추가
    void add(int v1, int v2){
        this.edges[v1][v2] = 1;
        if(!this.directed){//무방향 그래프이면
            this.edges[v2][v1] = 1;
        }
    }
    void dfs(int v){
        // 탐색 시작 전에 생성자 등에서 visited는 0으로 초기화
        // this.visited = new int[this.size];
        this.visited[v] = true;
        System.out.print(v + " -> ");
        for(int i=0; i < this.size; i++){
            if(this.edges[v][i] == 1 && this.visited[i] == false){
                dfs(i);
            }
        }
    }
    void clear(int v){
        this.visited[v] = false;
        for(int i=0; i < this.size; i++){
            if(this.edges[v][i] == 1 && this.visited[i] == true){
                clear(i);
            }
        }
    }
}

public class Exam0509 {
    public static void main(String[] args){
        GraphMatrix t = new GraphMatrix(8, false);

        t.add(0, 1);
        t.add(1, 0);
        t.add(0, 2);
        t.add(2, 0);
        t.add(2,7);
        t.add(7,2);
        t.add(1, 3);
        t.add(3, 1);
        t.add(3, 4);
        t.add(4, 3);
        t.add(3,7);
        t.add(7,3);
        t.add(4,5);
        t.add(5,4);
        t.add(5,6);
        t.add(6,5);
        t.add(7,6);
        t.add(6,7);
        t.dfs(0);
        System.out.println();
        t.clear(7);
        System.out.println();
        t.dfs(7);
    }
}
