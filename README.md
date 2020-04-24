# greedy-algorithm

## 자판기 구현하기


### 1. 전체 디자인 틀 잡기

#### 1. JPanel top : 돈 입력 받는 부분
   - top.add(lb); // "금액 입력" 
   - top.add(jtf1); // 금액 입력 하는 JTextField
   - top.add(input); // textfield 에서 입력한 값 받는 "입력" 버튼
  
#### 2. Jpanel mid : 상품을 보여 주는 부분
   - mid.add(pd[i]); // 상품 이미지 추가
   - mid.add(new JLabel(price[i]+"원")); // 상품 가격 추가

#### 3. Jpanel bot : 상품 수량 입력 하는 부분
   - bot.add(jl1); // 상품 명 JLabel
   - bot.add(spin1); // 해당 상품 스피너로 수량 입력 받기
   - bot.add(order); // 수량 계산 실행하는 "주문" 버튼
   - bot.add(cal); // 잔돈 계산 실행하는 "잔돈" 버튼

#### 4. Container ct : 전체 틀
   - top, mid, bot panel 을 전체 틀에 배치
   

### 2. 입력 , 주문 버튼 동작
#### 1.입력버튼동작 : JTextField에 금액 입력
   - String textFieldValue = jtf1.getText();//JTextField 입력값 저장
#### 2.주문버튼동작 : 입력받은 금액 - 총금액
   - 1. int[] oj= new int[4];//spinner입력값 저장하는 배열
   - 2. oj[0] = Integer.parseInt(spin1.getModel().getValue().toString());//배열에 스피너 입력값 저장
   - 3. for문 : 각 상품선택 개수 (각spinner입력값) * 각 상품가격 구해서 총 금액 계산
   - 4. int Change: 거스름돈 전역변수 설정, int sum: 총금액 전역변수설정
   - 5. Change= Integer.parseInt(textFieldValue) - sum;//입력받은금액-총금액 = 거스름돈
   


### 3. 잔돈 버튼 동작

#### 1. 첫번째 for 문 : 지폐의 개수를 계산 하는 부분(그리디 알고리즘)
   - count += Change/money[i]; // 지폐 개수를 구하는 부분
   - Change = Change%money[i]; //지폐개수를 파악하고 잔돈을 반환
   
#### 2. 두번째 for 문 : 동전의 개수를 계산 하는 부분(그리디 알고리즘)
   - cnt += Change/coin[i]; // 동전 개수를 구하는 부분
   - Change = Change%coin[i]; // 동전 개수를 파악하고 잔돈을 반환
   
#### 3. JLabel
   - mj.add(jla1); // "잔 돈" JLabel
   - mj.add(jla2); //  "지폐 개수" JLabel
   - mj.add(jla3); // "동전 개수" JLabel
   
#### 4. JButton
   - mj.add(b1); // 잔돈을 반환
   - mj.add(b2); // 지폐 개수를 반환
   - mj.add(b3); // 동전 개수를 반환
   
#### 5. frame2 : 거스름돈을 보여주는 frame 틀
   - JLabel과 JButton을 포함한 mj JPanel을 frame 틀에 추가

### 4. 구현 이미지

#### 1. 메인 화면
![실행화면1](https://user-images.githubusercontent.com/63060298/80197087-23429980-8659-11ea-873f-5bd507457a6b.png)
#### 2. 입력 금액 부족 알림
![입력금액 부족](https://user-images.githubusercontent.com/63060298/80197119-2b023e00-8659-11ea-8692-671de74413dd.png)
#### 3. 돈 부족 알림
![돈 부족 화면](https://user-images.githubusercontent.com/63060298/80197164-3c4b4a80-8659-11ea-93e6-0f1d89c1c79b.png)
#### 4. 주문 완료 알림
![주문 완료](https://user-images.githubusercontent.com/63060298/80197150-36ee0000-8659-11ea-881f-50ab7ceaf8d5.png)
#### 5. 계산 -> 잔돈 알림
![계산 실행](https://user-images.githubusercontent.com/63060298/80197371-7fa5b900-8659-11ea-93f3-bedd50ce49a4.png)




