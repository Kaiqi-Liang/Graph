package graph;

public class Main {
    public static void main(String[] args) {
        Graph<Integer> graphInteger = new Graph<>();
        Vertex<Integer> v1 = new Vertex<Integer>(1);
        Vertex<Integer> v2 = new Vertex<Integer>(2);
        Vertex<Integer> v3 = new Vertex<Integer>(3);
        graphInteger.addVertex(v1);
        graphInteger.addVertex(v2);
        graphInteger.addVertex(v3);
        graphInteger.addEdge(v1, v2);
        graphInteger.addEdge(v1, v3);

        Graph<Integer> graphNumber = new Graph<>();
        Vertex<Integer> vertex1 = new Vertex<Integer>(1);
        Vertex<Integer> vertex2 = new Vertex<Integer>(2);
        Vertex<Integer> vertex3 = new Vertex<Integer>(3);
        graphNumber.addVertex(vertex1);
        graphNumber.addVertex(vertex2);
        graphNumber.addVertex(vertex3);
        graphNumber.addEdge(vertex1, vertex2);
        graphNumber.addEdge(vertex1, vertex3);

        Graph<String> graphString = new Graph<>();
        Vertex<String> u = new Vertex<String>("u");
        Vertex<String> v = new Vertex<String>("v");
        graphString.addVertex(u);
        graphString.addVertex(v);
        graphString.addEdge(u, v);

        assert !graphInteger.equals(graphString);
        assert graphInteger.equals(graphInteger);
        assert graphInteger.equals(graphNumber);

        Graph<Graph<Object>> emptyGraph = new Graph<>();
        Graph<Object> empty = new Graph<>();
        assert !empty.equals(graphInteger);
        assert !emptyGraph.equals(graphNumber);
        assert !graphString.equals(empty);
        assert empty.equals(emptyGraph);
    }
}