package com.graphalgo.domain;

import java.util.*;

/**
 * This implementation uses an adjacency-lists representation.
 */
public abstract class AbstractGraph<T> implements Graph<T> {

    protected int edgesCount;
    protected List<Set<Integer>> adjacentList = new ArrayList<Set<Integer>>();

    private static final String NEWLINE = System.getProperty("line.separator");
    private int vertexCount;
    private Map<Integer, T> vertices = new HashMap<Integer, T>();

    /**
     * Initializes an empty graph with 0 vertices and 0 edges.
     *
     * @throws IllegalArgumentException if {@code vertexCount < 0}
     */
    public AbstractGraph() {
        if (vertexCount < 0) {
            throw new IllegalArgumentException("Number of vertices must be non negative");
        }
        this.vertexCount = 0;
        this.edgesCount = 0;
    }

    @Override
    public int addVertex(T vertex) {
        adjacentList.add(new HashSet<Integer>());
        vertices.put(vertexCount++, vertex);
        return vertexCount;
    }

    @Override
    public T getVertex(int vertexNum) {
        validateVertex(vertexNum);
        return vertices.get(vertexNum);
    }

    @Override
    public int getVertexCount() {
        return vertexCount;
    }

    @Override
    public int getEdgesCount() {
        return edgesCount;
    }

    @Override
    public Set<Integer> getAdjacent(int vertexNum) {
        validateVertex(vertexNum);
        return adjacentList.get(vertexNum);
    }

    @Override
    public List<Edge> getPath(int start, int target) {
        validateVertex(start);
        validateVertex(target);

        List<Edge> path = null;
        boolean[] marked = new boolean[vertexCount];
        int[] parentList = new int[vertexCount];
        if (dfsSearch(start, target, marked, parentList)) {
            path = buildPath(start, target, parentList);
        }
        return path;
    }

    private boolean dfsSearch(int start, int target, boolean[] marked, int[] parentVertex) {
        if (start == target) {
            return true;
        }
        marked[start] = true;
        for (Integer adjacentVertex : adjacentList.get(start)) {
            if (!marked[adjacentVertex]) {
                parentVertex[adjacentVertex] = start;
                if (dfsSearch(adjacentVertex, target, marked, parentVertex)) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<Edge> buildPath(int start, int target, int[] parentVertex) {
        LinkedList<Edge> path = null;
        if (start != target) {
            path = new LinkedList<Edge>();
            int current = target;
            while (current != start) {
                path.addFirst(new Edge(parentVertex[current], current));
                current = parentVertex[current];
            }
        }
        return path;
    }

    protected void validateVertex(int vertexNum) {
        if (vertexNum < 0 || vertexNum >= vertexCount) {
            throw new IllegalArgumentException("vertex " + vertexNum + " is not between 0 and " + (vertexCount - 1));
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertexCount).append(" vertices, ").append(edgesCount).append(" edges ").append(NEWLINE);
        for (int vertexNum = 0; vertexNum < vertexCount; vertexNum++) {
            s.append(vertexNum).append(": ");
            for (int w : adjacentList.get(vertexNum)) {
                s.append(w).append(" ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

}