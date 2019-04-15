package kata2;

import java.util.Map;
import java.util.TreeMap;

public class Histogram <T>{
    
    T [] data;
    Map <T,Integer> map;
    
    public Histogram(T [] array){
        data = array.clone();
        
    }
    
    public void histogram(){
        
        map = new TreeMap<>();
        
        for (int i = 0; i < data.length; i++) {
           int value = map.containsKey(data[i]) ? map.get(data[i])+1 : 1;
           map.put(data[i], value);
        }
        showContents();
        
    }
    
    public void showContents (){
        System.out.println("K --> Freq");
        for (Map.Entry<T, Integer> entry : map.entrySet()) {
            T key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("" + key + " --> " + value);
            
        }
    }
    
}
