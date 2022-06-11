package com.yang.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author YangFeng
 * @create 2022-04-30 20:39
 */
public class Graph<T> {
    private List<T> vertices;  //顶点
    private int[][] edges;  //边
    private int num;  //顶点总数

    private boolean visited[]; //用于遍历

    private Queue<T> queue = new LinkedList<>();  //用于BFS  深度优先使用的栈（递归，不用声明）

    public Graph(int num){
        vertices = new ArrayList<>();
        this.num = num;
        edges = new int[num][num];
        visited = new boolean[num];
    }

    public void insertVertex(T vertex){
        vertices.add(vertex);
    }

    public void insertEdge(int vertex1, int vertex2, int weight){
        edges[vertex1][vertex2] = weight;
        edges[vertex2][vertex1] = weight;
    }

    public void showMatrix(){
        for (int i=0; i<num; i++){
            for(int j=0; j<num; j++){
                System.out.print(edges[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void dfs(int vertex){
        //先将visited数组恢复初始状态，再遍历
        for(int i=0; i<visited.length; i++){
            visited[i] = false;
        }

        //遍历
        dfsTraverse(vertex);
    }

    private void dfsTraverse(int vertex){
        //先将当前节点标记为已访问
        visited[vertex] = true;
        System.out.print(vertices.get(vertex).toString()+" ");

        //遍历其第一个相连接的节点
        int i=0;
        for(i=0; i<num; i++){
            if(edges[vertex][i]!=0 && !visited[i]){
                dfsTraverse(i);
            }
        }
        if(i==num){
            return;
        }
    }

    public void bfs(int vertex){
        //先将visited数组恢复初始状态，再遍历
        for(int i=0; i<visited.length; i++){
            visited[i] = false;
        }

        bfsTraverse(vertex);
    }

    private void bfsTraverse(int vertex){
        //先将当前节点标记为已访问
        visited[vertex] = true;

        //让第一个节点入队
        queue.add(vertices.get(vertex));
        while (!queue.isEmpty()){
            //出队
            int index = vertices.indexOf(queue.poll());
            System.out.print(vertices.get(index)+" ");
            //将与之相连的节点入队
            for(int i=0; i<num; i++){
                if(edges[index][i]!=0 && !visited[i]){
                    //标记为已访问
                    visited[i]=true;
                    //将该节点入队
                    queue.add(vertices.get(i));
                }
            }
        }
    }

}
