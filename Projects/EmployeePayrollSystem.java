// Source code is decompiled from a .class file using FernFlower decompiler.
package Projects;

public class EmployeePayrollSystem {
   public EmployeePayrollSystem() {
   }

   public static void main(String[] args) {
      PayrollSystem payroll = new PayrollSystem();
      FullTimeEmployee e1 = new FullTimeEmployee("Vikas", 12, 70000.0);
      PartTimeEmployee e2 = new PartTimeEmployee("Rahul", 34, 40, 150.0);
      payroll.addEmployee(e1);
      payroll.addEmployee(e2);
      System.out.println("Initial employee details :");
      payroll.displayEmployee();
      payroll.removeEmployee(34);
      System.out.println("Remaining employee details :");
      payroll.displayEmployee();
   }
}
