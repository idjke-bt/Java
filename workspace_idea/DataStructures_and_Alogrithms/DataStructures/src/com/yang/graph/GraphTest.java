package com.yang.graph;

/**
 * @author YangFeng
 * @create 2022-04-30 20:56
 */
public class GraphTest {

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>(5);
        String[] vertices = new String[]{"a","b","c","d","e"};
        for(int i=0; i<vertices.length; i++){
            graph.insertVertex(vertices[i]);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(0,3,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,4,1);

        //graph.showMatrix();
        graph.dfs(1);
        System.out.println();
        graph.bfs(4);
    }
}
