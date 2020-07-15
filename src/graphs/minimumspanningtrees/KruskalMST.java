package graphs.minimumspanningtrees;

import fundamentals.union_find.UnionFindImpl;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalMST {
    LinkedList<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new LinkedList<>();
        Queue<Edge> pq = new PriorityQueue<>(Comparator.comparing(Edge::weight));
        for(Edge e: G.edges())
            pq.add(e);

        UnionFindImpl uf = new UnionFindImpl(G.V());

        while(!pq.isEmpty() || mst.size() < G.V() -1 ) {
            Edge e =pq.poll();
            int v = e.either(), w = e.other(v);
            if(uf.connected(v, w)) continue;
            uf.union(v, w);
            mst.add(e);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }
}
