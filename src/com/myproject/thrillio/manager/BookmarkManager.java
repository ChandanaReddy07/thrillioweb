package com.myproject.thrillio.manager;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;

import com.myproject.thrillio.constants.BookGenre;
import com.myproject.thrillio.constants.KidFriendlyStatus;
import com.myproject.thrillio.constants.MovieGenre;
import com.myproject.thrillio.dao.BookmarkDao;
import com.myproject.thrillio.entities.Book;
import com.myproject.thrillio.entities.BookMark;
import com.myproject.thrillio.entities.Movie;
import com.myproject.thrillio.entities.User;
import com.myproject.thrillio.entities.UserBookmark;
import com.myproject.thrillio.entities.WebLink;
import com.myproject.thrillio.util.HttpConnect;
import com.myproject.thrillio.util.IOUtil;

public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager();
	private static BookmarkDao dao = new BookmarkDao();
    private BookmarkManager() {}
    public static BookmarkManager getInstance() {
		return instance;
	}

	public Movie createMovie(long id, String title, int releaseYear, String[] cast, String[] directors, MovieGenre genre,
			double imdbRating) {
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imdbRating);

		return movie;

	}

	public Book createBook(long id, String title, String imageUrl, int publicationyear, String publisher, String[] authors,
			BookGenre genre, double amazonrating) {
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setImageUrl(imageUrl);
		book.setAmazonRating(amazonrating);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setPublicationYear(publicationyear);
		book.setPublisher(publisher);

		return book;

	}

	public WebLink createWeblink(long id, String title, String profileUrl, String url, String host) {
		WebLink weblink = new WebLink();
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setProfileUrl(profileUrl);
		weblink.setUrl(url);
		weblink.setHost(host);

		return weblink;
	}

	/*public List<List<BookMark>> getBookmarks() {
		return dao.getBookmarks();
	}*/

	public void saveUserBookmark(User user, BookMark bookmark) {
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);
		/*
		if (bookmark instanceof WebLink) {
			try {
				String url = ((WebLink) bookmark).getUrl();
				if (!url.endsWith(".pdf")) {
					String webpage = HttpConnect.download(((WebLink) bookmark).getUrl());
					if (webpage != null) {
						IOUtil.write(webpage, bookmark.getId());
					}
				}
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			} catch (URISyntaxException e) {
				
				e.printStackTrace();
			}*/
			dao.saveUserBookmark(userBookmark);

		}
	

	public void setKidFriendlyStatus(User user,KidFriendlyStatus  kidFriendlyStatus, BookMark bookmark) {
		
		bookmark.setKidFriendlyMarkedBy(user);
		bookmark.setKidFriendlyStatus(kidFriendlyStatus);
		dao.upateKidFriendlyStatus(bookmark);
		System.out
				.println("kid friendly status: " + kidFriendlyStatus + ",Marked by" + user.getEmail() + "," + bookmark);

	}

	public void share(User user, BookMark bookmark) {
		bookmark.setSharedBy(user);
		System.out.println("data to be shared: ");

		if (bookmark instanceof Book) {
			System.out.println(((Book) bookmark).getItemData());
		} else if (bookmark instanceof WebLink) {
			System.out.println(((WebLink) bookmark).getItemData());

		}
		dao.sharedByInfo(bookmark);

	}
	public Collection<BookMark> getBooks(boolean b, long userId) {
		// TODO Auto-generated method stub
		System.out.println("manager");
		return dao.getBooks(b,userId);
	}
	
	public BookMark getBook(long bookId) {
		// TODO Auto-generated method stub
		return dao.getBook(bookId);
	}
	public void removeBook(long bId, Long userId) {
		dao.removeBook(bId,userId);
		
	}

}
