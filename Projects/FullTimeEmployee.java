// Source code is decompiled from a .class file using FernFlower decompiler.
package Projects;

class FullTimeEmployee extends Employee {
   private double monthlySalary;

   public FullTimeEmployee(String name, int id, double monthlySalary) {
      super(name, id);
      this.monthlySalary = monthlySalary;
   }

   public double calculateSalary() {
      return this.monthlySalary;
   }
}
