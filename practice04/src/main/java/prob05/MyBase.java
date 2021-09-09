package prob05;

public class MyBase extends Base {

	@Override
	public void service(String state) {
		if("낮".equals(state)) day();
		else if("오후".equals(state)) afternoon();
		else night();
	}

	@Override
	public void day() {
		System.out.println("낮에는 열심히 일하자!");
	}

	private void afternoon() {
		System.out.println("오후도 낮과 마찬가지로 일해야 합니다.");
	}

	
}
