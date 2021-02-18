package knapsack;

import java.util.ArrayList;
import java.util.List;


public class ListCapacity {

    
    private List<Objeto> lista;
    private int capacity;
    public ListCapacity(){
        this.lista=new ArrayList<>();
        this.capacity=0;
    }

    public void setLista(List<Objeto> lista) {
        this.lista = lista;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Objeto> getLista() {
        return lista;
    }

    public int getCapacity() {
        return capacity;
    }

}
