package graphs.directedgraphs.dfs;

import fundamentals.bagsqueuesandstacks.Queue;
import fundamentals.bagsqueuesandstacks.Stack;
import graphs.directedgraphs.Digraph;

import javax.naming.spi.DirObjectFactory;

public class DepthFirstOrder {
    private boolean[] marked;

    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph G) {
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        marked = new boolean[G.V()];

        for(int v = 0; v < G.V(); v++)
            if(!marked[v]) dfs(G, v);
    }

    private void dfs(Digraph G, int v) {
        pre.enqueue(v);

        marked[v] = true;
        for(int w: G.adj(v))
            if(!marked[w])
                dfs(G, w);

        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> preorder() {
        return pre;
    }

    public Iterable<Integer> postOrder() {
        return post;
    }

    public Iterable<Integer> reversePostOrder() {
        return reversePost;
    }
}
