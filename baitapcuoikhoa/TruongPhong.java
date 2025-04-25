import java.util.ArrayList;
import java.util.List;

public class TruongPhong extends NhanSu {
    private List <NhanVien> listNhanVien = new ArrayList<>();
    
    public TruongPhong(int ID, String name, String phoneNumber, int workingDay) {
        super(ID, name, phoneNumber, workingDay, 200);
    }

    public void addEmployee(NhanVien e) {
        this.listNhanVien.add(e);
        e.setManager(this);
    }

    public void removeEmployee(NhanVien e) {
        this.listNhanVien.remove(e);
        e.setManager(null);
    }

    public int getNumberOfEmployee() {
        return this.listNhanVien.size();
    }

    @Override
    public double calculateMonthlySalary() {
        return calculateBasicSalary() + 100 * getNumberOfEmployee();
    }
}
