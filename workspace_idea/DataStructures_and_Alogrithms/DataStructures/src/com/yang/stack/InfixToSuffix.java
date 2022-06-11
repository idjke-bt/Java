package com.yang.stack;

/**
 * 功能：将中缀(infix)表达式转换成后缀(suffix)表达式
 * 注意事项：
 * 1）中缀表达式含有括号
 * @author YangFeng
 * @create 2021-08-04 12:23
 */
public class InfixToSuffix {

    private ArrayStack<Character> operatorStack; //符号栈
    private String infix; //中缀表达式
    private StringBuffer suffix = new StringBuffer(); //后缀表达式

    

    public InfixToSuffix(String infix){
        operatorStack = new ArrayStack<>(infix.length());
        this.infix = infix;
        parse();
    }

    private void parse(){
        char ch;
        for(int i=0; i<infix.length(); i++){ //遍历字符串
            ch = infix.charAt(i);
            if(isNum(ch)){ //是数字
               i = dealNum(i);

            }else{ //碰到运算符
                dealOperator(ch);
            }
        }
        //遍历结束后，将栈中所有元素弹出
        while (!operatorStack.isEmpty()){
            suffix.append(operatorStack.pop()).append(" ");
        }

    }

    private boolean isNum(char c){
        return c-'0'<='9'-'0' && c-'0'>=0;
    }

    private int priority(char c) {
        //-1:数字  0:+-   1:*/  2:(  -1:)
        return switch (c) {
            case '+', '-' -> 0;
            case '*', '/' -> 1;
            case '(' -> 2;
            default -> -1;
        };
    }

    private int dealNum(int i){
        //处理多位数
        int j = i + 1;
        for (; j < infix.length(); j++) {
            if (!isNum(infix.charAt(j))) {//不是数字字符
                break;
            }
        }
        //数字放到输出中
        suffix.append(infix, i, j).append(" ");
        return j-1;
    }

    private void dealOperator(char ch) {
        if(operatorStack.isEmpty()){//运算符栈为空，直接压入栈中
            operatorStack.push(ch);
        }else { //运算符栈不为空
            int prior = priority(ch);
            switch (prior) {//左括号
                case 2 -> operatorStack.push(ch);

                case -1 -> {//右括号：将左右括号中的所有运算符弹出
                    while (operatorStack.topOfStack() != '(') {
                        suffix.append(operatorStack.pop()).append(" ");
                    }
                    operatorStack.pop();
                }

                default -> {//四则运算符
                    while ('(' != operatorStack.topOfStack() && priority(operatorStack.topOfStack()) >= prior) {
                        suffix.append(operatorStack.pop()).append(" ");
                        if(operatorStack.isEmpty())
                            break;
                    }
                    operatorStack.push(ch);
                }
            }
        }
    }

    public void answer(){
        System.out.println(infix+"的后缀表达式为："+suffix);
    }

    public StringBuffer getSuffix(){
        return suffix;
    }



}
