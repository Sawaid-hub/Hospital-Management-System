package DAO;

import Model.Doctor;
import DbConfig.DbSetup;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO implements GenericDAO<Doctor> {
    
    @Override
    public boolean create(Doctor doctor) {
        String query = "INSERT INTO doctors (name, specialty, phone_number, email, gender, years_of_experience, status, start_time, end_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DbSetup.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, doctor.getName());
            pst.setString(2, doctor.getSpecialty());
            pst.setString(3, doctor.getPhoneNumber());
            pst.setString(4, doctor.getEmail());
            pst.setString(5, doctor.getGender());
            pst.setInt(6, doctor.getYearsOfExperience());
            pst.setString(7, doctor.getStatus());
            pst.setString(8, doctor.getStartTime());
            pst.setString(9, doctor.getEndTime());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Doctor get(int id) {
        String query = "SELECT * FROM doctors WHERE id = ?";
        try (Connection con = DbSetup.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Doctor d = new Doctor();
                    d.setId(rs.getInt("id"));
                    d.setName(rs.getString("name"));
                    d.setSpecialty(rs.getString("specialty"));
                    d.setPhoneNumber(rs.getString("phone_number"));
                    d.setEmail(rs.getString("email"));
                    d.setGender(rs.getString("gender"));
                    d.setYearsOfExperience(rs.getInt("years_of_experience"));
                    d.setStatus(rs.getString("status"));
                    d.setStartTime(rs.getString("start_time"));
                    d.setEndTime(rs.getString("end_time"));
                    return d;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Doctor> getAll() {
        List<Doctor> doctors = new ArrayList<>();
        String query = "SELECT * FROM doctors";
        try (Connection con = DbSetup.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                Doctor d = new Doctor();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setSpecialty(rs.getString("specialty"));
                d.setPhoneNumber(rs.getString("phone_number"));
                d.setEmail(rs.getString("email"));
                d.setGender(rs.getString("gender"));
                d.setYearsOfExperience(rs.getInt("years_of_experience"));
                d.setStatus(rs.getString("status"));
                d.setStartTime(rs.getString("start_time"));
                d.setEndTime(rs.getString("end_time"));
                doctors.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    @Override
    public boolean update(Doctor doctor) {
        String query = "UPDATE doctors SET name=?, specialty=?, phone_number=?, email=?, gender=?, years_of_experience=?, status=?, start_time=?, end_time=? WHERE id=?";
        try (Connection con = DbSetup.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, doctor.getName());
            pst.setString(2, doctor.getSpecialty());
            pst.setString(3, doctor.getPhoneNumber());
            pst.setString(4, doctor.getEmail());
            pst.setString(5, doctor.getGender());
            pst.setInt(6, doctor.getYearsOfExperience());
            pst.setString(7, doctor.getStatus());
            pst.setString(8, doctor.getStartTime());
            pst.setString(9, doctor.getEndTime());
            pst.setInt(10, doctor.getId());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM doctors WHERE id=?";
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
