package prob03;

import java.util.Objects;

public class Money {
	private final int amount;
	
	public Money(int money) {
		this.amount = money;
	}
	/* 코드 작성 */
	public int getAmount() {return this.amount;}
	public Money add(Money money) {
		return new Money(this.amount + money.amount);
	}

	public Money minus(Money money) {
		return new Money(this.amount - money.amount);
	}

	public Money multiply(Money money) {
		return new Money(this.amount * money.amount);
	}

	public Money devide(Money money) {
		return new Money(this.amount / money.amount);
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
