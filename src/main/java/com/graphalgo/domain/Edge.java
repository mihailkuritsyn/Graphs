package com.graphalgo.domain;

/**
 * The {@code Edge} class represents an edge.
 * Each edge consists of two integers (naming the two vertices).
 */
public class Edge {

    private final int from;
    private final int to;

    /**
     * Initializes an edge between vertices {@code from} and {@code to}
     *
     * @param from one vertex
     * @param to   the other vertex
     * @throws IllegalArgumentException if either {@code from} or {@code to} is a negative integer
     */
    public Edge(int from, int to) {
        if (from < 0) {
            throw new IllegalArgumentException("vertex index must be a non negative integer");
        }
        if (to < 0) {
            throw new IllegalArgumentException("vertex index must be a non negative integer");
        }
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (from != edge.from) return false;
        return to == edge.to;

    }

    @Override
    public int hashCode() {
        int result = from;
        result = 31 * result + to;
        return result;
    }
}