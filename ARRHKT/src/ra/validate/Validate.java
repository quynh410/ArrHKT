package ra.validate;

public class Validate {
    public static boolean validateEmployeeId(String employeeId) {
        return employeeId.matches("NV\\d{4}");
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("0[3-9]\\d{8}");
    }

    public static boolean validateBirthday(String birthday) {
        return birthday.matches("\\d{2}/\\d{2}/\\d{4}");
    }

}

