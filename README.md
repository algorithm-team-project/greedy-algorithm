# greedy-algorithm

## 자판기 구현하기


### 1. 전체 디자인 틀 잡기

1. JPanel top : 돈 입력 받는 부분
    - top.add(lb); // "금액 입력" JLabel
    - top.add(jtf1); // 금액 입력 하는 JTextField
    - top.add(input); // textfield 에서 입력한 값 받는 "입력" 버튼
  
2. Jpanel mid : 상품을 보여 주는 부분
    - mid.add(pd[i]); // 상품 이미지 추가
    - mid.add(new JLabel(price[i]+"원")); // 상품 가격 추가

3. Jpanel bot : 상품 수량 입력 하는 부분
    - bot.add(jl1); // 상품 명 JLabel
    - bot.add(spin1); // 해당 상품 스피너로 수량 입력 받기
    - bot.add(cal); // 수량 입력 받아서 전체 금액 "계산" 버튼

4. Container ct : 전체 틀
   - top, mid, bot panel 을 전체 틀에 배치
  



