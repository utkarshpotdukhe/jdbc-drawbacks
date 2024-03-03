package com.demo.util;

import com.demo.constants.DbConstants;
import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.demo.constants.DbConstants.*;

public class ConnectionUtil {
    @Getter
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver not found");
        } catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println("Issue in connection");
        }
    }
}
