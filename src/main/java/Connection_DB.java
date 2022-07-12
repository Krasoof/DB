import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Connection_DB extends JFrame {

    private static JLabel password;
    private static JLabel label;
    private static JTextField userText;
    private static JPasswordField passwordField;
    private static JButton button;
    private static JLabel succes;
    private static JLabel ussers;
    private static  UsserService service;
    private static JFrame frame;
    private static JPanel panel;
    private static JLabel label3;
    private static Map<String,JButton> buttony = new HashMap<>();


    private static int i =0;
    private static int y = 150;


    static Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true)
                frame.repaint();
        }
    });





    public static void main(String[] args) throws Exception {



        service = new UsserService();
        service.addUsser(new Usser("IX3L_06","#ix3l_06#"));

        QueriesSerice queriesSerice = new QueriesSerice( new GoodQueries(),new BadQueries());
            frame = new JFrame("DB");
            thread.start();
            panel = new JPanel();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            panel.setLayout(null);
            frame.add(panel);

            label = new JLabel("Usser");
            label.setBounds(10,20,80,25);
            panel.add(label);

            userText = new JTextField("IX3L_06");
            userText.setBounds(100,20,165,25);



            password = new JLabel("Password");
            password.setBounds(10,50,80,25);

            passwordField = new JPasswordField("#ix3l_06#");
            passwordField.setBounds(100,50,165,25);

            button = new JButton("LogIn");
            button.setBounds(10,80,80,25);




            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    try {
                        service.addUsser(new Usser(userText.getText(), passwordField.getText()));
                        succes.setText("Login succesful");
                        buttony.put(userText.getText(),new JButton(userText.getText()));
                        buttony.get(userText.getText()).setBounds(10,y,80,25);
                        panel.add(buttony.get(userText.getText()));
                        buttony.get(userText.getText()).addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton buttonBad;
                                JButton buttonGood;
                                JTextArea textArea = new JTextArea();
                                JLabel label = new JLabel();
                                JTextField field = new JTextField(20);
                                JFrame frameUsser = new JFrame(userText.getText());
                                JPanel panelU = new JPanel();
                                panelU.setLayout(null);
                                frameUsser.setSize(300,300);
                                frameUsser.setVisible(true);
                                panelU.add(field).setBounds(100,20,165,25);
                                panelU.add(new JLabel("Insert queries")).setBounds(10,20,80,25);
                                panelU.add(label).setBounds(10,400,100,100);
                                buttonBad = new JButton("Bad Procces");
                                buttonBad.setBounds(10,80,180,25);
                                panelU.add(buttonBad);
                                frameUsser.add(panelU);
                                panelU.add(textArea);
                                buttonBad.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        System.out.println("eee");
                                        panelU.add(textArea);
                                        try {
                                            ResultSet rs =
                                                    queriesSerice.badQueries.selectQ(field.getText(),
                                                            service.ussers.get(userText.getText()));
                                            while (rs.next())
                                            {
                                                List<String> tmp = new ArrayList<>();
                                                        tmp.add(rs.getString("klient_imie"));
                                                System.out.println(tmp);

                                            }
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }


                                        frameUsser.add(new JLabel());

                                    }
                                });

                                buttonGood = new JButton("Good Procces");
                                panelU.add(buttonGood);
                                buttonGood.setBounds(10,120,180,25);
                                buttonGood.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            ResultSet rs = queriesSerice.goodQueries.selectQ(field.getText(),service.ussers.get(userText.getText()));
                                            while (rs.next())
                                            {
                                                String tmp = rs.getString("klient_imie");
                                                System.out.println(tmp);
                                            }
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }

                                    }
                                });

                            }
                        });

                        y +=30;
                        i++;
                    } catch (SQLException ex) {
                        ex.printStackTrace();

                    }
                }
            });



            succes = new JLabel("");
            succes.setBounds(10,110,300,25);
            label3 = new JLabel("Zalogowani");
            label3.setBounds(10,125,300,25);
            ussers = new JLabel("");
            ussers.setBounds(10,135,300,25);

            panel.add(button);
            panel.add(userText);
            panel.add(passwordField);
            panel.add(password);
            panel.add(succes);
            panel.add(ussers);
            panel.add(label3);

            frame.setVisible(true);

//            "IX3L_06"
//            "#ix3l_06#"






        }

    }


