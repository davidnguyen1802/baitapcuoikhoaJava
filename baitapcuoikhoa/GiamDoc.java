public class GiamDoc extends NhanSu {
    private double shareholder;

    public GiamDoc(int ID, String name, String phoneNumber, int workingDay, double shareholder) {
        super(ID, name, phoneNumber, workingDay, 300);
        this.shareholder = shareholder;
    }

    @Override
    public double calculateMonthlySalary() {
        return calculateBasicSalary();
    }

    public double caculateTotalIncome(double companyProfit) {
        return calculateMonthlySalary() + (shareholder / 100) * companyProfit; 
    }
}
