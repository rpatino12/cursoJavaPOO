package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

// Para no estar creando instancias de tipo ui.UIMenu, es una buena practica crear metodos estaticos dentro de la clase ui.UIMenu

public class UIMenu {
    // Como esta variable de meses no cambia sería una constante, por lo tanto utilizamos la palabra reservada 'final' y su nombre sería en mayusculas
    // La palabra reservada 'final' solo se usa para constantes y por lo general va de la mano con static
    public static final String[] MONTHS = {
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    };

    // Aqui creamos una variable global para que maneje el doctor o el paciente logeado
    public static Doctor doctorLogged;
    public static Patient patientLogged;

    public static void showMenu(){
        System.out.println();
        System.out.println("Welcome to My Appointments");
        System.out.println("Select the desired option:");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Exit");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    response = 0;
                    System.out.println("Doctor");
                    authenticateUser(1);
                    break;
                case 2:
                    response = 0;
                    System.out.println("Patient");
                    authenticateUser(2);
                    break;
                case 0:
                    System.out.println("Thank you for your visit, come back soon!");
                    break;
                default:
                    System.out.println("Please select the correct option");
            }
        } while (response != 0);
    }

    // Como para la logica del programa la clase UIMenu es estatica todos los metodos de la clase deben ser estaticos, ya que esta clase no va a ser instanciada
    private static void authenticateUser(int userType){
        // userType == 1 : Doctor
        // userType == 2 : Patient
        // userType == 3 : Nurse

        // Vamos a crear un ArrayList para guardar la lista de usuarios registrados, simulando que ya tenemos varios usuarios registrados
        ArrayList<Doctor> doctorsList = new ArrayList<>();
        doctorsList.add(new Doctor("Ricardo Patino", "ricardo@mail.com"));
        doctorsList.add(new Doctor("Paola Montoya", "paola@mail.com"));
        doctorsList.add(new Doctor("Guillermo Patino", "guillermo@mail.com"));
        doctorsList.add(new Doctor("Paulina Patino", "paulina@mail.com"));

        // Aqui creamos una lista de pacientes
        ArrayList<Patient> patientsList = new ArrayList<>();
        patientsList.add(new Patient("Laura Oquendo", "laura@mail.com"));
        patientsList.add(new Patient("Alejandro Sierra", "alejandro@mail.com"));
        patientsList.add(new Patient("Chris Wasil", "chris@mail.com"));
        patientsList.add(new Patient("Simon Londono", "simon@mail.com"));

        boolean emailCorrect = false;

        do {
            System.out.println("Insert your email: [email@mail.com]");
            System.out.println("Or type 'exit' to go back");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if (email.equals("Exit") || email.equals("exit")) {
                showMenu();
                break;
            } else {
                if (userType == 1) {
                    for (Doctor d: doctorsList){
                        if (d.getEmail().equals(email)){
                            emailCorrect = true;
                            // Obtener el usuario logeado, que va a ser el que hizo match con el mail que habia en la lista de doctores
                            doctorLogged = d;
                            // Mostrar el menu del doctor
                            UIDoctorMenu.showDoctorMenu();
                        }
                    }
                }
                if (userType == 2) {
                    for (Patient p: patientsList){
                        if (p.getEmail().equals(email)){
                            emailCorrect = true;
                            // Obtener el usuario logeado, que va a ser el que hizo match con el mail que habia en la lista de pacientes
                            patientLogged = p;
                            // Mostrar el menu del paciente
                            UIPatientMenu.showPatientMenu();
                        }
                    }
                }
            }
        } while (!emailCorrect);
    }
}
