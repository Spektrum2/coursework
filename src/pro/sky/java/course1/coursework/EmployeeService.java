package pro.sky.java.course1.coursework;

public class EmployeeService {
    public static void printEmployee(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static int calculateAmountEmployee(Employee[] employees) {
        int amount = 0;
        for (Employee employee : employees) {
            amount += employee.getSalary();
        }
        return amount;
    }

    public static void printEmployeeMinSalary(Employee[] employees) {
        int minSalary = 100000;
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
            }
        }
        for (Employee employee : employees) {
            if (employee.getSalary() == minSalary) {
                System.out.println("Сотрудник с минимальной зарплатой " + employee);
            }
        }

    }

    public static void printEmployeeMaxSalary(Employee[] employees) {
        int maxSalary = -1;
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
            }
        }
        for (Employee employee : employees) {
            if (employee.getSalary() == maxSalary) {
                System.out.println("Сотрудник с максимальной зарплатой " + employee);
            }
        }
    }

    public static int calculateAverageSalary(int amount) {
        int average = amount / Employee.id;
        return average;
    }

    public static void printEmployeeFio(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee.getFio());
        }
    }
}
