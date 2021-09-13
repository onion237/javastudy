package prob03;

import java.util.Objects;

public class Money {
	private final int amount;
	private static final int CACHE_MAX = 10000;
	private static Money[] cache = new Money[CACHE_MAX];
	
	public Money(int money) {
		this.amount = money;
	}
	/* 코드 작성 */
	public int getAmount() {return this.amount;}
	
	public Money add(Money money) {
		return createMoney(this.amount + money.amount);
	}

	public Money minus(Money money) {
		return createMoney(this.amount - money.amount);
	}

	public Money multiply(Money money) {
		return createMoney(this.amount * money.amount);
	}

	public Money devide(Money money) {
		return createMoney(this.amount / money.amount);
	}
	
	private Money createMoney(int amount) {
		if(amount >= 0 && amount < CACHE_MAX) { // 캐싱 대상 범위면
			if(cache[amount] == null) { //캐시에 저장된 불변객체가 있는지 검사
				synchronized (cache) {
					if(cache[amount] == null) { //double check
						cache[amount] = new Money(amount);
					}
				}
			}
			
			return cache[amount];
		}else {
			return new Money(amount);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return amount == other.amount;
	}
}
