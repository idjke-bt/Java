package com.yang.recursion;

/**
 * 迷宫问题
 *地图是一个二维数组：
 *      1表示墙壁（不能走）
 *      2表示具体路径
 *      0表示可以走的位置
 * @author YangFeng
 * @create 2021-08-05 12:18
 */
public class Maze {

    int[][] map = new int[6][7]; //地图

    public Maze(){
        //将地图初始化
        getMap();
    }

    private void getMap(){//将地图初始化
        //外面一圈都是不能走的(i=0;i=6;j=0;j=5)
        for(int j=0; j<map[0].length; j++){
            map[0][j] = 1;
            map[map.length-1][j] = 1;
        }
        for(int i=0; i<map.length; i++){
            map[i][0] = 1;
            map[i][map[0].length-1] = 1;
        }

        map[1][2] = 1;
        map[2][2] = 1;
        map[3][1] = 1;
    }

    public void start(int i, int j){//开始坐标
        //将地图初始化
        getMap();
        if(isStart(i,j)){
            System.out.println("地图为：");
            showMap();
            System.out.println("起点是: ("+i+","+j+")"+"终点是: ("+4+","+5+")");
            if(getWay(i,j)){
                showMap();
            }else{
                System.out.println("不存在该路线");
            }
        }else{
            System.out.println("该位置不能作为起点");
        }
    }



    /**
     * 功能：getWay():从坐标(i,j)出发是否能够到达终点
     *
     * 等价的问题：从坐标(i,j)出发是否能够到达终点取决于（下，右，上，左）
     *          从(i,j+1) (i+1,j) (i,j-1) (i-1,j)四个点出发是否能到达终点
     *
     * 终止条件：终点坐标(4,5)被标记为2
     *
     * 注意；
     *      0表示还没有走过的点
     *      1表示墙
     *      2表示从该点出发可以到达终点
     *      3表示从该点出发不可以到达终点
     * **/
    private boolean getWay(int i, int j){
      if(map[4][5]==2) //递归的终止条件
          return true;
      if(map[i][j]==0){//还没有走过的点
          map[i][j] = 2; //假定该店可以到达终点，用其相邻的四个方向验证
          boolean flag = getWay(i,j+1)||getWay(i+1,j)||getWay(i,j-1)||getWay(i-1,j);
          if(!flag){ //(i,j)的四个方向都走不通
              map[i][j] = 3;
          }
          return flag;
      }else{//map[i][j]!=0: (i,j)已经走过了
          return false;
      }





    }

    //判断(i,j)是否能作为起点
    public boolean isStart(int i, int j){
        return map[i][j]==0;
    }

    //输出地图
    public void showMap(){
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

}
