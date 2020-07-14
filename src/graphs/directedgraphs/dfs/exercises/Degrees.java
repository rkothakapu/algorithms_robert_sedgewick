package graphs.directedgraphs.dfs.exercises;

import graphs.directedgraphs.Digraph;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Degrees {
    int[] indegree;
    int[] outdegree;
    List<Integer> sources;
    List<Integer> sinks;

    public Degrees(@NotNull Digraph G) {
        indegree = new int[G.V()];
        outdegree = new int[G.V()];

        for(int v = 0; v < G.V(); v++) {
            for(int w: G.adj(v)) {
                outdegree[v]++;
                indegree[w]++;
            }
        }

        sources = new ArrayList<>();
        sinks = new ArrayList<>();
        for(int v = 0; v < G.V(); v++) {
            if(indegree[v] == 0)
                sources.add(v);
            if(outdegree[v] == 0)
                sources.add(v);
        }
    }

    public int indegree(int v) {
        return indegree[v];
    }

    public int outdegree(int v) {
        return outdegree[v];
    }

    Iterable<Integer> sources() {
        return sources;
    }

    Iterable<Integer> sinks() {
        return sinks;
    }
    boolean isMap() {
        for(int v = 0; v < outdegree.length; v++) {
            if(outdegree[v] != 1) return false;
        }
        return true;
    }
}
