package hw1;
/**
 * 
 * @author Benjamin Trettin
 * Models some aspects
of the behavior of simple television
 */
public class Television {
	/**
	 * stores volume for television
	 */
	private double volume;
	/**
	 * stores maximum channel of television
	 */
	private int tvmaxchannel;
	/**
	 * stores the current channel of the television
	 */
	private int channel;
	/**
	 * stores the previous channel of the television
	 */
	private int previouschannel; 
	/**
	 * sets the increment of the volume 
	 */
	public static final double VOLUME_INCREMENT = 0.07;
	/**
	 * sets the maximum channel
	 * @param givenChannelMax
	 */
	public Television(int givenChannelMax){
		tvmaxchannel = givenChannelMax;
		volume =.5;
		previouschannel = 0;
	}
	/**
	 * Changes the channel down by 1, wrapping around to channelMax - 1 if the
current channel is zero.
	 */
	public void channelDown(){
		previouschannel = channel; 
		channel = channel-1;
		if(channel==-1){
			channel=tvmaxchannel-1;
		}
	}
	/**
	 * Changes the channel up by 1, wrapping around to zero if the current channel is
channelMax - 1.
	 */
	public void channelUp(){
		previouschannel = channel;
		channel = channel + 1;
		if(channel==tvmaxchannel){
			channel = 0;
		}
	}
	/**
	 * Returns a string representing the current channel and volume in the form
"Channel x Volume y%", where x is the current channel and y is the volume,
multiplied by 100 and rounded to the nearest integer. 
	 * @return "Channel x Volume y%"
	 */
	public String display(){
		String msg ="Channel ";
		msg = msg + channel + " ";
		msg = msg + "Volume " + Math.round(volume*100);
		msg = msg + "%";
		return msg; 
	}
	/**
	 * 
	 * @return the current channel
	 */
	public int getChannel(){
		return channel;
	}
	/**
	 * 
	 * @return the current volume
	 */
	public double getVolume(){
		return volume;  
	}
	/**
	 * Sets the current channel to the most recent previous channel. If no channel has
ever been set for this Television using one of the methods channelDown,
channelUp, or setChannel, this method sets the channel is 0.
	 */
	public void goToPreviousChannel(){
		channel = previouschannel; 
		if(channel >= tvmaxchannel){
			channel = tvmaxchannel-1; 
		}
	}
	/**
	 * Resets this Television so that its available channels are now from 0 through
givenMax - 1. If the current channel is greater than givenMax - 1, it is
automatically adjusted to be givenMax - 1. Likewise, if the previous channel is
greater than givenMax - 1, it is automatically adjusted to be givenMax - 1.
	 * @param givenMax
	 */
	public void resetChannelMax(int givenMax){
		tvmaxchannel = givenMax; 
		if(channel >= tvmaxchannel){
			channel = givenMax-1;
		}
	}
	/**
	 * Sets the channel to the given channel number. If the given value is greater than
channelMax - 1, the channel is set to channelMax - 1. If the given value is
negative, the channel is set to zero.
	 * @param channelNumber
	 */
	public void setChannel(int channelNumber){
		previouschannel = channel;
		channel = channelNumber;
		if(channel >= tvmaxchannel){
			channel = tvmaxchannel-1; 
		}
		if(channel < 0){
			channel = 0;
		}
	}
	/**
	 * Lowers the volume by VOLUME_INCREMENT, but not below 0.0.
	 */
	public void volumeDown(){
		volume = volume - VOLUME_INCREMENT;
		if(volume < 0){
			volume = 0;
			}
		}
	/**
	 * Raises the volume by VOLUME_INCREMENT, but not above 1.0.
	 */
	public void volumeUp(){
		volume = volume +  VOLUME_INCREMENT; 
		if(volume > 1){
			volume = 1;
	}
}
}
	