package com.myproject.thrillio.constants;


	
	    /*private MovieGenre() {}
	    
	    public static final String CLASSICS = "Classics";
	    public static final String DRAMA = "Drama";
	    public static final String SCIFI_AND_FANTASY = "Sci-Fi & Fantasy";
	    public static final String COMEDY = "Comedy";
	    public static final String CHILDREN_AND_FAMILY = "Children & Family";
	    public static final String ACTION_AND_ADVENTURE = "Action & Adventure";
	    public static final String THRILLERS = "Thrillers";
	    public static final String MUSIC_AND_MUSICALS = "Music & Musicals";
	    public static final String TELEVISION = "Television";
	    public static final String HORROR = "Horror";
	    public static final String SPECIAL_INTEREST = "Special Interest";
	    public static final String INDEPENDENT = "Independent";
	    public static final String SPORTS_AND_FITNESS = "Sports & Fitness";
	    public static final String ANIME_AND_ANIMATION = "Anime & Animation";
	    public static final String GAY_AND_LESBIAN = "Gay & Lesbian";
	    public static final String CLASSIC_MOVIE_MUSICALS = "Classic Movie Musicals";
	    public static final String FAITH_AND_SPIRITUALITY = "Faith & Spirituality";
	    public static final String FOREIGN_DRAMAS = "Foreign Dramas";
	    public static final String FOREGIN_ACTION_AND_ADVENTURE = "Foreign Action & Adventure";
	    public static final String FOREGIN_THRILLERS = "Foreign Thrillers";
	    public static final String TV_SHOWS = "TV Shows";
	    public static final String DRAMAS = "Dramas";
	    public static final String ROMANTIC_MOVIES = "Romantic Movies";
	    public static final String COMEDIES = "Comedies";
	    public static final String DOCUMENTARIES = "Documentaries";
	    public static final String FOREIGN_MOVIES = "Foreign Movies";*/
	public enum MovieGenre {

		CLASSICS("Classics"), DRAMA("Drama"), SCIFI_AND_FANTASY("Sci-Fi & Fantasy"), COMEDY("Comedy"),
		CHILDREN_AND_FAMILY("Children & Family"), ACTION_AND_ADVENTURE("Action & Adventure"), THRILLERS("Thrillers"),
		MUSIC_AND_MUSICALS("Music & Musicals"), TELEVISION("Television"), HORROR("Horror"),
		SPECIAL_INTEREST("Special Interest"), INDEPENDENT("Independent"), SPORTS_AND_FITNESS("Sports & Fitness"),
		ANIME_AND_ANIMATION("Anime & Animation"), GAY_AND_LESBIAN("Gay & Lesbian"),
		CLASSIC_MOVIE_MUSICALS("Classic Movie Musicals"), FAITH_AND_SPIRITUALITY("Faith & Spirituality"),
		FOREIGN_DRAMAS("Foreign Dramas"), FOREGIN_ACTION_AND_ADVENTURE("Foreign Action & Adventure"),
		FOREGIN_THRILLERS("Foreign Thrillers"), TV_SHOWS("TV Shows"), DRAMAS("Dramas"), ROMANTIC_MOVIES("Romantic Movies"),
		COMEDIES("Comedies"), DOCUMENTARIES("Documentaries"), FOREIGN_MOVIES("Foreign Movies");

		private String name;

		MovieGenre(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}



