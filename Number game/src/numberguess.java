import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class numberguess extends JFrame implements ActionListener{
    private JLabel numbertxt;
    private JTextField numberentry;
    int randnumber;
    int guess=0;
    private JButton checkbtn;
    private JButton answerbtn;
    private JButton restartbtn;
    private JLabel answerlbl;
    private JTextArea histroyarea;


    public numberguess(){
        randnumber=new Random().nextInt(100)+1;
        setTitle("Number Guessing Game");
        setSize(600,400);
        setLayout(null);
        setBackground(Color.GRAY);
        insertwidgets();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void insertwidgets(){
        numbertxt=new JLabel("Enter Number between 1-100 :");
        numbertxt.setBounds(20,30,300,30);
        numbertxt.setFont(new Font("serif",Font.BOLD,20));
        numberentry=new JTextField(4);
        numberentry.setBounds(20,60,200,30);
        checkbtn=new JButton("Check");
        checkbtn.setBounds(290,60,80,30);
        checkbtn.addActionListener(this);
        answerlbl=new JLabel("Result");
        answerlbl.setBounds(90,100,300,30);
        answerlbl.setFont(new Font("serif",Font.ITALIC,20));
        answerbtn=new JButton("Give up!");
        answerbtn.setBounds(100,140,100,30);
        answerbtn.addActionListener(this);
        restartbtn=new JButton("Restart");
        restartbtn.setBounds(250,140,100,30);
        restartbtn.addActionListener(this);
        histroyarea=new JTextArea();
        histroyarea.setBounds(30,180,410,170);



        add(numbertxt);
        add(numberentry);
        add(checkbtn);
        add(answerlbl);
        add(answerbtn);
        add(restartbtn);
        add(histroyarea);


    }

    public static void main(String[]args){
        new numberguess().setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        guess=Integer.parseInt(numberentry.getText());
        if (e.getSource()==answerbtn){
            answerlbl.setText(("Answer= "+randnumber));

        }
        if (e.getSource()==checkbtn){
            histroyarea.append("You guessed "+guess+"\n");
            if(guess<=0||guess>100){
                answerlbl.setText("Your guess is Invalid");
            }
            else if(guess==randnumber){
                answerlbl.setText("Correct guess.Number="+randnumber);
            }
            else if(guess>randnumber){
                answerlbl.setText("Your guess is too high.Try Again");
            }
            else if(guess<randnumber){
                answerlbl.setText("Your guess is too low.Try Again");
            }
            else{
                answerlbl.setText("Your guess is incorrect.Try again");
            }


        }
        if (e.getSource()==restartbtn){
            randnumber=new Random().nextInt(100)+1;
            histroyarea.setText(null);
            answerlbl.setText("");
            numberentry.setText("");
        }


    }
}
