package ra.presentation;

import ra.bussiness.EmployeeBusiness;
import java.util.Scanner;

public class EmployeeApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeBusiness eb =  new EmployeeBusiness();
        while(true){
            System.out.println("=================EMPLOYEE MENU=================");
            System.out.println("1. Hiển thị danh sách nhân viên");
            System.out.println("2. Thêm mới nhân viên");
            System.out.println("3. Chỉnh sửa thông tin sinh viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Tìm kiếm nhân viên");
            System.out.println("6. Sắp xếp");
            System.out.println("0.Thoát chương trình");
            System.out.println("===============================================");
            System.out.println("Mời bạn chọn chức năng: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    eb.displayAllEmployees();
                    break;
                case 2:
                    eb.addEmployee(sc);
                    break;
                case 3:
                    eb.editEmployee(sc);
                    break;
                case 4:
                    eb.deleteEmployee(sc);
                    break;
                case 5:
                    eb.searchEmployee(sc);
                    break;
                case 6:
                    eb.sortEmployees();
                    break;
                case 0:
                    System.out.println("Đang thoát chương trình...");
                    return;
                default:
                    System.out.println("lựa chọn ko hợp lệ vui lòng thử lại...");
            }
        }
    }
}
