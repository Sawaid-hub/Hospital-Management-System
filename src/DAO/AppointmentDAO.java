package DAO;

import Model.Appointment;
import DbConfig.DbSetup;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO implements GenericDAO<Appointment> {

    @Override
    public boolean create(Appointment appointment) {
        String query = "INSERT INTO appointments (patient_name, doctor_name, appointment_date, appointment_time, reason, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DbSetup.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, appointment.getPatientName());
            pst.setString(2, appointment.getDoctorName());
            pst.setDate(3, appointment.getAppointmentDate());
            pst.setTime(4, appointment.getAppointmentTime());
            pst.setString(5, appointment.getReason());
            pst.setString(6, appointment.getStatus());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Appointment get(int id) {
        String query = "SELECT * FROM appointments WHERE id = ?";
        try (Connection con = DbSetup.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Appointment a = new Appointment();
                    a.setId(rs.getInt("id"));
                    a.setPatientName(rs.getString("patient_name"));
                    a.setDoctorName(rs.getString("doctor_name"));
                    a.setAppointmentDate(rs.getDate("appointment_date"));
                    a.setAppointmentTime(rs.getTime("appointment_time"));
                    a.setReason(rs.getString("reason"));
                    a.setStatus(rs.getString("status"));
                    return a;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Appointment> getAll() {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointments";
        try (Connection con = DbSetup.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                Appointment a = new Appointment();
                a.setId(rs.getInt("id"));
                a.setPatientName(rs.getString("patient_name"));
                a.setDoctorName(rs.getString("doctor_name"));
                a.setAppointmentDate(rs.getDate("appointment_date"));
                a.setAppointmentTime(rs.getTime("appointment_time"));
                a.setReason(rs.getString("reason"));
                a.setStatus(rs.getString("status"));
                appointments.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    @Override
    public boolean update(Appointment appointment) {
        String query = "UPDATE appointments SET patient_name=?, doctor_name=?, appointment_date=?, appointment_time=?, reason=?, status=? WHERE id=?";
        try (Connection con = DbSetup.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, appointment.getPatientName());
            pst.setString(2, appointment.getDoctorName());
            pst.setDate(3, appointment.getAppointmentDate());
            pst.setTime(4, appointment.getAppointmentTime());
            pst.setString(5, appointment.getReason());
            pst.setString(6, appointment.getStatus());
            pst.setInt(7, appointment.getId());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM appointments WHERE id=?";
        try (Connection con = DbSetup.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, id);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
