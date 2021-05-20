package models;

public class AppuiEncastre extends Appui {

	public AppuiEncastre() {
	}

	
	@Override
	public String toString() {
		return String.format("AppuiEncastre;%d;%d;%d;%.2f\n", getId(), getTriangle().getId(), getJ(), getAlpha());
	}

}
