package graphs.undirectedgraphs.dfs;

import graphs.Graph;
import org.jetbrains.annotations.NotNull;

public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(@NotNull Graph G) {
        marked = new boolean[G.V()];
        for( int s = 0; s < G.V(); s++) {
            if(!marked[s])
                dfs(G, -1, s);
        }
    }

    private void dfs(@NotNull Graph G, int u, int v) {
        marked[v] = true;
        for(int w: G.adj(v))
            if(!marked[w])
                dfs(G, v, w);
            else if (w != u) hasCycle = true;
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
