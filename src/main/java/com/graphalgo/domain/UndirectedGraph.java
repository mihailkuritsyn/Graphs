package com.graphalgo.domain;

/**
 * The {@code UndirectedGraph} class represents an undirected graph
 */
public class UndirectedGraph<T> extends AbstractGraph<T> {

    @Override
    public void addEdge(int from, int to) {
        validateVertex(from);
        validateVertex(to);
        edgesCount++;
        adjacentList.get(from).add(to);
        adjacentList.get(to).add(from);
    }

}