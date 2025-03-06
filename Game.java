import java.beans.DefaultPersistenceDelegate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.management.monitor.Monitor;
import javax.swing.*;
import javax.swing.border.Border;

import org.w3c.dom.css.RGBColor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Game {

    static Plane PLANE = new Plane();
    static Siha SIHA = new Siha();
    static Bombshell BOMBSHELL = new Bombshell();
    static Kfs KFS = new Kfs();
    static Frigate FRIGATE = new Frigate();
    static Sida SIDA = new Sida();
    static ArrayList<Player> You = new ArrayList<>();
    static ArrayList<Player> Computer = new ArrayList<>();
    static Player User = new Player(0, "player");
    static Player CPU = new Player(0, "CPU");
    static int[] playerHandCard = { 0, 0, 0 };
    static int[] computerHandCard = { 0, 0, 0 };
    static int RandomNUM;
    static int num = 0;
    static int counterP = 0;
    static int counterC = 0;
    static int playerCardNum = 0;
    static int computerCardNum = 0;
    static Random random = new Random();
    static Scanner scan = new Scanner(System.in);
    static Set<Integer> chosenCards = new HashSet<>();
    static Set<Integer> chosenCardsP = new HashSet<>();
    static int a = 0;
    static int war = 0;
    static int choice;
    static int cardP;
    static JFrame FrameWork = new JFrame("Time Blitz WARFARE");
    static JPanel SideInfo = new JPanel();
    static JPanel PlayerInfo = new JPanel();
    static JPanel GameInfo = new JPanel();
    static JTextField Choice = new JTextField(20);
    static JButton Submit = new JButton("Submit");
    static JButton Next = new JButton("Next");
    static JButton Attack = new JButton("Attack");
    static JButton Result = new JButton("Result");
    static JTextPane ListCardP = new JTextPane();
    static JTextPane GameDetails = new JTextPane();
    static JTextPane GameSupDetails = new JTextPane();
    static JLabel[] labels = new JLabel[6];
    static int[] numm = { 0, 0, 0 };
    static int t;
    static String ListingP = "Your Cards:\n";
    static String ListingD = "";
    static String link;
    static boolean stop = false;
    static char endS;
    static Border blackBorder = BorderFactory.createLineBorder(Color.BLACK, 5);
    static String txt;
    static int totalDEFENSEplayer = 0;
    static int totalDEFENSEcomputer = 0;

    public static void main(String[] args) {

        User.UserID = random.nextInt(100) + 1;
        CPU.UserID = random.nextInt(100) + 100;
        txt = "Welcome to TIME BLITZ WARFARE data file:\nPlayer User ID: " + User.UserID + "\n" + "Computer User ID: "
                + CPU.UserID + "\n";
        displayGAME();
    }

    public static void playerCARD() {

        if (User.score > 20) {
            RandomNUM = random.nextInt(6) + 1;
        } else {
            RandomNUM = random.nextInt(3) + 1;
        }

        switch (RandomNUM) {
            case 1:
                num++;
                PLANE.id = num;
                You.add(new Player(PLANE.id, PLANE.level, PLANE.defense, PLANE.attack, PLANE.type, PLANE.subType,
                        PLANE.advantageOnA));
                playerCardNum++;
                break;
            case 2:
                num++;
                BOMBSHELL.id = num;
                You.add(new Player(BOMBSHELL.id, BOMBSHELL.level, BOMBSHELL.defense, BOMBSHELL.attack, BOMBSHELL.type,
                        BOMBSHELL.subType, BOMBSHELL.advantageOnN));
                playerCardNum++;
                break;
            case 3:
                num++;
                FRIGATE.id = num;
                You.add(new Player(FRIGATE.id, FRIGATE.level, FRIGATE.defense, FRIGATE.attack, FRIGATE.type,
                        FRIGATE.subType, FRIGATE.advantageOnAF));
                playerCardNum++;
                break;
            case 4:
                num++;
                SIHA.id = num;
                You.add(new Player(SIHA.id, SIHA.level, SIHA.defense, SIHA.attack, SIHA.type, SIHA.subType,
                        SIHA.advantageOnA));
                playerCardNum++;
                break;
            case 5:
                num++;
                KFS.id = num;
                You.add(new Player(KFS.id, KFS.level, KFS.defense, KFS.attack, KFS.type, KFS.subType,
                        KFS.advantageOnN));
                playerCardNum++;
                break;
            case 6:
                num++;
                SIDA.id = num;
                You.add(new Player(SIDA.id, SIDA.level, SIDA.defense, SIDA.attack, SIDA.type, SIDA.subType,
                        SIDA.advantageOnAF));
                playerCardNum++;
                break;
            default:
                System.out.println("Random number is wrong.");
                break;
        }

    }

    public static void computorCARD() {
        if (CPU.score > 20) {
            RandomNUM = random.nextInt(6) + 1;
        } else {
            RandomNUM = random.nextInt(3) + 1;
        }

        switch (RandomNUM) {
            case 1:
                num++;
                PLANE.id = num;
                Computer.add(new Player(PLANE.id, PLANE.level, PLANE.defense, PLANE.attack, PLANE.type, PLANE.subType,
                        PLANE.advantageOnA));
                computerCardNum++;
                break;
            case 2:
                num++;
                BOMBSHELL.id = num;
                Computer.add(new Player(BOMBSHELL.id, BOMBSHELL.level, BOMBSHELL.defense, BOMBSHELL.attack,
                        BOMBSHELL.type, BOMBSHELL.subType, BOMBSHELL.advantageOnN));
                computerCardNum++;
                break;
            case 3:
                num++;
                FRIGATE.id = num;
                Computer.add(new Player(FRIGATE.id, FRIGATE.level, FRIGATE.defense, FRIGATE.attack, FRIGATE.type,
                        FRIGATE.subType, FRIGATE.advantageOnAF));
                computerCardNum++;
                break;
            case 4:
                num++;
                SIHA.id = num;
                Computer.add(new Player(SIHA.id, SIHA.level, SIHA.defense, SIHA.attack, SIHA.type, SIHA.subType,
                        SIHA.advantageOnA));
                computerCardNum++;
                break;
            case 5:
                num++;
                KFS.id = num;
                Computer.add(new Player(KFS.id, KFS.level, KFS.defense, KFS.attack, KFS.type, KFS.subType,
                        KFS.advantageOnN));
                computerCardNum++;
                break;
            case 6:
                num++;
                SIDA.id = num;
                Computer.add(new Player(SIDA.id, SIDA.level, SIDA.defense, SIDA.attack, SIDA.type, SIDA.subType,
                        SIDA.advantageOnAF));
                computerCardNum++;
                break;
            default:
                System.out.println("Random number is wrong.");
                break;
        }
    }

    public static void attacking() {
        // WAR------------------------------------------------------------------------------------------------------

        int[] removeCARDplayer = { -1, -1, -1 };
        int[] removeCARDcomputer = { -1, -1, -1 };

        ListingD = "Results: Game " + (t + 1) + "\n";
        txt += "Results: Game " + (t + 1) + "\n";
        for (int i = 0; 3 > i; i++) {
            // player

            Computer.get(computerHandCard[i]).defense = Computer.get(computerHandCard[i]).defense
                    - You.get(playerHandCard[i]).attack;

            if (You.get(playerHandCard[i]).subType.equals("Siha")
                    && Computer.get(computerHandCard[i]).subType.equals("Frigate")
                    && Computer.get(computerHandCard[i]).subType.equals("Sida")) {
                Computer.get(computerHandCard[i]).defense = Computer.get(computerHandCard[i]).defense
                        - SIHA.advantageSPEC;
            } else if (You.get(playerHandCard[i]).subType.equals("Kfs")
                    && Computer.get(computerHandCard[i]).subType.equals("Plane")
                    && Computer.get(computerHandCard[i]).subType.equals("Siha")) {
                Computer.get(computerHandCard[i]).defense = Computer.get(computerHandCard[i]).defense
                        - KFS.advantageSPEC;
            } else if (You.get(playerHandCard[i]).subType.equals("Sida")
                    && Computer.get(computerHandCard[i]).subType.equals("Bombshell")
                    && Computer.get(computerHandCard[i]).subType.equals("Kfs")) {
                Computer.get(computerHandCard[i]).defense = Computer.get(computerHandCard[i]).defense
                        - You.get(playerHandCard[i]).attack + SIDA.advantageSPEC;
            } else if (You.get(playerHandCard[i]).type.equals("Air")
                    && Computer.get(computerHandCard[i]).type.equals("Army")) {
                Computer.get(computerHandCard[i]).defense = Computer.get(computerHandCard[i]).defense
                        - You.get(playerHandCard[i]).advantage;
            } else if (You.get(playerHandCard[i]).type.equals("Army")
                    && Computer.get(computerHandCard[i]).type.equals("Navy")) {
                Computer.get(computerHandCard[i]).defense = Computer.get(computerHandCard[i]).defense
                        - You.get(playerHandCard[i]).advantage;
            } else if (You.get(playerHandCard[i]).type.equals("Navy")
                    && Computer.get(computerHandCard[i]).type.equals("Air")) {
                Computer.get(computerHandCard[i]).defense = Computer.get(computerHandCard[i]).defense
                        - You.get(playerHandCard[i]).advantage;
            }

            // computer

            You.get(playerHandCard[i]).defense = You.get(playerHandCard[i]).defense
                    - Computer.get(computerHandCard[i]).attack;

            if (Computer.get(computerHandCard[i]).subType.equals("Siha")
                    && You.get(playerHandCard[i]).subType.equals("Frigate")
                    && You.get(playerHandCard[i]).subType.equals("Frigate")) {
                You.get(playerHandCard[i]).defense = You.get(playerHandCard[i]).defense - SIHA.advantageSPEC;
            } else if (Computer.get(computerHandCard[i]).subType.equals("Kfs")
                    && You.get(playerHandCard[i]).subType.equals("Plane")
                    && You.get(playerHandCard[i]).subType.equals("Siha")) {
                You.get(playerHandCard[i]).defense = You.get(playerHandCard[i]).defense - KFS.advantageSPEC;
            } else if (Computer.get(computerHandCard[i]).subType.equals("Sida")
                    && You.get(playerHandCard[i]).subType.equals("Bombshell")
                    && You.get(playerHandCard[i]).subType.equals("Kfs")) {
                You.get(playerHandCard[i]).defense = You.get(playerHandCard[i]).defense - SIDA.advantageSPEC;
            } else if (Computer.get(computerHandCard[i]).type.equals("Air")
                    && You.get((playerHandCard[i])).type.equals("Army")) {
                You.get(playerHandCard[i]).defense = You.get(playerHandCard[i]).defense
                        - Computer.get(computerHandCard[i]).advantage;
            } else if (Computer.get(computerHandCard[i]).type.equals("Army")
                    && You.get((playerHandCard[i])).type.equals("Navy")) {
                You.get(playerHandCard[i]).defense = You.get(playerHandCard[i]).defense
                        - Computer.get(computerHandCard[i]).advantage;
            } else if (Computer.get(computerHandCard[i]).type.equals("Navy")
                    && You.get((playerHandCard[i])).type.equals("Air")) {
                You.get(playerHandCard[i]).defense = You.get(playerHandCard[i]).defense
                        - Computer.get(computerHandCard[i]).advantage;
            }

            // result
            if (You.get(playerHandCard[i]).defense <= 0) {
                if (You.get(playerHandCard[i]).level < 10) {
                    You.get(playerHandCard[i]).level = 10;
                }
                CPU.score = CPU.score + You.get(playerHandCard[i]).level;
                Computer.get(computerHandCard[i]).level = Computer.get(computerHandCard[i]).level
                        + You.get(playerHandCard[i]).level;
                ListingD = ListingD + "\nPLAYER(die) " + You.get(playerHandCard[i]).subType + ":\n" + "Defense: "
                        + You.get(playerHandCard[i]).defense + "\n"
                        + "Level: " + You.get(playerHandCard[i]).level + "\n";
                // TXT
                txt += "\nPLAYER(die) " + You.get(playerHandCard[i]).subType + ":\n" + "Defense: "
                        + You.get(playerHandCard[i]).defense + "\n"
                        + "Level: " + You.get(playerHandCard[i]).level + "\n";

                removeCARDplayer[i] = You.get(playerHandCard[i]).id;
                changeImage(labels, i);
            } else
                ListingD = ListingD + "\nPLAYER: " + You.get(playerHandCard[i]).subType + ":\n" + "Defense: "
                        + You.get(playerHandCard[i]).defense + "\n"
                        + "Level: " + You.get(playerHandCard[i]).level + "\n";
            // TXT
            txt += "\nPLAYER: " + You.get(playerHandCard[i]).subType + ":\n" + "Defense: "
                    + You.get(playerHandCard[i]).defense + "\n"
                    + "Level: " + You.get(playerHandCard[i]).level + "\n";

            if (Computer.get(computerHandCard[i]).defense <= 0) {
                if (Computer.get(computerHandCard[i]).level < 10) {
                    Computer.get(computerHandCard[i]).level = 10;
                }
                User.score = User.score + Computer.get(computerHandCard[i]).level;
                You.get(playerHandCard[i]).level = You.get(playerHandCard[i]).level
                        + Computer.get(computerHandCard[i]).level;
                ListingD = ListingD + "COMPUTER(die) " + Computer.get(computerHandCard[i]).subType + ":\n" + "Defense: "
                        + Computer.get(computerHandCard[i]).defense + "\n"
                        + "Level: " + Computer.get(computerHandCard[i]).level + "\n";
                // TXT
                txt += "COMPUTER(die) " + Computer.get(computerHandCard[i]).subType + ":\n" + "Defense: "
                        + Computer.get(computerHandCard[i]).defense + "\n"
                        + "Level: " + Computer.get(computerHandCard[i]).level + "\n";

                removeCARDcomputer[i] = Computer.get(computerHandCard[i]).id;
                changeImage(labels, i + 3);
            } else
                ListingD = ListingD + "COMPUTER: " + Computer.get(computerHandCard[i]).subType + ":\n" + "Defense: "
                        + Computer.get(computerHandCard[i]).defense + "\n"
                        + "Level: " + Computer.get(computerHandCard[i]).level + "\n";
            // TXT
            txt += "COMPUTER: " + Computer.get(computerHandCard[i]).subType + ":\n" + "Defense: "
                    + Computer.get(computerHandCard[i]).defense + "\n"
                    + "Level: " + Computer.get(computerHandCard[i]).level + "\n";
        }
        GameDetails.setText(ListingD);
        for (int i = 0; removeCARDplayer.length > i; i++) {
            for (int j = 0; playerCardNum > j; j++) {
                if (removeCARDplayer[i] == You.get(j).id) {
                    You.remove(j);
                    playerCardNum--;
                }
            }
        }

        for (int i = 0; removeCARDcomputer.length > i; i++) {
            for (int j = 0; computerCardNum > j; j++) {
                if (removeCARDcomputer[i] == Computer.get(j).id) {
                    Computer.remove(j);
                    computerCardNum--;
                }
            }
        }

    }

    public static void displayGAME() {

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

        ListCardP.setEditable(false);
        GameDetails.setEditable(false);
        GameSupDetails.setEditable(false);

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
                SideInfo.add(GameInfo, BorderLayout.SOUTH);
                GameInfo.setLayout(null);
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

                GameInfo.setPreferredSize(new Dimension(200, 450));
                GameDetails.setBounds(0, 50, 200, 450);
                GameDetails.setBackground(Color.LIGHT_GRAY);
                GameSupDetails.setBounds(0, 0, 200, 50);
                GameSupDetails.setBackground(Color.LIGHT_GRAY);
                GameSupDetails.setText("Choose 3 cards.");
                for (int j = 0; playerCardNum > j; j++) {
                    ListingP = ListingP + "-" + You.get(j).subType + " " + You.get(j).id + "\n";
                }
                ListCardP.setText(ListingP);
                GameInfo.add(GameDetails);
                GameInfo.add(GameSupDetails);

                FrameWork.add(Monitor, BorderLayout.CENTER);
                FrameWork.add(SideInfo, BorderLayout.EAST);
            }
        });
        Monitor.add(Start);
        FrameWork.add(Monitor);

        Submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    cardP = Integer.parseInt(Choice.getText());
                    if (cardP < 1 || cardP > playerCardNum)
                        throw new ArithmeticException("The number is too high or too low");
                    else if (chosenCardsP.contains(You.get(cardP - 1).id))
                        throw new ArithmeticException(
                                "You have already chosen this card. Please choose a different card.");
                    else {
                        playerHandCard[a] = cardP - 1;
                        GameSupDetails.setText(
                                You.get(playerHandCard[a]).subType + "-" + You.get(playerHandCard[a]).id + " chosen.");
                        chosenCardsP.add(You.get(playerHandCard[a]).id);
                        a++;
                        if (chosenCardsP.size() >= playerCardNum)
                            chosenCardsP.clear();
                    }
                } catch (NumberFormatException ex) {
                    GameSupDetails.setText("Please enter only number format!");
                } catch (ArithmeticException ex) {
                    GameSupDetails.setText(ex.getMessage());
                }
                if (a == 3) {
                    GameSupDetails.setText("You've entered succesfully 3 Cards now click on next to continue.");
                    Submit.setEnabled(false);
                    Next.setEnabled(true);
                    for (int i = 0; i < 3; i++) {
                        int card;
                        do {
                            card = random.nextInt(computerCardNum);
                            computerHandCard[i] = card;
                        } while (chosenCards.contains(Computer.get(computerHandCard[i]).id));
                        chosenCards.add(Computer.get(computerHandCard[i]).id);

                        if (chosenCards.size() >= computerCardNum) {
                            chosenCards.clear();
                        }

                    }
                    a = 0;
                }
            }
        });
        Next.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                changeImage(labels, playerHandCard, computerHandCard);
                Attack.setEnabled(true);
                Next.setEnabled(false);
                GameSupDetails.setText("The Cards are on the table.\nNow it's time to fight!");
            }

        });
        Attack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                war++;
                changeImage(war, labels, GameDetails);
                if (war == 3) {
                    Result.setEnabled(true);
                    Result.setVisible(true);
                    Attack.setEnabled(false);
                    war = 0;
                    GameSupDetails.setText("Attacking...");
                }
            }
        });
        Result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Result.setVisible(false);
                attacking();
                GameSupDetails.setText("Wait for the cards to be dealt!");
                if (playerCardNum == 0 && computerCardNum != 0) {
                    txt += "\nComputer is winner. BY KO\n";
                    for (int j = 0; computerCardNum > j; j++) {
                        txt += Computer.get(j).subType + "\n";
                        txt += "level: " + Computer.get(j).level + "\n";
                        txt += "defense: " + Computer.get(j).defense + "\n";
                    }
                    // ENDING
                    endS = 'C';
                    stop = false;
                }
                if (computerCardNum == 0 && playerCardNum != 0) {
                    txt += "\nPlayer is winner. BY KO\n";
                    for (int k = 0; playerCardNum > k; k++) {
                        txt += You.get(k).subType + "\n";
                        txt += "level: " + You.get(k).level + "\n";
                        txt += "defense: " + You.get(k).defense + "\n";
                    }
                    // ENDING
                    endS = 'P';
                    stop = true;
                }

                if (playerCardNum != 0 && computerCardNum != 0 && t == 4 || computerCardNum == 0 && playerCardNum == 0
                        || counterP == 1 || counterC == 1) {
                    txt += "\nWar is finish\n";

                    for (int j = 0; computerCardNum > j; j++) {
                        txt += "Computer: " + Computer.get(j).subType + "\n";
                    }
                    txt += "\n";
                    for (int j = 0; playerCardNum > j; j++) {
                        txt += "Player: " + You.get(j).subType + "\n";
                    }

                    for (int m = 0; playerCardNum > m; m++) {
                        totalDEFENSEplayer = totalDEFENSEplayer + You.get(m).defense;
                    }

                    for (int l = 0; computerCardNum > l; l++) {
                        totalDEFENSEcomputer = totalDEFENSEcomputer + Computer.get(l).defense;
                    }

                    if (CPU.score > User.score) {

                        txt += "\nwinner is computer(score)\n";
                        txt += "Score computer: " + CPU.score + "\n";
                        txt += "Score user: " + User.score + "\n";
                        // ENDING
                        endS = 'C';
                        stop = true;
                    } else if (User.score > CPU.score) {

                        txt += "\nwinner is player(score)\n";
                        txt += "Score player: " + User.score + "\n";
                        txt += "Score computer: " + CPU.score + "\n";
                        // ENDING
                        endS = 'P';
                        stop = true;
                    } else if (totalDEFENSEcomputer > totalDEFENSEplayer) {
                        txt += "\nwinner is computer(defense)\n";
                        for (int j = 0; computerCardNum > j; j++) {
                            txt += Computer.get(j).subType + "\n";
                            txt += "level: " + Computer.get(j).level + "\n";
                            txt += "defense: " + Computer.get(j).defense + "\n";
                        }
                        // ENDING
                        endS = 'C';
                        stop = true;
                    } else if (totalDEFENSEcomputer < totalDEFENSEplayer) {
                        txt += "\nwinner is player(level)\n";
                        for (int k = 0; playerCardNum > k; k++) {
                            txt += You.get(k).subType + "\n";
                            txt += "level: " + You.get(k).level + "\n";
                            txt += "defense: " + You.get(k).defense + "\n";
                        }
                        // ENDING
                        endS = 'P';
                    } else {
                        txt += "\nThe war ended in a draw.\n";
                        endS = 'T';
                        stop = true;
                    }
                }

                if (playerCardNum != 0)
                    playerCARD();
                if (computerCardNum != 0)
                    computorCARD();

                if (playerCardNum == 2 && counterP == 0) {
                    playerCARD();
                    counterP++;
                }
                if (computerCardNum == 2 && counterC == 0) {
                    computorCARD();
                    counterC++;

                }
                t++;

                Timer timer = new Timer(8000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        changeImage(labels);
                        GameSupDetails.setText("Now you can play.");
                        Submit.setEnabled(true);
                        ListingP = "Your CARDS:\n";
                        for (int j = 0; playerCardNum > j; j++) {
                            ListingP = ListingP + "-" + You.get(j).subType + " " + You.get(j).id + "\n";
                        }
                        ListCardP.setText(ListingP);
                    }
                });

                timer.setRepeats(false);
                timer.start();

                if (stop) {
                    for (int i = 0; i < 6; i++) {
                        Monitor.remove(labels[i] = new JLabel());
                    }
                    FrameWork.remove(Monitor);

                    Timer endGameTimer = new Timer(8000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            ENDGAME(endS);
                        }
                    });
                    endGameTimer.setRepeats(false);
                    endGameTimer.start();
                }
            }
        });

        // MAIN
        // GAME-------------------------------------------------------------------------------------------------------------
        for (int i = 0; 6 > i; i++) {
            playerCARD();
            computorCARD();
        }

    }

    public static void ENDGAME(char end) {

        FrameWork.remove(SideInfo);
        FrameWork.remove(Attack);
        FrameWork.remove(Next);
        FrameWork.remove(Submit);
        FrameWork.remove(Result);
        FrameWork.remove(Choice);
        FrameWork.remove(ListCardP);
        FrameWork.remove(GameDetails);
        FrameWork.remove(GameInfo);
        FrameWork.remove(GameSupDetails);
        FrameWork.remove(PlayerInfo);

        JTextPane EndScore = new JTextPane();
        JButton Exit = new JButton("Exit Game");

        EndScore.setBounds(1240, 400, 200, 400);
        EndScore.setBorder(blackBorder);
        EndScore.setText(ListingD);
        EndScore.setBackground(new Color(222, 210, 173));
        EndScore.setEditable(false);
        Exit.setBounds(1300, 800, 100, 50);
        Exit.setForeground(Color.RED);
        Exit.setVisible(true);
        Exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }

        });

        ListingD = "RESULTS\nPlayer reamining cards:\n";
        for (int i = 0; i < You.size() - 1; i++) {
            ListingD += You.get(i).subType + " " + You.get(i).id + "\n";
        }
        ListingD += "Computer reamining cards:\n";
        for (int i = 0; i < Computer.size() - 1; i++) {
            ListingD += Computer.get(i).subType + " " + Computer.get(i).id + "\n";
        }
        ListingD += User.showScore("Player", User.score, totalDEFENSEplayer);
        ListingD += CPU.showScore("Computer", CPU.score, totalDEFENSEcomputer);
        EndScore.setText(ListingD);
        switch (end) {
            case 'P':
                link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/Victory.png";
                break;
            case 'C':
                link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/Defeat.png";
                break;
            case 'T':
                link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/Tie.png";
                break;
            default:
                break;
        }
        JPanel Monitor = new JPanel() {
            private Image image = new ImageIcon(link)
                    .getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        Monitor.setLayout(null);
        Monitor.add(EndScore);
        Monitor.add(Exit);
        FrameWork.add(Monitor);

        writeNewFile(txt);
    }

    public static void changeImage(JLabel[] labels) {

        for (int i = 0; i < 6; i++) {
            link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/TBW2.png";
            ImageIcon imageIcon = new ImageIcon(link);
            Image scaledImage = imageIcon.getImage().getScaledInstance(300, 500, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            labels[i].setIcon(scaledIcon);
        }
    }

    public static void changeImage(JLabel[] labels, int[] play, int[] comp) {

        int mk = 0;
        for (int i = 0; i < 3; i++) {
            switch (You.get(play[mk]).subType.charAt(2)) {
                case 'h':
                    link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/SIHA.png";
                    break;
                case 'd':
                    link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/SIDA.png";
                    break;
                case 's':
                    link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/KFS.png";
                    break;
                case 'i':
                    link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/Frigate.png";
                    break;
                case 'm':
                    link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/Bombshell.png";
                    break;
                case 'a':
                    link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/Plane.png";
                    break;

                default:
                    break;
            }

            ImageIcon imageIcon = new ImageIcon(link);
            Image scaledImage = imageIcon.getImage().getScaledInstance(300, 500, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            labels[i].setIcon(scaledIcon);
            mk++;
        }
        mk = 0;
        for (int i = 3; i < 6; i++) {
            switch (Computer.get(comp[mk]).subType.charAt(2)) {
                case 'h':
                    link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/SIHA.png";
                    break;
                case 'd':
                    link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/SIDA.png";
                    break;
                case 's':
                    link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/KFS.png";
                    break;
                case 'i':
                    link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/Frigate.png";
                    break;
                case 'm':
                    link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/Bombshell.png";
                    break;
                case 'a':
                    link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/Plane.png";
                    break;

                default:
                    break;
            }

            ImageIcon imageIcon = new ImageIcon(link);
            Image scaledImage = imageIcon.getImage().getScaledInstance(300, 500, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            labels[i].setIcon(scaledIcon);
            mk++;
        }
    }

    public static void changeImage(int war, JLabel[] labels, JTextPane ListCardC) {

        link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/WAR.png";
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

    public static void changeImage(JLabel[] labels, int dead) {

        link = "/Users/nisanurkorkmaz/Desktop/ProLab-II/Game/src/assets/DEAD.png";
        ImageIcon imageIcon = new ImageIcon(link);
        Image scaledImage = imageIcon.getImage().getScaledInstance(300, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        labels[dead].setIcon(scaledIcon);
    }

    public static void writeNewFile(String GameText) {

        try {
            File TBWgame = new File("TBWgame.txt");
            if (!TBWgame.exists()) {
                TBWgame.createNewFile();

                FileWriter fw = new FileWriter(TBWgame);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write(GameText);
                System.out.println(GameText);
                bw.close();
                fw.close();
            }
        } catch (IOException f) {
            System.err.println("A problem has occured: " + f.getMessage());
        }

    }
}

class Player {

    int score;
    String name;
    int UserID;
    int id;
    int advantage;
    int level;
    int defense;
    int attack;
    String type;
    String subType;
    boolean used = false;
    HashMap<String, Integer> cards = new HashMap<>();
    int i = 1;

    Player(int id, int level, int defense, int attack, String type, String subType, int advantage) {
        this.id = id;
        this.level = level;
        this.defense = defense;
        this.attack = attack;
        this.type = type;
        this.advantage = advantage;
        this.subType = subType;
        cards.put(subType, i);
        i++;
    }

    Player(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public String showScore(String sentence, int score, int def) {

        return ("\n" + sentence + " Score: " + score + "/Defense: " + def + "\n");
    }
}