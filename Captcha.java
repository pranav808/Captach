package CaptchaSecurity;



import javax.swing.*;
import java.awt.*;
//import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Captcha extends Frame implements ActionListener {
    TextField t1;
    Button b1;
    JButton b2;
    Label lb;
    StringBuilder sb;


    public Captcha() {
        lb = new Label("");
        lb.setBounds(170, 100, 200, 30);
        lb.setText(getcaptcha());
        t1 = new TextField(10);
        b1 = new Button("Submit");
        sb = new StringBuilder();
        this.setBackground(new Color(173,216,230));
        ImageIcon ii =new ImageIcon("C:\\Users\\pranav\\IdeaProjects\\untitled\\iimg\\ref.png");
        b2= new JButton();
        b2.setIcon(ii);
        b1.setBackground(new Color(135,206,235));

    }

    public static void main(String[] args) {
        Captcha cp = new Captcha();
        Font f = new Font("Cooper Std", Font.BOLD, 20);
        cp.setSize(500, 300);
        cp.setTitle("captcha of new g");
        cp.setVisible(true);
        cp.addWindowListener(new MyClose());

        cp.add(cp.b1);
        cp.add(cp.b2);
        cp.add(cp.t1);
        cp.add(cp.lb);
//        cp.add(cp.lb2);
        cp.setLayout(null);
        cp.b1.setBounds(200, 190, 70, 40);
        cp.b2.setBounds(350, 150, 30, 30);
        cp.t1.setBounds(150, 150, 200, 30);





        cp.lb.setFont(f);
        cp.t1.setFont(f);
        cp.b1.addActionListener(cp);
        cp.b2.addActionListener(cp);
    }


    public String getcaptcha() {
        char data[] = {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p',
                'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', 'Q', 'W', 'R', 'T', 'Y', 'U', 'I', 'O', 'P',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};


        char Index[] = new char[6];
        Random r = new Random();

        for (int i = 0; i < (Index.length); i++) {
            int ran = r.nextInt(data.length);
            Index[i] = data[ran];

        }
        return new String(Index);

    }
Label validity ;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {

            System.out.println(t1.getText());
            System.out.println(lb.getText());
            if (t1.getText().equals(lb.getText()) ) {

                validity=new Label("The captcha is valid");
                this.add(validity);
                Font f = new Font("Cooper Std", Font.BOLD, 17);
                validity.setFont(f);
                validity.setBounds(160,250,180,20);

            } else {
                 validity=new Label("The captcha is invalid");
                this.add(validity);
                Font f = new Font("Cooper Std", Font.BOLD, 17);
                validity.setFont(f);
                validity.setBounds(150,250,180,20);
            }


        }
        if (e.getSource() == b2) {
            lb.setText(getcaptcha());
            t1.setText("");

//            valid.setVisible(false);
            validity.setVisible(false);


        }

    }
}
