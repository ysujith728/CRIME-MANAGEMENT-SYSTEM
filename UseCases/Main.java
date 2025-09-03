package UseCases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import Bean.*;
import Dao.CrimeDaoImp;
import Dao.CriminalDaoImp;
import Dao.VictimDaoImp;
import Dto.CrimesDoneByCriminalDto;
import Dto.CriminalArrestedDto;
import Dto.CriminalsCrimeDto;
import Dto.VictimsDto;
import Exceptions.*;


public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            CrimeDaoImp crimeDao = new CrimeDaoImp();
            CriminalDaoImp criminalDao = new CriminalDaoImp();
            VictimDaoImp victimDao = new VictimDaoImp();
            
            boolean exit = false;
            
            while (!exit) {
                try {
                    System.out.println("\n===== Crime Record =====");
                    System.out.println("1. Crime Section");
                    System.out.println("2. Criminal Section");
                    System.out.println("3. Victim Section");
                    System.out.println("0. Exit");
                    System.out.print("Enter your choice: ");
                    
                    int choice = getValidIntInput(sc, "");
                    switch (choice) {
                        case 1:
                            crimeManagement(sc, crimeDao);
                            break;
                        case 2:
                            criminalManagement(sc, criminalDao, crimeDao, victimDao);
                            break;
                        case 3:
                            victimManagement(sc, victimDao, crimeDao);
                            break;
                        case 0:
                            exit = true;
                            System.out.println("Thank you for using Crime Record !!");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } catch (Exception e) {
                    System.out.println("An unexpected error occurred: " + e.getMessage());
                }
            }
        } finally {
            sc.close();
        }
    }
    
    private static void crimeManagement(Scanner sc, CrimeDaoImp crimeDao) {
        boolean back = false;
        
        while (!back) {
            System.out.println("\n===== Crime Section =====");
            System.out.println("1. Register a new crime");
            System.out.println("2. View all crimes");
            System.out.println("3. View criminals by crime ID");
            System.out.println("4. Update crime details");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");
            
            int choice = getValidIntInput(sc, "");
            switch (choice) {
                case 1:
                    registerCrime(sc, crimeDao);
                    break;
                case 2:
                    viewAllCrimes(crimeDao);
                    break;
                case 3:
                    viewCriminalsByCrimeId(sc, crimeDao);
                    break;
                case 4:
                    updateCrimeDetails(sc, crimeDao);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void criminalManagement(Scanner sc, CriminalDaoImp criminalDao, CrimeDaoImp crimeDao, VictimDaoImp victimDao) throws CrimeExceptions {
        boolean back = false;
        
        while (!back) {
            System.out.println("\n===== Criminal Section =====");
            System.out.println("1. Register a new criminal");
            System.out.println("2. View all criminals");
            System.out.println("3. View crimes by criminal ID");
            System.out.println("4. View criminals by area of arrest");
            System.out.println("5. Update criminal details");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");
            
            int choice = getValidIntInput(sc, "");
            switch (choice) {
                case 1:
                    registerCriminal(sc, criminalDao, crimeDao, victimDao);
                    break;
                case 2:
                    viewAllCriminals(criminalDao);
                    break;
                case 3:
                    viewCrimesByCriminalId(sc, criminalDao);
                    break;
                case 4:
                    viewCriminalsByPoliceStation(sc, criminalDao);
                    break;
                case 5:
                    updateCriminalDetails(sc, criminalDao);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void victimManagement(Scanner sc, VictimDaoImp victimDao, CrimeDaoImp crimeDao) throws CrimeExceptions {
        boolean back = false;
        
        while (!back) {
            System.out.println("\n===== Victim Section =====");
            System.out.println("1. Register a new victim");
            System.out.println("2. View all victims");
            System.out.println("3. View victims by crime type");
            System.out.println("4. Update victim details");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");
            
            int choice = getValidIntInput(sc, "");
            switch (choice) {
                case 1:
                    registerVictim(sc, victimDao, crimeDao);
                    break;
                case 2:
                    viewAllVictims(victimDao);
                    break;
                case 3:
                    viewVictimsByCrimeType(sc, victimDao);
                    break;
                case 4:
                    updateVictimDetails(sc, victimDao);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static boolean isValidDate(String dateStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate inputDate = LocalDate.parse(dateStr, formatter);
            LocalDate currentDate = LocalDate.now();
            return !inputDate.isAfter(currentDate);
        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date format. Please use YYYY-MM-DD format.");
            return false;
        }
    }
    
    private static int getValidIntInput(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }
    
    private static void registerCrime(Scanner sc, CrimeDaoImp crimeDao) {
        System.out.println("\n===== Register a New Crime =====");
        int crimeId = getValidIntInput(sc, "Enter Crime ID: ");
        
        System.out.print("Enter Crime Type: ");
        String crimeType = sc.nextLine();
        if (crimeType.trim().isEmpty()) crimeType = "Unknown";
        
        System.out.print("Enter Description: ");
        String description = sc.nextLine();
        
        System.out.print("Enter Police Station Area: ");
        String psArea = sc.nextLine();
        
        String date;
        do {
            System.out.print("Enter Date (YYYY-MM-DD): ");
            date = sc.nextLine();
        } while (!isValidDate(date));
        
        Crime crime = new Crime(crimeId, crimeType, description, psArea, date, null);
        try {
            System.out.println(crimeDao.registerCrime(crime));
        } catch (CrimeExceptions e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void viewAllCrimes(CrimeDaoImp crimeDao) {
        System.out.println("\n===== All Crimes =====");
        try {
            crimeDao.getAllCrimes().forEach(System.out::println);
        } catch (CrimeExceptions e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void viewCriminalsByCrimeId(Scanner sc, CrimeDaoImp crimeDao) {
        System.out.println("\n===== View Criminals by Crime ID =====");
        int crimeId = getValidIntInput(sc, "Enter Crime ID: ");
        try {
            crimeDao.getCriminalsByCrimeId(crimeId).forEach(System.out::println);
        } catch (CrimeExceptions e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void updateCrimeDetails(Scanner sc, CrimeDaoImp crimeDao) {
        System.out.println("\n===== Update Crime Details =====");
        int crimeId = getValidIntInput(sc, "Enter Crime ID to update: ");
        
        System.out.print("Enter Crime Type: ");
        String crimeType = sc.nextLine();
        if (crimeType.trim().isEmpty()) crimeType = "Unknown";
        
        System.out.print("Enter Description: ");
        String description = sc.nextLine();
        
        System.out.print("Enter Police Station Area: ");
        String psArea = sc.nextLine();
        
        String date;
        do {
            System.out.print("Enter Date (YYYY-MM-DD): ");
            date = sc.nextLine();
        } while (!isValidDate(date));
        
        try {
            List<Crime> crimes = crimeDao.getAllCrimes();
            String victimId = crimes.stream()
                .filter(c -> c.getCrimeId() == crimeId)
                .findFirst()
                .map(Crime::getVictimId)
                .orElse(null);
            
            Crime crime = new Crime(crimeId, crimeType, description, psArea, date, victimId);
            System.out.println(crimeDao.updateCrimeDetails(crime));
        } catch (CrimeExceptions e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void registerCriminal(Scanner sc, CriminalDaoImp criminalDao, CrimeDaoImp crimeDao, VictimDaoImp victimDao) throws CrimeExceptions {
        System.out.println("\n===== Register a New Criminal =====");
        int criminalId = getValidIntInput(sc, "Enter Criminal ID: ");
        
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        if (name.trim().isEmpty()) name = "Unknown";
        
        int age = getValidIntInput(sc, "Enter Age: ");
        if (age < 0 || age > 120) age = 30;
        
        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();
        
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        
        System.out.print("Enter Identifying Mark: ");
        String identifyingMark = sc.nextLine();
        
        System.out.print("Enter Area of Arrest: ");
        String areaOfArrest = sc.nextLine();
        
        int crimeId;
        do {
            crimeId = getValidIntInput(sc, "Enter Crime ID (must exist): ");
            try {
                crimeDao.getAllCrimes();
                break;
            } catch (CrimeExceptions e) {
                System.out.println("Error: No crimes exist. Please register a crime first.");
                return;
            }
        } while (!crimeDao.getAllCrimes().stream().anyMatch(c -> c.getCrimeId() == crimeId));
        
        String crimeIdStr = String.valueOf(crimeId);
        Criminal criminal = new Criminal(criminalId, name, age, gender, address, identifyingMark, areaOfArrest, crimeIdStr);
        
        try {
            CriminalsCrimeDto dto = new CriminalsCrimeDto(crimeId, 
                crimeDao.getAllCrimes().stream()
                    .filter(c -> c.getCrimeId() == crimeId)
                    .findFirst()
                    .get()
                    .getCrimeType(),
                criminalId, name);
            CrimeDaoImp.addCriminalCrimeDto(dto);
            
            CrimesDoneByCriminalDto crimeDto = new CrimesDoneByCriminalDto(criminalId, name, crimeId,
                dto.getCrimeType(),
                crimeDao.getAllCrimes().stream()
                    .filter(c -> c.getCrimeId() == crimeId)
                    .findFirst()
                    .get()
                    .getDate());
            CriminalDaoImp.addCrimesDoneByCriminalDto(crimeDto);
            
            CriminalArrestedDto arrestDto = new CriminalArrestedDto(criminalId, name, areaOfArrest, 
                LocalDate.now().toString());
            CriminalDaoImp.addCriminalArrestedDto(arrestDto);
            
            System.out.println(criminalDao.registerCriminal(criminal));
        } catch (CriminalExceptions e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void viewAllCriminals(CriminalDaoImp criminalDao) {
        System.out.println("\n===== All Criminals =====");
        try {
            criminalDao.getAllCriminals().forEach(System.out::println);
        } catch (CriminalExceptions e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void viewCrimesByCriminalId(Scanner sc, CriminalDaoImp criminalDao) {
        System.out.println("\n===== View Crimes by Criminal ID =====");
        int criminalId = getValidIntInput(sc, "Enter Criminal ID: ");
        try {
            criminalDao.getCrimesByCriminalId(criminalId).forEach(System.out::println);
        } catch (CriminalExceptions e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void viewCriminalsByPoliceStation(Scanner sc, CriminalDaoImp criminalDao) {
        System.out.println("\n===== View Criminals by Area of Arrest =====");
        System.out.print("Enter Area Of Arrest: ");
        String policeStation = sc.nextLine().trim();  // Trim spaces
        
        try {
            List<CriminalArrestedDto> criminals = criminalDao.getCriminalsByPoliceStation(policeStation);
            
            if (criminals.isEmpty()) {
                System.out.println("No criminals found for the given area.");
            } else {
                criminals.forEach(System.out::println);
            }
        } catch (CriminalExceptions e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    
    private static void updateCriminalDetails(Scanner sc, CriminalDaoImp criminalDao) {
        System.out.println("\n===== Update Criminal Details =====");
        int criminalId = getValidIntInput(sc, "Enter Criminal ID to update: ");
        
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        if (name.trim().isEmpty()) name = "Unknown";
        
        int age = getValidIntInput(sc, "Enter Age: ");
        if (age < 0 || age > 120) age = 30;
        
        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();
        
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        
        System.out.print("Enter Identifying Mark: ");
        String identifyingMark = sc.nextLine();
        
        System.out.print("Enter Area of Arrest: ");
        String areaOfArrest = sc.nextLine();
        
        try {
            List<Criminal> criminals = criminalDao.getAllCriminals();
            String crimeId = criminals.stream()
                .filter(c -> c.getCriminalId() == criminalId)
                .findFirst()
                .map(Criminal::getCrimeId)
                .orElse(null);
            
            Criminal criminal = new Criminal(criminalId, name, age, gender, address, identifyingMark, areaOfArrest, crimeId);
            System.out.println(criminalDao.updateCriminalDetails(criminal));
        } catch (CriminalExceptions e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void registerVictim(Scanner sc, VictimDaoImp victimDao, CrimeDaoImp crimeDao) throws CrimeExceptions {
        System.out.println("\n===== Register a New Victim =====");
        int victimId = getValidIntInput(sc, "Enter Victim ID: ");
        
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        if (name.trim().isEmpty()) name = "Unknown";
        
        int age = getValidIntInput(sc, "Enter Age: ");
        if (age < 0 || age > 120) age = 30;
        
        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();
        
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        
        int crimeId;
        do {
            crimeId = getValidIntInput(sc, "Enter Crime ID (must exist): ");
            try {
                crimeDao.getAllCrimes();
                break;
            } catch (CrimeExceptions e) {
                System.out.println("Error: No crimes exist. Please register a crime first.");
                return;
            }
        } while (!crimeDao.getAllCrimes().stream().anyMatch(c -> c.getCrimeId() == crimeId));
        
        Victim victim = new Victim(victimId, name, age, gender, address);
        try {
            Crime crime = crimeDao.getAllCrimes().stream()
                .filter(c -> c.getCrimeId() == crimeId)
                .findFirst()
                .get();
            crime.setVictimId(String.valueOf(victimId));
            crimeDao.updateCrimeDetails(crime);
            
            VictimsDto dto = new VictimsDto(victimId, name, crime.getCrimeType(), crime.getDate());
            VictimDaoImp.addVictimsDto(dto);
            
            System.out.println(victimDao.registerVictim(victim));
        } catch (VictimExceptions | CrimeExceptions e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void viewAllVictims(VictimDaoImp victimDao) {
        System.out.println("\n===== All Victims =====");
        try {
            victimDao.getAllVictims().forEach(System.out::println);
        } catch (VictimExceptions e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void viewVictimsByCrimeType(Scanner sc, VictimDaoImp victimDao) {
        System.out.println("\n===== View Victims by Crime Type =====");
        System.out.print("Enter Crime Type: ");
        String crimeType = sc.nextLine();
        try {
            victimDao.getAllVictims().forEach(System.out::println);
        } catch (VictimExceptions e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void updateVictimDetails(Scanner sc, VictimDaoImp victimDao) {
        System.out.println("\n===== Update Victim Details =====");
        int victimId = getValidIntInput(sc, "Enter Victim ID to update: ");
        
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        if (name.trim().isEmpty()) name = "Unknown";
        
        int age = getValidIntInput(sc, "Enter Age: ");
        if (age < 0 || age > 120) age = 30;
        
        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();
        
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        
        Victim victim = new Victim(victimId, name, age, gender, address);
        try {
            System.out.println(victimDao.updateVictimDetails(victim));
        } catch (VictimExceptions e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}