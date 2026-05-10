package Entites;

import java.time.LocalDate;

public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String poneNumber;
    private String email;
    private String address;

    public Person(String id, String firstName, String lastName,
                  LocalDate dateOfBirth, String gender, String poneNumber,
                  String email, String address){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.poneNumber = poneNumber;
        this.email = email;
        this.address = address;
    }
}
