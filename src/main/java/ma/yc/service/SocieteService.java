package ma.yc.service;

import ma.yc.dto.EmployeDto;
import ma.yc.dto.SocieteDto;

public interface SocieteService extends Authenfication {

        public SocieteDto addSociete(SocieteDto societeDto);
        public SocieteDto consultSociete(long societeId);
        public EmployeDto addEmployee(long societeId, EmployeDto employeeDto);
        public EmployeDto consultEmployee(long societeId, long employeeMatricule);
        public EmployeDto declareJourTravileParEmployee(long societeId, long employeeMatricule, int jourTravile);


}
