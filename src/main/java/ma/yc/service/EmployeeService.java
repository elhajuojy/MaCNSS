package ma.yc.service;

import ma.yc.dto.EmployeDto;

public interface EmployeeService  extends Authenfication{

    public EmployeDto addEmployee(EmployeDto employeeDto);
    public EmployeDto consultEmployee(long employeeMatricule);


    boolean isEmployeeExist(Long id);

    boolean updateEmployeeSalary(Long id,Long idSociete, double salary);

    boolean declareJourTravileParEmployee(long societeId, long employeeMatricule, int jourTravile);
}
