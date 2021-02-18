package knapsack;

/**
 *
 * @author josei
 */
public class Knapsack {

    public static void main(String[] args) {
        ListCapacity start = new ListCapacity();
        ValueTaken res = new ValueTaken();
        for(int i = 0; i<args.length;i++){
           if (args[i].equals("-h")||args[i].equals("--help")){
                System.out.println("usage: ks.py [-h] [[-d] [DIRECTORY]] [[-f] [FILE]] [-b] [-r] [-t] [-dt] [-sg] [-sm] [-st]\n" +
                        "optional arguments:\n"+
                        "   -h, --help              show this help message and exit.\n"+
                        "   -d [DIRECTORY], --directory[DIRECTORY].\n"+
                        "   -f [FILE], -- file[FILE].\n"+
                        "   -b, --benefit           Display benefit.\n"+
                        "   -r, --room              Display room (unused knapsack weigth).\n"+
                        "   -t, --time              Display time.\n"+
                        "   -dt, --display_taken    Display identifier of taken items.\n"+
                        "   -sg, --greedy           Solve it with Greedy.\n"+
                        "   -sm, --memoization      Solve it with Memoization.\n"+
                        "   -st, --tabulation       Solve it with Tabulation.\n");
                System.exit(0);
                        
            }
        }
        for(int i = 0; i<args.length;i++){
            if (args[i].equals("-f")||args[i].equals("--file")){
                start = ObjetoReader.read(args[i+1]);
            }
        }
        long startTime = System.currentTimeMillis();
        for(int i = 0; i<args.length;i++){
            switch(args[i]){
                case "-sm" -> res = AlgorithmFunction.solve_memoization(start.getLista(),start.getCapacity());
                case "-st" -> res = AlgorithmFunction.solve_tabulation(start.getLista(),start.getCapacity());
                case "-sg" -> res = AlgorithmFunction.solve_greedy(start.getLista(),start.getCapacity());
            }
        }
        long endTime = System.currentTimeMillis()- startTime;
        
        for(int i = 0; i<args.length;i++){  
            if(args[i].equals("-d")||args[i].equals("--directory")){
                //Nu se lo que hay que poner xD
            }
            
            if(args[i].equals("-b")||args[i].equals("--benefit")){
                System.out.println("Beneficio -> " + res.getValue());
            }
            
            if(args[i].equals("-r")||args[i].equals("--room")){
                int hueco = start.getCapacity() - res.getWeightmax();
                System.out.println("Hueco restante -> " + hueco);
            }
            
            if(args[i].equals("-t")||args[i].equals("--time")){
                //Nu se lo que hay que poner xD
                System.out.println("Tiempo de ejecucion -> " + (double)(endTime/1000));
            }    
            
            if(args[i].equals("-dt")||args[i].equals("--display_taken")){
                //Nu se lo que hay que poner xD
                String auxtakenvalor = "[";
                for (int k = 0; k < res.getTaken().length;k++){
                    int [] aux  = res.getTaken();
                    
                    if(aux[k]==1){
                        auxtakenvalor += k+1 + ",";
                    }

                }
                String takenvalor = auxtakenvalor.substring(0, auxtakenvalor.length()-1);
                System.out.println("Items elegidos -> " + takenvalor + "]");
            }

        }
    
    }

}
