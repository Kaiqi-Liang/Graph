package graph;

public class Vertex<T> {

    private T data;

    public Vertex(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Vertex<?>)) return false;
        return ((Vertex<?>) obj).data.equals(data);
    }

}