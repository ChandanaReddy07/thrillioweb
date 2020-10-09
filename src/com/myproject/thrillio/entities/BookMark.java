package com.myproject.thrillio.entities;

import com.myproject.thrillio.constants.KidFriendlyStatus;

public abstract class BookMark {
	private long id;
	private String title;
	private String profileUrl;
	private KidFriendlyStatus kidFriendlyStatus=KidFriendlyStatus.UNKNOWN;
	private User kidFriendlyMarkedBy;
	private User sharedBy;
	
	public User getSharedBy() {
		return sharedBy;
	}

	public void setSharedBy(User sharedBy) {
		this.sharedBy = sharedBy;
	}

	public User getKidFriendlyMarkedBy() {
		return kidFriendlyMarkedBy;
	}

	public void setKidFriendlyMarkedBy(User kidFriendlyMarkedBy) {
		this.kidFriendlyMarkedBy = kidFriendlyMarkedBy;
	}

	public KidFriendlyStatus getKidFriendlyStatus() {
		return kidFriendlyStatus;
	}

	public void setKidFriendlyStatus(KidFriendlyStatus kidFriendlyStatus) {
		this.kidFriendlyStatus = kidFriendlyStatus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}
	
	public abstract boolean isKidFriendlyEligible();

	}
