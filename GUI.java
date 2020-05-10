import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.CardLayout;
import java.awt.Color;
import java.io.IOException;
import java.awt.Container;
import java.awt.Font;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

public class GUI {

    Player player = new Player();
    Warden warden = new Warden();
    static Laugh clicked_laugh = new Laugh();
    JFrame frame = new JFrame();
    JPanel panelController = new JPanel();
    JPanel panelFirst = new JPanel();
    JPanel panelSecond = new JPanel();
    JMenuBar menuBar;
    JMenu fileMenu, submenu;
    JMenuItem stageTwo;
    static JButton laughbutton = new JButton("laugh");
    CardLayout cl = new CardLayout();
    static Font titleFont = new Font("Times New Roman", Font.PLAIN, 16);
    static ImageIcon diceImage01 = new ImageIcon("resources/dice/dice1.png");
    static ImageIcon diceImage02 = new ImageIcon("resources/dice/dice1.png");
    static JLabel dice01 = new JLabel(diceImage01, JLabel.CENTER);
    static JLabel dice02 = new JLabel(diceImage02, JLabel.CENTER);
    public GUI() {


        buildLaughPanel(panelFirst);
        buildGamePanel(panelSecond);

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_A);
        fileMenu.getAccessibleContext().setAccessibleDescription("Menu with menu items");
        menuBar.add(fileMenu);

        stageTwo = new JMenuItem("Next Stage", KeyEvent.VK_T);
        stageTwo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        stageTwo.getAccessibleContext().setAccessibleDescription("Proceed to next stage");
        stageTwo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(panelController, "2");
            }

        });
        fileMenu.add(stageTwo);
        
        panelController.setLayout((cl));
        panelController.add(panelFirst, "1");
        panelController.add(panelSecond, "2");
        cl.show(panelController, "1");

        frame.add(panelController);
        frame.setJMenuBar(menuBar);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    private void buildLaughPanel(JPanel panel){
        panel.setLayout(null);
        JLabel label = new JLabel("Laugh Tracks");

        //label.setBorder(BorderFactory.createLineBorder(Color.black));
        
        laughbutton.setBounds(350, 80, 100, 25);
        laughbutton.addActionListener((ActionListener) new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                try {
                    clicked_laugh.PlayLaugh();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        });
        panel.add(laughbutton);

        label.setBounds(350, 50, 200, 25);
        label.setFont(titleFont);
        panel.add(label);
    }
    private void buildGamePanel(JPanel panel) {
        panel.setLayout(null);
        JLabel wardenOpenLabel = new JLabel();
        JLabel wardenDialogueLabel = new JLabel();
        JButton roll = new JButton("Roll");

        //wardenOpenLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        wardenOpenLabel.setText(warden.getOpeningSpeech());
        wardenOpenLabel.setBounds(200, 50, 400, 25);
        wardenOpenLabel.setFont(titleFont);
        panel.add(wardenOpenLabel);

        roll.setBounds(350, 300, 100, 25);
        roll.addActionListener((ActionListener) new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String [] file_paths = player.DiceImage();

                wardenDialogueLabel.setText(warden.CheckRoll(player));

                ImageIcon new_diceImage01 = new ImageIcon(file_paths[0]);
                ImageIcon new_diceImage02 = new ImageIcon(file_paths[1]);
                dice01.setIcon(new_diceImage01);
                dice02.setIcon(new_diceImage02);
                dice01.setBounds(250, 200, 100, 41);
                dice02.setBounds(450, 200, 100, 41);
                panel.add(dice01);
                panel.add(dice02);
            }


            
        });



        wardenDialogueLabel.setBounds(200, 400, 400, 25);
        wardenDialogueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(wardenDialogueLabel);
        panel.add(roll);
    }
  
    public static void main(String[] args){
        new GUI();

    }
}