package models;

public class AppuiSimple extends Appui {

	public AppuiSimple() {
	}


	@Override
	public String toString() {
		return String.format("AppuiSimple;%d;%d;%d;%.2f\n", getId(), getTriangle().getId(), getJ(), getAlpha());
	}

}
