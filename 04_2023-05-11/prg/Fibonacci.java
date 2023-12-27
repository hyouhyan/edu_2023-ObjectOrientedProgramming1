public class Fibonacci {
    public IntCollector get(int n){
        IntCollector fibo = new IntCollector();
        fibo.add(0);
        fibo.add(1);

        int candidate = 0;

        for(int i = 0; true; i++){
            candidate = fibo.getArray()[i] + fibo.getArray()[i + 1];
            if(candidate <= n) fibo.add(candidate);
            else break;
        }

        return fibo;
    }

    public static void main(String[] args) {
        // Fibonacci app = new Fibonacci();

        // IntCollector test = app.get(10000);
        // test.print();

        // test = app.get(0);
        // test.print();
    }
}
