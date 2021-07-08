import java.util.Scanner;

public class LeapYear {

    public static void main(String agrs[]){
        Scanner input = new Scanner(System.in);
        System.out.print("Year: ");
        int year = input.nextInt();
        String yesorno = calculator(year);
        System.out.println(yesorno);



    }

    public static String calculator(int inputyear){
        String output;
        if((inputyear % 4 == 0)  && !(inputyear % 100 == 0 ) || (inputyear % 400 == 0)){
            output = "This year is a leap year!";
        }
        else{
            output = "This year is not a leap year!";
        }
        return output;
    }
}
