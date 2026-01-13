package Modules;

import DAO.DoctorDAO;
import Model.Doctor;
import java.util.List;

public class DoctorsPage extends BaseEntityPage {

    private static final Object[][] FORM_STRUCTURE = {
        {"Id", "IntegerField", null, null},
        {"Name", "TextField", null, null},
        {"Specialty", "ComboBox", new String[]{"Cardiology", "Neurology", "Orthopedics", "Pediatrics", "Other"}, null},
        {"Phone_Number", "TextField", null, null},
        {"Email", "TextField", null, null},
        {"Gender", "RadioButton", new String[]{"Male", "Female"}, null},
        {"Years_of_Experience", "IntegerField", null, null},
        {"Status", "ComboBox", new String[]{"Active", "Inactive"}, null},
        {"Start_Time", "TimeField", null, null},
        {"End_Time", "TimeField", null, null}
    };

    private static final String[] COLUMNS = {
        "ID", "Name", "Specialty", "Phone Number", "Email", "Gender", "Years of Experience", "Status", "Start Time", "End Time", "Action"
    };

    public DoctorsPage() {
        super("Doctor", "doctors", FORM_STRUCTURE, COLUMNS);
    }

    @Override
    protected Object[][] fetchData() {
        DoctorDAO doctorDAO = new DoctorDAO();
        List<Doctor> doctors = doctorDAO.getAll();
        Object[][] data = new Object[doctors.size()][COLUMNS.length];
        for (int i = 0; i < doctors.size(); i++) {
            Doctor d = doctors.get(i);
            data[i][0] = d.getId();
            data[i][1] = d.getName();
            data[i][2] = d.getSpecialty();
            data[i][3] = d.getPhoneNumber();
            data[i][4] = d.getEmail();
            data[i][5] = d.getGender();
            data[i][6] = d.getYearsOfExperience();
            data[i][7] = d.getStatus();
            data[i][8] = d.getStartTime();
            data[i][9] = d.getEndTime();
            data[i][10] = null; // Action column
        }
        return data;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(DoctorsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new DoctorsPage().setVisible(true);
        });
    }
}
