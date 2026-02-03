import java.util.Scanner;

/**
 * Factory Robot Hazard Analyzer
 *
 * UC6: Introduces custom exception for safety validation.
 */
public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Arm Precision (0.0 - 1.0): ");
            double armPrecision = sc.nextDouble();

            System.out.print("Enter Worker Density (1 - 20): ");
            int workerDensity = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Machinery State (Worn/Faulty/Critical): ");
            String machineryState = sc.nextLine();

            validateInputs(armPrecision, workerDensity, machineryState);

            double machineRiskFactor = 1.0;

            double hazardRisk =
                    ((1.0 - armPrecision) * 15.0)
                            + (workerDensity * machineRiskFactor);

            System.out.println("\n--- HAZARD ANALYSIS REPORT ---");
            System.out.println("Arm Precision   : " + armPrecision);
            System.out.println("Worker Density  : " + workerDensity);
            System.out.println("Machinery State : " + machineryState);
            System.out.println("Hazard Risk     : " + hazardRisk);

        } catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Validates robot hazard inputs.
     */
    private static void validateInputs(double armPrecision,
                                       int workerDensity,
                                       String machineryState)
            throws RobotSafetyException {

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException(
                    "Error: Arm precision must be between 0.0 and 1.0");
        }

        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException(
                    "Error: Worker density must be between 1 and 20");
        }

        if (!machineryState.equals("Worn")
                && !machineryState.equals("Faulty")
                && !machineryState.equals("Critical")) {
            throw new RobotSafetyException(
                    "Error: Unsupported machinery state");
        }
    }
}

/**
 * Custom exception for robot safety validation.
 */
class RobotSafetyException extends Exception {

    public RobotSafetyException(String message) {
        super(message);
    }
}
