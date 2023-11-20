public class timer {
    private double start_time;
    public timer(){
        start_time = System.nanoTime();
    }
    public double time(){
        return (System.nanoTime() - start_time)/1000000000.0;
    }
}
