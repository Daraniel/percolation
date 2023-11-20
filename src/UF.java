public class UF{
    private int[] id;
    private int[] weight;

    // initializing
    public UF(int length){
        this.id = new int[length];
        this.weight = new int[length];
        for (int i = 0; i < length; i++) {
            this.id[i] = i;
            this.weight[i] = 0;
        }
    }

    public void reset(){
        for (int i = 0; i < id.length; i++) {
            this.id[i] = i;
            this.weight[i] = 0;
        }
    }

    // connecting different trees together
    public void union(int a, int b){
        int root_a = find(a);
        int root_b = find(b);
        // checking Whether nodes are connected to the same parent or not
        if(root_a == root_b){
            return;
        }
        // connecting smaller tree to bigger tree or if they are equal connects second tree to first one
        if (this.weight[root_a] > this.weight[root_b]){
            this.id[root_b] = root_a;
            return;
        }
        if (this.weight[root_a] < this.weight[root_b]){
            this.id[root_a] = root_b;
            return;
        }
        this.id[root_b] = root_a;
        this.weight[root_a]++;
    }

    // checking whether two nodes are connected to each other or no
    public boolean connected(int a, int b){
        return find(a) == find(b);
    }

    // finding a nodes grandparent
    private int find(int key){
        while (key != this.id[key]){
            this.id[key] = this.id[id[key]];
            key = id[key];
        }
        return key;
    }

    // counting total number of the trees
    public int count(){
        int j = 0;
        for (int i : this.id) {
            if(i == this.id[i]){
                j++;
            }
        }
    return j;
    }
    public static void main(String[] args){
        final long startTime = System.nanoTime();

        UF uf = new UF(25*25);

        for(int i = 0; i < 100000; i++){
            uf.reset();
        }

        // printing the time
        final long duration = System.nanoTime() - startTime;
        System.out.println("process duration: " + duration/1000000000.0);
    }
}