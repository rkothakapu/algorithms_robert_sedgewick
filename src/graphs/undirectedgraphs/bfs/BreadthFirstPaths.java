package graphs.undirectedgraphs.bfs;

import fundamentals.bagsqueuesandstacks.Queue;
import fundamentals.bagsqueuesandstacks.Stack;
import graphs.Graph;
import graphs.Paths;

public class BreadthFirstPaths implements Paths {
    private boolean[] marked; // Is a shorted path to this vertex known?
    private int[] edgeTo; // Last vertex on the known path to this vertex
    private final int s; // source

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        queue.enqueue(s);
        while(!queue.isEmpty()) {
            int v = queue.dequeue();
            for(int w: G.adj(v))
                if(!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
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
