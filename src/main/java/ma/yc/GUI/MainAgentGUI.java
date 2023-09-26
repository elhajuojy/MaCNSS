package ma.yc.GUI;

import ma.yc.core.Print;
import ma.yc.core.Util;
import ma.yc.dto.*;
import ma.yc.enums.statusDossier;
import ma.yc.model.*;
import ma.yc.service.AgentService;
import ma.yc.service.DossierService;
import ma.yc.service.PatientService;
import ma.yc.service.impl.AgentServiceImpl;
import ma.yc.service.impl.DossierServiceImpl;
import ma.yc.service.impl.PatientServiceImpl;


import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainAgentGUI implements DisplayGUI {

    private AgentService agentService;
    private DossierDto dossierDto = new DossierDto();
    private DossierService dossierService;
    private PatientService patientService;
    private boolean isAuthentificated = false;
    private Scanner scanner ;
    private AgentDto agentDto;
    public MainAgentGUI() {
        this.agentService = new AgentServiceImpl();
        this.dossierService = new DossierServiceImpl();
        this.agentDto = new AgentDto();
        this.patientService = new PatientServiceImpl();
    }
    public static boolean verifyEmail(String input){
        String rgx = "^[a-zA-Z0-9]+@[a-z]+\\.[a-z]+$";
        Pattern pattern = Pattern.compile(rgx);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static Boolean sendMail(String body,String subject ,String email) {
        final String username = "obelkadi336@gmail.com";
        final String password = "hbdi wose rkeq qpme";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(subject);
            message.setText("Here is the code of verification authentic: "+body);
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public int displayMainOptions(Scanner scanner ) {
        this.scanner = scanner;
        Print.log("Bienvenue dans l'application de gestion des patients");
        Print.log("Authentification");
        scanner.nextLine();
        String email = Util.readString("Email",scanner);
        agentDto.email = email;
        if (verifyEmail(email)){
            String password = Util.readString("Password",scanner);
            agentDto.password = password;
            String code = this.agentService.authentifier(agentDto);
            if (!code.isEmpty()){
                System.out.println("Success: " + code);

                this.agentDto.codeVerification=code;
                if(this.agentService.insertCode(agentDto)){
                    desplayValidateCode(scanner, agentDto);
                }
                sendMail(code, "code", agentDto.email);
            }else {
                System.out.println("Ops");
            }
        }else {
            System.out.println(email + " is not a valid email address.");

        }
        // : something went worng password or email are not correct .
        Print.log("something went worng password or email are not correct .");
        return 0;
    }
    public static void desplayValidateCode(Scanner scanner,AgentDto agentDto){
        String codeVerification = Util.readString("code",scanner);
        agentDto.codeVerification = codeVerification;
    }


    void verifyCodeVerification( ){
        //if the authentification is successful then show the admin dashboard
        Print.log("Send the verification code to your email");
        String code = Util.readString("Code",scanner);

        boolean isCodeVerified = this.agentService.verifyCodeVerification(code);
        if (isCodeVerified){
            this.agentDashboard();
        }else {
            //: something went worng the code is not correct .
            Print.log("something went worng the code is not correct");
        }
    }

    private void agentDashboard( ) {
        Print.log("=== Agent Operation  ===");
        Print.log("1 - Add a new Dossier ");
        Print.log("2 - Change a Dossier status");
        Print.log("3 - Consult a Dossier ");
        Print.log("4 - Consult all Dossiers ");
        //go back to the main menu
        Print.log("5 - Go back to the main menu ");
        Print.log("0 - Exit ");

        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                //add a new Dossier
                this.addDossier();
                break;
            case 2:
                //change a Dossier status
                this.changeDossierStatus();
                break;
            case 3:
                //consult a Dossier
                this.consultDossier();
                break;
            case 4:
                //consult all Dossiers
                this.consultAllDossiers();
                break;
            case 0:
                //go back to the main menu
                break;
            default:
                Print.log("Invalid choice");
                break;
        }
    }

    private void consultAllDossiers( ) {
        //Todo:Test Just for test
        // : the consulterDossiers function must return List of DossierDto
        DossierDto dossierDto1 = new DossierDto();
        dossierDto1.patientDto = new PatientDto();
        dossierDto1.patientDto.matricule = Util.readString("Matricule",scanner);
        List<DossierDto> dossierDtoList = this.dossierService.consulterDossiers(dossierDto1);
        //todo:stream data and map it to be more nice to be seen
        dossierDtoList.stream().map(dossierDto -> {
            Print.log(dossierDto.toString());
            return dossierDto;
        });

    }

    private void consultDossier( ) {
        // : ask about the dossier id and show it
        // : ask about dossier :code_bar
         Print.log("Entre le code bar de votre dossier");
         String code_bar = Util.readString("Code bar",scanner);
         this.dossierService.consulterDossier();
    }

    private void changeDossierStatus( ) {
        // : ask about the dossier id and the new status and update it
        Print.log("Entre le num dossier de votre dossier");
        String code_bar = Util.readString("num_dossier",scanner);
        Print.log("Entre le nouveau status");
        String status = Util.readString("Status",scanner);

        DossierDto dossierDto = new DossierDto();
        dossierDto.numDossier = code_bar;
        //TODO : CONVERT THE STRING TO ENUM
//        dossierDto.status = "En_attend";
        this.dossierService.suiviEtatDossier("");

    }

    private void addDossier( ) {
        // : ask about the dossier information and add it
        Print.log("Entre le matricule de votre patient");
        String matricule = Util.readString("Matricule",scanner);
        // first i need to verify the patient matircule if it exist or not
        PatientDto patientDto = new PatientDto();
        patientDto.matricule = matricule;
        if (!this.patientService.authentification(patientDto))
        {
            Print.log("Matricule does not exist");
            return;
        }
        // : if the matricule exist then add the dossier
        dossierDto.patientDto =patientDto  ;
        String num_dossier = Util.readString("Num dossier",scanner);
        dossierDto.numDossier = num_dossier;
        dossierDto.status = statusDossier.En_attend;

        //: ask about ficher one ficher
        dossierDto.fichier = this.saveFicher();

        //: ask about medicaments  list;
        dossierDto.medicamentsDto = this.saveMedicament();

        //: ask about analyses list;
        //: ask if there's a analyses to include in the dossier

        dossierDto.analysesDto = this.saveAnalyses();
        // : ask about scanners list;
        dossierDto.scannersDto = this.saveScanners();
        // : ask about radios list;
        dossierDto.radiosDto = this.saveRadios();
        // : ask about visits list ;
        dossierDto.visitesDto = this.saveVisits();
        //: Print information
        Print.log(dossierDto.toString());
        //:save dossier
        this.dossierService.enregistrerDossier(dossierDto);


        //:call service to count amomunt .... totalRemboursement
        Float totalRemoursement =  this.dossierService.totalRemoursement();
        Print.log("Total Remboursement : " + totalRemoursement);




    }

    private FichierDto saveFicher() {
        this.dossierDto.fichier = new FichierDto();
        String dateDepot = Util.readString("dateDepot",scanner);
        String specialite = Util.readString("specialite",scanner);
        Print.log("Entre les total frais dossier ");
        float totalFraisDossier = scanner.nextFloat();

        dossierDto.fichier.dateDepot = dateDepot;
        dossierDto.fichier.specialite = specialite;
        dossierDto.fichier.totalFraisDossier = totalFraisDossier;
        return dossierDto.fichier ;
    }

    private List<VisiteDto> saveVisits() {
        this.dossierDto.visitesDto = new ArrayList<>();
        Print.log("Voulez vous ajouter un autre visite ? (y/n)");
        String saveVisits = scanner.nextLine();
        boolean isVisites = false;
        if (saveVisits.equals("y")){
            isVisites = true;
        }
        while (isVisites){
            VisiteDto visiteDto = new VisiteDto();
            visiteDto.description = Util.readString("Description",scanner);
            Print.log("Entre le prix de la visite : ");
            visiteDto.prix =  scanner.nextFloat();
            Print.log("Entre l'id de la visite : ");
            visiteDto.visiteId = scanner.nextLong();
            //: add visite to list
            dossierDto.visitesDto.add(visiteDto);
            Print.log("Voulez vous ajouter un autre visite ? (y/n)");
            String choice = Util.readString("Choix",scanner);
            if (choice.equals("n")){
                break;
            }
        }
        return this.dossierDto.visitesDto;
    }

    private List<RadioDto> saveRadios() {
        this.dossierDto.radiosDto = new ArrayList<>();

        Print.log("Voulez vous ajouter un autre radio ? (y/n)");
        String saveRadois = scanner.nextLine();
        boolean isRadios = false;
        if (saveRadois.equals("y")){
            isRadios = true;
        }
        while (isRadios){
            RadioDto radioDto = new RadioDto();
            radioDto.description = Util.readString("Description",scanner);
            Print.log("Entre le prix de la radio : ");
            radioDto.prix =  scanner.nextFloat();
            Print.log("Entre l'id de la radio : ");
            radioDto.radioId = scanner.nextLong();
            //: add radio to list
            dossierDto.radiosDto.add(radioDto);
            Print.log("Voulez vous ajouter un autre radio ? (y/n)");
            String choice = Util.readString("Choix",scanner);
            if (choice.equals("n")){
                break;
            }
        }

        return this.dossierDto.radiosDto;
    }

    private List<ScannerDto> saveScanners() {
        this.dossierDto.scannersDto = new ArrayList<>();

        Print.log("Voulez vous ajouter un autre scanner ? (y/n)");
        String saveScanner = Util.readString("choice",scanner);
        boolean isScanners = false;
        if (saveScanner.equals("y")){
            isScanners= true;
        }
        while (isScanners){
            ScannerDto scannerDto = new ScannerDto();
            scannerDto.description = Util.readString("Description",scanner);
            Print.log("Entre le prix de la scanner : ");
            scannerDto.prix =  scanner.nextFloat();
            Print.log("Entre l'id de la scanner : ");
            scannerDto.scannerId = scanner.nextLong();
            //: add scanner to list
            dossierDto.scannersDto.add(scannerDto);
            Print.log("Voulez vous ajouter un autre scanner ? (y/n)");
            String choice = Util.readString("Choix",scanner);
            if (choice.equals("n")){
                break;
            }
        }
        return  this.dossierDto.scannersDto;
    }

    private List<AnalyseDto> saveAnalyses() {
        dossierDto.analysesDto = new ArrayList<>();
        List<AnalyseDto> analyseDtoList = new ArrayList<>();
        Print.log("Voulez vous ajouter un autre analyse ? (y/n)");
        String saveAnaylayse = scanner.nextLine();
        boolean isAnalyses = false;
        if (saveAnaylayse.equals("y")){
            isAnalyses = true;
        }
        while (isAnalyses){
            AnalyseDto analyseDto = new AnalyseDto();
            analyseDto.description = Util.readString("Description ",scanner);
            Print.log("Entre le prix de l'analyse : ");
            analyseDto.prix =  scanner.nextFloat();
            Print.log("Entre l'id de l'analyse : ");
            analyseDto.analyseId = scanner.nextLong();
            //: add analyse to list
            dossierDto.analysesDto.add(analyseDto);
            Print.log("Voulez vous ajouter un autre analyse ? (y/n)");
            String choice = Util.readString("Choix",scanner);
            if (choice.equals("n")){
                break;
            }
        }

        return analyseDtoList;
    }

    public List<MedicamentDto> saveMedicament(){
        List<MedicamentDto> medicamentDtoList = new ArrayList<>();
        MedicamentDto medicamentDto = new MedicamentDto();
        Print.log("Voulez vous ajouter un autre medicament ? (y/n)");
        scanner.nextLine();
        String addMedicament =scanner.nextLine();
        boolean isMedicamentSave = false;
        if (addMedicament.equals("y") ){
            isMedicamentSave = true;
        }
        while (isMedicamentSave){
            Print.log("Entre le code bar  de medicament");
            long codeBar = scanner.nextLong();
            Print.log("Entre la quantite de medicament");
            int quantite = scanner.nextInt();
            medicamentDto.codeBarre = codeBar;
            medicamentDto.quantite = quantite;

            //: add medicament to list
            medicamentDtoList.add(medicamentDto);

            Print.log("Voulez vous ajouter un autre medicament ? (y/n)");
            String choice = Util.readString("Choix",scanner);
            if (choice.equals("n")){
                break;
            }
        }
        return medicamentDtoList;
    }


}
