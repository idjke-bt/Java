package com.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class EightPuzzle {
    private static State start;
    private static State goal;
    private List<State> states = new ArrayList<>();
    private List<State> list = new ArrayList<>();
    private List<State> path = new ArrayList<>();
    private static int count=0;
    static {
        start = new State(new int[][]{{7,2,4},{5,0,6},{8,3,1}});
//        start = new State(new int[][]{{2,1,3},{0,8,4},{6,7,5}});

        goal = new State(new int[][]{{0,1,2},{3,4,5},{6,7,8}});
//        goal = new State(new int[][]{{2,1,3},{0,4,5},{6,7,8}});
        goal.setManhattan(0);

    }

    public EightPuzzle(){
        //初态初始化
        initStart();
        if(isSolvable()){
            aStar();
        }else {
            System.out.println("此问题无解");
        }
    }

    /**
     * 判断问题是否有解
     * @return
     */
    private boolean isSolvable(){
        int N = goal.getPuzzle().length;
        int[] startNum = new int[N * N];
        int[] endNum = new int[N * N];
        int cnt1=0, cnt2=0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(start.getPuzzle()[i][j]!=0){
                    startNum[cnt1++]=start.getPuzzle()[i][j];
                }
                if(goal.getPuzzle()[i][j]!=0){
                    endNum[cnt2++]=goal.getPuzzle()[i][j];
                }
            }
        }

        int st = 0;
        int et = 0;
        for (int i = N * N - 2; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (startNum[i] > startNum[j])
                    st++;
                if (endNum[i] > endNum[j])
                    et++;
            }
        }
        if (st % 2 == et % 2)
            return true;
        return false;

    }

    public void aStar(){
        State tempState;
        State s = null;
        while (!states.isEmpty()){
            //选出当前代价最小的状态，进行下一步
            Collections.sort(states);
            tempState = states.get(0);
            states.remove(0);
            //空格的移动有4种选择，将移动后的状态加入path列表
            //dir数组分别表示向上下左右移动
            int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
            for(int i=0; i<dir.length; i++){
                int xIndex = tempState.getXSpace()+dir[i][0];
                int yIndex = tempState.getYSpace()+dir[i][1];
                if(xIndex<=2&&xIndex>=0 && yIndex<=2&&yIndex>=0){//判断该移动是否可行
                    int[][] arr = tempState.clonePuzzle();
                    //移动：0和某位置元素互换
                    arr[tempState.getXSpace()][tempState.getYSpace()] = arr[xIndex][yIndex];
                    arr[xIndex][yIndex] = 0;
                    s = newState(arr, tempState);
                    if(s.getManhattan()==0){
                        states.removeAll(states);
                        break;
                    }else {
                        // 判断当前状态有没有出现过
                        boolean mark = false;
                        for(int j=0; j< list.size(); j++){
                            if(arrayEquals(list.get(j).getPuzzle(), arr)){//数组已存在
                                mark = true;
                                break;
                            }
                        }
                        if(!mark){
                            states.add(s);
                            list.add(s);
                        }
                    }
                }
            }
        }
        //将路径保存下来
        path.add(s);
        while (s.getParent()!=null){
            s = s.getParent();
            path.add(s);
            count++;
        }
    }

    private void initStart(){
        start.setParent(null);
        start.setDepth(0);
        start.setManhattan(manhattan_distance(start));
        start.setEvaluation(start.getManhattan()+start.getDepth());
        states.add(start);
        list.add(start);
    }

    private State newState(int[][] puzzle, State parent){
        State state = new State(puzzle);
        state.setParent(parent);
        state.setDepth(parent.getDepth()+1);
        state.setManhattan(manhattan_distance(state));
        state.setEvaluation(state.getManhattan()+state.getDepth());
        return state;
    }

    /**
     * 计算当前态state和终态goal的曼哈顿距离(不包括0)
     * @param state
     * @return
     */
    public int manhattan_distance(State state){
        Integer[] index1,index2;
        int diff, distance = 0;
        for(int i=0; i<State.getLen();i++){
            for(int j=0; j<State.getLen(); j++){
                if(state.getPuzzle()[i][j]==0){ //不统计空格的曼哈顿距离
                    continue;
                }
                diff=0;
                index1 = state.getMap().get(state.getPuzzle()[i][j]);
                index2 = goal.getMap().get(state.getPuzzle()[i][j]);

                for(int k=0;k<index1.length;k++){
                    diff += Math.abs(index1[k]-index2[k]);
                }
                distance += diff;
            }
        }
        return distance;
    }

    public static State getStart() {
        return start;
    }

    public static State getGoal() {
        return goal;
    }

    public List<State> getStates() {
        return states;
    }

    public void showPath(){
        System.out.println("最少步数为："+count);
        System.out.println("具体路径为：");
        System.out.println("=========初始状态：==========");
        path.get(path.size()-1).show();
        for(int i=2; i<= path.size(); i++){
            System.out.println("=========第"+(i-1)+"次移动：==========");
            path.get(path.size()-i).show();
        }
    }

    public boolean arrayEquals(int[][] array1,int[][] array2){

        if (array1==array2)
            return true;
        if (array1==null || array2==null)
            return false;

        if (array1.length != array2.length)
            return false;

        if (array1[0].length != array2[0].length)
            return false;

        for (int i = 0; i < array1.length; i++) {  //二维数组中的每个数组使用equals方法比较
            if (Arrays.equals(array1[i],array2[i])==false)
                return false;  //有一个为false，返回false
        }

        return true;
    }
}
