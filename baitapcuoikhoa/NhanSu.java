abstract class NhanSu {
    protected int ID;
    protected String name;
    protected String phoneNumber;
    protected double workingDay;
    protected double dailySalary;

    // public abstract void fillInformation();

    public NhanSu(int ID, String name, String phoneNumber, int workingDay, int dailySalary) {
        this.ID = ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.workingDay = workingDay;
        this.dailySalary = dailySalary;
    }

    public int getId() { return ID; }

    public String getName() { return name; }

    public double calculateBasicSalary() {
        return workingDay * dailySalary;
    }

    public abstract double calculateMonthlySalary();

}
