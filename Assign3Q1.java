import java.sql.*;


public class Assign3Q1 {
    Connection conn;
    public Assign3Q1() {
        // JDBC & Database credentials
        String url = "jdbc:postgresql://localhost:5433/Asn3db";
        String user = "postgres";
        String password = "Hasib123";
        try {
            Class.forName("org.postgresql.Driver"); // Connect to the database
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to PostgreSQL successfully!");
            } else {
                System.out.println("Failed to establish connection.");
            } // Close the connection (in a real scenario, do this in a finally
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println("\n");
    }

    /**
     * Retrieves and displays all records from the students table.*/
    public void getAllStudents(){
        // Create statement
        try {
            Statement stmt = this.conn.createStatement(); // Execute SQL query
            String SQL = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                int id = rs.getInt("student_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                String enroll_date = rs.getString("enrollment_date");
                System.out.println("Student ID: " + id + ", First Name: " + first_name +
                        ", Last Name: " + last_name + ", Email: " + email + ", Enrollment Date: " +
                        enroll_date);
            }
            rs.close();
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("\n");
    }

    /**
     * Inserts a new student record into the students table.
     */
    public void addStudent(String first_name, String last_name, String email, Date enrollment_date){
        try{
            // INSERT Operation
            String insertSQL = "INSERT INTO students (first_name, last_name, email, enrollment_date) " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, email);
            pstmt.setDate(4, enrollment_date);
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("New student" + first_name + " was inserted successfully!");
            }
        }catch (SQLException e ) {
            //if function throws duplicate error code handle it by alerting user of duplicate email
            if (e.getSQLState().equals("23505")) {
                System.out.println("Error: The email '" + email + "' already exists for another student.");
            } else {
                e.printStackTrace();
            }
        }
        System.out.println("\n");
    }

    /**
     * Updates the email address for a student with the specified student_id.
     */
    public void updateStudentEmail(int student_id, String new_email){
        try{
            // INSERT Operation
            String insertSQL = "Update students SET email = ? WHERE student_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, new_email);
            pstmt.setInt(2, student_id);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Email succesfully updated for student with Student Id: " + student_id +".");
            }
            else{
                System.out.println("Student not found.");
            }
        }catch (SQLException e) {
            //if function throws duplicate error code handle it by alerting user of duplicate email
            if (e.getSQLState().equals("23505")) {
                System.out.println("Error: The email '" + new_email + "' already exists for another student.");
            } else {
                e.printStackTrace();
            }
        }
        System.out.println("\n");
    }

    /**
     * Deletes the record of the student with the specified student_id.
     */
    public void deleteStudent(int student_id){
        try{
            // DELETE Operation
            String insertSQL = "DELETE FROM students WHERE student_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setInt(1, student_id);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted> 0) {
                System.out.println("Student with Student Id: " + student_id +" succesfully deleted.");
            }
            else{
                System.out.println("Student not found.");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Assign3Q1 q = new Assign3Q1();
        q.getAllStudents();
        q.addStudent("Has","Kho", "hk@gmail.com",Date.valueOf("2024-09-01"));
        q.getAllStudents();
        q.updateStudentEmail(4,"hk1@gmail.com");
        q.deleteStudent(4);
        q.getAllStudents();

    }

}