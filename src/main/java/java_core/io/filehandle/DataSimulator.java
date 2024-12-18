package java_core.io.filehandle;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataSimulator {
    /*
    CREATE TABLE users_io(
      id SERIAL PRIMARY KEY,
      name VARCHAR(100),
      country VARCHAR(100),
      cellphone VARCHAR(50)
    );
     */

    private final static Faker FAKER = new Faker();

    private final static String FILE_NAME = "./user_test_data.csv";

    // CREATE TABLE "user_test" ("id" varchar(255), "isUser" varchar(255), "rating" varchar(255));
    public static void main(String[] args) throws IOException, SQLException {
        TracingUtils.proxyMethod(DataSimulator::simulateFileCsv, "Simulate Data");

        try (Connection connection = DataSource.getConnection()) {
            TracingUtils.proxyMethod(DataSimulator::insertMillionUsers, connection, "Insert Data");
        }
    }

    private static void insertMillionUsers(Connection connection) {
        try {
            doInsertMillionUsers(connection);
        } catch (IOException|SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
    private static void doInsertMillionUsers(Connection connection) throws IOException, SQLException {
        final String query = "INSERT INTO users_io VALUES(?,?,?,?)";

        connection.setAutoCommit(false);
        try (
                InputStream inputStream = new FileInputStream(FILE_NAME);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                PreparedStatement ps = connection.prepareStatement(query)
        ) {
            int counter = 0;

            // skip first line
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parameters = line.split(",");
                ps.setInt(1, Integer.parseInt(parameters[0]));
                ps.setString(2, parameters[1]);
                ps.setString(3, parameters[2]);
                ps.setString(4, parameters[3]);
                ps.addBatch();
                counter++;
                if (counter % 1000 == 0) {
                    ps.executeBatch();
                    ps.clearBatch();
                }

                if (counter % 10_000 == 0) {
                    connection.commit();
                    System.out.println("Commit " + counter);
                }
            }

            // last one
            ps.executeBatch();
            connection.commit();
        }
    }

    private static void simulateFileCsv() {
        try {
            doSimulateFileCsv();
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }
    private static void doSimulateFileCsv() throws IOException {
        final File file = new File(FILE_NAME);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("id,name,country,cellphone\n");

            for (int i = 6_000_000; i < 24_000_000; i++) {
                writer.write(String.format("%d,%s,%s,%s\n", i + 1, FAKER.name().fullName(), FAKER.country().name(), FAKER.phoneNumber().cellPhone()));
            }
            writer.flush();
        }
    }
}
