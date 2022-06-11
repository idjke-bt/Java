package com.puzzle;

import java.util.HashMap;
import java.util.Map;

/**
 * 八数码的状态
 * 用一个3*3的数组描述八数码的当前状态
 * g(n):节点的深度depth
 *h(n):曼哈顿距离
 * f(n)=g(n)+h(n)
 */
public class State implements Comparable<State> {
    private static int len=3;//状态是一个len*len的矩阵
    private int[][] puzzle = new int[len][len]; //当前状态

    private int depth;  //g(n)
    private int manhattan;  //h(n)
    private int evaluation; //f(n)

    private State parent; //父节点
    private Map<Integer, Integer[]> map = new HashMap<>();//用于存储每个数字的index

    public int getXSpace() {
        return xSpace;
    }

    public int getYSpace() {
        return ySpace;
    }

    //空格的位置
    private int xSpace;
    private int ySpace;

    public State(int[][] puzzle){
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                this.puzzle[i][j] = puzzle[i][j];
                map.put(puzzle[i][j], new Integer[]{i,j});
            }
        }

        int[] pos = getSpacePos();
        xSpace=pos[0];
        ySpace=pos[1];
    }

    public static int getLen() {
        return len;
    }


    public int[][] getPuzzle() {
        return puzzle;
    }


    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getManhattan() {
        return manhattan;
    }

    public void setManhattan(int manhattan) {
        this.manhattan = manhattan;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public State getParent() {
        return parent;
    }

    public void setParent(State parent) {
        this.parent = parent;
    }

    public Map<Integer, Integer[]> getMap() {
        return map;
    }

    /**
     * 获取空格的位置
     * @return
     */
    private int[] getSpacePos(){
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(puzzle[i][j]==0){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public int[][] clonePuzzle(){
        int[][] arr = new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                arr[i][j] = puzzle[i][j];
            }
        }
        return arr;
    }



    @Override
    public int compareTo(State o) {
        return this.evaluation-o.evaluation;
    }

    public void show(){
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                System.out.print(puzzle[i][j]+" ");
            }
            System.out.println();
        }
    }
}
