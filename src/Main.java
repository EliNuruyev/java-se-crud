import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        check();
    }
    public static  void check (){
        System.out.println("1: create car, 2: update car, 3: delete car, 4: show all car, 5: find car by parametrs, 6 or invalid input: Exit the system");
        switch(input.next()){
            case "1":
                Operation.createCar();
                check();
                break;
            case "2":
                Operation.updateCar();
                check();
                break;
            case "3":
                Operation.removeCar();
                check();
                break;
            case "4":
                Operation.showAllCars();
                check();
                break;
            case "5":
                Operation.findCarByParametrs();
                check();
                break;
            default:
                System.out.println("Exited from system");
        }
    }
}

