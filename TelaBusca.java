import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaBusca extends JFrame {

    public TelaBusca() {
        setTitle("Buscar Número");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        JLabel rotuloBusca = new JLabel("Número a Buscar:");
        JTextField campoBusca = new JTextField();
        add(rotuloBusca);
        add(campoBusca);

        JButton botaoBuscar = new JButton("Buscar");
        add(botaoBuscar);
        add(new JLabel(""));

        botaoBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero = Integer.parseInt(campoBusca.getText());
                    int[] numerosOrdenados = TelaNumeros.getNumerosOrdenados();

                    new TelaResultado(numero, numerosOrdenados).setVisible(true);
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número inteiro.");
                }
            }
        });

        setVisible(true);
    }
}
