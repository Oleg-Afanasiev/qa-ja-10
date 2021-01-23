package com.academy.telesens.lesson12;

import com.academy.telesens.util.PropertyProvider;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class MySQLDemo {
    public static void main(String[] args) {
        String dbUrl2 = PropertyProvider.get("db.url");
        System.out.println(dbUrl2);

        String url = "jdbc:mysql://localhost:3306/mobile?user=root&password=root";
//        String url = args[0];
        String sqlInsert = "INSERT INTO subscriber " +
                "(first_name, last_name, gender, age)" +
                "VALUES('demo', 'demo', 'm', 23)";

        String sqlInsertTemplate = "INSERT INTO subscriber " +
                "(first_name, last_name, gender, age)" +
                "VALUES(?, ?, ?, ?)";

        try(Connection conn = DriverManager.getConnection(url)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement statement = conn.createStatement();
            statement.executeUpdate(sqlInsert);

            PreparedStatement preparedStatement = conn.prepareStatement(sqlInsertTemplate);
            preparedStatement.setString(1, "demo_firstName_2");
            preparedStatement.setString(2, "demo_lastName_2");
            preparedStatement.setString(3, "f");
            preparedStatement.setInt(4, 26);
            preparedStatement.executeUpdate();

            // Прочитаем полностью таблицу subscriber
            Statement readStatement = conn.createStatement();
            ResultSet resultSet = readStatement.executeQuery("SELECT * FROM subscriber");

            while(resultSet.next()) {
                int id = resultSet.getInt("subscriber_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");

                System.out.println(String.format("%d | %s | %s | %s | %d",
                        id, firstName, lastName, gender, age));
            }
//            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
