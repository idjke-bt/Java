import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<Log> list = new ArrayList<>();
        for(int i=0; i<logs.length; i++){
            list.add(new Log(logs[i], i));
        }

        Comparator<Log> comparator = new Comparator<Log>() {
            @Override
            public int compare(Log o1, Log o2) {
                if(o1.type != o2.type){ //不同类型，字母log>数字log
                    return o1.type-o2.type;
                }else if(o1.type==1){ //都是数字log
                    return o1.index - o2.index; //保留原有的顺序
                }else {//都是字母log，先根据内容字符串比较排序
                    int order = o1.content.compareTo(o2.content);
                    if(order!=0){
                        return order;
                    }else {
                        return o1.identifier.compareTo(o2.identifier);
                    }
                }
            }
        };

        Collections.sort(list, comparator);

        String[] ans = new String[logs.length];
        for(int i=0; i<logs.length; i++){
            ans[i] = list.get(i).original;
        }
        return ans;
    }
}

class Log {
    public int index;  //该log在数组中的位置
    public int type;  //该log的类型 0--->letter log; 1--->digit log
    public String original; //log本身=identifier+content
    public String identifier;  //标识符
    public String content;

    public Log(String log, int index){
        original = log;
        this.index = index;
        int j=0;
        while (j<log.length() && log.charAt(j)!=' '){
            j++;
        }
        identifier = log.substring(0,j);
        content = log.substring(j+1);

        if(Character.isDigit(log.charAt(j+1))){//是数字字符
            type=1;
        }else {
            type=0;
        }
    }
}