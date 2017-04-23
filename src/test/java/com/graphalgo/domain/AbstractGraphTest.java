
package com.graphalgo.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AbstractGraphTest {

    public static final int VERTEX_COUNT = 1000;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testSmokeGraphApi() {
        Graph<Vertex> graph = new DirectedGraph<Vertex>();
        for (int i = 0; i < VERTEX_COUNT; i++) {
            graph.addVertex(new Vertex());
        }
        for (int i = 1; i < VERTEX_COUNT; i++) {
            graph.addEdge(i - 1, i);
        }

        assertNotNull(graph.getVertex(VERTEX_COUNT - 1));
        assertNotNull(graph.getPath(0, VERTEX_COUNT - 1));
        assertNotNull(graph.getAdjacent(0));
        assertEquals(VERTEX_COUNT - 1, graph.getEdgesCount());
        assertEquals(VERTEX_COUNT, graph.getVertexCount());
    }

    @Test
    public void testGetNotExistedVertex() {
        Graph<Vertex> graph = new DirectedGraph<Vertex>();
        for (int i = 0; i < VERTEX_COUNT; i++) {
            graph.addVertex(new Vertex());
        }
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("vertex 1000 is not between 0 and 999");
        graph.getVertex(VERTEX_COUNT);
    }

    @Test
    public void testGetNotExistedAdj() {
        Graph<Vertex> graph = new DirectedGraph<Vertex>();
        for (int i = 0; i < VERTEX_COUNT; i++) {
            graph.addVertex(new Vertex());
        }
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("vertex 1000 is not between 0 and 999");
        graph.getAdjacent(VERTEX_COUNT);
    }

    @Test
    public void testGetNotExistedPath() {
        Graph<Vertex> graph = new DirectedGraph<Vertex>();
        for (int i = 0; i < VERTEX_COUNT; i++) {
            graph.addVertex(new Vertex());
        }
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("vertex -1 is not between 0 and 999");
        graph.getPath(-1, 0);
    }


}
