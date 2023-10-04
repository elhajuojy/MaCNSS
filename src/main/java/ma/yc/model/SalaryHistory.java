package ma.yc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryHistory {
    private Long id ;
    private double salaire ;
    private Employe employe ;
}
