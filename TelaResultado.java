import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class TelaResultado extends JFrame {

    public TelaResultado(int numero, int[] numerosOrdenados) {
        setTitle("Resultado da Busca");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        int resultado = Arrays.binarySearch(numerosOrdenados, numero);
        String mensagem;

        if (resultado >= 0) {
            mensagem = "Número encontrado na posição: " + (resultado + 1);
        } else {
            mensagem = "Número não encontrado.";
        }

        JLabel rotuloResultado = new JLabel(mensagem, SwingConstants.CENTER);
        add(rotuloResultado);

        JButton botaoEntra = new JButton("Entra");
        add(botaoEntra);

        botaoEntra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }
}