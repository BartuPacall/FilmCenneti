import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MovieReview {
    private JTextField movieTitleField;
    private JTextField userNameField;
    private JTextArea reviewTextArea;
    private JComboBox<Integer> ratingComboBox;

    private Connection connection;

    public MovieReview() {

        try {
            String url = "jdbc:mysql://localhost:3306/imdb_movie_data"; // Veritabanı bağlantı URL'i
            String username = "your_username"; // Veritabanı kullanıcı adı
            String password = "your_password"; // Veritabanı parola
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Veritabanına bağlanılamadı!");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MovieReview());
    }
}
