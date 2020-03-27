package myJmeter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class MakeStr {
    public static String makeSort(HashMap str){
        Set set=str.keySet();
        Object[] arr=set.toArray();
        Arrays.sort(arr);
        String result = "";
        for(Object key:arr){
            if(!str.get(key).equals("")){
                result +=key.toString()+str.get(key);
            }
        }
        System.out.println("排序结果:"+result);
        return result;
    }
}
