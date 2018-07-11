package com.yeho.hero.data.remote.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Result implements Serializable {

  private int id;
  private String name;
  private String description;
  private Date modified;
  private Thumbnail thumbnail;
  private String resourceURI;
  private Comics comics;
  private Series series;
  private Stories stories;
  private Events events;
  private ArrayList<Url> urls;

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getModified() {
    return this.modified;
  }

  public void setModified(Date modified) {
    this.modified = modified;
  }

  public Thumbnail getThumbnail() {
    return this.thumbnail;
  }

  public void setThumbnail(Thumbnail thumbnail) {
    this.thumbnail = thumbnail;
  }

  public String getResourceURI() {
    return this.resourceURI;
  }

  public void setResourceURI(String resourceURI) {
    this.resourceURI = resourceURI;
  }

  public Comics getComics() {
    return this.comics;
  }

  public void setComics(Comics comics) {
    this.comics = comics;
  }

  public Series getSeries() {
    return this.series;
  }

  public void setSeries(Series series) {
    this.series = series;
  }

  public Stories getStories() {
    return this.stories;
  }

  public void setStories(Stories stories) {
    this.stories = stories;
  }

  public Events getEvents() {
    return this.events;
  }

  public void setEvents(Events events) {
    this.events = events;
  }

  public ArrayList<Url> getUrls() {
    return this.urls;
  }

  public void setUrls(ArrayList<Url> urls) {
    this.urls = urls;
  }
}
