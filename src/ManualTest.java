import DAO.DoctorDAO;
import Model.Doctor;
import java.util.List;

public class ManualTest {
    public static void main(String[] args) {
        System.out.println("Running Manual Test for DoctorDAO...");
        
        try {
            DoctorDAO dao = new DoctorDAO();
            
            // Create
            System.out.println("Creating new doctor...");
            Doctor d = new Doctor();
            d.setName("Manual Test Doctor");
            d.setSpecialty("Cardiology");
            d.setPhoneNumber("9998887777");
            d.setEmail("manual@test.com");
            d.setGender("Male");
            d.setYearsOfExperience(5);
            d.setStatus("Active");
            d.setStartTime("09:00");
            d.setEndTime("17:00");
            
            boolean created = dao.create(d);
            System.out.println("Creation Success: " + created);
            
            // Read
            System.out.println("Fetching all doctors...");
            List<Doctor> list = dao.getAll();
            System.out.println("Total doctors found: " + list.size());
            
            boolean found = false;
            for (Doctor doc : list) {
                if ("Manual Test Doctor".equals(doc.getName())) {
                    System.out.println("Found created doctor: " + doc.getName());
                    found = true;
                }
            }
            
            if (found) {
                System.out.println("TEST PASSED: Doctor created and retrieved successfully.");
            } else {
                System.out.println("TEST FAILED: Created doctor not found.");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("TEST FAILED with Exception.");
        }
    }
}
