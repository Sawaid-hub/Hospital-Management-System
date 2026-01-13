package DAO;

import Model.Doctor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class DoctorDAOTest {

    @Test
    public void testCreateAndGetDoctor() {
        DoctorDAO dao = new DoctorDAO();
        Doctor d = new Doctor();
        d.setName("JUnit Doctor");
        d.setSpecialty("Neurology");
        d.setPhoneNumber("1112223333");
        d.setEmail("junit@test.com");
        d.setGender("Female");
        d.setYearsOfExperience(10);
        d.setStatus("Active");
        d.setStartTime("08:00");
        d.setEndTime("16:00");

        boolean created = dao.create(d);
        assertTrue(created, "Doctor should be created");

        List<Doctor> doctors = dao.getAll();
        assertNotNull(doctors);
        assertTrue(doctors.size() > 0);
        
        boolean found = false;
        for (Doctor doc : doctors) {
            if ("JUnit Doctor".equals(doc.getName())) {
                found = true;
                break;
            }
        }
        assertTrue(found, "Created doctor should be in the list");
    }
}
