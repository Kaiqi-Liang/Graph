package graph;

/**
 * A testing program to demonstrate the generic graph system.
 */
public class GraphTest {
    public static void main(String[] args) {
        Graph<String> stringGraph = new Graph<String>();
        Vertex<String> u1 = new Vertex<String>("A");
        Vertex<String> u2 = new Vertex<String>("B");
        Vertex<String> v1 = new Vertex<String>("C");
        Vertex<String> v2 = new Vertex<String>("D");
        Vertex<String> w1 = new Vertex<String>("E");
        Vertex<String> w2 = new Vertex<String>("F");
        stringGraph.addVertex(u1);
        stringGraph.addVertex(u2);
        stringGraph.addVertex(v1);
        stringGraph.addVertex(v2);
        stringGraph.addVertex(w1);
        stringGraph.addVertex(w2);
        stringGraph.addEdge(u1, u2);
        stringGraph.addEdge(v1, v2);
        stringGraph.addEdge(w1, w2);
        stringGraph.addEdge(u1, v1);
        stringGraph.addEdge(u1, w1);
        stringGraph.addEdge(v1, w1);

        // Returns true, since a graph is equal to itself
        System.out.println(stringGraph.equals(stringGraph));

        Graph<String> otherStringGraph = new Graph<String>();
        Vertex<String> a1 = new Vertex<String>("A");
        Vertex<String> a2 = new Vertex<String>("B");
        Vertex<String> b1 = new Vertex<String>("C");
        Vertex<String> b2 = new Vertex<String>("D");
        Vertex<String> c1 = new Vertex<String>("E");
        Vertex<String> c2 = new Vertex<String>("F");
        otherStringGraph.addVertex(a1);
        otherStringGraph.addVertex(a2);
        otherStringGraph.addVertex(b1);
        otherStringGraph.addVertex(b2);
        otherStringGraph.addVertex(c1);
        otherStringGraph.addVertex(c2);
        otherStringGraph.addEdge(a1, a2);
        otherStringGraph.addEdge(b1, b2);
        otherStringGraph.addEdge(c1, c2);
        otherStringGraph.addEdge(a1, b1);
        otherStringGraph.addEdge(a1, c1);
        otherStringGraph.addEdge(b1, c1);

        // Should return true, as the graphs are the same
        System.out.println(stringGraph.equals(otherStringGraph));

        // Should now return false as we have removed an edge between A and B
        otherStringGraph.removeEdge(a1, a2);
        System.out.println(stringGraph.equals(otherStringGraph));

        Graph<Integer> intGraph = new Graph<Integer>();
        Vertex<Integer> x1 = new Vertex<Integer>(1);
        Vertex<Integer> x2 = new Vertex<Integer>(2);
        Vertex<Integer> y1 = new Vertex<Integer>(3);
        Vertex<Integer> y2 = new Vertex<Integer>(4);
        Vertex<Integer> z1 = new Vertex<Integer>(5);
        Vertex<Integer> z2 = new Vertex<Integer>(6);
        intGraph.addVertex(x1);
        intGraph.addVertex(x2);
        intGraph.addVertex(y1);
        intGraph.addVertex(y2);
        intGraph.addVertex(z1);
        intGraph.addVertex(z2);
        intGraph.addEdge(x1, x2);
        intGraph.addEdge(y1, y2);
        intGraph.addEdge(z1, z2);
        intGraph.addEdge(x1, y1);
        intGraph.addEdge(x1, z1);
        intGraph.addEdge(y1, z1);

        // Should return false, because the graphs aren't even the same type
        System.out.println(stringGraph.equals(intGraph));
    }
}