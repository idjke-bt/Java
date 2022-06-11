package com.yang.recursion;

import org.junit.Test;

/**
 * @author YangFeng
 * @create 2021-08-05 16:02
 */
public class Demo {

    @Test
    public void mazeTest(){
        Maze maze = new Maze();
       maze.start(1,1);
       maze.showMap();
    }

    @Test
    public void queenTest(){
        EightQueens eq = new EightQueens(8);
        eq.sol();
    }
}
