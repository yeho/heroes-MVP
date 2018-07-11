package com.yeho.hero.data.remote.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Comics implements Serializable {
  private int available;
  private String collectionURI;
  private ArrayList<ComicItem> items;
  private int returned;

  public int getAvailable() {
    return this.available;
  }

  public void setAvailable(int available) {
    this.available = available;
  }

  public String getCollectionURI() {
    return this.collectionURI;
  }

  public void setCollectionURI(String collectionURI) {
    this.collectionURI = collectionURI;
  }

  public ArrayList<ComicItem> getItems() {
    return this.items;
  }

  public void setItems(ArrayList<ComicItem> items) {
    this.items = items;
  }

  public int getReturned() {
    return this.returned;
  }

  public void setReturned(int returned) {
    this.returned = returned;
  }
}