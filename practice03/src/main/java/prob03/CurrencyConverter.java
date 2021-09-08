package prob03;

public class CurrencyConverter {
	public static double rate; // KRW / 1$
	
	public static void setRate(double r) {
		rate = r;
	}

	public static double toDollar(double krw) {
		// TODO Auto-generated method stub
		return krw / rate;
	}

	public static double toKRW(double dollar) {
		return dollar * rate;
	}

}