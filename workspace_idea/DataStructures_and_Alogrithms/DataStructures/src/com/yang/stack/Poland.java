package com.yang.stack;

/**
 * 实现逆波兰表达式
 *功能：
 *    输入后缀表达式，计算结果
 *
 * 注意事项：
 * 1)不同数字之间，数字和符号之间都用空格隔开
 * 2)表达式是一个字符串
 * 3)后缀表达式计算方法：
 *    从左向右读取表达式：
 *          遇到数字就压入栈中
 *          遇到运算符就将栈顶部的两个元素出栈，计算 后出栈 运算符 先出栈
 *              将结果压入栈中
 *
 * @author YangFeng
 * @create 2021-08-03 11:26
 */
public class Poland {

    private ArrayStack<Integer> stack;
    String str;

    public Poland(String s){
        str = s;
        stack = new ArrayStack<>(s.length());
        String [] arr = s.split("\\s+");  //根据空格将字符串分割
        for(int i=0; i<arr.length; i++){
            if(arr[i].charAt(0)-'0'<='9'-'0' && arr[i].charAt(0)-'0'>=0){//第一个位置是数字，说明是数字字符串
                stack.push(Integer.parseInt(arr[i]));
            }else{ //运算符
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(cal(num1, num2, arr[i]));
            }
        }
    }

    public int cal(int num1, int num2, String operator){ //计算
        //num2先入栈，说明num2在运算符的左侧
        return switch (operator) {
            case "+" -> num2 + num1;
            case "-" -> num2 - num1;
            case "*" -> num2 * num1;
            case "/" -> num2 / num1;
            default -> 0;
        };
    }

    public void answer(){
        System.out.println("逆序表达式\""+str+"\"的结果是："+stack.pop());
    }

}
