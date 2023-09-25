package ma.yc.GUI;

import ma.yc.core.Print;
import ma.yc.core.Util;
import ma.yc.dto.AgentDto;
import ma.yc.dto.DossierDto;
import ma.yc.enums.statusDossier;
import ma.yc.model.*;
import ma.yc.service.AgentService;
import ma.yc.service.DossierService;
import ma.yc.service.impl.AgentServiceImpl;
import ma.yc.service.impl.DossierServiceImpl;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainAgentGUI implements DisplayGUI {

    private AgentService agentService;
    private DossierService dossierService;
    private boolean isAuthentificated = false;
    private Scanner scanner ;
    private AgentDto agentDto;
    public MainAgentGUI() {
        this.agentService = new AgentServiceImpl();
        this.dossierService = new DossierServiceImpl();
        this.agentDto = new AgentDto();
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
                sendMail(code, "code","hay.anas.336@gmail.com");
            }else {
                System.out.println("Ops");
            }
        }else {
            System.out.println(email + " is not a valid email address.");

        }

        //todo : something went worng password or email are not correct .

        return 0;
    }
    public static void desplayValidateCode(Scanner scanner,AgentDto agentDto){
        String codeVerification = Util.readString("code",scanner);
        agentDto.codeVerification = codeVerification;
        this.
    }


    void verifyCodeVerification( ){
        //if the authentification is successful then show the admin dashboard
        Print.log("Send the verification code to your email");
        String code = Util.readString("Code",scanner);

        boolean isCodeVerified = this.agentService.verifyCodeVerification(code);
        if (isCodeVerified){
            this.AgentDashboard();
        }else {
            //todo : something went worng the code is not correct .
        }
    }

    private void AgentDashboard( ) {
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
        //todo : the consulterDossiers function must return List of DossierDto
//        List<DossierDto> dossierDtoList = this.dossierService.consulterDossiers();
        //todo:stream data and map it to be more nice to be seen

    }

    private void consultDossier( ) {
        //todo : ask about the dossier id and show it
        //todo : ask about dossier :code_bar
         Print.log("Entre le code bar de votre dossier");
         String code_bar = Util.readString("Code bar",scanner);
         this.dossierService.consulterDossier();
    }

    private void changeDossierStatus( ) {
        //todo : ask about the dossier id and the new status and update it
        Print.log("Entre le num dossier de votre dossier");
        String code_bar = Util.readString("num_dossier",scanner);
        Print.log("Entre le nouveau status");
        String status = Util.readString("Status",scanner);

        DossierDto dossierDto = new DossierDto();
        dossierDto.num_dossier = code_bar;
        //TODO : CONVERT THE STRING TO ENUM
//        dossierDto.status = "En_attend";
        this.dossierService.suiviEtatDossier("");

    }

    private void addDossier( ) {
        //todo : ask about the dossier information and add it
        Print.log("Entre le matricule de votre patient");
        String matricule = Util.readString("Matricule",scanner);
        //todo : first i need to verify the patient matircule if it exist or not
        if (true)
        {
            Print.log("Matricule does not exist");
            return;
        }
        //todo : if the matricule exist then add the dossier
        DossierDto dossierDto = new DossierDto();
        dossierDto.matricule = matricule ;
        Print.log("Entre le num dossier de votre dossier");
        Print.log("");
        String num_dossier = Util.readString("Num dossier",scanner);
        Print.log("Entre le status de votre dossier");
        statusDossier status = statusDossier.En_attend;
        dossierDto.status = status;

        //todo: ask about ficher one ficher


        //todo: ask about medicaments  list;

        //todo: ask about analyses list;

        //todo : ask about scanners list;

        //todo : ask about radios list;

        //todo : ask about visits list ;

        //todo:save dossier
        this.dossierService.enregistrerDossier(dossierDto);
        //todo:call service to count amomunt .... totalRemboursement


        //todo : show totalRemboursement

//        private Fichier fichier;
//        private List<Medicament> medicaments;
//        private List<Analyse> analyses;
//        private List<ma.yc.model.Scanner> scanners;
//        private List<Radio> radios;
//        private List<Visite> visites;




    }


}
