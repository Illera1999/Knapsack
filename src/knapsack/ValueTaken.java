package knapsack;

public class ValueTaken {

    
    private int value;
    private int [] taken;
    private int weightmax;
    
    public ValueTaken(){
        value = 0;
        taken = new int [0];
        weightmax = 0;
    }

    public void setWeightmax(int weightmax) {
        this.weightmax = weightmax;
    }

    public int getWeightmax() {
        return weightmax;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setTaken(int[] taken) {
        this.taken = taken;
    }

    public int getValue() {
        return value;
    }

    public int[] getTaken() {
        return taken;
    }
    
}
