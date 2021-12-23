public class Arrays {
    public static void main(String[] args) {

        // Java Lab – Arrays
        // Part 1
        // Given the following:
        int[] arr = { 10, 15, 7, 20, 11, 2 };

        int x = -1;
        int y = 100;
        int z = 3;

        // Show the values in x and y after executing each of the following:
        // 1. x = arr[3];
        // 2. x = 2 * arr[0];
        // 3. x = arr[1] + arr[2];
        // 4. x = arr[z] + z;
        // y = x + arr[5];
        // 5. x = arr[z] + 1;
        // y = arr[z+1];

        // System.out.println(x);

        // Given the following array:
        int[] a = new int[10];
        // Write a loop to do each of the following:

        // 6. Add 1 to every element of a.
         for (int i = 0; i < a.length; i++){
            a[i] = 1;
           //System.out.println("From i"+i);
            //System.out.println("From Array"+a[i]);
        }
        


        // 7. Count the number of negative numbers in a.
        a[5] = -11;
        
        for (int i = 0; i < a.length; i++){
            //if(a[i] < 0){


            //System.out.println("Negative found at index "+i+", Value: "+a[i]);}
        }
    

        // 8. Create a new array b which is the same size as a, and copy all element
        // from a into b.
        int[] b = new int[a.length];

        for(int i = 0; i < a.length; i++){
            b[i] = a[i];
            //System.out.println(b[i]);
        }

        // 9. Print the elements of a in reverse order.
        for(int i = a.length; i > 0; i--){
            b[i] = a[i];
            //System.out.println(b[i]);
        }

        // 10. Count the number of elements in a that have values between 10 and 20
        // inclusive.
        a[0] = 10;
        for(int i = 0; i < a.length; i++){
            int counter = 0;

            if(a[i] > 9 && a[i] < 21){
                counter++;
            }
            System.out.println("Result: "+counter);
        }

        // Part 2

        // 1. Declare one-dimensional arrays according to the following descriptions.

        // a. A 24-element float array
         float[] balance = new float[24];
    

        // b. A 500-element int array
        // c. A 50-element double array
        // d. A 10-element char array

        // 2. Write a code fragment to do the following tasks:
        // a. Declare a constant named CLASS_SIZE representing the number of students in
        // a class.
        // b. Declare an array QuizAvg of size CLASS_SIZE whose components will contain
        // quiz
        // score averages (double).

        // 3. What is the output of the following program? The data for the program is
        // given below.

        // import java.util.Scanner;
        // public class Array {
        // public static void main(String [] args) {
        // int [] a,b;
        // int j, m, suma = 0, sumb = 0, sumdiff = 0;
        // Scanner keyboard = new Scanner(System.in);
        // a=new int[100];
        // b=new int[100];

        // m = keyboard.nextInt();
        // for (j = 0 ; j < m ; j++) {
        // a[j]=keyboard.nextInt();
        // b[j]=keyboard.nextInt();
        // suma = suma + a[j];
        // sumb += b[j];
        // sumdiff = sumdiff + (a[j] - b[j]);
        // }
        // for (j = m - 1; j >= 0; j--)
        // System.out.println(a[j] + " " + b[j] + " " + (a[j]-b[j]));
        // System.out.println(suma + " " + sumb + " " + sumdiff);
        // }
        // }

        // DATA:
        // 5
        // 11 15
        // 19 14
        // 4 2
        // 17 6
        // 1 3

        // 4. Given the declarations
        int[] sample = new int[8];

        // Show the contents of the array sample after the following code segment is
        // executed.

        for (int k = 0; k < 8; k++) {
            sample[k] = 10 - k;
        }
    } // End Main
} // End Class