package com.yeho.hero.data.remote.model;

import java.io.Serializable;

public class Thumbnail implements Serializable {

  private String path;

  public String getPath() { return this.path; }

  public void setPath(String path) { this.path = path; }

  private String extension;

  public String getExtension() { return this.extension; }

  public void setExtension(String extension) { this.extension = extension; }
}
