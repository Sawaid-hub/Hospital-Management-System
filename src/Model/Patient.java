package Model;

import java.sql.Date;

public class Patient {
    private int id;
    private String name;
    private Date dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String diagnosis;
    private String treatmentStatus;
    private String status;

    public Patient() {}

    public Patient(int id, String name, Date dateOfBirth, String gender, String phoneNumber, String email, String address, String diagnosis, String treatmentStatus, String status) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.diagnosis = diagnosis;
        this.treatmentStatus = treatmentStatus;
        this.status = status;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getTreatmentStatus() { return treatmentStatus; }
    public void setTreatmentStatus(String treatmentStatus) { this.treatmentStatus = treatmentStatus; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
