
package com.graphalgo.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class DirectedGraphTest {

    private DirectedGraph<Vertex> graph;

    @Before
    public void init() {
        //link to picture: http://algs4.cs.princeton.edu/42digraph/images/dag.png
        graph = new DirectedGraph<Vertex>();
        for (int i = 0; i < 13; i++) {
            graph.addVertex(new Vertex());
        }
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(0, 6);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(5, 4);
        graph.addEdge(6, 4);
        graph.addEdge(6, 9);
        graph.addEdge(7, 6);
        graph.addEdge(8, 7);
        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);
    }

    @Test
    public void testDirectedGraph() {
        List<Edge> expectedPath = new LinkedList<Edge>() {
            {
                add(new Edge(0, 6));
                add(new Edge(6, 9));
                add(new Edge(9, 11));
                add(new Edge(11, 12));
            }
        };
        List<Edge> path = graph.getPath(0, 12);
        assertEquals(expectedPath, path);
    }

    @Test
    public void getNotExistedPath() {
        assertNull(graph.getPath(0, 7));
        assertNull(graph.getPath(0, 8));
        assertNull(graph.getPath(0, 3));
        assertNull(graph.getPath(12, 0));
    }

    @Test
    public void getSelfLoopPath() {
        assertNull(graph.getPath(0, 0));
        assertNull(graph.getPath(12, 12));
    }

}
