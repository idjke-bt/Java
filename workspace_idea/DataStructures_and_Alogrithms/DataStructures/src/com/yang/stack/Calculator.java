package com.yang.stack;

/**
 * 实现简单的计算器功能
 * 1)均为非负整数
 * 2)无括号 无空格
 * 3)输入为一个字符串
 * 4)只考虑表达式合法的情况
 *
 * @author YangFeng
 * @create 2021-08-02 11:22
 */
public class Calculator {

    ArrayStack<Integer> numsStack;  //数栈  存数
    ArrayStack<Character> operatorStack;  //运算符栈  存运算符

    public Calculator(String s){//s为输入的表达式  只考虑表达式合法的情况
        numsStack = new ArrayStack<>(s.length());
        operatorStack = new ArrayStack<>(s.length());
        calculate(s);
    }

    public void calculate(String s){
        //1.遍历字符串
        char ch;  //接收字符
        int priority; //表示接收的运算符的优先级 -1:数字， 0:+-  1:*/
        for(int i=0; i<s.length(); i++){
            ch = s.charAt(i);
            priority = priority(ch);

            if (priority == -1) { //数字入栈  注意处理多位数
                int j = i + 1;
                for (; j < s.length(); j++) {
                    if (s.charAt(j) - '0' > '9' - '0' || s.charAt(j) - '0' < 0) {//不是数字字符
                        break;
                    }
                }
                numsStack.push(Integer.parseInt(s.substring(i, j))); //数字入栈
                i = j-1;
            } else {//运算符入栈
                pushOperator(ch, priority);
            }
        }
        //遍历结束 将运算符栈中的元素弹出，进行计算
        while (!operatorStack.isEmpty()){
            popOperator();
        }
    }

    public int priority(char c){
        //-1:数字  0:+-   1:*/
       return switch (c) {
            case '+', '-' -> 0;
            case '*', '/' -> 1;
            default -> -1;
        };

    }


    public void pushOperator(char ch, int priority){

        if (!operatorStack.isEmpty() && priority <= priority(operatorStack.topOfStack())) { //当前元素优先级<=栈顶部元素
            //栈顶部元素出栈
            popOperator();

            //(4)判断运算符ch是否可以入栈了
            pushOperator(ch,priority);
        } else {
            //栈为空 or 当前元素优先级>栈顶部元素 直接入栈
            operatorStack.push(ch);
        }
    }

    public void popOperator(){
        //(1) 顶部元素出栈
        char topChar = operatorStack.pop();

        //(2) N栈中两个数字出栈
        int num1 = numsStack.pop();
        int num2 = numsStack.pop(); //num2先入栈，说明num2在运算符的左侧

        //(3)计算，并将计算结果入数栈
        numsStack.push(cal(num1,num2,topChar));
    }

    public int cal(int num1, int num2, char operator){ //计算
        //num2先入栈，说明num2在运算符的左侧
        return switch (operator) {
            case '+' -> num2 + num1;
            case '-' -> num2 - num1;
            case '*' -> num2 * num1;
            case '/' -> num2 / num1;
            default -> 0;
        };
    }

    public void answer(){
        System.out.println(numsStack.topOfStack());
    }
}
