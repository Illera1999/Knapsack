package knapsack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AlgorithmFunction {

    public static ValueTaken solve_tabulation(List<Objeto> items, int capacity) {
        ValueTaken res = new ValueTaken();

        //Creamos una tabla de las dimensiones de items +1 y capacity +1
        int[][] matriz = new int[items.size() + 1][capacity + 1];

        //Ponemos a cero las fila 0 y la columna 0 entera
        for (int j = 0; j <= capacity; j++) {
            matriz[0][j] = 0; //[y][x]
        }
        for (int i = 1; i <= items.size(); i++) {
            matriz[i][0] = 0;
        }

        //Empezamos con las operaciones del resto de la matriz
        for (int i = 1; i <= items.size(); i++) {
            for (int w = 0; w <= capacity; w++) {
                if (items.get(i - 1).getWeight() <= w) {
                    if (items.get(i - 1).getValue() + matriz[i - 1][w - items.get(i - 1).getWeight()] > matriz[i - 1][w]) {
                        matriz[i][w] = items.get(i - 1).getValue() + matriz[i - 1][w - items.get(i - 1).getWeight()];
                    } else {
                        matriz[i][w] = matriz[i - 1][w];
                    }
                } else {
                    matriz[i][w] = matriz[i - 1][w];
                }
            }
        }
        res.setValue(matriz[items.size()][capacity]);

        int[] takenres = new int[items.size()];
        int i = items.size();
        int k = capacity;
        while (i > 0 && k > 0) {
            if (matriz[i][k] != matriz[i - 1][k]) {
                takenres[i - 1] = 1;
                i--;
                k = k - items.get(i).getWeight();
            } else {
                takenres[i - 1] = 0;
                i--;
            }
        }
        res.setTaken(takenres);
        int suma = 0;
        for (int j = 0; j < takenres.length; j++) {
            if (takenres[j]==1){
                suma += items.get(j).getWeight();
            }
            
        }
        res.setWeightmax(suma);
        return res;
    }

    public static ValueTaken solve_memoization(List<Objeto> items, int capacity) {
        ValueTaken res = new ValueTaken();

        Map<String, Integer> mem = new HashMap<>();
        int value = memoization(items.size() - 1, capacity, items, mem);
        int[] taken = new int[items.size()];
        
        int n = items.size()-1;
        int wmax = capacity;
        while (n>0){
            String index = Integer.toString(n) + "-" + Integer.toString(wmax);
            String next_index = Integer.toString(n-1) + "-" + Integer.toString(wmax-items.get(n).getWeight());
            if (mem.containsKey(next_index)&& mem.get(index) == items.get(n).getValue()+ mem.get(next_index)){
                taken[n]=1;
                wmax -= items.get(n).getWeight();
            }else{
                taken[n]=0;
            }
            n--;
        }
        res.setTaken(taken);
        res.setValue(value);
        int suma = 0;
        for (int j = 0; j < taken.length; j++) {
            if (taken[j]==1){
                suma += items.get(j).getWeight();
            }
            
        }
        res.setWeightmax(suma);
        return res;
    }

    public static int memoization(int n, int wmax, List<Objeto> items, Map<String,Integer> mem) {
        if(n==-1){
            return 0;
        }
        String key = Integer.toString(n) + "-" + Integer.toString(wmax);
        if(!mem.containsKey(key)){
            if(items.get(n).getWeight()> wmax){
                mem.put(key, memoization(n-1,wmax,items,mem));
            }else{
                mem.put(key,Math.max(memoization(n-1,wmax,items,mem),items.get(n).getValue()+memoization(n-1,wmax-items.get(n).getWeight(),items,mem)));
            }
        }
        return mem.get(key);
    }
    
    public static ValueTaken solve_greedy(List<Objeto> items, int capacity){
        ValueTaken res = new ValueTaken();
        return res;
    }

}
