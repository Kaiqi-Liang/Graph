package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * An implementation of an undirected Graph that uses an adjacency list representation.
 * The adjacency list is stored as a Set which is stored as the Value in a Map where the Key is the vertex
 * 
 * @invariant for all edge u-v in the graph, hasEdge(u, v) iff hasEdge(v, u)
 *
 * @author Kaiqi Liang
 * 
 * @param <E> The type of elements contained within this graph
 */
public class Graph<E> {

    /**
     * Key of the Map contains all the vertices
     * Value of each pair is the vertices that are adjacent to the vertex corresponding to the key
     */
    private Map<Vertex<E>, Set<Vertex<E>>> adjLists = new HashMap<>();

    public Set<Vertex<E>> getKeys() {
        return adjLists.keySet();
    }

    public Set<Vertex<E>> getValue(Vertex<?> vertex) {
        return adjLists.get(vertex);
    }

    public boolean hasVertex(Vertex<E> vertex) {
        return adjLists.containsKey(vertex);
    }

    public void addVertex(Vertex<E> vertex) {
        if (!hasVertex(vertex)) {
            adjLists.put(vertex, new HashSet<Vertex<E>>());
        }
    }

    public void addEdge(Vertex<E> u, Vertex<E> v) {
        if (adjLists.containsKey(u) && adjLists.containsKey(v)) {
            adjLists.get(u).add(v);
            adjLists.get(v).add(u);
        }
    }

    public void removeEdge(Vertex<E> u, Vertex<E> v) {
        if (hasVertex(u) && hasVertex(v)) {
            adjLists.get(u).remove(v);
            adjLists.get(v).remove(u);
        }
    }

    public boolean hasEdge(Vertex<E> u, Vertex<E> v) {
        return hasVertex(u) && hasVertex(v) ? adjLists.get(u).contains(v) && adjLists.get(v).contains(u) : false;
    }

    @Override
    public String toString() {
        return adjLists.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (!(other instanceof Graph<?>)) return false;
        Graph<?> graph = (Graph<?>) other;
        return subgraphOf(graph) && graph.subgraphOf(this);
    }

    /**
     * Determine if this graph is a subgraph of another graph
     * @param graph
     * @return whether or not both vertices and edges of this graph is in the other graph and
     * for any edge e in this graph, if e is incident on vertex v in the this graph,
     * then e is incident on v in the other graph
     */
    private boolean subgraphOf(Graph<?> graph) {
        for (Vertex<E> vertex: getKeys()) {// Check if all the vertices in this graph is in the other graph
            Vertex<?> v = graph.getVertex(vertex);
            if (v == null) return false;

            // For each vertex in the graph check if all the adjacent vertices are in the other graph
            Set<?> vertices1 = getValue(vertex);
            Set<?> vertices2 = graph.getValue(v);
            // Check if 2 adjacency lists are equal
            if (!(subsetOf(vertices1, vertices2) && subsetOf(vertices2, vertices1))) return false;
        }
        return true;
    }

    /**
     * Determine if one set is a subset of another
     * @param set1
     * @param set2
     * @return whether or not the subset relation holds
     */
    private boolean subsetOf(Set<?> set1, Set<?> set2) {
        return set1.stream().filter(vertex -> hasElement(set2, vertex)).count() == set1.size();
    }

    /**
     * Determine if an element is in a set
     * @param set
     * @param element
     * @return whether or not set contains element
     */
    private boolean hasElement(Set<?> set, Object element) {
        return set.stream().filter(e -> e.equals(element)).findFirst().isPresent();
    }

    /**
     * Determine if a vertex is in this graph
     * @param vertex
     * @return whether or not this graph contains vertex
     */
    private Vertex<E> getVertex(Vertex<?> vertex) {
        return getKeys().stream().filter(v -> v.equals(vertex)).findFirst().orElse(null);
    }

}
