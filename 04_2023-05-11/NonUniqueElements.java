public class NonUniqueElements {
    public IntCollector convert(IntCollector arr){
        for(int i : arr.getArray()){
            if(arr.countOf(i) == 1) arr.remove(arr.indexOf(i));
        }
        return arr;
    }

    public static void main(String[] args) {
        // int[] values = {10,9,10,10,9,8};
        // IntCollector test = new IntCollector(values);
        // test.print();

        // NonUniqueElements app = new NonUniqueElements();
        // app.convert(test);

        // test.print();

        // values = {5,5,5,5,5,5};
        // test.setArray(values);
        // test.print();

        // app.convert(test);

        // test.print();

        // values = {1,2,3,4,5};
        // test.setArray(values);
        // test.print();

        // app.convert(test);

        // test.print();
    }
}
