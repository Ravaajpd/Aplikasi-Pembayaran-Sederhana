import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class PembayaranAppGUI {
        private JFrame frame;
        private JTextField hargaField;
        private JTextField jumlahField;        private JTextField bayarField;
        private JTextArea hasilArea;

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                try {
                    PembayaranAppGUI window = new PembayaranAppGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        public PembayaranAppGUI() {
            initialize();
        }

        private void initialize() {
            frame = new JFrame();
            frame.setBounds(100, 100, 450, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(null);

            JLabel lblHarga = new JLabel("Harga Barang:");
            lblHarga.setBounds(10, 11, 120, 14);
            frame.getContentPane().add(lblHarga);

            hargaField = new JTextField();
            hargaField.setBounds(140, 8, 86, 20);
            frame.getContentPane().add(hargaField);
            hargaField.setColumns(10);

            JLabel lblJumlah = new JLabel("Jumlah Barang:");
            lblJumlah.setBounds(10, 42, 120, 14);
            frame.getContentPane().add(lblJumlah);

            jumlahField = new JTextField();
            jumlahField.setBounds(140, 39, 86, 20);
            frame.getContentPane().add(jumlahField);
            jumlahField.setColumns(10);

            JLabel lblBayar = new JLabel("Uang Dibayar:");
            lblBayar.setBounds(10, 73, 120, 14);
            frame.getContentPane().add(lblBayar);

            bayarField = new JTextField();
            bayarField.setBounds(140, 70, 86, 20);
            frame.getContentPane().add(bayarField);
            bayarField.setColumns(10);

            JButton btnHitung = new JButton("Hitung");
            btnHitung.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    hitungTotal();
                }
            });
            btnHitung.setBounds(10, 104, 89, 23);
            frame.getContentPane().add(btnHitung);

            hasilArea = new JTextArea();
            hasilArea.setEditable(false);
            hasilArea.setBounds(10, 138, 414, 112);
            frame.getContentPane().add(hasilArea);

            JButton btnUlang = new JButton("Ulang");
            btnUlang.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ulang();
                }
            });
            btnUlang.setBounds(109, 104, 89, 23);
            frame.getContentPane().add(btnUlang);

            JButton btnKeluar = new JButton("Keluar");
            btnKeluar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    keluar();
                }
            });
            btnKeluar.setBounds(208, 104, 89, 23);
            frame.getContentPane().add(btnKeluar);
        }

        private void hitungTotal() {
            try {
                double harga = Double.parseDouble(hargaField.getText());
                int jumlah = Integer.parseInt(jumlahField.getText());
                double bayar = Double.parseDouble(bayarField.getText());

                double total = harga * jumlah;
                double kembalian = bayar - total;

                String hasil = String.format("Harga Barang: %.2f\nJumlah Barang: %d\nTotal Belanja: %.2f\nUang Dibayar: %.2f\nUang Kembalian: %.2f",
                        harga, jumlah, total, bayar, kembalian);

                hasilArea.setText(hasil);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Masukkan angka yang valid.");
            }
        }

        private void ulang() {
            hargaField.setText("");
            jumlahField.setText("");
            bayarField.setText("");
            hasilArea.setText("");
        }

        private void keluar() {
            System.exit(0);
        }
    }
