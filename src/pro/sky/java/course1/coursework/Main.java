package pro.sky.java.course1.coursework;

public class Main {
    private static final Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Захаров Марк Никитич", 1, 50_000);
        employees[1] = new Employee("Нефедова София Германовна", 2, 60_000);
        employees[2] = new Employee("Дементьев Алексей Захарович", 3, 30_000);
        employees[3] = new Employee("Левин Александр Кириллович", 4, 20_000);
        employees[4] = new Employee("Михайлова Майя Александровна", 5, 70_000);
        employees[5] = new Employee("Попова Майя Дмитриевна", 5, 80_000);
        employees[6] = new Employee("Мещерякова Злата Артёмовна", 4, 15_000);
        employees[7] = new Employee("Федоров Дмитрий Константинович", 3, 40_000);
        employees[8] = new Employee("Гаврилов Георгий Даниилович", 2, 35_000);
        employees[9] = new Employee("Яковлева Мадина Марсельевна", 1, 90_000);
        task1();
        task8();
        task1();

    }

    private static void printEmployee() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static int calculateAmountEmployee(Employee[] employees) {
        int amount = 0;
        for (Employee employee : employees) {
            amount += employee.getSalary();
        }
        return amount;
    }

    private static void printEmployeeMinSalary(Employee[] employees) {
        int minSalary = 1_000_001;
        Employee minEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                minEmployee = employee;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой " + minEmployee);
    }

    private static void printEmployeeMaxSalary(Employee[] employees) {
        int maxSalary = -1;
        Employee maxEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                maxEmployee = employee;
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой " + maxEmployee);
    }

    private static double calculateAverageSalary(Employee[] employees, int count) {
        double amount = calculateAmountEmployee(employees);
        return amount / count;
    }

    private static void printEmployeeFio() {
        for (Employee employee : employees) {
            System.out.println(employee.getFio());
        }
    }

    private static void printIdEmployeeFioSalary(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println("id = " + employee.getId() + ", Ф.И.О. = " + employee.getFio() + ", Зарпалата = " + employee.getSalary());
        }
    }

    private static void indexingSalary(Employee[] employees, double percent) {
        for (Employee employee : employees) {
            double indexing = employee.getSalary() + employee.getSalary() * (percent / 100);
            employee.setSalary((int) indexing);
        }
    }

    private static Employee[] searchByDepartment(int numberDepartment) {
        if (numberDepartment < 0 || numberDepartment > 5) {
            throw new IllegalArgumentException("Неправильно указан номер отдела. Укажите номер отдела от 1 до 5!");
        }
        int size = 0;
        int size2 = 0;
        for (Employee value : employees) {
            if (value.getDepartment() == numberDepartment) {
                size++;
            }
        }
        Employee[] employeesDepartment = new Employee[size];
        for (Employee employee : employees) {
            if (employee.getDepartment() == numberDepartment) {
                employeesDepartment[size2++] = employee;
            }
        }
        return employeesDepartment;
    }

    private static Employee[] compareLessSalary(int number) {
        int size = 0;
        int size2 = 0;
        for (Employee employee : employees) {
            if (employee.getSalary() < number) {
                size++;
            }
        }
        Employee[] lessSalary = new Employee[size];
        for (Employee employee : employees) {
            if (employee.getSalary() < number) {
                lessSalary[size2++] = employee;
            }
        }
        return lessSalary;
    }

    private static Employee[] compareMoreSalary(int number) {
        int size = 0;
        int size2 = 0;
        for (Employee employee : employees) {
            if (employee.getSalary() >= number) {
                size++;
            }
        }
        Employee[] moreSalary = new Employee[size];
        for (Employee employee : employees) {
            if (employee.getSalary() >= number) {
                moreSalary[size2++] = employee;
            }
        }
        return moreSalary;
    }

    private static void indexingSalaryEmployee(Employee[] employees1) {
        for (Employee employee : employees1) {
            for (Employee employee1 : employees) {
                if (employee.equals(employee1)) {
                    employee1.setSalary(employee.getSalary());
                }
            }
        }
    }

    private static void task1() {
        printEmployee();
    }

    private static void task2() {
        int amount = calculateAmountEmployee(employees);
        System.out.println("Сумма затрат на зарплаты в месяц " + amount);
    }

    private static void task3() {
        printEmployeeMinSalary(employees);
    }

    private static void task4() {
        printEmployeeMaxSalary(employees);
    }

    private static void task5() {
        int count = employees.length;
        double average = calculateAverageSalary(employees, count);
        System.out.println("Среднее значение зарплат " + average);
    }

    private static void task6() {
        printEmployeeFio();
    }

    private static void task7() {
        double percent = 15;
        indexingSalary(employees, percent);
    }

    private static void task8() {
        int department = 1;
        double percent = 20;
        Employee[] employeesDepartment = searchByDepartment(department);
        int count = employeesDepartment.length;
        printEmployeeMinSalary(employeesDepartment);
        printEmployeeMaxSalary(employeesDepartment);
        int amount = calculateAmountEmployee(employeesDepartment);
        System.out.println("Сумма затрат на зарплаты в месяц " + amount);
        double average = calculateAverageSalary(employeesDepartment, count);
        System.out.println("Среднее значение зарплат " + average);
        indexingSalary(employeesDepartment, percent);
        indexingSalaryEmployee(employeesDepartment);
        printIdEmployeeFioSalary(employeesDepartment);
    }

    private static void task9() {
        int number = 45_000;
        Employee[] lessSalary = compareLessSalary(number);
        Employee[] moreSalary = compareMoreSalary(number);
        System.out.println("Сотрудники с зарплатой меньше " + number);
        printIdEmployeeFioSalary(lessSalary);
        System.out.println("Сотрудники с зарплатой больше (или равно) " + number);
        printIdEmployeeFioSalary(moreSalary);
    }
}