package ra.bussiness;

import ra.entity.Employee;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeBusiness {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(Scanner sc) {
        System.out.print("Nhập số lượng nhân viên cần thêm: ");
        int num;
        while (true) {
            while (!sc.hasNextInt()) {
                System.out.print("Số lượng không hợp lệ. Nhập lại: ");
                sc.next();
            }
            num = sc.nextInt();
            sc.nextLine();
            if (num > 0) break;
            System.out.print("Số lượng phải lớn hơn 0. Nhập lại: ");
        }

        for (int i = 0; i < num; i++) {
            Employee emp = new Employee();
            emp.inputData(sc);
            employees.add(emp);
        }
        System.out.println("Thêm nhân viên thành công!");
    }

    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }
        for (Employee emp : employees) {
            emp.displayData();
        }
    }

    public void editEmployee(Scanner sc) {
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }

        System.out.print("Nhập mã nhân viên cần chỉnh sửa: ");
        String id = sc.nextLine();

        for (Employee emp : employees) {
            if (emp.getEmployeeId().equalsIgnoreCase(id)) {
                emp.displayData();
                emp.inputData(sc);
                System.out.println("Cập nhật thông tin thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên với mã: " + id);
    }

    public void deleteEmployee(Scanner sc) {
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }

        System.out.print("Nhập mã nhân viên cần xóa: ");
        String id = sc.nextLine();

        for (Employee emp : employees) {
            if (emp.getEmployeeId().equalsIgnoreCase(id)) {
                System.out.print("Bạn có chắc chắn muốn xóa? (Y/N): ");
                char confirm = sc.next().charAt(0);
                sc.nextLine();

                if (confirm == 'Y' || confirm == 'y') {
                    employees.remove(emp);
                    System.out.println("Xóa nhân viên thành công!");
                } else {
                    System.out.println("Hủy thao tác xóa.");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên.");
    }

    public void sortEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }
        employees.sort((e1, e2) -> e1.getEmployeeId().compareTo(e2.getEmployeeId()));
        System.out.println("Sắp xếp nhân viên theo mã nhân viên thành công!");
    }

    public void searchEmployee(Scanner sc) {
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }

        System.out.print("Nhập tên nhân viên cần tìm: ");
        String name = sc.nextLine().toLowerCase();
        boolean found = false;

        for (Employee emp : employees) {
            if (emp.getEmployeeName().toLowerCase().contains(name)) {
                emp.displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy nhân viên với tên: " + name);
        }
    }
}
