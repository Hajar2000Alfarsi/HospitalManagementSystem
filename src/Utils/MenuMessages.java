package Utils;

public class MenuMessages {
    public static String MAIN_MENU_MESSAGE = """
            Hospital Menu 
            1. Patients Management
            2. Doctors Management
            3. Nurses Management
            4. Appointments Management
            5. Medical Records Management
            6. Departments Management
            7. Reports and Statistics
            8. Exit
             """;

    public static String PATIENT_MENU_MESSAGE = """
            Patient Menu 
            1. Register New Patient
            2. Register InPatient
            3. Register OutPatient
            4. Register Emergency Patient
            5. View All Patients
            6. Search Patient
            7. Update Patient Information
            8. Remove Patient
            9. View Patient Medical History
            10. Exit
            """;

    public static String DOCTOR_MENU_MESSAGE = """
            Doctor Menu 
            1.  Add Doctor
            2.  Add Surgeon
            3.  Add Consultant
            4.  Add General Practitioner
            5.  View All Doctors
            6.  Search Doctor by Specialization
            7.  View Available Doctors
            8.  Assign Patient to Doctor
            9.  Update Doctor Information
            10. Remove Doctor
            11. Exit
             """;

    public static String NURSE_MENU_MESSAGE = """
            Nurse Menu 
            1. Add Nurse
            2. View All Nurses
            3. View Nurses by Department
            4. View Nurses by Shift
            5. Assign Nurse to Patient
            6.  Update Nurse Information
            7. Remove Nurse
            8. Exit
             """;

    public static String MEDICAL_RECORD_MENU_MESSAGE = """
            Medical Record Menu 
            1. Create Medical Record
            2. View All Records
            3. View Records by Patient
            4. View Records by Doctor
            5. Update Medical Record
            6.  Delete Medical Record
            7. Generate Patient History Report
            8. Exit
             """;

    public static String APPOINTMENT_MENU_MESSAGE = """
            Appointment Menu 
            1.  Schedule New Appointment
            2.  View All Appointments
            3.  View Appointments by Patient
            4.  View Appointments by Doctor
            5.  View Appointments by Date
            6.  Reschedule Appointment
            7.  Cancel Appointment
            8.  Complete Appointment
            9.  View Upcoming Appointments
            10. Exit
           """;

    public static String Department_MENU_MESSAGE = """
            Department Menu 
            1. Add Departments
            2. View All Departments
            3. View Department Details
            4. Assign Doctor to Department
            5. Assign Nurse to Department
            6. Update Department Information
            7. View Department Statistics
            8. Exit
            """;

    public static String REPORT_AND_STATICS_MENU_MESSAGE = """
            Reports and Statistics Menu
            1. Daily Appointments Report
            2. Doctor Performance Report
            3. Department Occupancy Report
            4. Patient Statistics
            5. Emergency Cases Report
            6. Exit
            """;
}
