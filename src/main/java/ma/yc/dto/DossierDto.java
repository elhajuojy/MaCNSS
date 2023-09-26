package ma.yc.dto;

import ma.yc.enums.statusDossier;
import ma.yc.dto.RemboursementDto;

import java.util.List;

public class DossierDto {

    public String numDossier;

    public statusDossier status;
    public float totalRemboursement;
    public RemboursementDto remboursementDto;
    public FichierDto fichier;
    public PatientDto patientDto;

    public List<MedicamentDto> medicamentsDto;
    public List<AnalyseDto> analysesDto;
    public List<ScannerDto> scannersDto;
    public List<RadioDto> radiosDto;
    public List<VisiteDto> visitesDto;


    @Override
    public String toString() {
        return "DossierDto{" +
                "numDossier='" + numDossier + '\'' +
                ", status=" + status +
                ", totalRemboursement=" + totalRemboursement +
                ", remboursementDto=" + remboursementDto +
                ", fichier=" + fichier +
                ", patientDto=" + patientDto +
                ", medicamentsDto=" + medicamentsDto +
                ", analysesDto=" + analysesDto +
                ", scannersDto=" + scannersDto +
                ", radiosDto=" + radiosDto +
                ", visitesDto=" + visitesDto +
                '}';

    }
}
