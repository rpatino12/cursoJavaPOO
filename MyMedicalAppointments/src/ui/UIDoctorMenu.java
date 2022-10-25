package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {

    // Vamos a crear un arraylist solo con los doctores que asignaron citas disponibles en su agenda
    public static ArrayList<model.Doctor> doctorsAvailableAppointments = new ArrayList<>();

    public static void showDoctorMenu(){
        int response = 0;
        do {
            System.out.println("\n");
            System.out.println("Doctor-Menu");
            System.out.println("Welcome " + UIMenu.doctorLogged.getName());
            System.out.println("1. Add available appointment");
            System.out.println("2. My Scheduled appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    response = 0;
                    showAddAvailableAppointmentMenu();
                    break;
                case 2:
                    System.out.println(getDoctorsAvailableAppointments());
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
                default:
                    System.out.println("Please select the correct option");
            }
        } while (response != 0);
    }

    private static void showAddAvailableAppointmentMenu(){
        int response = 0;
        do {
            System.out.println();
            System.out.println("::Add available appointment");
            System.out.println(":::Select a month");

            for (int i = 0; i < 3; i++) {
                int j = i + 1;
                System.out.println(j + ". " + UIMenu.MONTHS[i]);
            }
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if (response > 0 && response < 4){
                // Opciones 1, 2, 3
                int selectedMonth = response;
                System.out.println("You choose this month: " + selectedMonth + ". " + UIMenu.MONTHS[selectedMonth - 1]);
                System.out.println("Insert an available date: [dd/mm/yyyy]");
                String date = sc.nextLine();

                System.out.println("Your date is: " + date + "\n1. Correct \n2. Modify date");
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2){
                    continue;
                }

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Insert the time available for date: " + date + " [hh:mm]");
                    time = sc.nextLine();
                    System.out.println("Your time is: " + time + "\n1. Correct \n2. Modify time");
                    responseTime = Integer.valueOf(sc.nextLine());
                } while (responseTime != 1);

                UIMenu.doctorLogged.addAvailableAppointment(date, time);
                // Una vez que todos los datos sean correctos, se almacenaran las citas en el arreglo 'doctorsAvailableAppointments' gracias al metodo 'checkDoctorAvailableAppointment'
                checkDoctorAvailableAppointment(UIMenu.doctorLogged);
                continue;

            } else if (response == 0) {
                showDoctorMenu();
            }
        } while (response != 0);
    }

    private static void checkDoctorAvailableAppointment(Doctor doctor){
        // Aqui vamos a validar si el doctor tiene citas, es decir, ese array que me devuelve el metodo 'getAvailableAppointments()' es mayor que cero y ademas verificar que el array 'doctorsAvailableAppointments' no contenga a ese doctor, y asi poder agregarlo
        if (doctor.getAvailableAppointments().size() > 0 && !doctorsAvailableAppointments.contains(doctor)){
            doctorsAvailableAppointments.add(doctor);
        }
    }

    public static ArrayList<Doctor> getDoctorsAvailableAppointments() {
        return doctorsAvailableAppointments;
    }
}
