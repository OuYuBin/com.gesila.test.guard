package com.gesila.test.guard.layout;

/**
 * 
 * @author robin
 *
 */
public class GesilaBorderData {

	public static final int NORTH = 0;

	public static final int SOUTH = 1;

	public static final int WEST = 2;

	public static final int EAST = 3;

	public static final int CENTER = 4;

	private int region;
	
	public GesilaBorderData(int region) {
		this.region=region;
	}
	
	
	public GesilaBorderData() {
		this.region=CENTER;
	}


	public int getRegion() {
		return region;
	}
	
	
}
