import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class CheckBoxItemEventEx extends JFrame {
    String [] names = {"사과", "배", "귤", "오렌지", "포도"};
    JCheckBox [] fruits = new JCheckBox [names.length];

    int[] prices = new int[] {2000, 5000, 500, 1000, 3000};
    JLabel sumLabel;
    int sum = 0;

    ImageIcon [] fruitsImage = {
            new ImageIcon("C:\\Users\\철순\\Desktop\\apple.png"),
            new ImageIcon("C:\\Users\\철순\\Desktop\\pear.jpg"),
            new ImageIcon("C:\\Users\\철순\\Desktop\\mandarin.jpg"),
            new ImageIcon("C:\\Users\\철순\\Desktop\\orange.jpg"),
            new ImageIcon("C:\\Users\\철순\\Desktop\\grape.jpg")
    }; //이미지아이콘 배열

    JLabel [] LableImage = new JLabel[fruitsImage.length]; //라벨생성
    boolean [] imageTF = {false, false, false, false, false}; // 이미지의 상태
    JPanel imagePanel = new JPanel();
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
            sb.append("원");
            if(i!=names.length - 1)
                sb.append(", ");
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
        setSize(720, 540);
        setVisible(true);


        imagePanel.setLayout(new GridLayout(1,5));
        for(int i=0; i<fruitsImage.length; i++) {
            LableImage[i] = new JLabel(fruitsImage[i]);
            imagePanel.add(LableImage[i]);
            LableImage[i].setVisible(imageTF[i]);
        }
            contentPane.add(imagePanel);

    }

    class MyItemListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            int selected=1;
            if(e.getStateChange() == ItemEvent.SELECTED)
                selected = 1;
            else
                selected = -1;
            if(e.getItem() == fruits[0]){
                sum = sum + selected*prices[0];
                imageTF[0] = !imageTF[0];
                LableImage[0].setVisible(imageTF[0]);
            }  // 직접 가격값을 쓰지말고 price 배열을 이용하시오.
            else if(e.getItem() == fruits[1]){
                sum = sum + selected*prices[1];
                imageTF[1] = !imageTF[1];
                LableImage[1].setVisible(imageTF[1]);
            }
            else if(e.getItem() == fruits[2]){
                sum = sum + selected*prices[2];
                imageTF[2] = !imageTF[2];
                LableImage[2].setVisible(imageTF[2]);
            }
            else if (e.getItem() == fruits[3]){
                sum = sum + selected*prices[3];
                imageTF[3] = !imageTF[3];
                LableImage[3].setVisible(imageTF[3]);
            }
            else{
                sum = sum + selected*prices[4];
                imageTF[4] = !imageTF[4];
                LableImage[4].setVisible(imageTF[4]);
            }

            sumLabel.setText("현재 "+sum+"원 입니다.");
        }
    }
    public static void main(String [] args) {
        new CheckBoxItemEventEx();
    }
}
