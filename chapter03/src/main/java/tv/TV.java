package tv;

public class TV {
	private final int MAX_CHANNEL = 255;
	private final int MIN_CHANNEL = 1;
	private final int MAX_VOLUME = 100;
	private final int MIN_VOLUME = 0;
	
	private int channel; // 1~255
	private int volume; // 0~100
	private boolean power; 
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	public void power(boolean on) {
		this.power = on;
	}

	public void channel(int channel) {
		if(channel < MIN_CHANNEL || channel > MAX_CHANNEL)
			return;
		
		this.channel = channel;
	}

	public void channel(boolean up) {
		int channel = this.channel;
		
		if(up) {
			channel = channel % MAX_CHANNEL + MIN_CHANNEL;
		}else {
			channel = channel == MIN_CHANNEL? MAX_CHANNEL : channel - 1;
		}
		
		channel(channel);
	}




	public void volume(boolean up) {
		int volume = this.volume;
		
		if(up) {
			volume = volume % MAX_VOLUME + MIN_VOLUME;
		}else {
			volume = volume == MIN_VOLUME? MAX_VOLUME : volume - 1;
		}
		volume(volume);
	}

	public void volume(int volume) {
		if(volume < MIN_VOLUME || volume > MAX_VOLUME)
			return;
		
		this.volume = volume;
	}

	public void status() {
		System.out.println("TV [channel=" + channel + ", volume=" + volume + ", power=" + power + "]"); 
		
	}
}
