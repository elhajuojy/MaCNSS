package ma.yc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Hourly_emp {
    private Long id ;
    private Date date ;
    private Employe employe ;
    private int jourTravaille ;
}
