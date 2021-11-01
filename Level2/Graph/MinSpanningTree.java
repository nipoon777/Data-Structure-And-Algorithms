import java.util.*;
import java.lang.*;

class Main
{
	public static class Edge{
		int src;
		int nbr;
		int wt;
		
		Edge(int src, int nbr, int wt ){
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn = new Scanner(System.in);
		int nvtcs = scn.nextInt();
		int nEdges = scn.nextInt();
		
		ArrayList<Edge> graph[] = new ArrayList[nvtcs + 1];
		
		for(int i = 1; i < graph.length ; i++  ){
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < nEdges ; i++ ){
			int src = scn.nextInt();
			int nbr = scn.nextInt();
			int wt = scn.nextInt();
			
			graph[src].add( new Edge(src, nbr, wt) );
			graph[nbr].add( new Edge(nbr, src, wt) );
		}
		
		System.out.println(getMinimumSpanningTree(graph, 1, new boolean[nvtcs + 1]));
	}
	
	public static class Pair implements Comparable<Pair> {
		int vtx;
		int wt;
		Pair(int vtx, int wt ){
			this.vtx = vtx;
			this.wt = wt;
		}
		
		public int compareTo(Pair o){
			return this.wt - o.wt;
		}
	}
	public static int getMinimumSpanningTree(ArrayList<Edge>[] graph, int vtx, boolean[] visited){
		PriorityQueue< Pair>  pq = new PriorityQueue<>();
		
		pq.add(new Pair(vtx,0));
		int totalWt = 0;
		while( pq.size() > 0 ) {
			Pair minWt = pq.remove();
			if( visited[minWt.vtx] == false ){
				visited[minWt.vtx] = true;
				totalWt += minWt.wt;
				for(Edge e : graph[minWt.vtx] ){
					if( visited[e.nbr]  == false ){
						pq.add( new Pair(e.nbr, e.wt) );
					}
				}
			}
		}
		
		
		return totalWt;
		
		
		
	}
}