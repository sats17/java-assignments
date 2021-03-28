package com.github.sats17.model;

import java.util.ArrayList;

public class News {

	private int newsId;
	private String postedByUser;
	private String commentByUser;
	private ArrayList<String> comment;

	public News() {
		++this.newsId;
	}

	public News( String postedByUser, String commentByUser, ArrayList<String> comment) {
		this();
		this.postedByUser = postedByUser;
		this.commentByUser = commentByUser;
		this.comment = comment;
	}

	/**
	 * @return the comment
	 */
	public ArrayList<String> getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(ArrayList<String> comment) {
		this.comment = comment;
	}

	/**
	 * @return the newsId
	 */
	public int getNewsId() {
		return newsId;
	}

	/**
	 * @param newsId the newsId to set
	 */
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	/**
	 * @return the postedByUser
	 */
	public String getPostedByUser() {
		return postedByUser;
	}

	/**
	 * @param postedByUser the postedByUser to set
	 */
	public void setPostedByUser(String postedByUser) {
		this.postedByUser = postedByUser;
	}

	/**
	 * @return the commentByUser
	 */
	public String getCommentByUser() {
		return commentByUser;
	}

	/**
	 * @param commentByUser the commentByUser to set
	 */
	public void setCommentByUser(String commentByUser) {
		this.commentByUser = commentByUser;
	}

}
