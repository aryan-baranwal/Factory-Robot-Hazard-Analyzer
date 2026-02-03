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

        double machineRiskFactor = 1.0;

        double hazardRisk =
                ((1.0 - armPrecision) * 15.0)
                        + (workerDensity * machineRiskFactor);

        System.out.println("\n--- HAZARD ANALYSIS REPORT ---");
        System.out.println("Arm Precision   : " + armPrecision);
        System.out.println("Worker Density  : " + workerDensity);
        System.out.println("Machinery State : " + machineryState);
        System.out.println("Hazard Risk     : " + hazardRisk);
    }
}
