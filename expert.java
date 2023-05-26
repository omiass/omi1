package abhi1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class expert {
    // Define a Hospital class to represent each hospital
    static class Hospital {
        String name;
        String address;
        List<String> specialties;

        Hospital(String name, String address, List<String> specialties) {
            this.name = name;
            this.address = address;
            this.specialties = specialties;
        }
    }

    // Define a list of hospitals with their facilities and specialties
    static List<Hospital> hospitals = List.of(
    		new Hospital("CNS Hospital", "Nashik Road", List.of("Emergency Care", "Surgery", "Radiology", "Cardiology")),
            new Hospital("Brain Hospital", "College Road", List.of("Pediatrics", "Neurology", "Oncology")),
            new Hospital("Heart Hospital", "Amrutdham", List.of("Cardiology", "Heart Surgery", "Cardiac Rehabilitation")),
            new Hospital("Women's Hospital", "Jail Road", List.of("Obstetrics", "Gynecology", "Skin Health", "Fertility Services")),
            new Hospital("Eye Hospital", "Sharanpur Road", List.of("Ophthalmology", "Optometry")),
            new Hospital("Bone Hospital", "Satpur Colony", List.of("Orthopedics", "Physiotherapy")),
            new Hospital("Dental Hospital", "CIDCO", List.of("Dentistry", "Oral Surgery")),
            new Hospital("Psychiatric Hospital", "Gangapur Road", List.of("Psychiatry", "Counseling"))

    );

    // Define a function to search for hospitals based on a user's disease input
    static void searchHospitals(String disease) {
        disease = disease.toLowerCase(); // convert user input to lowercase
        System.out.println("Hospitals for " + disease + ":");
        for (Hospital hospital : hospitals) {
            for (String specialty : hospital.specialties) {
                if (specialty.toLowerCase().contains(disease)) { // convert specialty to lowercase and check for match
                    System.out.println(hospital.name + " - " + hospital.address);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Display all available hospitals and their facilities
        System.out.println("List of hospitals:");
        for (Hospital hospital : hospitals) {
            System.out.println(hospital.name);
            System.out.println("Address: " + hospital.address);
            System.out.print("Facilities: ");
            for (String specialty : hospital.specialties) {
                System.out.print(specialty + ", ");
            }
            System.out.println();
        }

        // Prompt the user to enter a disease and search for hospitals that treat it
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a disease to search for hospitals: ");
        String disease = scanner.nextLine();
        searchHospitals(disease);
    }
}
