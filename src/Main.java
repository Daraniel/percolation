public class Main {

    public static void main(String[] args) {

        // setting the timer
        timer time = new timer();
        System.out.println("program uses default value of 25 for square size and total test count of 100000 time \n" +
                "you can enter x or y size or runs count to change them \n" +
                "example: 'java percolation 5' or 'java percolation 5 5' or 'java percolation 5 5 100'\n" +
                "predicted duration for default values: less than 3 seconds");

        // setting default size of percolation square
        int lengthX = 25;
        int lengthY = 25;
        // setting default test runs count
        int runs = 100000;
        // checking whether user has provided value for length or runs
        if(args.length == 1){
            lengthX = Integer.parseInt(args[0]);
            lengthY = lengthX;
        } else if (args.length == 2){
            lengthX = Integer.parseInt(args[0]);
            lengthY = Integer.parseInt(args[1]);
        } else if(args.length == 3) {
            lengthX = Integer.parseInt(args[0]);
            lengthY = Integer.parseInt(args[1]);
            runs = Integer.parseInt(args[2]);
        }

        // initializing functions
        Multi m1 = new Multi(lengthX, lengthY, runs/4);
        Multi m2 = new Multi(lengthX, lengthY, runs/4);
        Multi m3 = new Multi(lengthX, lengthY, runs/4);
        Multi m4 = new Multi(lengthX, lengthY, runs/4);

        // initializing threads
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);
        Thread t3 = new Thread(m3);
        Thread t4 = new Thread(m4);

        // starting threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // waiting for threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            System.out.println((m1.getValue() + m2.getValue() + m3.getValue() + m4.getValue())/4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // printing the time
        System.out.println("process duration: " + time.time());
    }
}
