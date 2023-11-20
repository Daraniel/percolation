
import java.util.ArrayList;

public class test {
    public static void main(String[] args){

        int a = 10000000;
        int[] b = new int[a];
        ArrayList list = new ArrayList();
        for (int i = 0; i < a; i++){
            list.add(i);
        }





        timer ti3 = new timer();

        for (int i=0; i<a; i++) {
            list.set(a-1, 5);
        }

        // printing the time
        System.out.println("process duration:" + ti3.time());

        timer ti4 = new timer();
        for (int j=0; j<a; j++) {
            list.set(0, 5);

        }

        // printing the time
        System.out.println("process duration:" + ti4.time());

        System.out.println(ti3.time());





        timer ti = new timer();

        for (int i=0; i<a; i++) {
            b[a-1] = 5;
        }

        // printing the time
        System.out.println("process duration:" + ti.time());

        timer ti2 = new timer();
        for (int j=0; j<a; j++) {
            b[0] = 5;
        }

        // printing the time
        System.out.println("process duration:" + ti2.time());
        System.out.println(ti4.time());


    }
}
