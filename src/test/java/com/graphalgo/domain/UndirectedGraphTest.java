
package com.graphalgo.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class UndirectedGraphTest {

    private UndirectedGraph<Vertex> graph;

    @Before
    public void init() {
        //link to picture: http://algs4.cs.princeton.edu/41graph/images/graph.png
        graph = new UndirectedGraph<Vertex>();
        for (int i = 0; i < 13; i++) {
            graph.addVertex(new Vertex());
        }
        graph.addEdge(0, 5);
        graph.addEdge(4, 3);
        graph.addEdge(0, 1);
        graph.addEdge(9, 12);
        graph.addEdge(6, 4);
        graph.addEdge(5, 4);
        graph.addEdge(0, 2);
        graph.addEdge(11, 12);
        graph.addEdge(9, 10);
        graph.addEdge(0, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 11);
        graph.addEdge(5, 3);
    }

    @Test
    public void testDirectedGraph() {
        List<Edge> expectedPath = new LinkedList<Edge>() {
            {
                add(new Edge(0, 5));
                add(new Edge(5, 3));
            }
        };
        List<Edge> path = graph.getPath(0, 3);
        assertEquals(expectedPath, path);
    }

    @Test
    public void testGetNotExistedPath() {
        assertNull(graph.getPath(0, 10));
        assertNull(graph.getPath(0, 7));
        assertNull(graph.getPath(9, 8));
    }

    @Test
    public void testGetSelfLoopPath() {
        assertNull(graph.getPath(0, 0));
        assertNull(graph.getPath(12, 12));
    }

}
