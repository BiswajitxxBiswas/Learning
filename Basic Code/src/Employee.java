import java.util.Scanner;

public class Employee {
    private int empno;
    private String ename;
    private float basic;
    private float hr;
    private float da;
    private float netpay;

    public float calculate() {
        return basic + hr + da;
    }

    public void havedata() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee Number: ");
        empno = scanner.nextInt();

        System.out.print("Enter Employee Name: ");
        scanner.nextLine();
        ename = scanner.nextLine();

        System.out.print("Enter Basic Salary: ");
        basic = scanner.nextFloat();

        System.out.print("Enter HRA: ");
        hr = scanner.nextFloat();

        System.out.print("Enter DA: ");
        da = scanner.nextFloat();

        netpay = calculate();
    }

    public void dispdata() {
        System.out.println("Employee Number: " + empno);
        System.out.println("Employee Name: " + ename);
        System.out.println("Basic Salary: " + basic);
        System.out.println("HRA: " + hr);
        System.out.println("DA: " + da);
        System.out.println("Net Pay: " + netpay);
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.havedata();
        employee.dispdata();
    }
}
