import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;


public class test extends JFrame {

    Container ct = getContentPane();
    JFrame frame2 = new JFrame(); // 잔돈 frame



    JPanel top = new JPanel(new GridLayout(1,1,10,10)); // 금액 입력 받는 상단 panel
    JLabel lb = new JLabel(" 금액 투입 " ,JLabel.CENTER);
    JButton input = new JButton("입 력");
    JTextField jtf1 = new JTextField();

    JPanel mj = new JPanel(new FlowLayout(FlowLayout.LEFT,35,60));


    int sum;
    int change;
    String textFieldValue;
    int Change;
    int money[] = {50000, 10000, 5000, 1000}; //지폐 종류
    int coin[] = {500, 100, 50, 10}; // 동전 종류
    int count = 0; //지폐 개수
    int cnt = 0; // 동전


    JPanel mid = new JPanel(); // 상품 보여 주는 중간 panel
    JButton pd[] = new JButton[4];
    int price[] ={1200 , 900 , 4500 , 2100}; // 상품 가격


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

    JButton order = new JButton("주 문");
    JButton cal = new JButton("계 산");



    public test(){

        setTitle("자판기");
        setSize(600,500);
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
                    String textFieldValue = jtf1.getText();
                if(textFieldValue.equals("")){
                    JOptionPane.showMessageDialog(null,"돈을 입력하세요!","알림",JOptionPane.INFORMATION_MESSAGE);
                } // 돈 입력 값이 없을 때 알림 메시지


            }
        }); // 입력 버튼 동작

        mid.setSize(400,200);
        mid.setBackground(Color.white);

        pd[0] = new JButton(new ImageIcon("src/images/milk.png"));
        pd[1] = new JButton(new ImageIcon("src/images/water.png"));
        pd[2] = new JButton(new ImageIcon("src/images/snack1.png"));
        pd[3] = new JButton(new ImageIcon("src/images/snack2.png"));




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
        order.setPreferredSize(new Dimension(80, 40));
        cal.setPreferredSize(new Dimension(80, 40));



        JLabel jl1 = new JLabel("우유");
        jl1.setFont(f);
        bot.add(jl1); bot.add(spin1);

        JLabel jl2 = new JLabel("생수");
        jl2.setFont(f);
        bot.add(jl2);    bot.add(spin2);

        JLabel jl3 = new JLabel("초코파이");
        jl3.setFont(f);
        bot.add(jl3);  bot.add(spin3);

        JLabel jl4 = new JLabel("포카칩");
        jl4.setFont(f);
        bot.add(jl4); bot.add(spin4);

        bot.add(order);
        bot.add(cal);
        order.setFont(f);
        cal.setFont(f);

        // 스피너 인자값 받아 오기
        int[] oj= new int[4];
        Arrays.fill(oj, 0);




        order.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0; i< pd.length ;i++)
                {

                    oj[0] = Integer.parseInt(spin1.getModel().getValue().toString());
                    oj[1] = Integer.parseInt(spin2.getModel().getValue().toString());
                    oj[2] = Integer.parseInt(spin3.getModel().getValue().toString());
                    oj[3] = Integer.parseInt(spin4.getModel().getValue().toString());

                    if(oj[i]!=0)
                    {
                        oj[i]= oj[i] * price[i];
                        sum = sum + oj[i];
                    }
                }
                textFieldValue = jtf1.getText();
                if (sum > Integer.parseInt(textFieldValue)) {
                    int result = JOptionPane.showConfirmDialog(null, "돈이 부족합니다! 다시 시작하시겠습니까?", "알 림",JOptionPane.YES_NO_OPTION);
                    // 입력 값이 계산 값 보다 적을 때 알림 메시지
                    if(result == JOptionPane.YES_OPTION) {
                        System.exit(JFrame.EXIT_ON_CLOSE); // 프레임을 종료
                    } else if ((result == JOptionPane.NO_OPTION) || (result == JOptionPane.CLOSED_OPTION )) {
                        return; // 아무 작업 없이 다이얼로그 상자 종료
                    }


                }else
                    JOptionPane.showMessageDialog(null,"주문 되었습니다! 잔돈을 확인하세요!","알림",JOptionPane.INFORMATION_MESSAGE);


                Change= Integer.parseInt(textFieldValue) - sum;
                change = Change;


            }
        }); //주문 버튼 동작

        cal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                frame2.setSize(600,200);
                frame2.setTitle("잔 돈");
                frame2.setVisible(true);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setLocationRelativeTo(null);
                frame2.add(mj);
                frame2.setBackground(new Color(5,180,255));
                mj.setBackground(new Color(255,255,255));

                for(int i=0;i<money.length;i++){
                    if(Change/money[i] == 0)
                        Change = Change%money[i];
                    else{
                        count += Change/money[i];
                        Change = Change%money[i];
                    }
                } // 지폐 개수 구하는 알고리즘
                for(int i=0;i<coin.length;i++){
                    if(Change/coin[i] == 0)
                        Change = Change%coin[i];
                    else{
                        cnt += Change/coin[i];
                        Change = Change%coin[i];
                    }
                } // 동전 개수 구하는 알고리즘
                JLabel jla1 = new JLabel("잔 돈");
                JButton b1 = new JButton(String.valueOf(change));
                JLabel jla2 = new JLabel("지폐 개수");
                JButton b2 = new JButton(String.valueOf(count));
                JLabel jla3 = new JLabel("동전 개수");
                JButton b3 = new JButton(String.valueOf(cnt));
                jla1.setFont(f);
                jla2.setFont(f);
                jla3.setFont(f);
                b1.setFont(f);
                b2.setFont(f);
                b3.setFont(f);
                mj.add(jla1);
                mj.add(b1);
                mj.add(jla2);
                mj.add(b2);
                mj.add(jla3);
                mj.add(b3);
            }
        }); //잔돈 버튼 동작


        ct.add(top,BorderLayout.NORTH);
        ct.add(mid ,BorderLayout.CENTER);
        ct.add(bot, BorderLayout.SOUTH);

        setVisible(true);

    }


    public static void main(String[] args){

        new test().setVisible(true);
    }
}
