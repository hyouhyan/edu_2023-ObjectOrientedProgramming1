public class IntCollector {
    private int[] array;

    public IntCollector(){
        array = new int[0];
    }

    public IntCollector(int[] values){
        array = new int[values.length];
        for(int i = 0; i < values.length; i++){
            array[i] = values[i];
        }
    }

    public int[] getArray(){
        return array;
    }

    public void setArray(int[] values){
        array = new int[values.length];
        for(int i = 0; i < values.length; i++){
            array[i] = values[i];
        }
    }

    public void add(int value){
        int[] newArray = new int[array.length + 1];
        for(int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        newArray[array.length] = value;
        array = newArray;
    }

    public int countOf(int value){
        int count = 0;
        for(int i : array){
            if(i == value){
                count++;
            }
        }
        return count;
    }

    public int indexOf(int value){
        for(int i = 0; i < array.length; i++){
            if(array[i] == value){
                return i;
            }
        }
        return -1;
    }

    public void remove(int index){
        int[] newArray = new int[array.length - 1];

        if(index < array.length) for(int i = 0; i < array.length; i++){
            if(i < index) newArray[i] = array[i];
            if(i > index) newArray[i - 1] = array[i];
        }
        array = newArray;
    }

    public void print(){
        System.out.print("[");
        for(int i = 0; i < array.length; i++) {
            if(i == 0) System.out.print(array[i]);
            else System.out.print("," + array[i]);
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // int[] values = {1, 2, 3, 4};
        // IntCollector test = new IntCollector(values);
        // test.print();

        // test.remove(1);
        // test.print();

        // test.add(1);
        // test.print();

        // System.out.println(test.countOf(1));
        // System.out.println(test.indexOf(3));
        // System.out.println(test.indexOf(100));
    }
        
}
