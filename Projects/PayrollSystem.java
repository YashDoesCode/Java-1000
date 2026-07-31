// Source code is decompiled from a .class file using FernFlower decompiler.
package Projects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PayrollSystem {
   private List<Employee> employeeList = new ArrayList();

   public PayrollSystem() {
   }

   public void addEmployee(Employee e) {
      this.employeeList.add(e);
   }

   public void removeEmployee(int id) {
      Employee employeeToRemove = null;
      Iterator var3 = this.employeeList.iterator();

      while(var3.hasNext()) {
         Employee e = (Employee)var3.next();
         if (e.getId() == id) {
            employeeToRemove = e;
            break;
         }
      }

      if (employeeToRemove != null) {
         this.employeeList.remove(employeeToRemove);
      }

   }

   public void displayEmployee() {
      Iterator var1 = this.employeeList.iterator();

      while(var1.hasNext()) {
         Employee e = (Employee)var1.next();
         System.out.println(e);
      }

   }
}
