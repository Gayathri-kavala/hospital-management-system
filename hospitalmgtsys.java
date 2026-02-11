package webDriver;
import java.util.*;

abstract class appointment{
	private int appointmentid;
	private String patientname;
	private double consultantfee;
	private final double GST_RATE = 0.18;
	
	public appointment(int appointmentid,String Patientname,double consultantfee) {
		this.appointmentid=appointmentid;
		this.patientname=patientname;
		this.consultantfee=consultantfee;
	}
	
	public int getappointmentid() {
		return appointmentid;
	}
	public String getpatientname() {
		return patientname;
	}
	public double getconsultantfee() {
		return consultantfee;
	}
	
	public abstract double diagnosticCharge();
	
	public double gst() {
		return(consultantfee + diagnosticCharge()) * GST_RATE;
	}
	
	public double calculateTotalBill() {
        return consultantfee + diagnosticCharge() + gst();
    }

	public void display() {
        System.out.println("\n------ Appointment Bill ------");
        System.out.println("Appointment ID   : " + appointmentid);
        System.out.println("Patient Name     : " + patientname);
        System.out.println("Consultant Fee   : " + consultantfee);
        System.out.println("Diagnostic Charge: " + diagnosticCharge());
        System.out.println("GST (18%)        : " + gst());
        System.out.println("Total Bill       : " + calculateTotalBill());
        System.out.println("------------------------------");
    }
}

class GeneralDoctor extends appointment{
	public GeneralDoctor(int appointmentid, String patientname, double consultantfee) {
        super(appointmentid, patientname, consultantfee);
    }
	
	@Override
    public double diagnosticCharge() {
        return 300; // fixed diagnostic charge
    }
}

class SpecialistDoctor extends appointment {

    public SpecialistDoctor(int appointmentid, String patientname, double consultantfee) {
        super(appointmentid, patientname, consultantfee);
    }

    @Override
    public double diagnosticCharge() {
        return 700; // fixed diagnostic charge
    }
}

class SurgeonDoctor extends appointment {

    public SurgeonDoctor(int appointmentid, String patientname, double consultantfee) {
        super(appointmentid, patientname, consultantfee);
    }

    @Override
    public double diagnosticCharge() {
        return 1500; // fixed diagnostic charge
    }
}
	



public class HospitalAppoitmentApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===== Hospital Appointment & Billing System =====");

        System.out.print("Enter Appointment ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Consultant Fee: ");
        double fee = sc.nextDouble();
		
        System.out.println("\nChoose Doctor Type:");
        System.out.println("1. General Doctor");
        System.out.println("2. Specialist Doctor");
        System.out.println("3. Surgeon Doctor");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        
        appointment app = null;
        
        switch(choice) {
        case 1:
        	app = new GeneralDoctor(id,name,fee);
        	break;
        case 2:
        	app = new SpecialistDoctor(id,name,fee);
        	break;
        case 3:
        	app = new SurgeonDoctor(id,name,fee);
        	break;
        	
        default:
        	System.out.println("invalidchoice");
        	System.out.println(0);
        }
        app.display();
        
        sc.close();


	}

}
