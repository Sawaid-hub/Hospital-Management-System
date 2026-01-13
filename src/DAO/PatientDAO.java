package DAO;

import Model.Patient;
import DbConfig.DbSetup;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO implements GenericDAO<Patient> {
    
    @Override
    public boolean create(Patient patient) {
        String query = "INSERT INTO patients (name, date_of_birth, gender, phone_number, email, address, diagnosis, treatment_status, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DbSetup.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, patient.getName());
            pst.setDate(2, patient.getDateOfBirth());
            pst.setString(3, patient.getGender());
            pst.setString(4, patient.getPhoneNumber());
            pst.setString(5, patient.getEmail());
            pst.setString(6, patient.getAddress());
            pst.setString(7, patient.getDiagnosis());
            pst.setString(8, patient.getTreatmentStatus());
            pst.setString(9, patient.getStatus());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Patient get(int id) {
        String query = "SELECT * FROM patients WHERE id = ?";
        try (Connection con = DbSetup.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Patient p = new Patient();
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("name"));
                    p.setDateOfBirth(rs.getDate("date_of_birth"));
                    p.setGender(rs.getString("gender"));
                    p.setPhoneNumber(rs.getString("phone_number"));
                    p.setEmail(rs.getString("email"));
                    p.setAddress(rs.getString("address"));
                    p.setDiagnosis(rs.getString("diagnosis"));
                    p.setTreatmentStatus(rs.getString("treatment_status"));
                    p.setStatus(rs.getString("status"));
                    return p;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Patient> getAll() {
        List<Patient> patients = new ArrayList<>();
        String query = "SELECT * FROM patients";
        try (Connection con = DbSetup.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                Patient p = new Patient();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDateOfBirth(rs.getDate("date_of_birth"));
                p.setGender(rs.getString("gender"));
                p.setPhoneNumber(rs.getString("phone_number"));
                p.setEmail(rs.getString("email"));
                p.setAddress(rs.getString("address"));
                p.setDiagnosis(rs.getString("diagnosis"));
                p.setTreatmentStatus(rs.getString("treatment_status"));
                p.setStatus(rs.getString("status"));
                patients.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    @Override
    public boolean update(Patient patient) {
        String query = "UPDATE patients SET name=?, date_of_birth=?, gender=?, phone_number=?, email=?, address=?, diagnosis=?, treatment_status=?, status=? WHERE id=?";
        try (Connection con = DbSetup.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, patient.getName());
            pst.setDate(2, patient.getDateOfBirth());
            pst.setString(3, patient.getGender());
            pst.setString(4, patient.getPhoneNumber());
            pst.setString(5, patient.getEmail());
            pst.setString(6, patient.getAddress());
            pst.setString(7, patient.getDiagnosis());
            pst.setString(8, patient.getTreatmentStatus());
            pst.setString(9, patient.getStatus());
            pst.setInt(10, patient.getId());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM patients WHERE id=?";
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
