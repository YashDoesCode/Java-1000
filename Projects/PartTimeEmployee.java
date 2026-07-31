// Source code is decompiled from a .class file using FernFlower decompiler.
package Projects;

class PartTimeEmployee extends Employee {
   private int hoursWorked;
   private double hourlySalary;

   public PartTimeEmployee(String name, int id, int hoursWorked, double hourlySalary) {
      super(name, id);
      this.hoursWorked = hoursWorked;
      this.hourlySalary = hourlySalary;
   }

   public double calculateSalary() {
      return (double)this.hoursWorked * this.hourlySalary;
   }
}
