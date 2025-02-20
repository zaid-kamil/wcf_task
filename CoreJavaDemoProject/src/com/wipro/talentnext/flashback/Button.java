package com.wipro.talentnext.flashback;

public class Button {
	private int ButtonType = 4;

	public Button(int buttonType) {
		super();
		ButtonType = buttonType;
	}

	public int getButtonType() {
		return ButtonType;
	}

	public void setButtonType(int buttonType) {
		ButtonType = buttonType;
	}

	public void addEventListener(OnClickEvent onClickEvent) {
		System.out.println("Event occurred");
	}
	
	
	
}


