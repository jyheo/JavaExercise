import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class CheckBoxItemEventEx extends JFrame {
    String [] names = new String[]{"사과", "배","귤", "오렌지","포도"};
    JCheckBox [] fruits = new JCheckBox [names.length];
        ImageIcon img[] ={
                new ImageIcon("image/apple.jpg"),
                new ImageIcon("image/pear.jpg"),
                new ImageIcon("image/mandarin.jpg"),
                new ImageIcon("image/orange.jpg"),
                new ImageIcon("image/grape.jpg")
        };

    JLabel label1=new JLabel();
    JLabel label2=new JLabel();
    JLabel label3=new JLabel();
    JLabel label4=new JLabel();
    JLabel label5=new JLabel();
    int[] prices = new int[] {2000,5000,500,1000,3000};

    JPanel panel1=new JPanel();
    JPanel panel2=new JPanel(new GridLayout());
    JLabel sumLabel;
    int sum = 0;

    CheckBoxItemEventEx() {
        setTitle("체크박스와 ItemEvent  예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(panel1,BorderLayout.NORTH);
        contentPane.add(panel2);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            sb.append(names[i]);
            sb.append(" ");
            sb.append(prices[i]);
            sb.append("원, ");
        }
        panel1.add(new JLabel(sb.toString()));

        for(int i = 0; i < fruits.length; i++) {
            fruits[i] = new JCheckBox(names[i]);
            fruits[i].setBorderPainted(true);
            panel1.add(fruits[i]);
            fruits[i].addItemListener(new MyItemListener());
        }
        sumLabel = new JLabel("현재 0 원 입니다.");
        panel1.add(sumLabel);
        setSize(800,800);
        setVisible(true);
        panel2.add(label1);   
        panel2.add(label2);
        panel2.add(label3);
        panel2.add(label4);
        panel2.add(label5);

        label1.setIcon(img[0]);  
        label2.setIcon(img[1]);
        label3.setIcon(img[2]);
        label4.setIcon(img[3]);
        label5.setIcon(img[4]);

        label1.setVisible(false);   
        label2.setVisible(false);
        label3.setVisible(false);
        label4.setVisible(false);
        label5.setVisible(false);
    }

    class MyItemListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            int selected=1;
            if(e.getStateChange() == ItemEvent.SELECTED)  
                selected = 1;
            else
                selected = -1;
            /*--------------------------------------*/
            if(e.getItem() == fruits[0]) { 
                sum = sum + selected * prices[0];
                if (selected == 1) {   
                    label1.setVisible(true);
                } else {
                    label1.setVisible(false);
                }
            }
            else if(e.getItem() == fruits[1]) {
                sum = sum + selected * prices[1];
                if (selected == 1) {   
                    label2.setVisible(true);
                } else {
                    label2.setVisible(false);
                }
            }
            else if(e.getItem() == fruits[2]) {
                sum = sum + selected * prices[2];
                if (selected == 1) { 
                    label3.setVisible(true);
                } else {
                    label3.setVisible(false);
                }
            }
            else if(e.getItem() == fruits[3]) {
                sum = sum + selected * prices[3];
                if (selected == 1) {
                    label4.setVisible(true);
                } else {
                    label4.setVisible(false);
                }
            }
            else {
                sum = sum + selected * prices[4];
                if (selected == 1) {    
                    label5.setVisible(true);
                } else {
                    label5.setVisible(false);
                }
            }
            
            sumLabel.setText("현재 "+sum+"원 입니다.");
        }
    }
    public static void main(String [] args) {
        new CheckBoxItemEventEx();
    }
}
