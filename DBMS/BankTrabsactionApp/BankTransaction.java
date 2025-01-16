package DBMS.BankTrabsactionApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankTransaction {

    public static void ACIDProperty() {
        String jdbcURL = "jdbc:mysql://localhost:3306/banking";
        String username = "root";
        String password = "password";

        double transferAmount = 200.0;
        int fromAccountId = 1;
        int toAccountId = 2;

        Connection connection = null;

        try {
            // Establish DB Connection
            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false); // Disable auto-commit for transaction

            // Check if the source account has sufficient balance
            if (!hasSufficientBalance(connection, fromAccountId, transferAmount)) {
                System.out.println("Insufficient balance in account " + fromAccountId);
                return;
            }

            // Debit from Account A
            String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
            try (PreparedStatement debitStatement = connection.prepareStatement(debitSQL)) {
                debitStatement.setDouble(1, transferAmount);
                debitStatement.setInt(2, fromAccountId);
                debitStatement.executeUpdate();
            }

            // Credit to Account B
            String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
            try (PreparedStatement creditStatement = connection.prepareStatement(creditSQL)) {
                creditStatement.setDouble(1, transferAmount);
                creditStatement.setInt(2, toAccountId);
                creditStatement.executeUpdate();
            }

            // Commit the transaction
            connection.commit();
            System.out.println("Transaction successful! Transferred $" + transferAmount);

        } catch (SQLException ex) {
            // Rollback transaction in case of error
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Transaction failed! Rolled back.");
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            ex.printStackTrace();
        } finally {
            // Close connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException closeEx) {
                    closeEx.printStackTrace();
                }
            }
        }
    }

    private static boolean hasSufficientBalance(Connection connection, int accountId, double amount)
            throws SQLException {
        String checkBalanceSQL = "SELECT balance FROM accounts WHERE account_id = ?";
        try (PreparedStatement checkStatement = connection.prepareStatement(checkBalanceSQL)) {
            checkStatement.setInt(1, accountId);
            try (ResultSet resultSet = checkStatement.executeQuery()) {
                if (resultSet.next()) {
                    double balance = resultSet.getDouble("balance");
                    return balance >= amount;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }

}
