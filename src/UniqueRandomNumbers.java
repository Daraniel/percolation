import java.util.ArrayList;
import java.util.Collections;

public class UniqueRandomNumbers {
    private ArrayList<int[]> list;
    private int counter;
    private int max;

    public  UniqueRandomNumbers(int MaxX, int MaxY) {
        max = MaxX * MaxY;
        counter = max;
        int[] a = new int[MaxX];
        int[] b = new int[MaxY];
        for (int i = 0; i < MaxX; i++){
            a[i]=i;
        }
        for (int i = 0; i < MaxY; i++){
            b[i]=i;
        }
        list = new ArrayList<>();
        for (int i : a)
            for (int j : b) list.add(new int[]{i, j});
        Collections.shuffle(list);
    }

    public int[] nextInt(){
        return list.get(--counter);
    }

    public void shuffle(){
        counter = max;
        Collections.shuffle(list);
    }
}