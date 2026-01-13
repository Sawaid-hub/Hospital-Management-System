package Model;

public class Doctor {
    private int id;
    private String name;
    private String specialty;
    private String phoneNumber;
    private String email;
    private String gender;
    private int yearsOfExperience;
    private String status;
    private String startTime;
    private String endTime;

    public Doctor() {}

    public Doctor(int id, String name, String specialty, String phoneNumber, String email, String gender, int yearsOfExperience, String status, String startTime, String endTime) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.yearsOfExperience = yearsOfExperience;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
}
