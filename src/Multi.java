public class Multi implements Runnable {

    private int x;
    private int y;
    private int runs;
    private double value;

    public Multi(int x, int y, int runs){
        this.x = x;
        this.y = y;
        this.runs = runs;
    }

    @Override
    public void run()
    {
        value = percolation.percolation(this.x, this.y, this.runs);
    }
    
    public double getValue(){
        return value;
    }

}
