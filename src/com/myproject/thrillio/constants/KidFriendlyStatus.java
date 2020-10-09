package com.myproject.thrillio.constants;

/*public class KidFriendlyStatus {
	private KidFriendlyStatus() {}
	
	public static final String APPROVED="approved";
	public static final String REJECTED="rejected";
	public static final String UNKNOWN="unknown";
	
}*/
public enum KidFriendlyStatus {
	APPROVED("approved"), REJECTED("rejected"), UNKNOWN("unknown");

	private String name;

	private KidFriendlyStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
