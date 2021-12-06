import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class Framka extends JFrame{


    private Random location = new Random();

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Framka window = new Framka();

            }
       });
    }

    public Framka() throws HeadlessException {
        this("uciekający przycisk");
    }

    public Framka(String title) throws HeadlessException {
        super(title);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650,400);
        setVisible(true);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setBounds(0,0,600,450);
        setContentPane(panel);
        panel.setLayout(null);

        JButton runBtn = new JButton("Run");
        runBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (e.getX() < runBtn.getWidth() - 10) {
                    runBtn.setLocation(location.nextInt(500), location.nextInt(300));
                }
                runBtn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        new Kanwa().setVisible(true);
                    }
                });
            }
        });
        runBtn.setBounds(130, 300, 120, 35);
        panel.add(runBtn);


        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(400, 300, 120, 35);
        cancelBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                runBtn.setLocation(130,300);
            }
        });
        panel.add(cancelBtn);



    }
}