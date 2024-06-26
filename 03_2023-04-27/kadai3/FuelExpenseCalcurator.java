import java.util.Scanner;

public class FuelExpenseCalcurator {
    public static void main(String[] args) {
        Car car = new Car();

        Scanner in = new Scanner(System.in);
        String inputLine;

        car.fuelEfficiency = 18;

        int num;
        while(true){
            System.out.print("走行距離を入力してください ");
            inputLine = in.nextLine();
            if(inputLine.equals("end")) break;

            num = Integer.parseInt(inputLine);

            car.run(num);

            // car.printInfo();
        }

        car.printInfo();

        return;
    }
}
