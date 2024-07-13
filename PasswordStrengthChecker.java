import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a password to check its strength: ");
        String password = scanner.nextLine();
        System.out.println(checkPasswordStrength(password));
        scanner.close();
    }

    public static String checkPasswordStrength(String password) {
        int strengthPoints = 0;
        StringBuilder feedback = new StringBuilder();
        if (password.length() >= 8) {
            strengthPoints++;
        } else {
            feedback.append("Password should be at least 8 characters long.\n");
        }
        if (password.matches(".*[A-Z].*")) {
            strengthPoints++;
        } else {
            feedback.append("Password should contain at least one uppercase letter.\n");
        }
        if (password.matches(".*[a-z].*")) {
            strengthPoints++;
        } else {
            feedback.append("Password should contain at least one lowercase letter.\n");
        }
        if (password.matches(".*[0-9].*")) {
            strengthPoints++;
        } else {
            feedback.append("Password should contain at least one number.\n");
        }
        if (password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            strengthPoints++;
        } else {
            feedback.append("Password should contain at least one special character (e.g., !@#$%^&*).\n");
        }
        String strength;
        switch (strengthPoints) {
            case 0:
                strength = "Very Strong";
                break;
            case 1:
                strength = "Strong";
                break;
            case 2:
                strength = "Medium";
                break;
            case 3:
                strength = "Weak";
                break;
            default:
                strength = "Very Weak";
                break;
        }

        feedback.insert(0, "Password strength: " + strength + "\n");
        return feedback.toString();
    }
}
