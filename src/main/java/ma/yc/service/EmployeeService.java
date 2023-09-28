package ma.yc.service;

import ma.yc.dto.EmployeDto;

public interface EmployeeService {

    public void addEmployee(EmployeDto employeeDto);
    public EmployeDto consultEmployee(long employeeMatricule);


}
