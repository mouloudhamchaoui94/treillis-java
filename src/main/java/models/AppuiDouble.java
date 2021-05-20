package models;

public class AppuiDouble extends Appui {

	public AppuiDouble() {
	}

	@Override
	public String toString() {
		return String.format("AppuiDouble;%d;%d;%d;%.2f\n", getId(), getTriangle().getId(), getJ(), getAlpha());
	}

}
