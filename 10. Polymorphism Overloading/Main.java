class Main {
  public static void main(String[] args){

    Calculator calc1 = new Calculator();
    System.out.println(calc1.add(5, 10));
    System.out.println(calc1.add(5, 10, 15));

    System.out.println(calc1.substract(5, 10));
    System.out.println(calc1.substract(5.9, 10.5));
    
  }
}