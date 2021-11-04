import java.util.*;

public class Main{
    
    public static class Edge{
        int src;
        int nbr;
        int wt;
        
        public Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int nvtcs = scn.nextInt();
        
        ArrayList <Edge> []graph = new ArrayList[nvtcs];
        
        for(int i = 0 ; i < graph.length; i++ ){
            graph[i] = new ArrayList<>();
        }
        
        
        for(int vtx = 0 ; vtx < nvtcs ; vtx++ ){
            for(int nbr = 0 ; nbr < nvtcs ; nbr++ ){
                int wt = scn.nextInt();
                if( wt > 0 ){
                    graph[vtx].add( new Edge(vtx, nbr, wt));
                }
            }
        }
        
        System.out.println(findMinimumCost(graph, new boolean[nvtcs], 0));
        
    }
    public static class Pair implements Comparable<Pair>{
        int vtx;
        int wt;
        
        Pair(int vtx, int wt){
            this.vtx = vtx;
            this.wt = wt;
        }
        
        public int compareTo(Pair o){
            return this.wt - o.wt;
        }
    }
    
    public static int findMinimumCost(ArrayList<Edge>[] graph, boolean[] visited, int vtx){
        PriorityQueue <Pair> pq = new PriorityQueue<>();
        pq.add( new Pair(vtx, 0) );
        int totalCost = 0;
        while( pq.size() > 0 ) {
            Pair elem = pq.remove();
            
            if( visited[elem.vtx] == false ){
                visited[elem.vtx] = true;
                totalCost += elem.wt;
                for(Edge e : graph[elem.vtx] ){
                    if( visited[e.nbr] == false ){
                        
                        pq.add( new Pair(e.nbr, e.wt) );
                    }
                }
            }
        }
        return totalCost;
    }
}