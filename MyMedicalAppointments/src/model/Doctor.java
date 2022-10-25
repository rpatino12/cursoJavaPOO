package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{
    // Atributos de la clase hija
    private String speciality;

    // Metodos (Comportamientos)

    // Metodos constructores, van a haber 2 (esto lo llamamos sobrecarga)
    // La sobrecarga de métodos consiste en crear diferentes funciones que, en realidad, hacen lo mismo, pero soportan diferentes tipos y cantidades de argumentos.
    // La sobrecarga de constructores es lo mismo, pero con constructores
    public Doctor(){
        super();
        System.out.println("Construyendo el objeto doctor");
    }

    public Doctor(String name, String email){
        super(name, email);
        // System.out.println("El nombre del doctor asignado es: " + name);
    }

    // Getters and setters

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    // Aqui aplicamos polimorfismo, sobreescribiendo otra vez el metodo toString
    @Override
    public String toString() {
        return super.toString() + "\nSpeciality: " + speciality + "\nAvailable: " + availableAppointments.toString();
    }

    // Como este metodo esta definido como abstracto en la clase padre User, es obligatorio implementarlo
    @Override
    public void showDataUser() {
        System.out.println("Hospital: Cruz Roja");
        System.out.println("Departamento: Oncologia");
    }

    // Clases anidadas

    // Despues de crear la clase anidada 'AvailableAppointment', vamos a crear un metodo al nivel de la clase 'Doctor' para añadir una cita para el doctor
    // Tambien creamos una coleccion de objetos de tipo 'AvailableAppointment'
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

    public void addAvailableAppointment(String date, String time) {
        // Agregamos las nuevas citas a la coleccion de objetos de tipo 'AvailableAppointment' con el metodo 'add', creando una instancia de citas disponibles con los argumentos de esta funcion 'addAvailableAppointment'
        availableAppointments.add(new AvailableAppointment(date, time));
    }

    // Y por ultimo creamos un metodo que me devuelve la lista de citas disponibles
    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }

    // Vamos a crear una clase que esta totalmente vinculada con la logica del doctor ya que solo el doctor puede agendar citas disponibles, por lo tanto se va a crear una clase anidada de tipo estatica
    public static class AvailableAppointment {
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");

        public AvailableAppointment(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate(String DATE) {
            return date;
        }

        public String getDate() {
            return format.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Available Appointments: \nDate: " + date + ", Time: " + time;
        }
    }
}

