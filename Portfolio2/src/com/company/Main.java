package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        String query1 = "SELECT id FROM voyage WHERE (arrdate - depdate) <= 0";
        String query2 = "SELECT id FROM voyage WHERE depport = arrport";
        String query3 = "SELECT voyage.id FROM voyage " +
                "JOIN vessel ON voyage.vessel = vessel.name " +
                "WHERE vessel.capacity < 3000";

        List<Integer> failedVoyages1 = getFailedVoyages(query1);
        List<Integer> failedVoyages2 = getFailedVoyages(query2);
        List<Integer> failedVoyages3 = getFailedVoyages(query3);

        System.out.println("Failed voyages for condition 1: " + failedVoyages1);
        System.out.println("Failed voyages for condition 2: " + failedVoyages2);
        System.out.println("Failed voyages for condition 3: " + failedVoyages3);
    }

    static List<Integer> getFailedVoyages(String query) {
        List<Integer> failedVoyages = new ArrayList<>();
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:identifier.sqlite";
            conn = DriverManager.getConnection(url);

            Statement stmt = null;

            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int voyageId = rs.getInt("id");
                    failedVoyages.add(voyageId);
                }
            } catch (SQLException e) {
                throw new Error("Problem", e);
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
            }
        } catch (SQLException e) {
            throw new Error("Problem", e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return failedVoyages;
    }
}
