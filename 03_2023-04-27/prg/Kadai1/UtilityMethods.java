public class UtilityMethods {
    public static void main(String[] args) {
        UtilityMethods app = new UtilityMethods();
        
        app.printCurrency(12);
        System.out.println(app.add(1, 2));
        System.out.println(app.division(1, 2));
        System.out.println(app.getTheAnswerToTheUltimateQuestionOfLife_TheUniverse_And_Everything());
    }
    void printCurrency(double num) {
        System.out.printf("%.2f\n", num);
    }
    int add(int num1, int num2){
        return num1 + num2;
    }
    double division(int num1, int num2){
        return (double) num1 / num2;
    }
    String getTheAnswerToTheUltimateQuestionOfLife_TheUniverse_And_Everything(){
        try{
            Thread.sleep(750);
        }catch(InterruptedException e){}
        return "42";
    }
}
