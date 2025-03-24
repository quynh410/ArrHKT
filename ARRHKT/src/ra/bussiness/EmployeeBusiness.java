package ra.bussiness;

import ra.entity.Employee;
import java.util.Scanner;

public class EmployeeBusiness {
    private Employee[] employees = new Employee[100];
    private int count = 0;

    public void addEmployee(Scanner sc) {
        if (count >= employees.length) {
            System.out.println("Danh sách nhân viên đã đầy, không thể thêm mới!");
            return;
        }

        int num;
        do {
            System.out.print("Nhập số lượng nhân viên cần thêm: ");
            while (!sc.hasNextInt()) {
                System.out.print("Số lượng không hợp lệ. Nhập lại: ");
                sc.next();
            }
            num = sc.nextInt();
        } while (num <= 0 || num > (employees.length - count));
        sc.nextLine();

        for (int i = 0; i < num; i++) {
            Employee emp = new Employee();
            emp.inputData(sc);
            employees[count++] = emp;
        }
        System.out.println("Thêm nhân viên thành công!");
    }

    public void displayAllEmployees() {
        if (count == 0) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }
        for (int i = 0; i < count; i++) {
            employees[i].displayData();
        }
    }

    public void editEmployee(Scanner sc) {
        if (count == 0) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }

        System.out.print("Nhập mã nhân viên cần chỉnh sửa: ");
        String id = sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(id)) {
                employees[i].displayData();
                employees[i].inputData(sc);
                System.out.println("Cập nhật thông tin thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên với mã: " + id);
    }

    public void deleteEmployee(Scanner sc) {
        if (count == 0) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }

        System.out.print("Nhập mã nhân viên cần xóa: ");
        String id = sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(id)) {
                System.out.print("Bạn có chắc chắn muốn xóa? (Y/N): ");
                char confirm = sc.next().charAt(0);
                sc.nextLine();

                if (confirm == 'Y' || confirm == 'y') {
                    for (int j = i; j < count - 1; j++) {
                        employees[j] = employees[j + 1];
                    }
                    employees[--count] = null;
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
        if (count == 0) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (employees[i].getEmployeeId().compareTo(employees[j].getEmployeeId()) > 0) {
                    Employee temp = employees[i];
                    employees[i] = employees[j];
                    employees[j] = temp;
                }
            }
        }
        System.out.println("Sắp xếp nhân viên theo mã nhân viên thành công!");
    }

    public void searchEmployee(Scanner sc) {
        if (count == 0) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }

        System.out.print("Nhập tên nhân viên cần tìm: ");
        String name = sc.nextLine().toLowerCase();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeName().toLowerCase().contains(name)) {
                employees[i].displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy nhân viên với tên: " + name);
        }
    }
}
