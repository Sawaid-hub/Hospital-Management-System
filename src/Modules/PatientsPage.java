package Modules;

import DAO.PatientDAO;
import Model.Patient;
import java.util.List;

public class PatientsPage extends BaseEntityPage {

    private static final Object[][] FORM_STRUCTURE = {
        {"Id", "IntegerField", null, null},
        {"Name", "TextField", null, null},
        {"Date_of_Birth", "DateField", null, null},
        {"Gender", "RadioButton", new String[]{"Male", "Female", "Other"}, null},
        {"Phone_Number", "TextField", null, null},
        {"Email", "TextField", null, null},
        {"Address", "TextField", null, null},
        {"Diagnosis", "TextField", null, null},
        {"Treatment_Status", "ComboBox", new String[]{"Ongoing", "Completed", "Pending", "Discontinued"}, null},
        {"Status", "ComboBox", new String[]{"Active", "Inactive"}, null}
    };

    private static final String[] COLUMNS = {
        "ID", "Name", "Date of Birth", "Gender", "Phone Number", "Email", "Address", "Diagnosis", "Treatment Status", "Status", "Action"
    };

    public PatientsPage() {
        super("Patient", "patients", FORM_STRUCTURE, COLUMNS);
    }

    @Override
    protected Object[][] fetchData() {
        PatientDAO patientDAO = new PatientDAO();
        List<Patient> patients = patientDAO.getAll();
        Object[][] data = new Object[patients.size()][COLUMNS.length];
        for (int i = 0; i < patients.size(); i++) {
            Patient p = patients.get(i);
            data[i][0] = p.getId();
            data[i][1] = p.getName();
            data[i][2] = p.getDateOfBirth();
            data[i][3] = p.getGender();
            data[i][4] = p.getPhoneNumber();
            data[i][5] = p.getEmail();
            data[i][6] = p.getAddress();
            data[i][7] = p.getDiagnosis();
            data[i][8] = p.getTreatmentStatus();
            data[i][9] = p.getStatus();
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
            java.util.logging.Logger.getLogger(PatientsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PatientsPage().setVisible(true);
        });
    }
}
