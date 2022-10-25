package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User{
    // Atributos de la clase hija
    private String birthday;
    private double weight;
    private double height;
    private String bloodType;

    private ArrayList<AppointmentDoctor> appointmentListDoctors = new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentListNurses = new ArrayList<>();

    public ArrayList<AppointmentDoctor> getAppointmentListDoctors() {
        return appointmentListDoctors;
    }

    public void addAppointmentListDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this, doctor);
        appointmentDoctor.schedule(date, time);
        appointmentListDoctors.add(appointmentDoctor);
    }

    public ArrayList<AppointmentNurse> getAppointmentListNurses() {
        return appointmentListNurses;
    }

    public void setAppointmentListNurses(ArrayList<AppointmentNurse> appointmentListNurses) {
        this.appointmentListNurses = appointmentListNurses;
    }

    // Constructores de la clase hija
    public Patient(){
        super();
        System.out.println("Construyendo el objeto paciente");
    }

    public Patient(String name, String email){
        super(name, email);
        // System.out.println("Construyendo el objeto paciente");
    }

    public Patient(String name, String email, String birthday, double weight) {
        super(name, email);
        this.birthday = birthday;
        this.weight = weight;
    }

    // Metodos Getters and Setters

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getWeight() {
        return weight + " kg.";
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height + " m.";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    // Aqui sobreescribimos el metodo toString de la clase padre model.User, que alli tambien fue sobreescrito y asi aplicamos Polimorfismo tambien
    @Override
    public String toString() {
        return super.toString() + "\n Birthday: " + birthday + "\n Weight: " + getWeight() + "\n Height: " + getHeight() + "\n Blood type: " + bloodType;
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente");
        System.out.println("Historial completo");
    }
}
