import java.util.Scanner;

/**
 * Factory Robot Hazard Analyzer
 *
 * UC8: Final refactored OOPS-compliant design.
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

            double hazardRisk = analyzeHazard(
                    armPrecision,
                    workerDensity,
                    machineryState
            );

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
     * Performs full hazard analysis.
     */
    private static double analyzeHazard(double armPrecision,
                                        int workerDensity,
                                        String machineryState)
            throws RobotSafetyException {

        validateInputs(armPrecision, workerDensity, machineryState);

        double machineRiskFactor = getMachineRiskFactor(machineryState);

        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);
    }

    /**
     * Validates all inputs.
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

    /**
     * Maps machinery state to risk factor.
     */
    private static double getMachineRiskFactor(String machineryState) {

        switch (machineryState) {
            case "Worn":
                return 1.3;
            case "Faulty":
                return 2.0;
            default: // Critical
                return 3.0;
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
