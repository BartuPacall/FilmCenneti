
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class YorumEkleme extends javax.swing.JFrame {
    private JComboBox<String> puanBox;
    private JTextArea yorumTextArea;
    private JTextField kullaniciAdiField;
    private JButton yorumEkleButton;

    private ArrayList<Object[]> yorumlarList;
    /**
     * Creates new form YorumEkleme
     */
    public YorumEkleme() {
        
        boolean loggedIn = AnaEkran.isLoggedIn();
         if (loggedIn) {
        
         } else {
        
             JOptionPane.showMessageDialog(this, "Yorum yapabilmek için giriş yapmalısınız !");
             System.exit(0);
        }
        initComponents();
        // JFrame ayarları
        setTitle("Yorum Ekle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 300));
        setLocationRelativeTo(null);

        // Yorumları, puanları ve adları tutmak için ArrayList
        yorumlarList = new ArrayList<>();

        // Puan için JComboBox
        String[] puanlar = {"1", "2", "3", "4", "5","6","7","8","9","10"};
        puanBox = new JComboBox<>(puanlar);

        // Yorum girişi için JTextArea
        yorumTextArea = new JTextArea(5, 30);
        JScrollPane yorumScrollPane = new JScrollPane(yorumTextArea);

        // Kullanıcı adı girişi için JTextField
        kullaniciAdiField = new JTextField(20);

        // Yorum Ekle düğmesi
        yorumEkleButton = new JButton("Yorum Ekle");
        yorumEkleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String yorum = yorumTextArea.getText();
                String secilenDeger = puanBox.getSelectedItem().toString();
                String kullaniciAdi = kullaniciAdiField.getText();

                // Girişleri kontrol et (boş alanlar için hata mesajı ver)
                if (yorum.trim().isEmpty() || kullaniciAdi.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(YorumEkleme.this, "Yorum ve kullanıcı adı alanları boş olamaz!", "Hata", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Yorumu, puanı ve kullanıcı adını tabloya ekliyoruz
                Object[] rowData = {secilenDeger, yorum, kullaniciAdi};
                yorumlarList.add(rowData); // Yorumları ArrayList'e ekliyoruz
                
                // Yorumları göstermek için metodu çağırıyoruz
                showYorumlar();

                // Alanları temizleyelim
                yorumTextArea.setText("");
                kullaniciAdiField.setText("");
            }
        });

        // JFrame bileşenlerini düzenleme
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Kullanıcı Adı: "));
        topPanel.add(kullaniciAdiField);
        topPanel.add(new JLabel("Puan: "));
        topPanel.add(puanBox);
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(yorumScrollPane, BorderLayout.CENTER);
        panel.add(yorumEkleButton, BorderLayout.SOUTH);

        setContentPane(panel);
        pack();
        setVisible(true);
    }
    
    private void showYorumlar() {
        // Tabloyu oluşturuyoruz
        String[] columnNames = {"Puan", "Yorum", "İsim"};
        Object[][] data = new Object[yorumlarList.size()][3];
        for (int i = 0; i < yorumlarList.size(); i++) {
            data[i] = yorumlarList.get(i);
        }
        JTable table = new JTable(data, columnNames);

        // Tabloyu gösteriyoruz
        JOptionPane.showMessageDialog(this, new JScrollPane(table), "Yorumlar", JOptionPane.PLAIN_MESSAGE);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(YorumEkleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YorumEkleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YorumEkleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YorumEkleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YorumEkleme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
