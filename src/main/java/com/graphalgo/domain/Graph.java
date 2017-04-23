package com.graphalgo.domain;

import java.util.List;
import java.util.Set;

public interface Graph<T> {

    /**
     * Adds the vertex to this graph.
     *
     * @param vertex user defined vertex object
     * @return assigned number of vertex in the graph
     */
    int addVertex(T vertex);

    /**
     * Returns the vertex of this graph.
     *
     * @param vertexNum the vertex number in the graph
     * @return vertex object
     * @throws IllegalArgumentException unless {@code 0 <= vertexNum < vertexCount}
     */
    T getVertex(int vertexNum);

    /**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    int getVertexCount();

    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    int getEdgesCount();

    /**
     * Returns the vertices adjacent to vertex {@code vertexNum}.
     *
     * @param vertexNum the vertex number in the graph
     * @return the vertices adjacent to vertex {@code vertexNum}, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= vertexNum < vertexCount}
     */
    Set<Integer> getAdjacent(int vertexNum);

    /**
     * Adds the edge to this graph.
     *
     * @param from one vertex in the edge
     * @param to   the other vertex in the edge
     * @throws IllegalArgumentException unless both {@code 0 <= from < vertexCount} and {@code 0 <= to < vertexCount}
     */
    void addEdge(int from, int to);

    /**
     * Returns a path consist of edges between the source vertex {@code startVertexNum} and vertex {@code targetVertexNum}, or
     * {@code null} if no such path.
     *
     * @param target the vertex
     * @return the sequence of edges on a path between the source vertex
     * {@code startVertexNum} and vertex {@code targetVertexNum}, as an Iterable
     * @throws IllegalArgumentException unless {@code 0 <= targetVertexNum < vertexCount}
     */
    List<Edge> getPath(int start, int target);
}
