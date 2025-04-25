public class NhanVien extends NhanSu {
    private TruongPhong manager;

    public NhanVien(int ID, String name, String phoneNumber, int workingDay) {
        super(ID, name, phoneNumber, workingDay, 100);
    }

    public void setManager(TruongPhong manager) {
        this.manager = manager;
    }

    @Override
    public double calculateMonthlySalary(){
        return calculateBasicSalary();
    };

    public TruongPhong getManager() {
        return manager;
    }
}
