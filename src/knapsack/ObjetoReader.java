package knapsack;


import knapsack.Objeto;
import knapsack.ListCapacity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ObjetoReader {
    public static ListCapacity read (String fileName){
        List<Objeto> auxList = new ArrayList<>();
        ListCapacity res = new ListCapacity();

        
        try {
            //Leemos el archivo.
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
            //Bucle infinito
            int aux = 0;
            while(true){
                String line = reader.readLine();
                //Si llegamos al final que salga del bucle
                if (line==null)break;
                if(aux==1){
                    String [] auxline = line.split(" ");
                    auxList.add(new Objeto(Integer.parseInt(auxline[0]),Integer.parseInt(auxline[1])));
                }
                if (aux == 0){
                    aux = 1;
                    String [] auxline = line.split(" ");
                    res.setCapacity(Integer.parseInt(auxline[1]));
                }

            }
            res.setLista(auxList);
        } catch (FileNotFoundException exception) {
            System.out.println("ERROR ObjetoListReader: :read (File not found)" + exception.getMessage());
        } catch (IOException exception) {
            System.out.println("ERROR ObjetoListReader: :read (IO)" + exception.getMessage());
        }
        
        return res;
    }
}
