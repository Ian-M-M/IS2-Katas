package kata3;

public class Kata3 {
    
    public static void main(String[] args) {
        Histogram<String> his = new Histogram<>();
        String [] dominios = {"@gmail.es","@outlook.es",
            "@alfonso.es","@hotmail.es","@yahoo.es"};
        for (String dominio : dominios) {
            his.increment(dominio);
        }
        for(int i = 0; i < 50; i++){
            his.increment(dominios[ (int)(Math.random()*5)]);
        }
        HistogramDisplay histo = new HistogramDisplay(his);
        histo.execute();
    }
    
}