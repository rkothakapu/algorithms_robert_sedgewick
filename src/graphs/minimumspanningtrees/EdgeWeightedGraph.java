package graphs.minimumspanningtrees;

import fundamentals.bagsqueuesandstacks.Bag;

public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for(int v = 0; v < V; v++) {
            adj[0] = new Bag<Edge>();
        }
    }

    public int V() {
        return V;
    }

    public void addEdge(Edge edge) {
        int v =  edge.either(), w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        Bag<Edge> bag = new Bag<>();
        for(int v = 0; v < V; v++) {
            for(Edge e: adj[v])
                if(e.other(v) > v)
                    bag.add(e);
        }
        return bag;
    }
}
