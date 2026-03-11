package RelogioJava;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Relogio  extends JFrame {

    private JLabel label;

    public Relogio() {
        setTitle("Relógio Digital");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ImageIcon imagem = new ImageIcon(getClass().getResource("relogio.png"));

        JLabel imagemLabel = new JLabel(imagem);
        imagemLabel.setHorizontalAlignment(SwingConstants.CENTER);

        setLocationRelativeTo(null);


        label = new JLabel("", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setForeground(Color.black);

        add(imagemLabel, BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);

        Timer timer = new Timer(1000, e -> atualizarRelogio());
        timer.start();

        atualizarRelogio();
    }

    private void atualizarRelogio() {
        String horaAtual = new SimpleDateFormat("HH:mm:ss").format(new Date());
        label.setText(horaAtual);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Relogio relogio = new Relogio();
            relogio.setVisible(true);
        });
    }
    
}
