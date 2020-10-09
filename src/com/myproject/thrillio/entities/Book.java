package com.myproject.thrillio.entities;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.myproject.thrillio.constants.BookGenre;
import com.myproject.thrillio.partner.Shareable;

public class Book extends BookMark implements Shareable{
	private int publicationYear;
	private String publisher;
	private String[] authors;
	private BookGenre genre;
	private double amazonRating;
    private String imageUrl;
	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public BookGenre getGenre() {
		return genre;
	}

	public void setGenre(BookGenre genre) {
		this.genre = genre;
	}

	public double getAmazonRating() {
		return amazonRating;
	}

	public void setAmazonRating(double amazonRating) {
		this.amazonRating = amazonRating;
	}
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	@Override
	public String toString() {
		return "Book [publicationYear=" + publicationYear + ", publisher=" + publisher + ", authors="
				+ Arrays.toString(authors) + ", genre=" + genre + ", amazonRating=" + amazonRating + "]";
	}

	public boolean isKidFriendlyEligible() {
		if (genre.equals(BookGenre.PHILOSOPHY) || genre.equals(BookGenre.SELF_HELP)) {
			return false;
		}
		return true;
	}

	@Override
	public String getItemData() {
		StringBuilder builder=new StringBuilder();
		builder.append("<item>");
		    builder.append("<type>Book</type>");
		    builder.append("<title>").append(getTitle()).append("</title>");
		    builder.append("<authors>").append(StringUtils.join(authors,",")).append("</authors>");
		    builder.append("<publisher>").append(publisher).append("</publisher>");
		    builder.append("<publictionYear>").append(publicationYear).append("</publicationYear>");
		    builder.append("<genre>").append(genre).append("</genre>");
		    builder.append("<amazonRating>").append(amazonRating).append("</amazonRating>");
		builder.append("</item>");
		
		
		return builder.toString();
		
		
		
		
		
	}


}
