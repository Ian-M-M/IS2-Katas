package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {
    
    public static List<String> read(String fileName){
        
        ArrayList<String> lista = new ArrayList<>();
        
        try {
            
            FileReader fichero = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fichero);
            String linea="";
            while((linea = br.readLine()) != null){
                
                if(linea.contains("@")){
                    lista.add(linea);
                }
            }
            
            br.close();
            
        } catch (Exception e) {
            System.out.println("No puedo abrir el fichero " + fileName);
        }
        
        return lista;
    }
    
}