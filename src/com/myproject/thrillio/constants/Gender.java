package com.myproject.thrillio.constants;

public enum Gender {
	
	 MALE(0),
	 FEMALE(1),
	 TRANSGENDER (2);
	private Gender(int index) {
		this.index=index;
		
	}
	private int index;
	private int getGender() {
		return index;
	}

}
