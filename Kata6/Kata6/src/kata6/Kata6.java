package kata6;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Kata6 {

    public static void main(String[] args) {
        File root = new File("D:\\Anima\\Excel");
        File [] files = root.listFiles();
        
        ArrayList<File> a_files = new ArrayList<>();
        
        a_files.addAll(Arrays.asList(files));
        
        Iterator<File> iter = iteratorOf(a_files);
        
        while(iter.hasNext()){
            File f = iter.next();
            System.out.println(f.toString());
        }
        
        System.out.println("--------------------------------------------");
        
        Histogram<Integer> histogram = new Histogram<> (megabytes(lengths(iteratorOf(a_files))));
        
        System.out.println(histogram.toString());
        
    }

    private static <T> Iterator<T> iteratorOf(ArrayList<File> items) {
        return new Iterator<T>(){
            
            int index = 0;
            @Override
            public boolean hasNext() {                
                return index < items.size();
            }

            @Override
            public T next() {
                return (T) items.get(index++);
            }
        };
    }

    private static Iterator<Long> lengths(Iterator<File> iterator) {
        return new Iterator<Long>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Long next() {
                return iterator.next().length();
            }
        };
    }

    private static Iterator<Integer> megabytes(Iterator<Long> iterator) {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return (int) (iterator.next() / (1024*1024));
            }
        };
    }
}