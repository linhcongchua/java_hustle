package java_core.io.filehandle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SimulateReadDBandWriteFile {

    private final static String FILE_OUTPUT = "./data_output_BufferedWriter.csv";

    public static void main(String[] args) throws SQLException, IOException {
        test3();
    }

    // Paging
    private static void test4() throws SQLException, IOException {
        Connection connection = DataSource.getConnection();

        TracingUtils.printMemoryUsage();
        long startTime = System.nanoTime();
        final String query = "SELECT * FROM users_io LIMIT 10000 OFFSET ?";
        final File file = new File(FILE_OUTPUT);
        int offset = 0;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(User.getHeader());

            while (true) {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, offset);

                ResultSet rs = ps.executeQuery();
                boolean hasNext = false;
                while (rs.next()) {
                    hasNext = true;
                    User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("country"), rs.getString("cellphone"));
                    String csvRow = user.toCsvRow();
                    bw.write(csvRow);
                }

                bw.flush();
                ps.close();
                rs.close();
                if (!hasNext) {
                    break;
                }
                offset+= 10_000;
            }
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("[BufferedWriter]Logic execution time: " + duration + " nanoseconds");
        TracingUtils.printMemoryUsage();
    }

    // BufferedWriter result set fetch size
    private static void test3() throws SQLException, IOException {
        Connection connection = DataSource.getConnection();

        TracingUtils.printMemoryUsage();
        long startTime = System.nanoTime();
        final String query = "SELECT * FROM users_io";
        final File file = new File(FILE_OUTPUT);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (
             BufferedWriter bw = new BufferedWriter(new FileWriter(file))
        ) {
            ps = connection.prepareStatement(query);
            ps.setFetchSize(10_000);
            rs = ps.executeQuery();
            rs.setFetchSize(10_000);

            bw.write(User.getHeader());
            int count = 0;
            while (rs.next()) {
                count++;
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("country"), rs.getString("cellphone"));
                String csvRow = user.toCsvRow();
                bw.write(csvRow);

                if (count % 10_000 == 0) {
                    bw.flush();
                }
            }
        } finally {
            if (Objects.nonNull(connection)) {
                connection.close();
            }
            if (Objects.nonNull(ps)) {
                ps.close();
            }
            if (Objects.nonNull(rs)) {
                rs.close();
            }
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("[BufferedWriter]Logic execution time: " + duration + " nanoseconds");
        TracingUtils.printMemoryUsage();
    }

    // BufferedWriter fetch to list -> to file
    private static void test2() throws SQLException, IOException {
        Connection connection = DataSource.getConnection();

        TracingUtils.printMemoryUsage();
        long startTime = System.nanoTime();
        final String query = "SELECT * FROM users_io";
        final File file = new File(FILE_OUTPUT);
        List<User> users = new ArrayList<User>(6_000_000);
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("country"), rs.getString("cellphone"));
                users.add(user);
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(User.getHeader());
            for (User user : users) {
                bw.write(user.toCsvRow());
            }
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("[BufferedWriter-list->csv]Logic execution time: " + duration + " nanoseconds");
        TracingUtils.printMemoryUsage();
    }

    // BufferedWriter write and fetch at the same time.
    private static void test1() throws SQLException, IOException {
        Connection connection = DataSource.getConnection();

        TracingUtils.printMemoryUsage();
        long startTime = System.nanoTime();
        final String query = "SELECT * FROM users_io";
        final File file = new File(FILE_OUTPUT);
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery();
             BufferedWriter bw = new BufferedWriter(new FileWriter(file))
        ) {
            bw.write(User.getHeader());
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("country"), rs.getString("cellphone"));
                String csvRow = user.toCsvRow();
                bw.write(csvRow);
            }
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("[BufferedWriter]Logic execution time: " + duration + " nanoseconds");
        TracingUtils.printMemoryUsage();
    }

    static class User {
        public User(int id, String name, String country, String cellphone) {
            this.id = id;
            this.name = name;
            this.country = country;
            this.cellphone = cellphone;
        }

        public int id;
        public String name;
        public String country;
        public String cellphone;

        public String toCsvRow() {
            return String.format("%d,%s,%s,%s\n", id, name, country, cellphone);
        }

        public static String getHeader() {
            return "id,name,country,cellphone\n";
        }
    }
}
