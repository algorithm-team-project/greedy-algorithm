import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class test extends JFrame {

    Container ct = getContentPane();

    JPanel top = new JPanel(new GridLayout(1,1,10,10)); // 금액 입력 받는 상단 panel
    JLabel lb = new JLabel(" 금액 투입 " ,JLabel.CENTER);
    JButton input = new JButton("입 력");
    JTextField jtf1 = new JTextField();

    JPanel mid = new JPanel(); // 상품 보여 주는 중간 panel
    JButton pd[] = new JButton[4];
    int price[] ={ 800,1300,900,1000};

    JPanel bot = new JPanel(); // 수량 입력 하는 하단 panel

    JSpinner spinner; // 수량 입력 받는 스피너 생성
    SpinnerNumberModel value1 = new SpinnerNumberModel(0,0,10,1);
    SpinnerNumberModel value2 = new SpinnerNumberModel(0,0,10,1);
    SpinnerNumberModel value3 = new SpinnerNumberModel(0,0,10,1);
    SpinnerNumberModel value4 = new SpinnerNumberModel(0,0,10,1);
    JSpinner spin1 = new JSpinner(value1);
    JSpinner spin2 = new JSpinner(value2);
    JSpinner spin3 = new JSpinner(value3);
    JSpinner spin4 = new JSpinner(value4);

    JButton cal = new JButton("계 산");



    public test(){

        setTitle("자판기");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        ct.setBackground(new Color(5,180,255));
        ct.setLayout(new BorderLayout());

        top.setBackground(Color.lightGray);
        mid.setBackground(Color.GRAY);
        bot.setBackground(Color.lightGray);

        Font f= new Font("견고딕",Font.BOLD,15);


        top.setPreferredSize(new Dimension(400, 50));

        lb.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
        top.add(lb);
        lb.setFont(f);
        top.add(jtf1);
        top.add(input);
        input.setFont(f);

        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }); // 입력 버튼 동작

        mid.setSize(400,200);
        mid.setLocation(60,40);
        mid.setBackground(Color.white);

        pd[0] = new JButton(new ImageIcon("src/images/coffee.png"));
        pd[1] = new JButton(new ImageIcon("src/images/cola.png"));
        pd[2] = new JButton(new ImageIcon("src/images/milk.png"));
        pd[3] = new JButton(new ImageIcon("src/images/water.png"));



        for(int i =0; i<4 ; i++){
            pd[i].setBackground(Color.white);
            mid.add(pd[i]);
            mid.add(new JLabel(price[i]+"원"));

        }


        bot.setSize(400,200);
        bot.setLocation(60,470);

        spin1.setPreferredSize(new Dimension(40, 40));
        spin2.setPreferredSize(new Dimension(40, 40));
        spin3.setPreferredSize(new Dimension(40, 40));
        spin4.setPreferredSize(new Dimension(40, 40));
        cal.setPreferredSize(new Dimension(80, 40));



        JLabel jl1 = new JLabel("커피");
        jl1.setFont(f);
        bot.add(jl1); bot.add(spin1);

        JLabel jl2 = new JLabel("콜라");
        jl2.setFont(f);
        bot.add(jl2);    bot.add(spin2);

        JLabel jl3 = new JLabel("우유");
        jl3.setFont(f);
        bot.add(jl3);  bot.add(spin3);

        JLabel jl4 = new JLabel("생수");
        jl4.setFont(f);
        bot.add(jl4); bot.add(spin4);

        bot.add(cal);
        cal.setFont(f);

        // 스피너 인자값 받아 오기
        Object count1 = spin1.getModel().getValue();
        Object count2 = spin2.getModel().getValue();
        Object count3 = spin3.getModel().getValue();
        Object count4 = spin4.getModel().getValue();

        cal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }); //계산 버튼 동작


        ct.add(top,BorderLayout.NORTH);
        ct.add(mid ,BorderLayout.CENTER);
        ct.add(bot, BorderLayout.SOUTH);

        setVisible(true);

    }


    public static void main(String[] args){

        new test().setVisible(true);
    }
}
