import java.util.ArrayList;
import java.util.Scanner;

public class Operation {
    public static Scanner inp = new Scanner(System.in);

    public static void createCar() {
        System.out.println("Enter serial number: ");
        String serialNumber = inp.next();
        System.out.println("Enter brand: ");
        String brand = inp.next();
        System.out.println("Enter model: ");
        String model = inp.next();
        System.out.println("Enter color: ");
        String color = inp.next();
        Car.carList.add(new Car(serialNumber, brand, model, color));
        System.out.println("Created: " + Car.carList.getLast());

    }

    public static int returnedIndex() {
        String no = inp.next();
        for (int i = 0; i < Car.carList.size(); i++) {
            if (no.equals(Car.carList.get(i).serialNumber)) {
                return i;
            }
        }
        return -1;
    }

    public static void updateCar() {
        System.out.println("Enter serial number of car which you want to change");
        int index = returnedIndex();
        if (index == -1) {
            System.out.println("Car not found. Update operation canceled.");
            return;
        }

        System.out.println("Enter parameters by using ',' to separate ");
        inp.nextLine();

        String[] deyer = inp.nextLine().split(",");


        for (int i = 0; i < deyer.length; i++) {
            String parameter = deyer[i].trim();
            if (parameter.equals("serialNumber")) {
                System.out.println("Update serial number: ");
                Car.carList.get(index).serialNumber = inp.next();
            } else if (parameter.equals("brand")) {
                System.out.println("Update brand: ");
                Car.carList.get(index).brand = inp.next();
            } else if (parameter.equals("model")) {
                System.out.println("Update model: ");
                Car.carList.get(index).model = inp.next();
            } else if (parameter.equals("color")) {
                System.out.println("Update color: ");
                Car.carList.get(index).color = inp.next();
            } else {
                System.out.println("Invalid parameter: " + parameter);
                return;
            }
        }
        System.out.println("Updated: " + Car.carList.get(index));

    }

    public static void removeCar() {
        if (!Car.carList.isEmpty()) {
            System.out.println("Enter serial number to remove a car from list of car");
            int index = returnedIndex();
            if (index == -1) {
                System.out.println("Car not found. Delete operation canceled.");
                return;
            }
            Car.carList.remove(index);
            System.out.println("last verion of car list: " + Car.carList);

        } else {
            System.out.println("Car list is empty");
        }
    }

    public static void findCarByParametrs() {

        System.out.println("Enter parametrs for searching ");
        inp.nextLine();
        String terminal = inp.nextLine();
//        terminal = terminal.replace(" ","");
        String[] arr = terminal.contains(",") ? terminal.split(",") : new String[]{terminal};
        ArrayList<String[]> arr2 = new ArrayList<>();
        ArrayList<Car> foundCars = new ArrayList<>();


        for (int i = 0; i < arr.length; i++) {
            arr2.add(arr[i].split("="));
        }
        for (int i = 0; i < arr2.size(); i++) {
            for (int j = 0; j < arr2.get(i).length; j++) {
                arr2.get(i)[j] = arr2.get(i)[j].trim();
            }
        }
        for (int i = 0; i < Car.carList.size(); i++) {
            boolean isTrue = true;
            for (String[] param : arr2) {
                if(param[0].equals("serialNumber") && !Car.carList.get(i).serialNumber.equals(param[1])){
                    isTrue = false;
                    break;
                } else if (param[0].equals("brand") && !Car.carList.get(i).brand.equals(param[1])) {
                    isTrue = false;
                    break;
                }else if (param[0].equals("model") && !Car.carList.get(i).model.equals(param[1])) {
                    isTrue = false;
                    break;
                }
                else if (param[0].equals("color") && !Car.carList.get(i).color.equals(param[1])) {
                    isTrue = false;
                    break;
                }

            }
            if(isTrue){
                foundCars.add(Car.carList.get(i));
                System.out.println(Car.carList.get(i));
            }

        }

    }

    public static void showAllCars() {
        System.out.println(Car.carList);
    }

}
