package java_core.io.filehandle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SimulateReadDBandWriteFile {

    public static void main(String[] args) throws SQLException {
        Connection connection = DataSource.getConnection();

        final String query = "";
        try (PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {

            }
        }
    }

    static class User {
        public int id;
        public String fullname;
        public String note;
        public String credit;
    }
}
