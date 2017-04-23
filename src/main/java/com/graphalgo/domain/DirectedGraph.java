package com.graphalgo.domain;

/**
 * The {@code DirectedGraph} class represents a directed graph
 */
public class DirectedGraph<T> extends AbstractGraph<T> {

    @Override
    public void addEdge(int from, int to) {
        validateVertex(from);
        validateVertex(to);
        edgesCount++;
        adjacentList.get(from).add(to);
    }

}
