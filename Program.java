package Ex1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Program {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculatrice");

        frame.setLayout(null);
        frame.setBounds(0, 0, 400, 300);
        frame.setLocationRelativeTo(null);

        JTextField txtNum1 = new JTextField();
        JTextField txtNum2 = new JTextField();
        JComboBox<String> cboOperation = new JComboBox<>();
        JButton btnCalcul = new JButton("Calculer");
        JLabel lblResult = new JLabel();

        txtNum1.setBounds(10, 10, 200, 30);
        txtNum2.setBounds(10, 50, 200, 30);
        cboOperation.setBounds(10, 90, 200, 30);
        btnCalcul.setBounds(10, 130, 200, 30);
        lblResult.setBounds(10, 170, 200, 20);

        cboOperation.addItem("+");
        cboOperation.addItem("-");
        cboOperation.addItem("X");
        cboOperation.addItem("/");

        frame.add(txtNum1);
        frame.add(txtNum2);
        frame.add(cboOperation);
        frame.add(btnCalcul);
        frame.add(lblResult);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nb1 = Integer.parseInt(txtNum1.getText());
                int nb2 = Integer.parseInt(txtNum2.getText());
                int resultat = 0;

                switch ((String) cboOperation.getSelectedItem()) {
                    case "+":
                        resultat = nb1 + nb2;
                        break;
                    case "-":
                        resultat = nb1 - nb2;
                        break;
                    case "X":
                        resultat = nb1 * nb2;
                        break;
                    case "/":
                        if (nb2 == 0) {
                            lblResult.setText("Division par zero");
                            return;
                        }

                        resultat = nb1 / nb2;
                        break;
                    default:
                        lblResult.setText("Erreur");
                        break;
                }

                lblResult.setText(String.valueOf(resultat));
            }
        };

        btnCalcul.addActionListener(al);
        cboOperation.addActionListener(al);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
