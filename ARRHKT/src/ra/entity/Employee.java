package ra.entity;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Employee implements IApp {
    private static final int BASE_SALARY = 1800000;
    private String employeeId;
    private String employeeName;
    private String birthday;
    private String phoneNumber;
    private boolean sex;
    private float coefficient;
    private int allowanceSalary;
    private String department;
    private byte status;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, String birthday, String phoneNumber, boolean sex, float coefficient, int allowanceSalary, String department, byte status) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.coefficient = coefficient;
        this.allowanceSalary = allowanceSalary;
        this.department = department;
        this.status = status;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public int getAllowanceSalary() {
        return allowanceSalary;
    }

    public void setAllowanceSalary(int allowanceSalary) {
        this.allowanceSalary = allowanceSalary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner sc) {
        sc.nextLine();
        while (true) {
            System.out.print("Nhập mã nhân viên (NVxxxx): ");
            employeeId = sc.nextLine().trim();
            if (Pattern.matches("NV\\d{4}", employeeId)) break;
            System.out.println(" Mã nhân viên không hợp lệ! Hãy nhập lại.");
        }

        while (true) {
            System.out.print("Nhập tên nhân viên: ");
            employeeName = sc.nextLine().trim();
            if (!employeeName.isEmpty()) break;
            System.out.println("Tên nhân viên không được để trống!");
        }

        while (true) {
            System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
            birthday = sc.nextLine().trim();
            if (Pattern.matches("\\d{2}/\\d{2}/\\d{4}", birthday)) break;
            System.out.println("Ngày sinh không hợp lệ! Hãy nhập lại.");
        }

        while (true) {
            System.out.print("Nhập số điện thoại: ");
            phoneNumber = sc.nextLine().trim();
            if (Pattern.matches("^0[1-9]\\d{8}$", phoneNumber)) break;
            System.out.println("Số điện thoại không hợp lệ! Hãy nhập lại.");
        }

        System.out.print("Nhập giới tính (true - Nam, false - Nữ): ");
        while (!sc.hasNextBoolean()) {
            System.out.println("Giá trị không hợp lệ! Hãy nhập true hoặc false.");
            sc.next();
        }
        sex = sc.nextBoolean();
        sc.nextLine();

        System.out.print("Nhập hệ số lương: ");
        while (!sc.hasNextFloat() || (coefficient = sc.nextFloat()) <= 0) {
            System.out.println("Hệ số lương phải lớn hơn 0!");
            sc.next();
        }

        System.out.print("Nhập phụ cấp lương: ");
        while (!sc.hasNextInt() || (allowanceSalary = sc.nextInt()) < 0) {
            System.out.println("Phụ cấp lương phải lớn hơn hoặc bằng 0!");
            sc.next();
        }
        sc.nextLine();

        while (true) {
            System.out.print("Nhập phòng ban: ");
            department = sc.nextLine().trim();
            if (!department.isEmpty()) break;
            System.out.println("Phòng ban không được để trống!");
        }

        System.out.print("Nhập trạng thái (1- Đang làm việc, 2- Đang nghỉ phép, 3- Đã nghỉ việc): ");
        while (!sc.hasNextByte() || (status = sc.nextByte()) < 1 || status > 3) {
            System.out.println("Trạng thái chỉ nhận giá trị từ 1 đến 3!");
            sc.next();
        }

        System.out.println("Nhập thông tin nhân viên thành công!");
    }

    @Override
    public void displayData() {
        int age = 2024 - Integer.parseInt(birthday.split("/")[2]);
        int totalSalary = BASE_SALARY * (int) coefficient + allowanceSalary;

        System.out.println("Mã NV: " + employeeId);
        System.out.println("Tên NV: " + employeeName);
        System.out.println("Tuổi: " + age);
        System.out.println("Giới tính: " + (sex ? "Nam" : "Nữ"));
        System.out.println("SĐT: " + phoneNumber);
        System.out.println("Tổng lương: " + totalSalary);
        System.out.println("Phòng ban: " + department);
        System.out.println("Trạng thái: " + (status == 1 ? "Đang làm việc" : status == 2 ? "Đang nghỉ phép" : "Đã nghỉ việc"));
    }
}
