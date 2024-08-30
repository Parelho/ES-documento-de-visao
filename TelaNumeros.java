import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class TelaNumeros extends JFrame {
    private JTextField[] camposTexto = new JTextField[8];
    private static int[] numerosOrdenados = new int[8];

    public TelaNumeros() {
        setTitle("Inserir Números");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2));

        for (int i = 0; i < 8; i++) {
            JLabel rotulo = new JLabel("Número " + (i + 1) + ":");
            camposTexto[i] = new JTextField();
            add(rotulo);
            add(camposTexto[i]);
        }

        JButton botaoEntra = new JButton("Entra");
        add(botaoEntra);
        add(new JLabel(""));

        botaoEntra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int[] numeros = new int[8];
                    for (int i = 0; i < 8; i++) {
                        numeros[i] = Integer.parseInt(camposTexto[i].getText());
                    }

                    Arrays.sort(numeros);
                    System.arraycopy(numeros, 0, numerosOrdenados, 0, numeros.length);

                    new TelaBusca().setVisible(true);
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira apenas números inteiros.");
                }
            }
        });

        setVisible(true);
    }

    public static int[] getNumerosOrdenados() {
        return numerosOrdenados;
    }

    public static void main(String[] args) {
        new TelaNumeros();
    }
}
