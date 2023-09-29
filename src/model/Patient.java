package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User{
    //Atributos
    static String birthday;
    private double weight;
    private double height;
    static String blood;
    private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentNurses = new ArrayList<>();
    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this, doctor);
        appointmentDoctor.schedule(date, time);
        appointmentDoctors.add(appointmentDoctor);
    }

    public ArrayList<AppointmentNurse> getAppointmentNurses() {
        return appointmentNurses;
    }

    public void setAppointmentNurses(ArrayList<AppointmentNurse> appointmentNurses) {
        this.appointmentNurses = appointmentNurses;
    }

    public Patient(String name, String email){
        super(name, email);
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public String getWeight(){
        return this.weight + "kg.";
    }

    public static String getBirthday() {
        return birthday;
    }

    public static void setBirthday(String birthday) {
        Patient.birthday = birthday;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public static String getBlood() {
        return blood;
    }

    public static void setBlood(String blood) {
        Patient.blood = blood;
    }

    @Override
    public String toString(){
        return super.toString() + "\nAge: " + birthday + "\nWeight: " + weight + "\nHeight: " + getHeight();
    }

    @Override
    public void showDatUser() {
        System.out.println("Paciente");
    }
}
