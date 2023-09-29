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
            System.out.println("\n");
            System.out.println("Patient");
            System.out.println("Welcome " + UIMenu.patientLogged.getName());
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            System.out.println("response " + response);

            switch (response) {
                case 1:
                    showBookAppointment();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    sc.close();
                    break;
            }
        }while(response != 0);
    }
    private static void showBookAppointment(){
        int response = 0;
        do {
            System.out.println("::Book appointment");
            System.out.println("::Select date");

            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointment.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments = UIDoctorMenu.doctorsAvailableAppointment.get(i).getAvailableAppointment();

                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();
                for (int j = 0; j < availableAppointments.size(); j++) {
                           k++;
                           System.out.println(k + ". " + availableAppointments.get(j).getDate());
                           doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointment.get(i));
                           doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("", "");

            for (Map.Entry<Integer, Doctor> doc:doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }
            System.out.println(doctorSelected.getName() + " Date: "+ doctorSelected.getAvailableAppointment().get(indexDate).getDate() + " Time: " + doctorSelected.getAvailableAppointment().get(indexDate).getTime());
            System.out.println("Confirm date appointment: \n1. Yes \n2. Change data");
            response = Integer.valueOf((sc.nextLine()));

            if(response == 1) {
                UIMenu.patientLogged.addAppointmentDoctors(doctorSelected, doctorSelected.getAvailableAppointment().get(indexDate).getDate(null), doctorSelected.getAvailableAppointment().get(indexDate).getTime());
                showPatientMenu();
            }

        }while(response != 0);
    }

    private static void showPatientMyAppointments(){
        int response = 0;
        do {
            System.out.println(":: My appointments");
            if(UIMenu.patientLogged.getAppointmentDoctors().size() == 0){
                System.out.println("You don't have any appointments");
                break;
            }
            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". " + "Date: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() + " Time: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime() + "\nDoctor: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName());
            }
            System.out.println("0. Return");
        }while(response != 0);

    }
}
