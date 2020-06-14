package graphs.undirectedgraphs.dfs;

import fundamentals.bagsqueuesandstacks.Stack;
import graphs.Graph;
import graphs.Paths;

public class DepthFirstPaths implements Paths {
    private boolean[] marked; // Has dfs() been called for this vertex
    private int[] edgeTo; // last vertex on known path to this vertex
    private final int s; // source

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G,s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for(int w: G.adj(v)) {
            if(!marked[w]) {
                edgeTo[w] = v;
                dfs(G,w);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v)) return null;

        Stack<Integer> path = new Stack<>();
        for(int x = v; x != s; x = edgeTo[v]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
