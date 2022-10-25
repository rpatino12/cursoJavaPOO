package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {
    public static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println();
            System.out.println("Patient-Menu");
            System.out.println("Welcome " + UIMenu.patientLogged.getName());
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
                default:
                    System.out.println("Please select the correct option");
            }
        } while (response != 0);
    }

    private static void showBookAppointmentMenu(){
        int response = 0;
        do {
            if (UIDoctorMenu.getDoctorsAvailableAppointments().size() == 0){
                System.out.println();
                System.out.println("There is no available appointments");
                break;
            }
            System.out.println("::Book an appointment");
            System.out.println(":::Select date:");
            // Ahora vamos a buscar las fechas disponibles de los doctores que agendaron citas disponibles
            // Los objetos de tipo map siempre van a tener la siguiente composicion Map<Key, Value>
            // El primer elemento del Map (el key) va a almacenar la numeracion de la lista de fechas
            // El segundo elemento (el value) va a ser otro map y va a almacenar el indice de la fecha seleccionada por el paciente y el doctor que tiene citas disponibles para esa fecha
            // Y el objeto de tipo Map quedaria asi:
                // 1- Doctor x
                        // 1- Fecha1
                        // 2- Fecha2
                // 2- Doctor y
                // 3- Doctor z
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                // Ahora creamos un ArrayList 'availableAppointments' donde vamos a guardar las citas
                ArrayList<Doctor.AvailableAppointment> availableAppointments = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();

                // Aqui creamos el objeto de tipo Map 'doctorAppointments' el cual va a tener las fechas de las citas disponibles
                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();
                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    // Aqui con el metodo put agrego los datos al objeto map, los cuales son: la numeracion de las citas y las fechas disponibles
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    // Aqui agregamos la numeracion de los doctores y el map 'doctorAppointments' dentro del map 'doctors'
                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }

            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());

            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);

            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("", "");

            for (Map.Entry<Integer, Doctor> doctorDate :doctorAvailableSelected.entrySet()) {
                // Recorro el objeto map 'doctorAvailableSelected' y con los metodos .getKey() obtengo el indice de cada fecha y .getValue() obtengo el valor de la fecha
                indexDate = doctorDate.getKey();
                doctorSelected = doctorDate.getValue();
            }

            System.out.println(
                    doctorSelected.getName() +
                    ". Date " +
                    doctorSelected.getAvailableAppointments().get(indexDate).getDate() +
                    ". Time: " +
                    doctorSelected.getAvailableAppointments().get(indexDate).getTime()
            );

            System.out.println("Confirm your appointment: \n1. Yes \n2. Change Data");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1) {
                UIMenu.patientLogged.addAppointmentListDoctors(
                    doctorSelected,
                    doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                    doctorSelected.getAvailableAppointments().get(indexDate).getTime()
                );
                showPatientMenu();
                break;
            }

        } while (response != 0);
    }

    private static void showPatientMyAppointments(){
        int response = 0;
        do {
            System.out.println("::My Appointments");
            if (UIMenu.patientLogged.getAppointmentListDoctors().size() == 0){
                System.out.println("You don't have any appointments booked yet");
                break;
            }

            for (int i = 0; i < UIMenu.patientLogged.getAppointmentListDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". " +
                        "Date: " +
                        UIMenu.patientLogged.getAppointmentListDoctors().get(i).getDate() +
                        "Time: " +
                        UIMenu.patientLogged.getAppointmentListDoctors().get(i).getTime() +
                        "\nDoctor: " +
                        UIMenu.patientLogged.getAppointmentListDoctors().get(i).getDoctor().getName()
                        );
            }
            System.out.println("0. Return");
        } while (response != 0);
    }
}
