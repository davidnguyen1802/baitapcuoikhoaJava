import java.util.*;

public class CongTy extends ThongTinCongTy {
    private List <NhanSu> staff = new ArrayList<>();

    public void addStaff(NhanSu ns) {
        staff.add(ns);
    }

    public void removeStaff(int ID) {
        staff.removeIf(ns -> ns.getId() == ID);

        for (NhanSu ns : staff) {
            if (ns instanceof NhanVien) {
                NhanVien e = (NhanVien) ns;
                if (e.getManager() != null && e.getManager().getId() == ID) {
                    e.getManager().removeEmployee(e);
                }
            }
        }
    }

    public List <NhanSu> getStaff() {
        return staff;
    }

    public double totalSalary() {
        return staff.stream().mapToDouble(NhanSu::calculateMonthlySalary).sum();
    }

    public double companyProfit() {
        return getMonthlyRevenue() - totalSalary();
    }


}
