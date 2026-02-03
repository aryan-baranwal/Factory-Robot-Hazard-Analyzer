import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Arm Precision (0.0 - 1.0): ");
        double armPrecision = sc.nextDouble();

        System.out.print("Enter Worker Density (1 - 20): ");
        int workerDensity = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Machinery State (Worn/Faulty/Critical): ");
        String machineryState = sc.nextLine();

        System.out.println("\n--- INPUT SUMMARY ---");
        System.out.println("Arm Precision   : " + armPrecision);
        System.out.println("Worker Density  : " + workerDensity);
        System.out.println("Machinery State : " + machineryState);
    }
}
