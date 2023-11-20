public class percolation {


    /**
     * calculates average percolation percent for rectangles
     * @param lengthX X size
     *@param lengthY Y size
     * @param runs test count
     * @return percolation percentage
     */

    public static double percolation(int lengthX, int lengthY, int runs){
        // defining the variables
        UF uf;
        UniqueRandomNumbers rnd = new UniqueRandomNumbers(lengthX, lengthY);
        int count;
        int[] a;
        int x;
        int y;
        boolean[] trigger;
        int average = 0;
        int lx;
        uf = new UF(lengthX*lengthY + 2);

        // loop to calculate percolation percent several times
        for (int i=0; i < runs; i++){
            // resetting the variables
            count = 0;
            trigger = new boolean[lengthX * lengthY];
            rnd.shuffle();
            uf.reset();

            // loop to calculate percolation percent for each run
            while(!uf.connected(lengthX * lengthY, lengthX * lengthY + 1)) {
                // getting next random number and open its square(trigger it)
                a = rnd.nextInt();
                x = a[0];
                y = a[1];
                trigger[x * lengthX + y] = true;
                lx = x * lengthX;

                // checking if new square is in the top line
                if (x == 0) {
                    uf.union(x * lengthX + y, lengthX * lengthY);
                    if (trigger[(x + 1) * lengthX + y]) uf.union(lx + y, lx + lengthX + y);
                    if (y != lengthY - 1) {
                        if (trigger[lx + y + 1]) uf.union(lx + y, lx + y + 1);
                    }
                    if (y != 0) {
                        if (trigger[lx + y - 1]) uf.union(lx + y, lx+ y - 1);
                    }
                    count++;
                }
                // checking if new square is in the bottom line
                else if (x == lengthX - 1) {
                    uf.union(lx + y, lengthX * lengthY + 1);
                    if (y != lengthY - 1) {
                        if (trigger[lx + y + 1]) uf.union(lx + y, lx + y + 1);
                    }
                    if (y != 0) {
                        if (trigger[lx + y - 1]) uf.union(lx + y, lx + y - 1);
                    }
                    if (trigger[lx - lengthX + y]) uf.union(lx + y, lx - lengthX + y);
                    count++;
                }
                // new square is in middle
                else {
                    if (trigger[lx + lengthX + y]) uf.union(lx + y, lx + lengthX + y);
                    if (y != lengthY - 1) {
                        if (trigger[lx + y + 1]) uf.union(lx + y, lx + y + 1);
                    }
                    if (y != 0) {
                        if (trigger[lx + y - 1]) uf.union(lx + y, lx + y - 1);
                    }
                    if (trigger[lx - lengthX + y]) uf.union(lx + y, lx - lengthX + y);
                    count++;
                }
            }
            average += count;
        }
        return 1.0*average/runs/lengthX/lengthY;
    }


}
