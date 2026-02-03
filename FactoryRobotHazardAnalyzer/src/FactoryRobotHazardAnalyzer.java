import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Arm Precision (0.0 - 1.0): ");
        double armPrecision = sc.nextDouble();

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            System.out.println("Error: Arm precision must be between 0.0 and 1.0");
            return;
        }

        System.out.print("Enter Worker Density (1 - 20): ");
        int workerDensity = sc.nextInt();
        sc.nextLine(); // consume newline

        if (workerDensity < 1 || workerDensity > 20) {
            System.out.println("Error: Worker density must be between 1 and 20");
            return;
        }

        System.out.print("Enter Machinery State (Worn/Faulty/Critical): ");
        String machineryState = sc.nextLine();

        if (!machineryState.equals("Worn")
                && !machineryState.equals("Faulty")
                && !machineryState.equals("Critical")) {
            System.out.println("Error: Unsupported machinery state");
            return;
        }

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
