import java.util.*;

class Car {
    private String type;
    private Map<String, Integer> servicePrices;

    public Car(String type) {
        this.type = type;
        this.servicePrices = new HashMap<>();
        this.servicePrices.put("BASIC_SERVICE", 2000);
        this.servicePrices.put("ENGINE_FIXING", 5000);
        this.servicePrices.put("CLUTCH_FIXING", 2000);
        this.servicePrices.put("BRAKE_FIXING", 1000);
        this.servicePrices.put("GEAR_FIXING", 3000);

    }

    public String getType() {
        return this.type;
    }

    public double getServicePrice(String serviceCode) {
        if (this.servicePrices.containsKey(serviceCode)) {
            return this.servicePrices.get(serviceCode);
        } else {
            return 0.0;
        }
    }
}

class BillGenerator {
    private Map<String, Car> cars;

    public BillGenerator() {
        this.cars = new HashMap<>();
        this.cars.put("Hatchback", new Car("Hatchback"));
        this.cars.put("SUV", new Car("SUV"));
        this.cars.put("Sedan", new Car("Sedan"));
    }

    public double calculateBill(String carType, List<String> serviceCodes) {
        double totalAmount = 0.0;
        Car car = this.cars.get(carType);
        if (car != null) {
            for (String serviceCode : serviceCodes) {
                totalAmount += car.getServicePrice(serviceCode);
            }
        }
        return totalAmount;
    }
}

public class QuestionTwo {
    public static void main(String[] args) {
        BillGenerator billGenerator = new BillGenerator();
        String carType = "SUV";
        List<String> serviceCodes = Arrays.asList("BASIC_SERVICE", "ENGINE_FIXING");
        double totalAmount = billGenerator.calculateBill(carType, serviceCodes);
        System.out.println("Total amount for " + carType + " with services " + serviceCodes + ": $" + totalAmount);
    }
}
