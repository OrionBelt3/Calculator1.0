import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorWindow {
    Realization realization = new Realization();
    String WARRING_MESSAGE_EMPTY = "Won't entered any symbols!\n";
    int sizeButtonWeight = 60;
    int sizeButtonHeight = 60;
    int sizeBetweenButtons = 40;
    int heightTopPadding = 20;
    int sizeTextFieldWeight = 380;
    int sizeTextFieldHeight = 40;
    int pointXPanelRight = 300;
    int pointYPanelRight = 0;

    Font font = new Font("Bitstream Charter", Font.BOLD, 20);
    Font font2 = new Font("Bitstream Charter", Font.BOLD, 14);

    JFrame frame = new JFrame("CALCULATOR");

    private JFrame createJFrame(){
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width/2-400, dimension.height/2-250, 800, 500);

        String prevChar= "";

        panelRight.setLayout(null);

        panelLeft.setSize(320, 500);
        panelRight.setSize(480, 500);
        panelLeft.setLocation(0,0);
        panelRight.setLocation(320, 0);
        panelLeft.setBackground(Color.black);
        panelRight.setBackground(Color.black);
        display.setSize(440, 60);
        display.setLocation(pointXPanelRight+40, pointYPanelRight+10);
        buttonCF.setSize(sizeButtonWeight, sizeButtonHeight);
        buttonCF.setLocation(pointXPanelRight+30+3*sizeButtonWeight+3*sizeBetweenButtons, pointYPanelRight+sizeTextFieldHeight+6*heightTopPadding+4*sizeButtonHeight);
        buttonEqual.setSize(sizeButtonWeight, sizeButtonHeight);
        buttonEqual.setLocation(pointXPanelRight + 40, pointYPanelRight+sizeTextFieldHeight+2*heightTopPadding);
        buttonOpenBracket.setSize(sizeButtonWeight, sizeButtonHeight);
        buttonOpenBracket.setLocation(pointXPanelRight+40+sizeButtonWeight+sizeBetweenButtons, pointYPanelRight+sizeTextFieldHeight+2*heightTopPadding);
        buttonCloseBracket.setSize(sizeButtonWeight, sizeButtonHeight);
        buttonCloseBracket.setLocation(pointXPanelRight+40+2*sizeButtonWeight+2*sizeBetweenButtons, pointYPanelRight+sizeTextFieldHeight+2*heightTopPadding);
        buttonDelete.setSize(sizeButtonWeight, sizeButtonHeight);
        buttonDelete.setLocation(pointXPanelRight+sizeButtonWeight+280+2*sizeBetweenButtons, pointYPanelRight+sizeTextFieldHeight+2*heightTopPadding);

        button1.setSize(sizeButtonWeight, sizeButtonHeight);
        button1.setLocation(pointXPanelRight+40, pointYPanelRight+sizeTextFieldHeight+3*heightTopPadding+sizeButtonHeight);
        button2.setSize(sizeButtonWeight, sizeButtonHeight);
        button2.setLocation(pointXPanelRight+40+sizeButtonWeight+sizeBetweenButtons, pointYPanelRight+sizeTextFieldHeight+3*heightTopPadding+sizeButtonHeight);
        button3.setSize(sizeButtonWeight, sizeButtonHeight);
        button3.setLocation(pointXPanelRight+40+2*sizeButtonWeight+2*sizeBetweenButtons, pointYPanelRight+sizeTextFieldHeight+3*heightTopPadding+sizeButtonHeight);
        buttonPlus.setSize(sizeButtonWeight, sizeButtonHeight);
        buttonPlus.setLocation(pointXPanelRight+sizeButtonWeight+280+2*sizeBetweenButtons, pointYPanelRight+sizeTextFieldHeight+3*heightTopPadding+sizeButtonHeight);

        button4.setSize(sizeButtonWeight, sizeButtonHeight);
        button4.setLocation(pointXPanelRight+40, pointYPanelRight+sizeTextFieldHeight+4*heightTopPadding+2*sizeButtonHeight);
        button5.setSize(sizeButtonWeight, sizeButtonHeight);
        button5.setLocation(pointXPanelRight+40+sizeButtonWeight+sizeBetweenButtons, pointYPanelRight+sizeTextFieldHeight+4*heightTopPadding+2*sizeButtonHeight);
        button6.setSize(sizeButtonWeight, sizeButtonHeight);
        button6.setLocation(pointXPanelRight+40+2*sizeButtonWeight+2*sizeBetweenButtons, pointYPanelRight+sizeTextFieldHeight+4*heightTopPadding+2*sizeButtonHeight);
        buttonMinus.setSize(sizeButtonWeight, sizeButtonHeight);
        buttonMinus.setLocation(pointXPanelRight+sizeButtonWeight+280+2*sizeBetweenButtons, pointYPanelRight+sizeTextFieldHeight+4*heightTopPadding+2*sizeButtonHeight);

        button7.setSize(sizeButtonWeight, sizeButtonHeight);
        button7.setLocation(pointXPanelRight+40, pointYPanelRight+sizeTextFieldHeight+5*heightTopPadding+3*sizeButtonHeight);
        button8.setSize(sizeButtonWeight, sizeButtonHeight);
        button8.setLocation(pointXPanelRight+40+sizeButtonWeight+sizeBetweenButtons, pointYPanelRight+sizeTextFieldHeight+5*heightTopPadding+3*sizeButtonHeight);
        button9.setSize(sizeButtonWeight, sizeButtonHeight);
        button9.setLocation(pointXPanelRight+40+2*sizeButtonWeight+2*sizeBetweenButtons, pointYPanelRight+sizeTextFieldHeight+5*heightTopPadding+3*sizeButtonHeight);
        buttonMultiplication.setSize(sizeButtonWeight, sizeButtonHeight);
        buttonMultiplication.setLocation(pointXPanelRight+sizeButtonWeight+280+2*sizeBetweenButtons, pointYPanelRight+sizeTextFieldHeight+5*heightTopPadding+3*sizeButtonHeight);

        buttonPoint.setSize(sizeButtonWeight, sizeButtonHeight);
        buttonPoint.setLocation(pointXPanelRight+40, pointYPanelRight+sizeTextFieldHeight+6*heightTopPadding+4*sizeButtonHeight);
        button0.setSize(sizeButtonWeight, sizeButtonHeight);
        button0.setLocation(pointXPanelRight+40+sizeButtonWeight+sizeBetweenButtons, pointYPanelRight+sizeTextFieldHeight+6*heightTopPadding+4*sizeButtonHeight);
        buttonC.setSize(sizeButtonWeight, sizeButtonHeight);
        buttonC.setLocation(pointXPanelRight+40+2*sizeButtonWeight+2*sizeBetweenButtons, pointYPanelRight+sizeTextFieldHeight+6*heightTopPadding+4*sizeButtonHeight);
        buttonDivision.setSize(sizeButtonWeight, sizeButtonHeight);
        buttonDivision.setLocation(pointXPanelRight+sizeButtonWeight+280+2*sizeBetweenButtons, pointYPanelRight+sizeTextFieldHeight+6*heightTopPadding+4*sizeButtonHeight);

        historyDisplay.setBounds(10,10, 280, 500);

        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + ((JButton)e.getSource()).getText());
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + ((JButton)e.getSource()).getText());
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + ((JButton)e.getSource()).getText());
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + ((JButton)e.getSource()).getText());
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + ((JButton)e.getSource()).getText());
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + ((JButton)e.getSource()).getText());
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + ((JButton)e.getSource()).getText());
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + ((JButton)e.getSource()).getText());
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + ((JButton)e.getSource()).getText());
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + ((JButton)e.getSource()).getText());
            }
        });
        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + ((JButton)e.getSource()).getText());
                //prevChar = ((JButton)e.getSource()).getText();
            }
        });
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + ((JButton)e.getSource()).getText());
            }
        });
        buttonMultiplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + ((JButton)e.getSource()).getText());
            }
        });
        buttonDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + ((JButton)e.getSource()).getText());
            }
        });
        buttonPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + ((JButton)e.getSource()).getText());
            }
        });
        buttonOpenBracket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + ((JButton)e.getSource()).getText());
            }
        });
        buttonCloseBracket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + ((JButton)e.getSource()).getText());
            }
        });

        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder str = new StringBuilder(display.getText());
                if(str.length() != 0) {
                    display.setText(str.deleteCharAt(str.length()-1).toString());
                } else {
                    historyDisplay.setText(historyDisplay.getText() + WARRING_MESSAGE_EMPTY);
                }

            }
        });
        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(null);
            }
        });

        buttonCF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(null);
                historyDisplay.setText(null);
            }
        });

        buttonEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String result = (realization.calculation(display.getText()).toString());
                historyDisplay.setText(historyDisplay.getText() + display.getText() + "=" + result + "\n");
                display.setText(result);
            }
        });

        button0.setFont(font);
        button1.setFont(font);
        button2.setFont(font);
        button3.setFont(font);
        button4.setFont(font);
        button5.setFont(font);
        button6.setFont(font);
        button7.setFont(font);
        button8.setFont(font);
        button9.setFont(font);
        buttonPoint.setFont(font);
        buttonC.setFont(font);
        buttonCF.setFont(font);
        buttonPlus.setFont(font);
        buttonMinus.setFont(font);
        buttonMultiplication.setFont(font);
        buttonDivision.setFont(font);
        buttonDelete.setFont(font);
        buttonCloseBracket.setFont(font);
        buttonOpenBracket.setFont(font);
        buttonEqual.setFont(font);

        button0.setBackground(Color.lightGray);
        button1.setBackground(Color.lightGray);
        button2.setBackground(Color.lightGray);
        button3.setBackground(Color.lightGray);
        button4.setBackground(Color.lightGray);
        button5.setBackground(Color.lightGray);
        button6.setBackground(Color.lightGray);
        button7.setBackground(Color.lightGray);
        button8.setBackground(Color.lightGray);
        button9.setBackground(Color.lightGray);
        buttonPoint.setBackground(Color.lightGray);
        buttonC.setBackground(Color.lightGray);
        buttonCF.setBackground(Color.lightGray);
        buttonPlus.setBackground(Color.lightGray);
        buttonMinus.setBackground(Color.lightGray);
        buttonMultiplication.setBackground(Color.lightGray);
        buttonDivision.setBackground(Color.lightGray);
        buttonDelete.setBackground(Color.lightGray);
        buttonCloseBracket.setBackground(Color.lightGray);
        buttonOpenBracket.setBackground(Color.lightGray);
        buttonEqual.setBackground(Color.lightGray);




        panelRight.add(display);
        panelRight.add(buttonCF);
        panelRight.add(buttonEqual);
        panelRight.add(buttonDelete);
        panelRight.add(button1);
        panelRight.add(button2);
        panelRight.add(button3);
        panelRight.add(buttonPlus);
        panelRight.add(button4);
        panelRight.add(button5);
        panelRight.add(button6);
        panelRight.add(buttonMinus);
        panelRight.add(button7);
        panelRight.add(button8);
        panelRight.add(button9);
        panelRight.add(buttonMultiplication);
        panelRight.add(buttonPoint);
        panelRight.add(button0);
        panelRight.add(buttonC);
        panelRight.add(buttonDivision);
        panelRight.add(buttonOpenBracket);
        panelRight.add(buttonCloseBracket);
        panelLeft.add(historyDisplay);

        display.setBackground(Color.lightGray);
        display.setForeground(Color.BLACK);
        display.setFont(font);

        historyDisplay.setBackground(Color.black);
        historyDisplay.setForeground(Color.GREEN);
        historyDisplay.setFont(font);



        frame.add(panelLeft);
        frame.add(panelRight);

        return frame;
    }
    JPanel panelLeft = new JPanel();
    JPanel panelRight = new JPanel();
    JTextField display = new JTextField();
    JTextArea historyDisplay = new JTextArea();
    JButton button0 = new JButton("0");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton buttonPoint = new JButton(".");
    JButton buttonEqual = new JButton("=");
    JButton buttonPlus = new JButton("+");
    JButton buttonMinus = new JButton("-");
    JButton buttonMultiplication = new JButton("*");
    JButton buttonDivision = new JButton("/");
    JButton buttonC = new JButton("C");
    JButton buttonCF = new JButton("CF");
    JButton buttonDelete = new JButton("<-");
    JButton buttonOpenBracket = new JButton("(");
    JButton buttonCloseBracket = new JButton(")");

    CalculatorWindow(){
        createJFrame();
    }
}
