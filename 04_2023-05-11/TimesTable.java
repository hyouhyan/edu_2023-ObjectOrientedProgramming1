public class TimesTable {
    private int width;
    private int height;
    private int[][] array;

    private TimesTable(){}

    public TimesTable(int width, int height){
        this.height = height;
        this.width = width;

        array = new int[height][width];

        for(int h = 0; h < height; h++){
            for(int w = 0; w < width; w++){
                array[h][w] = (h + 1)*(w + 1);
            }
        }
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public int[][] getArray(){
        return array;
    }

    public void print(){
        for(int h = 0; h < height; h++){
            System.out.print("|");
            for(int w = 0; w < width; w++){
                System.out.print(array[h][w] + "|");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // TimesTable table = new TimesTable(9, 9);
        // TimesTable table = new TimesTable(1, 1);
        // TimesTable table = new TimesTable();
        // table.print();
    }
}
