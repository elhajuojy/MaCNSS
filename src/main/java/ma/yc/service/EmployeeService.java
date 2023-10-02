package ma.yc.service;

import ma.yc.dto.EmployeDto;

public interface EmployeeService  extends Authenfication{

    public EmployeDto addEmployee(EmployeDto employeeDto);
    public EmployeDto consultEmployee(long employeeMatricule);


    boolean isEmployeeExist(int id);

    boolean updateEmployeeSalary(int id, double salary);
}
