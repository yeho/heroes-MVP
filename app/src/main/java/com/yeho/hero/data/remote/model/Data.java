package com.yeho.hero.data.remote.model;

import java.util.ArrayList;

public class Data {
  private int offset;
  private int limit;
  private int total;
  private int count;
  private ArrayList<Result> results;

  public int getOffset() {
    return this.offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public int getLimit() {
    return this.limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public int getTotal() {
    return this.total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public int getCount() {
    return this.count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public ArrayList<Result> getResults() {
    return this.results;
  }

  public void setResults(ArrayList<Result> results) {
    this.results = results;
  }
}
