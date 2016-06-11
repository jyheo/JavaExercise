package gui;

/**
 * 명품Java 예제 11-4
 * Modified by jyheo on 2016-05-29.
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class CheckBoxItemEventEx extends JFrame {
    String[] names = new String[] {"사과", "배", "귤", "오렌지", "포도"};
    JCheckBox [] fruits = new JCheckBox [names.length];
    ImageIcon [] image = {
            new ImageIcon("C:\\Users\\SAM\\Desktop\\1.png"),
            new ImageIcon("C:\\Users\\SAM\\Desktop\\2.png"),
            new ImageIcon("C:\\Users\\SAM\\Desktop\\3.png"),
            new ImageIcon("C:\\Users\\SAM\\Desktop\\4.png"),
            new ImageIcon("C:\\Users\\SAM\\Desktop\\5.png")
    };

    JLabel [] la = {
            new JLabel(),
            new JLabel(),
            new JLabel(),
            new JLabel(),
            new JLabel()
    };



    int[] prices = new int[] {2000, 5000, 500, 1000, 3000};

    JLabel sumLabel;
    int sum = 0;

    CheckBoxItemEventEx() {
        setTitle("체크박스와 ItemEvent  예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            sb.append(names[i]);
            sb.append(" ");
            sb.append(prices[i]);
            sb.append("원, ");
        }
        contentPane.add(new JLabel(sb.toString()));
        for(int i = 0; i < fruits.length; i++) {
            fruits[i] = new JCheckBox(names[i]);
            fruits[i].setBorderPainted(true);
            contentPane.add(fruits[i]);
            fruits[i].addItemListener(new MyItemListener());
        }
        sumLabel = new JLabel("현재 0 원 입니다.");
        contentPane.add(sumLabel);
        setSize(1000,1000);
        setVisible(true);

        /*for(int i=0; i<fruits.length; i++){
            la[i] = new JLabel();
        }*/

        JPanel p= new JPanel();
        contentPane.add(p);
        p.setLayout(new GridLayout(1,5));
        for(int i=0; i<fruits.length; i++){
            p.add(la[i]);
        }

    }

    class MyItemListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            int selected=1;
            if(e.getStateChange() == ItemEvent.SELECTED)
                selected = 1;
            else
                selected = -1;
            for(int i=0; i<fruits.length; i++){
                if(e.getItem()==fruits[i]){
                    sum=sum+selected*prices[i];
                    if(selected==1)
                        la[i].setIcon(image[i]);
                    else
                        la[i].setIcon(null);
                }
            }


            sumLabel.setText("현재 "+sum+"원 입니다.");
        }
    }
    public static void main(String [] args) {
        new CheckBoxItemEventEx();
    }
}
