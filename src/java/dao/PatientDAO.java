
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Patient;

/**
 * A utility class for manipulating {@link Patient} records in a database.
 */
public class PatientDAO
{
    // Declared privately as this class contains only static members
    private PatientDAO()
    {
    }

    /**
     * Creates a new patient in the database. Should only ever be called when
     * there is already a user in the database with the username.
     *
     * @param patient the patient to be created
     * @param username the username for the patient
     * @return the number of rows affected by the insert, 1 if the operation was
     * successful, 0 otherwise
     * @throws DataAccessException if a data access error occurs
     */
    public static int create(Patient patient, String username)
            throws DataAccessException
    {
        String sqlInsert = "INSERT INTO patient VALUES (?, ?, ?, ?, ?);";
        int rowCount;
        try (Connection conn = Database.connect();
             PreparedStatement statement = conn.prepareStatement(sqlInsert))
        {
            statement.setString(1, username);
            statement.setString(2, patient.getGender().toString().substring(0, 1));
            statement.setInt(3, patient.getAge());
            statement.setDouble(4, patient.getWeight());
            statement.setBoolean(5, patient.isPrediction());
            rowCount = statement.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new DataAccessException(e);
        }

        return rowCount;
    }

    /**
     * Retrieves a patient record from the database.
     *
     * @param username the username of the patient
     * @return the patient, or null if no patient was found for that username or
     * the username doesn't exist
     * @throws DataAccessException if a data access error occurs
     */
    public static Patient retrieve(String username)
            throws DataAccessException
    {
        String sqlQuery = "SELECT * FROM patient WHERE username = ?;";
        Patient patient = null;
        try (Connection conn = Database.connect();
             PreparedStatement statement = conn.prepareStatement(sqlQuery))
        {
            statement.setString(1, username);
            try (ResultSet rs = statement.executeQuery())
            {
                if (rs.next())
                {
                    patient = new Patient();
                    patient.setAge(rs.getInt("age"));
                    patient.setWeight(rs.getDouble("weight"));
                    if (rs.getString("gender").equalsIgnoreCase("M"))
                    {
                        patient.setGender(Patient.Gender.MALE);
                    }
                    else if (rs.getString("gender").equalsIgnoreCase("F"))
                    {
                        patient.setGender(Patient.Gender.FEMALE);
                    }
                    patient.setPrediction(rs.getBoolean("prediction"));
                }
            }
        }
        catch (SQLException e)
        {
            throw new DataAccessException(e);
        }

        return patient;
    }

    /**
     * Updates a patient record in the database.
     *
     * @param patient the new patient details
     * @param username the username for the patient
     * @return the number of rows affected by the update, 1 if the operation was
     * successful, 0 otherwise
     * @throws DataAccessException if a data access error occurs
     */
    public static int update(Patient patient, String username)
            throws DataAccessException
    {
        String sqlUpdate = "UPDATE patient SET age = ?, weight = ?, gender = ?, "
                + "prediction = ?, timeAssessed = CURRENT_TIMESTAMP WHERE username = ?;";
        int rowCount;
        try (Connection conn = Database.connect();
             PreparedStatement statement = conn.prepareStatement(sqlUpdate))
        {
            statement.setInt(1, patient.getAge());
            statement.setDouble(2, patient.getWeight());
            statement.setString(3, patient.getGender().toString().substring(0, 1));
            statement.setBoolean(4, patient.isPrediction());
            statement.setString(5, username);
            rowCount = statement.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new DataAccessException(e);
        }

        return rowCount;
    }

    /**
     * Deletes a patient from the database.
     * 
     * @param username the username for the patient
     * @return the number of rows affected by the delete, 1 if the operation was
     * successful, 0 otherwise
     * @throws DataAccessException if a data access error occurs
     */
    public static int delete(String username)
            throws DataAccessException
    {
        String sqlDelete = "DELETE FROM patient WHERE username = ?;";
        int rowCount;
        try (Connection conn = Database.connect();
             PreparedStatement statement = conn.prepareStatement(sqlDelete))
        {
            statement.setString(1, username);
            rowCount = statement.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new DataAccessException(e);
        }

        return rowCount;
    }
}
