package week_02.src;

class PaymentSystem {
	// 버전 1: 현금 결제 (정수형 입력)
    void process(int amount) {
        System.out.println("현금 " + amount + "원 결제를 진행합니다.");
    }

    // 버전 2: 카드 결제 (문자열 입력)
    void process(String cardName) {
        System.out.println(cardName + "로 카드 결제를 진행합니다.");
    }

    // 버전 3: 혼합 결제 (매개변수 2개)
    void process(int point, int amount) {
        System.out.println("포인트 " + point + "점 사용 후, 남은 " + amount + "원을 결제합니다.");
    }
}

