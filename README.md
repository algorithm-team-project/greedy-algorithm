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
    - bot.add(order); // 수량 계산 실행하는 "주문" 버튼
    - bot.add(cal); // 잔돈 계산 실행하는 "잔돈" 버튼

4. Container ct : 전체 틀
   - top, mid, bot panel 을 전체 틀에 배치
   

### 2. 입력 , 주문 버튼 동작
  


### 3. 잔돈 버튼 동작
### 

``` java
for(int i=0;i<money.length;i++){
	if(Change/money[i] == 0)
		Change = Change%money[i];
	else{
		count += Change/money[i];
		Change = Change%money[i];
	}
}
for(int i=0;i<coin.length;i++){
	if(Change/coin[i] == 0)
		Change = Change%coin[i];
	else{
		cnt += Change/coin[i];
		Change = Change%coin[i];
	}
}
```

1. 첫번째 for 문 : 지폐의 개수를 계산 하는 부분(그리디 알고리즘)
   - count += Change/money[i]; // 지폐 개수
   - Change = Change%money[i]; //지폐개수를 파악하고 잔돈을 반환
2. 두번째 for 문 : 동전의 개수를 계산 하는 부분(그리디 알고리즘)
   - cnt += Change/coin[i]; // 동전 개수
   - Change = Change%coin[i]; // 동전 개수를 파악하고 잔돈을 반환
3. JLabel
   - mj.add(jla1); // "잔 돈" JLabel
   - mj.add(jla2); //  "지폐 개수" JLabel
   - mj.add(jla3); // "동전 개수" JLabel
4. JButton
   - mj.add(b1); // 잔돈을 반환
   - mj.add(b2); // 지폐 개수를 반환
   - mj.add(b3); // 동전 개수를 반환
5. frame2 : 거스름돈을 보여주는 frame
   - mj JPanel을 frame에 추가

### 4. 디자인
