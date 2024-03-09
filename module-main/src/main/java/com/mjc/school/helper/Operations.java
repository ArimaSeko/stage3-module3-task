package com.mjc.school.helper;

import static com.mjc.school.helper.Constant.OPERATION;

public enum Operations {
  GET_ALL_NEWS(1, "Get all news."),
  GET_NEWS_BY_ID(2, "Get news by id."),
  CREATE_NEWS(3, "Create news."),
  UPDATE_NEWS(4, "Update news."),
  REMOVE_NEWS_BY_ID(5, "Remove news by id."),

  GET_ALL_AUTHORS(6, "Get all authors."),
  GET_AUTHOR_BY_ID(7, "Get author by id."),
  CREATE_AUTHOR(8, "Create author."),
  UPDATE_AUTHOR(9, "Update author."),
  REMOVE_AUTHOR_BY_ID(10, "Remove author by id."),
  GET_ALL_TAGS(11, "Get all tags."),
  GET_TAG_BY_ID(12, "Get tag by id."),
  CREATE_TAG(13, "Create tag."),
  UPDATE_TAG(14, "Update tag."),
  REMOVE_TAG_BY_ID(15, "Remove tag by id."),

  GET_NEWS_BY_TAG_NAME(16, "Get news by tag name"),
  //byTagId  byAuthorName byTitle byContent
  GET_NEWS_BY_TAG_ID(17, "Get news by tag id"),
  GET_NEWS_BY_AUTHOR_NAME(18,"Get news by author name"),
  GET_NEWS_BY_TITLE(19,"Get news by title"),
  GET_NEWS_BY_CONTENT(20,"Get news by content"),

  EXIT(0, "Exit."),
  ;

  private final int operationNumber;
  private final String operation;

  Operations(int operationNumber, String operation) {
    this.operationNumber = operationNumber;
    this.operation = operation;
  }

  public String getOperation() {
    return OPERATION + operation;
  }

  public String getOperationWithNumber() {
    return operationNumber + " - " + operation;
  }

  public int getOperationNumber() {
    return operationNumber;
  }
}
