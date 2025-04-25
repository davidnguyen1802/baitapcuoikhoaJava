import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Khởi tạo công ty và nhập thông tin

        int choice = 0;
        do {
            ChucNang.displayMenu();
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Vui lòng nhập lựa chọn.");
                continue;
            }
            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập số.");
                continue;
            }

            switch (choice) {
                case 1 -> ChucNang.initCompany();
                case 2 -> ChucNang.assignEmployeeToManager();
                case 3 -> ChucNang.inputStaff();
                case 4 -> ChucNang.printAllStaff();
                case 5 -> ChucNang.findTotalSalary();
                case 6 -> ChucNang.findHighestSalaryEmployee();
                case 7 -> ChucNang.getNumberOfEmployeeWithManager();
                case 8 -> ChucNang.sortStaffByName();
                case 9 -> ChucNang.sortStaffBySalary();
                case 10 -> ChucNang.findDirectorWithMostShare();
                case 11 -> ChucNang.printDirectorIncome();
                case 0 -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
            }

        } while (choice != 0);

        sc.close();
    }
}
