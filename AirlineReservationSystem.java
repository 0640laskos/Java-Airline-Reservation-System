package Assignment2;

import java.util.LinkedList;
import java.util.Scanner;


public class AirlineReservationSystem {
	
	static class Reservation {

		String flightNo;
		String personName;
		
		public Reservation(String flightNo, String personName) {
			this.flightNo = flightNo;
			this.personName = personName;
		}
	}


	 public static void main(String[] args)
	    {
	        LinkedList<Reservation> reservations = new LinkedList<>();
	        Scanner scanner = new Scanner(System.in);
	        
	        while(true) {
	        	System.out.println("1. Reserve a ticket");
	        	System.out.println("2. cancel reservation");
	        	System.out.println("3. check reservation");
	        	System.out.println("4. list all reservations");
	        	System.out.print("5. Exit");
	        
		        int choice = scanner.nextInt();
		        scanner.nextLine();
		        
		        switch (choice) {
	            case 1:
	                System.out.print("Enter the flight number: ");
	                String flightNo = scanner.nextLine();
	                System.out.print("Enter the Person Name: ");
	                String personName = scanner.nextLine();
	                Reservation newReservation = new Reservation(flightNo, personName);
	                reservations.add(newReservation);
	                System.out.println("Reservation is added successfully");
	                break;
	            case 2:
	                System.out.print("Enter Person Name to cancel reservation: ");
	                String cancelName = scanner.nextLine();
	                boolean canceled = false;
	                for (Reservation reservation : reservations) {
	                    if (reservation.personName.equalsIgnoreCase(cancelName)) {
	                        reservations.remove(reservation);
	                        canceled = true;
	                        System.out.println("Reservation is removed successfully");
	                        break;
	                    }   
	                    
	                    }
	                if(!canceled) {
	                	System.out.println("No reservation found");
	                }  
	                break;
	            case 3:
	                System.out.print("Enter Person Name to check reservation: ");
	                String checkName = scanner.nextLine();
	                for (Reservation reservation : reservations) {
	                    if (reservation.personName.equalsIgnoreCase(checkName)) {
	                        System.out.println("Flight exists");
	                        break;
	                    }
	                }
	                System.out.println("No flight is found");
	                break;
	
	            case 4:
	                System.out.println("List of all reservations:");
	                for (Reservation reservation : reservations) {
	                    System.out.println("Flight Number: " + reservation.flightNo + ", Person: " + reservation.personName);
	                }
	                break;
	
	            case 5:
	                System.out.println("Goodbye");
	                scanner.close();
	                System.exit(0);
	
	            default:
	                System.out.println("Invalid choice.");
	           
		        }
	        }
	    }
}
