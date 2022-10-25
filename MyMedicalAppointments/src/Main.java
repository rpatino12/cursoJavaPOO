// Nuestro proyecto en este curso es construir un sistema que nos permita listar y agendar nuestras citas médicas

// Al importar el paquete ui es importante utilizar la palabra reservada static
import model.Doctor;
import model.Patient;
import static ui.UIMenu.*;

import java.util.Calendar;
import java.util.Date;

public class Main {
    // El metodo main es indispensable para cualquier proyecto, ya que es el punto de entrada del programa

    public static void main(String[] args) {
        // Declaro el objeto myDoctor
    //    Doctor myDoctor;
        // Aqui sé instancia (inicializa) el objeto myDoctor
        // Usando el metodo constructor que no tiene argumentos
    //    myDoctor = new Doctor();
    //    myDoctor.setName("Guillermo Patino");

        // Usando el metodo constructor que tiene de argumento el nombre para inicializar el objeto
        // myDoctor = new model.Doctor("Ricardo");
    //    myDoctor.showName();
    //    myDoctor.showId();

        // Declaremos e inicializemos otra instancia de la clase Doctor
    //    Doctor myDoctor2 = new Doctor("Paulina Patino", "paulina@platzi.com");
    //    myDoctor2.showId();

        // Declaremos e inicializemos otra instancia de la clase Doctor
    //    Doctor myDoctor3 = new Doctor("Ricardo Patino", "ricardo@platzi.com");
    //    myDoctor3.showId();
    //    myDoctor3.setSpeciality("Cirujano");
    //    System.out.println(myDoctor3.getSpeciality());
    //    System.out.println(myDoctor3.getEmail());
    //    myDoctor3.showDataUser();

        //Vamos a agregarle unas nuevas citas al doctor 'Ricardo Patino'
    //    myDoctor3.addAvailableAppointment(new Date(2022, Calendar.AUGUST, 2), "4:00pm");
    //    myDoctor3.addAvailableAppointment(new Date(2022, Calendar.AUGUST, 2), "10:00am");
    //    myDoctor3.addAvailableAppointment(new Date(2022, Calendar.AUGUST, 8), "1:00pm");

        // Lo que sucede con este ciclo for es que recorre el ArrayList que devuelve el metodo 'getAvailableAppointments()' y esta lista contiene objetos de tipo 'AvailableAppointment'.
        // Por lo que en cada recorrido, se imprimen los metodos getters '.getDate' y '.getTime' de ese objeto "appointment"
        /*
        for (model.Doctor.AvailableAppointment appointment: myDoctor3.getAvailableAppointments()){
            System.out.println(appointment.getDate() + " " + appointment.getTime());
        }
        */

        // Aqui invocamos el metodo toString, ya que cuando imprimimos un objeto el metodo toString es llamado por defecto
    //    System.out.println(myDoctor3);

        // Vamos a crear una instancia de la clase Patient
    //    Patient myPatient = new Patient("Paola Montoya", "paola@platzi.com");
    //    myPatient.setWeight(45.23);
    //    System.out.println(myPatient.getWeight());
    //    myPatient.setPhoneNumber("3122467577");
    //    System.out.println(myPatient.getPhoneNumber());
    //    myPatient.showId();
    //    myPatient.showName();

        // Aqui declaramos e instanciamos (inicializamos) un objeto de la clase paciente

    //    Patient myPatient2 = new Patient("Chris", "chris@platzi.com", "January 2", 75.3);
    //    myPatient2.setPhoneNumber("3127831708");
    //    myPatient2.setAddress("Calle 123");

    //    System.out.println(myPatient2);
    //    myPatient2.showDataUser();

        // Aqui puedo llamar el metodo estatico showMenu() y de esta forma modularizar el código, no necesito llamarlo con el método punto (UIMenu.showMenu()) ya que inicialmente lo importe en la línea 6
        showMenu();
    }
}
