import java.util.*;

class Employee {
    private String name;
    private int employeeId;
    private int leaveBalance;
    private ArrayList<String> leaveHistory;

    public Employee(String name, int employeeId, int leaveBalance) {
        this.name = name;
        this.employeeId = employeeId;
        this.leaveBalance = leaveBalance;
        this.leaveHistory = new ArrayList<>();
    }

    public void applyLeave(int days) throws Exception {
        if (days <= 0) {
            throw new Exception("Invalid number of leave days!");
        }

        if (days > leaveBalance) {
            throw new Exception("Insufficient leave balance!");
        }

        leaveBalance -= days;

        leaveHistory.add(
            "Leave Requested: " + days +
            " days - Status: Approved"
        );

        System.out.println("Leave applied successfully!");
    }

    public void displayLeaveBalance() {
        System.out.println("\nEmployee Name : " + name);
        System.out.println("Employee ID   : " + employeeId);
        System.out.println("Leave Balance : " + leaveBalance + " days");
    }

    public void displayLeaveHistory() {
        System.out.println("\nLeave History:");

        if (leaveHistory.isEmpty()) {
            System.out.println("No leave history available.");
        } else {
            for (String leave : leaveHistory) {
                System.out.println(leave);
            }
        }
    }
}

public class EmployeeLeaveManagementSystem {

   public static void main(String[] args) {

             Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            Employee employee = new Employee(name, id, 20);

            while (true) {

                System.out.println(
                    "\n===== Employee Leave Management System ====="
                );
                System.out.println("1. Apply Leave");
                System.out.println("2. Display Leave Balance");
                System.out.println("3. Display Leave History");
                System.out.println("4. Exit");

                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print(
                            "Enter number of leave days: "
                        );
                        int days = sc.nextInt();

                        try {
                            employee.applyLeave(days);
                        } catch (Exception e) {
                            System.out.println(
                                "Error: " + e.getMessage()
                            );
                        }
                        break;

                    case 2:
                        employee.displayLeaveBalance();
                        break;

                    case 3:
                        employee.displayLeaveHistory();
                        break;

                    case 4:
                        System.out.println("Thank you!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (InputMismatchException e) {
            System.out.println(
                "Error: Please enter valid input."
            );
        }
    }
