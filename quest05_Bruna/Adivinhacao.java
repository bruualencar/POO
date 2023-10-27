package quest05_Bruna;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Adivinhacao extends JFrame implements ActionListener {
    private int numeroAleatorio;
    private int tentativas = 0;
    private final int maxTentativas = 5;
    private JLabel tentativaLabel;
    private JButton[] botoes;

    public Adivinhacao() {
        super("Jogo de Adivinhação");

        
        Random random = new Random();
        numeroAleatorio = random.nextInt(20) + 1;

        setLayout(new GridLayout(4, 5));
        botoes = new JButton[20];

        for (int i = 0; i < 20; i++) {
            botoes[i] = new JButton(String.valueOf(i + 1));
            botoes[i].addActionListener(this);
            add(botoes[i]);
        }

        tentativaLabel = new JLabel("Tentativa: 1");
        add(tentativaLabel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
    }

    
    public void actionPerformed(ActionEvent e) {
        JButton botaoClicado = (JButton) e.getSource();
        int numeroEscolhido = Integer.parseInt(botaoClicado.getText());

        tentativas++;

        if (numeroEscolhido == numeroAleatorio) {
            JOptionPane.showMessageDialog(this, "Parabéns, você adivinhou o número!");
            reiniciarJogo();
        } else {
            if (tentativas == maxTentativas) {
                JOptionPane.showMessageDialog(this, "Suas tentativas acabaram. O número era " + numeroAleatorio);
                reiniciarJogo();
            } else {
                tentativaLabel.setText("Tentativa: " + tentativas);
            }
        }
    }

    private void reiniciarJogo() {
        Random random = new Random();
        numeroAleatorio = random.nextInt(20) + 1;
        tentativas = 0;
        tentativaLabel.setText("Tentativa: 1");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Adivinhacao();
        });
    }
}
