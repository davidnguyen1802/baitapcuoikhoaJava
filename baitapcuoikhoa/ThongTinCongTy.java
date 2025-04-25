
import java.util.Scanner;

public class ThongTinCongTy {
    private String name;
    private long taxCode;
    private double monthlyRevenue;

    public double getMonthlyRevenue() {
        return monthlyRevenue;
    }


    public void nhapThongTinCongTy() {
        Scanner sc = new Scanner (System.in);

        System.out.println("-- Nhập Thông Tin Công Ty --");
        while (true) { 
            System.out.print("Nhập Tên Công Ty: ");
            String name = sc.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Tên Công Ty Không Được Để Trống. Vui Lòng Nhập Lại.");
                sc.next();
            } else {
                this.name = name;
                break;
            }
        }

        
        // while (true) { 
        //     System.out.print("Nhap ma so thue cong ty (10 chu so): ");
            
        //     if (sc.hasNextLong()) {
        //         long taxCode = sc.nextLong();
        //         if (taxCode < 0) {
        //             System.out.println("Ma so thue khong la so am, vui long nhap lai.");
        //         } else {
        //             this.taxCode = taxCode;
        //             break;
        //         }
        //     }
        // }

        while (true) {
            System.out.print("Nhập mã số thuế công ty (10 chữ số): ");
            String input = sc.nextLine().trim();
        
            // Bỏ qua khi input rỗng
            if (input.isEmpty()) {
                System.out.println("Không được để trống, vui lòng nhập lại.");
                continue;
            }
        
            // Kiểm tra đúng 10 chữ số
            if (!input.matches("\\d{10}")) {
                System.out.println("Mã số thuế phải là đúng 10 chữ số.");
                continue;
            }
        
            // Chuyển sang long (đảm bảo không âm và giữ được leading zeros nếu cần hiển thị)
            try {
                long taxCode = Long.parseLong(input);
                this.taxCode = taxCode;
                break;
            } catch (NumberFormatException e) {
                // Trường hợp số quá lớn, rất ít khả năng với 10 chữ số nhưng vẫn an toàn
                System.out.println("Giá trị không hợp lệ, vui lòng nhập lại.");
            }
        }

        // while (true) {
        //     System.out.print("Nhập doanh thu (số, không âm, có thể có phần thập phân): ");
        //     String input = sc.nextLine().trim();

        //     // Bỏ qua khi input rỗng
        //     if (input.isEmpty()) {
        //         System.out.println("Không được để trống, vui lòng nhập lại.");
        //         continue;
        //     }

        //     // Regex: ít nhất 1 chữ số, có thể theo sau bằng . và nhiều chữ số
        //     if (!input.matches("\\d+(\\.\\d+)?")) {
        //         System.out.println("Doanh thu phải là số hợp lệ (ví dụ 1000000 hoặc 1234.56), không nhập ký tự khác.");
        //         continue;
        //     }

        //     // Parse và kiểm tra không âm
        //     try {
        //         BigDecimal dt = new BigDecimal(input);

        //         if (dt.compareTo(BigDecimal.ZERO) < 0) {
        //             System.out.println("Doanh thu không được âm, vui lòng nhập lại.");
        //             continue;
        //         }
        //         monthlyRevenue = dt;
        //         break;
        //     } catch (NumberFormatException e) {
        //         System.out.println("Giá trị ngoài phạm vi hoặc không hợp lệ, vui lòng nhập lại.");
        //     }
        // }

        while (true) {
            System.out.print("Nhập doanh thu (số, không âm, có thể có phần thập phân): ");
            String input = sc.nextLine().trim();
        
            if (input.isEmpty()) {
                System.out.println("Không được để trống, vui lòng nhập lại.");
                continue;
            }
        
            if (!input.matches("\\d+(\\.\\d+)?")) {
                System.out.println("Doanh thu phải là số hợp lệ (ví dụ 1000000 hoặc 1234.56), không nhập ký tự khác.");
                continue;
            }
        
            try {
                double rev = Double.parseDouble(input);
                if (rev < 0) {
                    System.out.println("Doanh thu không được âm, vui lòng nhập lại.");
                    continue;
                }
                monthlyRevenue = rev;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Giá trị ngoài phạm vi hoặc không hợp lệ, vui lòng nhập lại.");
            }
        }

    }
 
}
