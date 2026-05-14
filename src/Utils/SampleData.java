package Utils;

import Entites.*;
import service.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SampleData {


    public static void populateData() {
        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        NurseService nurseService = new NurseService();
        DepartmentService departmentService = new DepartmentService();
        AppointmentService appointmentService = new AppointmentService();
        MedicalRecordService medicalRecordService = new MedicalRecordService();

        Patients p1 = new Patients(
                "12345678",
                "Ahmed",
                "Ali",
                LocalDate.of(2000,5,10),
                "Male",
                "91234567",
                "ahmed@gmail.com",
                "Muscat",
                "PAT001",
                new ArrayList<>(),
                new ArrayList<>(),
                "INS001",
                "99887766",
                LocalDate.now(),
                List.of("Penicillin"),
                "O+"
        );

        Patients p2 = new Patients(
                "1002",
                "Sara",
                "Khalid",
                LocalDate.of(1999, 3, 15),
                "Female",
                "90000002",
                "sara@gmail.com",
                "Seeb",
                "PAT002",
                new ArrayList<>(),
                new ArrayList<>(),
                "INS1002",
                "99880022",
                LocalDate.now(),
                List.of("Dust Allergy"),
                "O+"
        );

        InPatient p3 = new InPatient(
                "1003",
                "Omar",
                "Hassan",
                LocalDate.of(1995, 7, 20),
                "Male",
                "90000003",
                "omar@gmail.com",
                "Muscat",
                "PAT003",

                new ArrayList<>(),
                new ArrayList<>(),

                "INS1003",
                "99880033",
                LocalDate.now(),
                List.of("Diabetes"),
                "B+",

                LocalDate.now(),        // admissionDate
                null,                  // dischargeDate (still admitted)
                "Room 101",            // roomNumber
                "Bed 1",               // bedNumber
                "DOC001",              // admittingDoctorId
                120.0                  // dailyCharges
        );

        InPatient p4 = new InPatient(
                "1004",
                "Mariam",
                "Saif",
                LocalDate.of(2002, 11, 5),
                "Female",
                "90000004",
                "mariam@gmail.com",
                "Seeb",
                "PAT004",

                new ArrayList<>(),
                new ArrayList<>(),

                "INS1004",
                "99880044",
                LocalDate.now(),
                List.of("Asthma"),
                "A-",

                LocalDate.now(),        // admissionDate
                null,                  // dischargeDate
                "Room 202",            // roomNumber
                "Bed 2",               // bedNumber
                "DOC002",              // admittingDoctorId
                150.0                  // dailyCharges
        );

        OutPatient p5 = new OutPatient(
                "1005",                      // id
                "Youssef",                   // firstName
                "Salim",                     // lastName
                LocalDate.of(1998, 1, 12),   // dateOfBirth
                "Male",                      // gender
                "90000005",                  // phoneNumber
                "youssef@gmail.com",        // email
                "Barka",                     // address
                "PAT005",                    // patientId
                new ArrayList<>(),           // medicalRecords
                new ArrayList<>(),           // appointments
                "INS1005",                   // insuranceId
                "99880055",                  // emergencyContact
                LocalDate.now(),             // registrationDate
                List.of("None"),            // allergies
                "O-",                       // bloodGroup
                LocalDate.of(2026, 1, 10),   // lastVisitDate
                "DOC101",                    // preferredDoctorId
                3                            // visitCount
        );

        OutPatient p6 = new OutPatient(
                "1006",
                "Noor",
                "Ahmed",
                LocalDate.of(2003, 9, 18),
                "Female",
                "90000006",
                "noor@gmail.com",
                "Muscat",
                "PAT006",
                new ArrayList<>(),
                new ArrayList<>(),
                "INS1006",
                "99880066",
                LocalDate.now(),
                List.of("Migraine"),
                "B-",
                LocalDate.of(2026, 2, 5),
                "DOC202",
                1
        );

        EmergencyPatient p7 = new EmergencyPatient(
                "1007",
                "Khalid",
                "Nasser",
                LocalDate.of(1990, 4, 2),
                "Male",
                "90000007",
                "khalid@gmail.com",
                "Muscat",
                "PAT007",
                new ArrayList<>(),
                new ArrayList<>(),
                "INS1007",
                "99880077",
                LocalDate.now(),
                List.of("Heart Condition"),
                "AB+",
                LocalDate.now(),      // admissionDate
                null,                 // dischargeDate
                "ER-01",              // roomNumber
                "B-01",               // bedNumber
                "DOC123",             // admittingDoctorId
                120.0,                // dailyCharges
                "Critical",           // emergencyType
                "Ambulance",          // arrivalMode
                5,                    // triageLevel
                true                  // admittedViaER
        );


        EmergencyPatient p8 = new EmergencyPatient(
                "1008",
                "Laila",
                "Hamed",
                LocalDate.of(1997, 12, 25),
                "Female",
                "90000008",
                "laila@gmail.com",
                "Seeb",
                "PAT008",
                new ArrayList<>(),
                new ArrayList<>(),
                "INS1008",
                "99880088",
                LocalDate.now(),
                List.of("Accident Injury"),
                "A+",

                LocalDate.now(),      // admissionDate
                null,                 // dischargeDate (still admitted)
                "ER-02",              // roomNumber
                "B-05",              // bedNumber
                "DOC456",             // admittingDoctorId
                150.0,                // dailyCharges
                "Critical",           // emergencyType
                "Ambulance",          // arrivalMode
                4,                    // triageLevel
                true                  // admittedViaER
        );


        Patients p9 = new Patients(
                "1009",
                "Ali",
                "Rashid",
                LocalDate.of(2000, 6, 30),
                "Male",
                "90000009",
                "ali9@gmail.com",
                "Bowsher",
                "PAT009",
                new ArrayList<>(),
                new ArrayList<>(),
                "INS1009",
                "99880099",
                LocalDate.now(),
                List.of("None"),
                "B+"
        );

        Patients p10 = new Patients(
                "1010",
                "Huda",
                "Saleh",
                LocalDate.of(2004, 2, 14),
                "Female",
                "90000010",
                "huda@gmail.com",
                "Muscat",
                "PAT010",
                new ArrayList<>(),
                new ArrayList<>(),
                "INS1010",
                "99880100",
                LocalDate.now(),
                List.of("Peanut Allergy"),
                "O+"
        );


        patientService.add(p1);
        patientService.add(p2);
        patientService.add(p3);
        patientService.add(p4);
        patientService.add(p5);
        patientService.add(p6);
        patientService.add(p7);
        patientService.add(p8);
        patientService.add(p9);
        patientService.add(p10);


        GeneralPractitioner d1 = new GeneralPractitioner(
                "1",
                "Ali",
                "Hassan",
                LocalDate.of(1985, 5, 10),
                "Male",
                "90000001",
                "ali@gp.com",
                "Muscat",
                "DOC001",
                new ArrayList<>(),
                new ArrayList<>(),
                20.0,
                "DEP001",
                10,
                "MBBS",
                "General Practitioner",
                true,
                true,
                true
        );

        GeneralPractitioner d2 = new GeneralPractitioner(
                "2",
                "Sara",
                "Khalid",
                LocalDate.of(1990, 3, 12),
                "Female",
                "90000002",
                "sara@gp.com",
                "Seeb",
                "DOC002",
                new ArrayList<>(),
                new ArrayList<>(),
                25.0,
                "DEP001",
                7,
                "MBBS",
                "General Practitioner",
                true,
                false,
                true
        );

        Surgeon d3 = new Surgeon(
                "3",
                "Omar",
                "Youssef",
                LocalDate.of(1980, 7, 20),
                "Male",
                "90000003",
                "omar@surgeon.com",
                "Muscat",
                "DOC003",
                new ArrayList<>(),
                new ArrayList<>(),
                100.0,
                "DEP002",
                15,
                "MD",
                "Surgeon",
                120,
                List.of("Cardiac Surgery", "Trauma"),
                true
        );

        Surgeon d4 = new Surgeon(
                "4",
                "Lina",
                "Hamed",
                LocalDate.of(1983, 11, 5),
                "Female",
                "90000004",
                "lina@surgeon.com",
                "Barka",
                "DOC004",
                new ArrayList<>(),
                new ArrayList<>(),
                120.0,
                "DEP002",
                12,
                "MD",
                "Surgeon",
                90,
                List.of("Orthopedic Surgery"),
                true
        );


        Consultant d5 = new Consultant(
                "5",
                "Nasser",
                "Ali",
                LocalDate.of(1978, 2, 14),
                "Male",
                "90000005",
                "nasser@consult.com",
                "Muscat",
                "DOC005",
                new ArrayList<>(),
                new ArrayList<>(),
                80.0,
                "DEP003",
                18,
                "MD",
                "Consultant",
                List.of("Cardiology", "Internal Medicine"),
                true,
                30
        );


        Consultant d6 = new Consultant(
                "6",
                "Huda",
                "Said",
                LocalDate.of(1982, 6, 18),
                "Female",
                "90000006",
                "huda@consult.com",
                "Seeb",
                "DOC006",
                new ArrayList<>(),
                new ArrayList<>(),
                90.0,
                "DEP003",
                14,
                "MD",
                "Consultant",
                List.of("Neurology"),
                false,
                45
        );

        GeneralPractitioner d7 = new GeneralPractitioner(
                "7",
                "Salim",
                "Rashid",
                LocalDate.of(1992, 9, 9),
                "Male",
                "90000007",
                "salim@gp.com",
                "Sohar",
                "DOC007",
                new ArrayList<>(),
                new ArrayList<>(),
                30.0,
                "DEP001",
                5,
                "MBBS",
                "General Practitioner",
                true,
                true,
                false
        );

        Surgeon d8 = new Surgeon(
                "8",
                "Mariam",
                "Saif",
                LocalDate.of(1986, 12, 25),
                "Female",
                "90000008",
                "mariam@surgeon.com",
                "Muscat",
                "DOC008",
                new ArrayList<>(),
                new ArrayList<>(),
                150.0,
                "DEP002",
                16,
                "MD",
                "Surgeon",
                200,
                List.of("Neurosurgery", "General Surgery"),
                true
        );

        doctorService.add(d1);
        doctorService.add(d2);
        doctorService.add(d3);
        doctorService.add(d4);
        doctorService.add(d5);
        doctorService.add(d6);
        doctorService.add(d7);
        doctorService.add(d8);


        Nurses n1 = new Nurses(
                "1",
                "Fatma",
                "Al-Harthy",
                LocalDate.of(1995, 3, 12),
                "Female",
                "90001001",
                "fatma@nurse.com",
                "Muscat",
                "DEP001",
                "NUR001",
                "Morning",
                "Bachelor Nursing",
                new ArrayList<>()
        );

        Nurses n2 = new Nurses(
                "2",
                "Salma",
                "Khalid",
                LocalDate.of(1992, 7, 18),
                "Female",
                "90001002",
                "salma@nurse.com",
                "Seeb",
                "DEP002",
                "NUR002",
                "Night",
                "Diploma Nursing",
                new ArrayList<>()
        );

        Nurses n3 = new Nurses(
                "3",
                "Aisha",
                "Saeed",
                LocalDate.of(1990, 11, 5),
                "Female",
                "90001003",
                "aisha@nurse.com",
                "Barka",
                "DEP001",
                "NUR003",
                "Evening",
                "Bachelor Nursing",
                new ArrayList<>()
        );

        Nurses n4 = new Nurses(
                "4",
                "Mona",
                "Hassan",
                LocalDate.of(1996, 1, 25),
                "Female",
                "90001004",
                "mona@nurse.com",
                "Muscat",
                "DEP003",
                "NUR004",
                "Morning",
                "RN Certified",
                new ArrayList<>()
        );


        Nurses n5 = new Nurses(
                "5",
                "Zainab",
                "Ali",
                LocalDate.of(1993, 9, 9),
                "Female",
                "90001005",
                "zainab@nurse.com",
                "Sohar",
                "DEP002",
                "NUR005",
                "Night",
                "Bachelor Nursing",
                new ArrayList<>()
        );

        nurseService.add(n1);
        nurseService.add(n2);
        nurseService.add(n3);
        nurseService.add(n4);
        nurseService.add(n5);


        Departments dep1 = new Departments(
                "DEP001",
                new ArrayList<>(),   // doctors (will assign later)
                "General Medicine",
                "DOC001",
                new ArrayList<>(),   // nurses
                50,
                30
        );


        Departments dep2 = new Departments(
                "DEP002",
                new ArrayList<>(),
                "Surgery",
                "DOC003",
                new ArrayList<>(),
                40,
                20
        );


        Departments dep3 = new Departments(
                "DEP003",
                new ArrayList<>(),
                "Cardiology",
                "DOC005",
                new ArrayList<>(),
                35,
                15
        );

        departmentService.add(dep1);
        departmentService.add(dep2);
        departmentService .add(dep3);


        Appointments a1 = new Appointments(
                "APP001", "DOC001", "PAT001",
                LocalDate.of(2026, 1, 10),
                "09:00 AM",
                "Scheduled",
                "General checkup",
                ""
        );

        Appointments a2 = new Appointments(
                "APP002", "DOC002", "PAT002",
                LocalDate.of(2026, 1, 11),
                "10:00 AM",
                "Scheduled",
                "Flu symptoms",
                ""
        );

        Appointments a3 = new Appointments(
                "APP003", "DOC003", "PAT003",
                LocalDate.of(2026, 1, 12),
                "11:30 AM",
                "Scheduled",
                "Surgery consultation",
                ""
        );

        Appointments a4 = new Appointments(
                "APP004", "DOC004", "PAT004",
                LocalDate.of(2026, 1, 13),
                "01:00 PM",
                "Completed",
                "Post surgery follow-up",
                ""
        );

        Appointments a5 = new Appointments(
                "APP005", "DOC005", "PAT005",
                LocalDate.of(2026, 1, 14),
                "02:00 PM",
                "Scheduled",
                "Heart checkup",
                ""
        );

        Appointments a6 = new Appointments(
                "APP006", "DOC006", "PAT006",
                LocalDate.of(2026, 1, 15),
                "03:00 PM",
                "Cancelled",
                "Neurology consultation",
                ""
        );

        Appointments a7 = new Appointments(
                "APP007", "DOC007", "PAT007",
                LocalDate.of(2026, 1, 16),
                "09:30 AM",
                "Scheduled",
                "Routine check",
                ""
        );

        Appointments a8 = new Appointments(
                "APP008", "DOC008", "PAT008",
                LocalDate.of(2026, 1, 17),
                "10:15 AM",
                "Scheduled",
                "Surgery follow-up",
                ""
        );

        Appointments a9 = new Appointments(
                "APP009", "DOC001", "PAT009",
                LocalDate.of(2026, 1, 18),
                "11:00 AM",
                "Scheduled",
                "General consultation",
                ""
        );

        Appointments a10 = new Appointments(
                "APP010", "DOC002", "PAT010",
                LocalDate.of(2026, 1, 19),
                "12:00 PM",
                "Completed",
                "Cold symptoms",
                ""
        );

        Appointments a11 = new Appointments(
                "APP011", "DOC003", "PAT001",
                LocalDate.of(2026, 1, 20),
                "01:30 PM",
                "Scheduled",
                "Pre-surgery check",
                ""
        );

        Appointments a12 = new Appointments(
                "APP012", "DOC004", "PAT002",
                LocalDate.of(2026, 1, 21),
                "02:30 PM",
                "Scheduled",
                "Follow-up",
                ""
        );

        Appointments a13 = new Appointments(
                "APP013", "DOC005", "PAT003",
                LocalDate.of(2026, 1, 22),
                "03:30 PM",
                "Scheduled",
                "Cardiology review",
                ""
        );

        Appointments a14 = new Appointments(
                "APP014", "DOC006", "PAT004",
                LocalDate.of(2026, 1, 23),
                "09:00 AM",
                "Cancelled",
                "Neurology check",
                ""
        );

        Appointments a15 = new Appointments(
                "APP015", "DOC007", "PAT005",
                LocalDate.of(2026, 1, 24),
                "10:30 AM",
                "Scheduled",
                "General follow-up",
                ""
        );

        appointmentService.add(a1);
        appointmentService.add(a2);
        appointmentService.add(a3);
        appointmentService.add(a4);
        appointmentService.add(a5);
        appointmentService.add(a6);
        appointmentService.add(a7);
        appointmentService.add(a8);
        appointmentService.add(a9);
        appointmentService.add(a10);
        appointmentService.add(a11);
        appointmentService.add(a12);
        appointmentService.add(a13);
        appointmentService.add(a14);
        appointmentService.add(a15);


        MedicalRecords r1 = new MedicalRecords("MR001", "PAT001",
                LocalDate.of(2026, 1, 10), "DOC001",
                "Flu", "Paracetamol", "Normal", "");

        MedicalRecords r2 = new MedicalRecords("MR002", "PAT002",
                LocalDate.of(2026, 1, 11), "DOC002",
                "Headache", "Painkillers", "Normal", "");

        MedicalRecords r3 = new MedicalRecords("MR003", "PAT003",
                LocalDate.of(2026, 1, 12), "DOC003",
                "Appendicitis", "Surgery", "Critical", "");

        MedicalRecords r4 = new MedicalRecords("MR004", "PAT004",
                LocalDate.of(2026, 1, 13), "DOC004",
                "Fracture", "Cast", "X-Ray Done", "");

        MedicalRecords r5 = new MedicalRecords("MR005", "PAT005",
                LocalDate.of(2026, 1, 14), "DOC005",
                "Chest Pain", "ECG", "Stable", "");

        MedicalRecords r6 = new MedicalRecords("MR006", "PAT006",
                LocalDate.of(2026, 1, 15), "DOC006",
                "Migraine", "Medication", "Normal MRI", "");

        MedicalRecords r7 = new MedicalRecords("MR007", "PAT007",
                LocalDate.of(2026, 1, 16), "DOC007",
                "Diabetes", "Insulin", "High Sugar", "");

        MedicalRecords r8 = new MedicalRecords("MR008", "PAT008",
                LocalDate.of(2026, 1, 17), "DOC008",
                "Hypertension", "Beta blockers", "High BP", "");

        MedicalRecords r9 = new MedicalRecords("MR009", "PAT009",
                LocalDate.of(2026, 1, 18), "DOC001",
                "Allergy", "Antihistamine", "Mild", "");

        MedicalRecords r10 = new MedicalRecords("MR010", "PAT010",
                LocalDate.of(2026, 1, 19), "DOC002",
                "Back Pain", "Physiotherapy", "Normal", "");

        MedicalRecords r11 = new MedicalRecords("MR011", "PAT001",
                LocalDate.of(2026, 1, 20), "DOC003",
                "Asthma", "Inhaler", "Stable", "");

        MedicalRecords r12 = new MedicalRecords("MR012", "PAT002",
                LocalDate.of(2026, 1, 21), "DOC004",
                "Infection", "Antibiotics", "Blood Test Done", "");

        medicalRecordService.add(r1);
        medicalRecordService.add(r2);
        medicalRecordService.add(r3);
        medicalRecordService.add(r4);
        medicalRecordService.add(r5);
        medicalRecordService.add(r6);
        medicalRecordService.add(r7);
        medicalRecordService.add(r8);
        medicalRecordService.add(r9);
        medicalRecordService.add(r10);
        medicalRecordService.add(r11);
        medicalRecordService.add(r12);

    }
}
