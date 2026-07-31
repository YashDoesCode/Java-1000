// Source code is decompiled from a .class file using FernFlower decompiler.
package Projects;

abstract class Employee {
   private String name;
   private int id;

   public Employee(String name, int id) {
      this.name = name;
      this.id = id;
   }

   public String getName() {
      return this.name;
   }

   public int getId() {
      return this.id;
   }

   public abstract double calculateSalary();

   public String toString() {
      String var10000 = this.name;
      return "Employee[name =" + var10000 + ", id =" + this.id + ", salary = " + this.calculateSalary() + "]";
   }
}
