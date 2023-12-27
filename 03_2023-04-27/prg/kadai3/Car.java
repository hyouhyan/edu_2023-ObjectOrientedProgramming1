public class Car {
    static double fuelEfficiency;
    static double totalMileage = 0;
    static double expendedFuel = 0;

    static double run(double mileage){
        totalMileage += mileage;
        expendedFuel += mileage / fuelEfficiency;

        return mileage * fuelEfficiency;        
    }

    static void printInfo(){
        System.out.printf("走行距離:%.2fkm 消費燃料:%.2fL\n", totalMileage, expendedFuel);
    }
}
