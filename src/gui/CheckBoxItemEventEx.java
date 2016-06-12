package gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class CheckBoxItemEventEx extends JFrame {
    String[] names = new String[] {"사과", "배", "귤", "오렌지", "포도"};
    JCheckBox [] fruits = new JCheckBox [names.length];
    ImageIcon [] image = {
      new ImageIcon("C:/Users/Administrator/Desktop/apple.jpg"),
      new ImageIcon("C:/Users/Administrator/Desktop/pear.jpg"),
      new ImageIcon("C:/Users/Administrator/Desktop/tangerine.jpg"),
      new ImageIcon("C:/Users/Administrator/Desktop/orange.jpg"),
      new ImageIcon("C:/Users/Administrator/Desktop/grape.jpg")
    };
    JLabel imageLabel0 = new JLabel();
    JLabel imageLabel1 = new JLabel();
    JLabel imageLabel2 = new JLabel();
    JLabel imageLabel3 = new JLabel();
    JLabel imageLabel4 = new JLabel();

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
        setSize(250,200);
        setVisible(true);

        JPanel panel = new JPanel();
        contentPane.add(panel);
        panel.setLayout(new GridLayout(2,3,10,10));
        panel.add(imageLabel0);
        panel.add(imageLabel1);
        panel.add(imageLabel2);
        panel.add(imageLabel3);
        panel.add(imageLabel4);
    }

    class MyItemListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            int selected=1;
            if(e.getStateChange() == ItemEvent.SELECTED)
                selected = 1;
            else
                selected = -1;
            if(e.getItem() == fruits[0]){
                sum = sum + selected*prices[0];  // 직접 가격값을 쓰지말고 price 배열을 이용하시오.
                if(selected == 1)
                    imageLabel0.setIcon(image[0]);
                else
                    imageLabel0.setIcon(null);
            }
            else if(e.getItem() == fruits[1]) {
                sum = sum + selected * prices[1];
                if(selected == 1)
                    imageLabel1.setIcon(image[1]);
                else
                    imageLabel1.setIcon(null);
            }

            else if(e.getItem() == fruits[2]) {
                sum = sum + selected * prices[2];
                if(selected == 1)
                    imageLabel2.setIcon(image[2]);
                else
                    imageLabel2.setIcon(null);
            }
            else if(e.getItem() == fruits[3]) {
                sum = sum + selected * prices[3];
                if(selected == 1)
                    imageLabel3.setIcon(image[3]);
                else
                    imageLabel3.setIcon(null);
            }
            else {
                sum = sum + selected * prices[4];
                if (selected == 1)
                    imageLabel4.setIcon(image[4]);
                else
                    imageLabel4.setIcon(null);
            }

            sumLabel.setText("현재 "+sum+"원 입니다.");
        }
    }
    public static void main(String [] args) {
        new CheckBoxItemEventEx();
    }
}
