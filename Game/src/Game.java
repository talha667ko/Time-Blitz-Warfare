import java.beans.DefaultPersistenceDelegate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    static Plane PLANE = new Plane();
    static Siha SIHA = new Siha();
    static Bombshell BOMBSHELL = new Bombshell();
    static Kfs KFS = new Kfs();
    static Frigate FRIGATE = new Frigate();
    static Sida SIDA = new Sida();
    static ArrayList<Player> You = new ArrayList<>();
    static ArrayList<Player> Computer = new ArrayList<>();
    static int[] pHAND;
    static int[] cHAND;
    static int pCardNum;

    static int a = 0;
    static int war = 0;

    public static void main(String[] args) {

        displayGAME();
    }

    public static void displayGAME() {

        JFrame FrameWork = new JFrame("TBW");
        FrameWork.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FrameWork.setSize(500, 500);
        FrameWork.setVisible(true);

        JPanel Monitor = new JPanel() {
            private Image image = new ImageIcon("/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/table.png")
                    .getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        JPanel SideInfo = new JPanel();
        JPanel PlayerInfo = new JPanel();
        JPanel ComputerInfo = new JPanel();
        JTextField Choice = new JTextField(20);
        JButton Submit = new JButton("Submit");
        JButton Next = new JButton("Next");
        JButton Attack = new JButton("Attack");
        JButton Result = new JButton("Result");
        JTextPane ListCardP = new JTextPane();
        JTextPane ListCardC = new JTextPane();
        JLabel[] labels = new JLabel[6];
        ListCardP.setEditable(false);
        ListCardC.setEditable(false);
        int[] num = { 0, 0, 0 };

        JButton Start = new JButton("Start The Game");
        Monitor.setLayout(null);
        Start.setBounds(1260, 690, 150, 180);
        Start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Monitor.remove(Start);
                FrameWork.remove(Monitor);
                JPanel Monitor = new JPanel() {
                    private Image image = new ImageIcon(
                            "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/table2.png")
                            .getImage();

                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                    }
                };
                FrameWork.setLayout(new BorderLayout());
                SideInfo.setBackground(Color.LIGHT_GRAY);
                Monitor.setPreferredSize(new Dimension(100, 100));
                SideInfo.setPreferredSize(new Dimension(200, 100));

                Monitor.setLayout(new GridLayout(2, 3, 10, 10));
                for (int i = 0; i < 6; i++) {
                    Monitor.add(labels[i] = new JLabel());
                }
                changeImage(labels);

                SideInfo.setLayout(new BorderLayout());
                SideInfo.add(PlayerInfo, BorderLayout.NORTH);
                SideInfo.add(ComputerInfo, BorderLayout.SOUTH);
                ComputerInfo.setLayout(null);
                PlayerInfo.setLayout(null);

                PlayerInfo.setPreferredSize(new Dimension(200, 450));
                ListCardP.setBounds(0, 0, 200, 275);
                // ListCard.setVerticalTextPosition(JTextArea.TOP);
                Choice.setBounds(0, 375, 80, 25);
                Submit.setBounds(0, 400, 80, 25);
                Next.setBounds(82, 400, 80, 25);
                Attack.setBounds(0, 425, 80, 25);
                Result.setBounds(82, 425, 80, 25);
                ListCardP.setText("This is your card list:\n");
                PlayerInfo.setBackground(Color.LIGHT_GRAY);
                ListCardP.setBackground(Color.LIGHT_GRAY);
                PlayerInfo.add(ListCardP);
                PlayerInfo.add(Choice);
                PlayerInfo.add(Submit);
                PlayerInfo.add(Next);
                PlayerInfo.add(Attack);
                PlayerInfo.add(Result);
                Result.setEnabled(false);
                Result.setVisible(false);
                Next.setEnabled(false);
                Attack.setEnabled(false);

                ComputerInfo.setPreferredSize(new Dimension(200, 450));
                ListCardC.setBounds(0, 0, 200, 450);
                ListCardC.setText("This is your card list:\nGame has started");
                ListCardC.setBackground(Color.LIGHT_GRAY);
                ComputerInfo.add(ListCardC);

                FrameWork.add(Monitor, BorderLayout.CENTER);
                FrameWork.add(SideInfo, BorderLayout.EAST);
            }
        });
        Monitor.add(Start);
        FrameWork.add(Monitor);

        Submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int choice = Integer.parseInt(Choice.getText());
                    if (choice > 5 || choice < 0)
                        throw new ArithmeticException("The number is too high or too low");
                    else {
                        num[a] = choice;
                        System.out.println(num[a]);
                        a++;
                    }
                } catch (NumberFormatException ex) {
                    ListCardC.setText("Please enter a valid number format!");
                } catch (ArithmeticException ex) {
                    ListCardC.setText(ex.getMessage());
                }
                if (a == 3) {
                    ListCardC.setText("You've entered 3 CArds now click on next");
                    Submit.setEnabled(false);
                    Next.setEnabled(true);
                    a = 0;
                }
            }
        });
        Next.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                changeImage(labels, ListCardC, num);
                Attack.setEnabled(true);
                Next.setEnabled(false);
            }

        });
        Attack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                war++;
                changeImage(war, labels, ListCardC);
                if (war == 3) {
                    Result.setEnabled(true);
                    Result.setVisible(true);
                    Attack.setEnabled(false);
                    war = 0;

                }
            }
        });
        Result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeImage(labels, ListCardC);
                Result.setVisible(false);
                Submit.setEnabled(true);

                Timer timer = new Timer(10000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        // Second call to changeImage
                        changeImage(labels);
                    }
                });

                // Start the timer (it runs once after 10 seconds)
                timer.setRepeats(false); // Ensures the timer runs only once
                timer.start();
            }
        });

    }

    public static void changeImage(JLabel[] labels) {

        for (int i = 0; i < 6; i++) {
            String link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/TBW2.png";
            ImageIcon imageIcon = new ImageIcon(link);
            Image scaledImage = imageIcon.getImage().getScaledInstance(300, 500, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            labels[i].setIcon(scaledIcon);
        }
    }

    public static void changeImage(JLabel[] labels, JTextPane ListCardC, int[] num) {

        String link = "";
        for (int i = 0; i < 3; i++) {
            switch (num[i]) {
                case 5:
                    link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/SIHA.png";
                    break;
                case 4:
                    link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/SIDA.png";
                    break;
                case 3:
                    link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/KFS.png";
                    break;
                case 2:
                    link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/Frigate.png";
                    break;
                case 1:
                    link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/Bombshell.png";
                    break;
                case 0:
                    link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/Plane.png";
                    break;

                default:
                    break;
            }

            ImageIcon imageIcon = new ImageIcon(link);
            Image scaledImage = imageIcon.getImage().getScaledInstance(300, 500, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            labels[i].setIcon(scaledIcon);
            ListCardC.setText("New List");
        }
    }

    public static void changeImage(int war, JLabel[] labels, JTextPane ListCardC) {

        String link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/WAR.png";
        ImageIcon imageIcon = new ImageIcon(link);
        Image scaledImage = imageIcon.getImage().getScaledInstance(300, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        switch (war) {
            case 1:
                labels[0].setIcon(scaledIcon);
                labels[3].setIcon(scaledIcon);
                ListCardC.setText("Round " + war);
                break;
            case 2:
                labels[1].setIcon(scaledIcon);
                labels[4].setIcon(scaledIcon);
                ListCardC.setText("Round " + war);
                break;
            case 3:
                labels[2].setIcon(scaledIcon);
                labels[5].setIcon(scaledIcon);
                ListCardC.setText("Round " + war);
                break;
            default:
                break;
        }
    }

    public static void changeImage(JLabel[] labels, JTextPane ListCardC) {

        String link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/DEAD.png";
        ImageIcon imageIcon = new ImageIcon(link);
        Image scaledImage = imageIcon.getImage().getScaledInstance(300, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        for (int i = 0; i < 6; i++) {
            labels[i].setIcon(scaledIcon);
        }
    }

    public static void attacking() {

    }

}

class Player {

    int score;
    String name;

    int level;
    int defense;
    int attack;
    String type;
    String subType;
    boolean used = false;

    Player(int level, int defense, int attack, String type, String subType) {
        this.level = level;
        this.defense = defense;
        this.attack = attack;
        this.type = type;
        this.subType = subType;
    }

    public void showScore() {

    }

    public void chooseCard() {

    }
}