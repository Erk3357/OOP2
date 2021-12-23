public class Calculator {

    int add(int a, int b){
        int sum;
        sum = a+b;

        System.out.println("2 int method");
        return sum;
    }

    int add(int a, int b, int c){
        int sum;
        sum = a+b+c;

        System.out.println("3 int method");
        return sum;
    }

    int substract(int a, int b){
        int sub;
        sub = a-b;

        System.out.println("Int Sub");
        return sub;
    }

    double substract(double a, double b){
        double sub;
        sub = a-b;

        System.out.println("double Sub");
        return sub;
    }
}