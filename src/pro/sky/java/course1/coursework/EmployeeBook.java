package pro.sky.java.course1.coursework;

public class EmployeeBook {
    private final Employee[] employees;
    private int size;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public Employee[] getEmployees() {
        return this.employees;
    }

    public void addEmployee(String fio, int department, double salary) {
        if (size >= employees.length) {
            throw new IllegalArgumentException("Список сотрудников заполнен. Добавление нового сотрудника ограничено.");
        }
        Employee newEmployee = new Employee(fio, department, salary);
        employees[size++] = newEmployee;
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                employees[i] = null;
                if (i != employees.length - 1) {
                    System.arraycopy(employees, i + 1, employees, i, size - 1);
                }
                size--;
                System.out.println("Сотрудник с " + id + " удален");
                return;
            }
        }
    }

    public void setSalary(String fio, double salary) {
        for (Employee employee : employees) {
            if (employee.getFio().equals(fio)) {
                employee.setSalary(salary);
            }
        }
    }

    public void setDepartment(String fio, int department) {
        for (Employee employee : employees) {
            if (employee.getFio().equals(fio)) {
                employee.setDepartment(department);
            }
        }
    }

    public void printDepartmentEmployee() {
        for (int i = 1; i < 6; i++) {
            System.out.println("Сотрудники отдела " + i + ":");
            for (Employee employee : employees) {
                if (employee.getDepartment() == i) {
                    System.out.println(employee.getFio());
                }
            }
            System.out.println();
        }
    }

    public void printEmployee() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public double calculateAmountEmployee(Employee[] employees) {
        double amount = 0;
        for (Employee employee : employees) {
            amount += employee.getSalary();
        }
        return amount;
    }

    public void printEmployeeMinSalary(Employee[] employees) {
        double minSalary = 1_000_001;
        Employee minEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                minEmployee = employee;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой " + minEmployee);
    }

    public void printEmployeeMaxSalary(Employee[] employees) {
        double maxSalary = -1;
        Employee maxEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                maxEmployee = employee;
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой " + maxEmployee);
    }

    public double calculateAverageSalary(Employee[] employees, int volume) {
        double amount = calculateAmountEmployee(employees);
        return amount / volume;
    }

    public void printEmployeeFio() {
        for (Employee employee : employees) {
            System.out.println(employee.getFio());
        }
    }

    public void printIdEmployeeFioSalary(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println("id = " + employee.getId() + ", Ф.И.О. = " + employee.getFio() + ", Зарпалата = " + employee.getSalary());
        }
    }

    public void indexingSalary(double percent) {
        for (Employee employee : employees) {
            double indexing = employee.getSalary() + employee.getSalary() * (percent / 100);
            employee.setSalary(indexing);
        }
    }

    public Employee[] searchByDepartment(int numberDepartment) {
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

    public Employee[] compareLessSalary(int number) {
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

    public Employee[] compareMoreSalary(int number) {
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

    public void indexingSalaryDepartment(Employee[] employees1, double percent) {
        for (Employee employee : employees1) {
            double indexing = employee.getSalary() + employee.getSalary() * (percent / 100);
            employee.setSalary(indexing);
            for (Employee employee1 : employees) {
                if (employee.equals(employee1)) {
                    employee1.setSalary(employee.getSalary());
                }
            }
        }
    }

}
