/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Modules;

import DAO.AppointmentDAO;
import Model.Appointment;
import java.util.List;

public class AppointmentsPage extends BaseEntityPage {

    private static final Object[][] FORM_STRUCTURE = {
        {"Id", "IntegerField", null, null},
        {"Patient_Name", "TextField", null, null},
        {"Doctor_Name", "TextField", null, null},
        {"Appointment_Date", "DateField", null, null},
        {"Appointment_Time", "TimeField", null, null},
        {"Reason", "TextField", null, null},
        {"Status", "ComboBox", new String[]{"Scheduled", "Completed", "Cancelled", "No Show"}, null}
    };

    private static final String[] COLUMNS = {
        "ID", "Patient Name", "Doctor Name", "Appointment Date", "Appointment Time", "Reason", "Status", "Action"
    };

    public AppointmentsPage() {
        super("Appointment", "appointments", FORM_STRUCTURE, COLUMNS);
    }

    @Override
    protected Object[][] fetchData() {
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        List<Appointment> appointments = appointmentDAO.getAll();
        Object[][] data = new Object[appointments.size()][COLUMNS.length];
        for (int i = 0; i < appointments.size(); i++) {
            Appointment a = appointments.get(i);
            data[i][0] = a.getId();
            data[i][1] = a.getPatientName();
            data[i][2] = a.getDoctorName();
            data[i][3] = a.getAppointmentDate();
            data[i][4] = a.getAppointmentTime();
            data[i][5] = a.getReason();
            data[i][6] = a.getStatus();
            data[i][7] = null; // Action column
        }
        return data;
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(AppointmentsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new AppointmentsPage().setVisible(true);
        });
    }
}
