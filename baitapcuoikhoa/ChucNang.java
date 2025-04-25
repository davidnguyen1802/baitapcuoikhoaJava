import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

public class ChucNang {
    private static CongTy congTy;

    public static void displayMenu() {
        System.out.println("---------------------------------------------");
        System.out.println("***MENU***");
        System.out.println("1. Nhập Thông Tin Công Ty.");
        System.out.println("2. Phân Bổ Nhân Viên Vào Trưởng Phòng.");
        System.out.println("3. Thêm, Xóa Thông Tin Nhân Sự.");
        System.out.println("4. Xuất Thông Tin Toàn Bộ Nhân Viên Trong Công Ty.");
        System.out.println("5. Tính Và Xuất Tổng Lương Cho Toàn Bộ Công Ty.");
        System.out.println("6. Tìm Nhân Viên Thường Có Lương Cao Nhất.");
        System.out.println("7. Tìm Trưởng Phòng Có Số Lượng Nhân Viên Dưới Quyền Nhiều Nhất.");
        System.out.println("8. Sắp Xếp Nhân Viên Toàn Công Ty Theo Thứ Tự ABC.");
        System.out.println("9. Sắp Xếp Nhân Viên Toàn Công Ty Theo Thứ Tự Lương Giảm Dần.");
        System.out.println("10. Tìm Giám Đốc Có Số Lượng Cổ Phần Nhiều Nhất.");
        System.out.println("11. Tính Và Xuất Tổng Thu Nhập Của Từng Giám Đốc.");
        System.out.println("---------------------------------------------");
        System.out.println("Lựa chọn của bạn: " );
    }

    public static void initCompany() {
        congTy = new CongTy();
        congTy.nhapThongTinCongTy();
    }

    public static void inputStaff() {
        Scanner scanner = new Scanner (System.in);
        int choice;
        
        while (true) {
            System.out.println("Nhập Loại Nhân Viên Bạn Muốn Thêm Vào Công Ty.");
            System.out.println("1. Nhân Viên Thường.");
            System.out.println("2. Trưởng Phòng.");
            System.out.println("3. Giám Đốc.");
            System.out.print("Lựa chọn của bạn là: ");

            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                System.out.println("Không được để trống, vui lòng nhập lại.");
                continue;
            }

            try {
                choice = Integer.parseInt(line);

                if (choice < 1 || choice > 3) {
                    System.out.println("Xin Vui Lòng Nhập Lại.");
                    continue;
                }
                break;    
            } 
            catch (NumberFormatException e) {
                System.out.println("Xin Vui Lòng Nhập Lại.");
            }
        }

        int ID;
        while (true) { 
            System.out.print("Nhập ID: ");
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                System.out.println("Không được để trống, vui lòng nhập lại.");
                continue;
            }

            try {
                ID = Integer.parseInt(line);
                break;    
            } 
            catch (NumberFormatException e) {
                System.out.println("Xin Vui Lòng Nhập Lại ID.");
            }
        }

        String name;
        while (true) { 
            System.out.print("Nhập Tên: ");
            String line = scanner.nextLine().trim();
            
            if (line.isEmpty()) {
                System.out.println("Không được để trống, vui lòng nhập lại.");
                continue;
            }

            if (!line.matches("[\\p{L} ]+")) {
                System.out.println("Tên chỉ được chứa chữ cái và khoảng trắng.");
                continue;
            }

            name = line;
            break;
        }

        String phoneNumber;
        while (true) { 
            System.out.print("Nhập Số Điện Thoại: ");
            String line = scanner.nextLine().trim();
            
            if (line.isEmpty()) {
                System.out.println("Không được để trống, vui lòng nhập lại.");
                continue;
            }

            if (!line.matches("\\d{10}")) {
                System.out.println("Số điện thoại chỉ được chứa chữ số (0–9) và đúng 10 chữ số.");
                continue;
            }

            if (!line.startsWith("0")) {
                System.out.println("Số điện thoại phải bắt đầu từ số 0.");
                continue;
            }

            phoneNumber = line;
            break;
        }

        int workingDays;
        while (true) { 
            System.out.print("Nhập số ngày làm việc: ");
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                System.out.println("Không được để trống, vui lòng nhập lại.");
                continue;
            }

            try {
                workingDays = Integer.parseInt(line);
                if (workingDays > 31) {
                    System.out.print("Số ngày làm việc không được vượt quá 31 ngày. Vui lòng nhập lại.");
                    continue;
                }
                break;    
            } 
            catch (NumberFormatException e) {
                System.out.println("Xin Vui Lòng Nhập Lại Số Ngày Làm Việc.");
            }
        }
        
        switch (choice) {
            case 1 -> {
                NhanVien nhanVien = new NhanVien(ID, name, phoneNumber, workingDays);
                congTy.addStaff(nhanVien);
                break;
            }   
            case 2 -> {
                TruongPhong manager = new TruongPhong(ID, name, phoneNumber, workingDays);
                congTy.addStaff(manager);
            }
                
            case 3 -> {
                double shareholder;
                while (true) { 
                    System.out.print("Nhập tỷ lệ cổ phần trong công ty (0 - 100): ");
                    String line = scanner.nextLine().trim();
        
                    if (line.isEmpty()) {
                        System.out.println("Không được để trống, vui lòng nhập lại.");
                        continue;
                    }
        
                    try {
                        shareholder = Double.parseDouble(line);
                        if (shareholder < 0 || shareholder > 100) {
                            System.out.print("Tỉ lệ cổ phần phải là số thực trong khoảng 0 - 100. Vui Lòng Nhập Lại.");
                            continue;
                        }
                        break;    
                    } 
                    catch (NumberFormatException e) {
                        System.out.println("Xin Vui Lòng Nhập Lại Tỷ Lệ Cổ Phần.");
                    }
                }

                GiamDoc director = new GiamDoc(ID, name, phoneNumber, workingDays, shareholder);
                congTy.addStaff(director);

            }
        }

        
    }

    public static void assignEmployeeToManager() {
        Scanner scanner = new Scanner(System.in);
        NhanVien employee = null;
        TruongPhong manager = null;

        int employeeID;
        int managerID;
        while (true) { 
            System.out.print("Nhập ID nhân viên bạn muốn thêm vào trưởng phòng: ");
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                System.out.println("Không được để trống, vui lòng nhập lại.");
                continue;
            }

            try {
                employeeID = Integer.parseInt(line);   
            } 
            catch (NumberFormatException e) {
                System.out.println("Xin Vui Lòng Nhập Lại ID nhân viên thường.");
                continue;
            }

            for (NhanSu ns : congTy.getStaff()) {
                if (ns instanceof NhanVien && ns.getId() == employeeID) {
                    employee = (NhanVien) ns;
                    break;
                }
            }

            if (employee == null) {
                System.out.println("Không tìm thấy nhân viên thường với ID = " + employeeID + ". Vui lòng nhập lại.");
            } else {
                break;
            }
        }

        while (true) { 
            System.out.print("Nhập ID trưởng phòng mà bạn muốn thêm nhân viên thường vào: ");
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                System.out.println("Không được để trống, vui lòng nhập lại.");
                continue;
            }

            try {
                managerID = Integer.parseInt(line);  
            } 
            catch (NumberFormatException e) {
                System.out.println("Xin Vui Lòng Nhập Lại ID trưởng phòng.");
                continue;
            }

            for (NhanSu ns : congTy.getStaff()) {
                if (ns instanceof TruongPhong && ns.getId() == managerID) {
                    manager = (TruongPhong) ns;
                    break;
                }
            }

            if (manager == null) {
                System.out.println("Không tìm thấy trưởng phòng với ID = " + employeeID + ". Vui lòng nhập lại.");
            } else {
                break;
            }
        }

        manager.addEmployee(employee);
        System.out.println("Đã thêm nhân viên với ID: " + employee.getId() + " cho trưởng phòng với ID: " + manager.getId());

        
    }

    public static void printAllStaff() {
        System.out.println("--- DANH SÁCH NHÂN SỰ ---");
        for (NhanSu ns : congTy.getStaff()) {
            String line = String.format("%s || %s || %s || Lương: %.2f",
                                            ns.getId(), 
                                            ns.getName(), 
                                            ns.getClass().getSimpleName(), 
                                            ns.calculateMonthlySalary());
            System.out.println(line);
        }
    }

    public static void findHighestSalaryEmployee() {
        Optional<NhanVien> maxNV = congTy.getStaff().stream()
            .filter(ns -> ns instanceof NhanVien)
            .map(ns -> (NhanVien) ns)
            .max(Comparator.comparingDouble(NhanSu::calculateMonthlySalary));

        if (maxNV.isPresent()) {
            NhanVien nv = maxNV.get();
            System.out.println("Nhân viên thường có lương cao nhất: " 
                + nv.getName() + " (ID: " + nv.getId() + ") - Lương: " 
                + String.format("%.2f", nv.calculateMonthlySalary()));
        } else {
            System.out.println("Không có nhân viên thường nào trong công ty.");
        }
    }

    public static void findTotalSalary() {
        double total = congTy.totalSalary();
        System.out.println("Tổng lương của toàn bộ công ty: " + String.format("%,.2f", total));
    }

    public static void getNumberOfEmployeeWithManager() {
        Optional <TruongPhong> maxManager = congTy.getStaff().stream()
        .filter(ns -> ns instanceof TruongPhong)
        .map(ns -> (TruongPhong) ns)
        .max(Comparator.comparingInt(TruongPhong::getNumberOfEmployee));

        if (maxManager.isPresent()) {
            TruongPhong manager = maxManager.get();
            System.out.println("Trưởng phòng có nhiều nhân viên dưới quyền nhất: "
            + manager.getName() + " (ID: " + manager.getId() + ") - Số lượng: " + manager.getNumberOfEmployee());
        } else {
            System.out.println("Không có trưởng phòng nào trong công ty.");
        }
    }

    public static void sortStaffByName() {
        congTy.getStaff().sort(Comparator.comparing(NhanSu :: getName));
        System.out.println("--- DANH SÁCH NHÂN SỰ (Theo thứ tự ABC) ---");
        printAllStaff();
    }

    public static void sortStaffBySalary() {
        congTy.getStaff().sort(
            Comparator.comparingDouble(NhanSu::calculateMonthlySalary).reversed()
        );
        System.out.println("--- DANH SÁCH NHÂN SỰ (Lương giảm dần) ---");
        printAllStaff();
    }

    public static void findDirectorWithMostShare() {
        double profit = congTy.companyProfit();
        Optional<GiamDoc> maxGD = congTy.getStaff().stream()
            .filter(ns -> ns instanceof GiamDoc)
            .map(ns -> (GiamDoc) ns)
            .max(Comparator.comparingDouble(gd -> 
                gd.caculateTotalIncome(profit) - gd.calculateMonthlySalary()
            ));

        if (maxGD.isPresent()) {
            GiamDoc gd = maxGD.get();
            System.out.println("Giám đốc có cổ phần nhiều nhất: " 
                + gd.getName() + " (ID: " + gd.getId() + ")");
        } else {
            System.out.println("Không có giám đốc nào trong công ty.");
        }
    }

    public static void printDirectorIncome() {
        double profit = congTy.companyProfit();
        System.out.println("--- THU NHẬP GIÁM ĐỐC ---");
        for (NhanSu ns : congTy.getStaff()) {
            if (ns instanceof GiamDoc) {
                GiamDoc gd = (GiamDoc) ns;
                System.out.println(gd.getName() + " (ID: " + gd.getId() + ") - Thu nhập: " 
                    + String.format("%.2f", gd.caculateTotalIncome(profit)));
            }
        }
    }
}
