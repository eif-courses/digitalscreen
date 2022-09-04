package eif.viko.lt.backend.domain.model;

import eif.viko.lt.backend.domain.enums.Languages;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Exhibit {
  @Id
  @GeneratedValue
  private long id;
  private String title;
  private Languages language;
  private String description;
  private String imageUrl;
  private String modelUrl;
  private String audioUrl;

  public Exhibit() {
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
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getModelUrl() {
    return modelUrl;
  }

  public void setModelUrl(String modelUrl) {
    this.modelUrl = modelUrl;
  }

  public String getAudioUrl() {
    return audioUrl;
  }

  public void setAudioUrl(String audioUrl) {
    this.audioUrl = audioUrl;
  }

  public Languages getLanguage() {
    return language;
  }

  public void setLanguage(Languages language) {
    this.language = language;
  }
}
