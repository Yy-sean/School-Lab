import java.sql.*;

public class VolunteerDAO {
    private Connection conn;

    public VolunteerDAO(Connection conn) {
        this.conn = conn;
    }

    public void addVolunteer(int id, String name, String sex, int age) throws SQLException {
        String sql = "INSERT INTO Volunteers (id, Name, Sex, Age) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, sex);
            stmt.setInt(4, age);
            stmt.executeUpdate();
        }
    }

    public void deleteVolunteer(int id) throws SQLException {
        String sql = "DELETE FROM Volunteers WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public void updateVolunteer(int id, String name) throws SQLException {
        String sql = "UPDATE Volunteers SET Name = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    public void queryVolunteer(int id) throws SQLException {
        String sql = "SELECT * FROM Volunteers WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("Name") + ", Sex: " + rs.getString("Sex") + ", Age: " + rs.getInt("Age"));
                } else {
                    System.out.println("No volunteer found with ID: " + id);
                }
            }
        }
    }

    public void displayAllVolunteers() throws SQLException {
        String sql = "SELECT * FROM Volunteers";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("Name") + ", Sex: " + rs.getString("Sex") + ", Age: " + rs.getInt("Age"));
            }
        }
    }
}