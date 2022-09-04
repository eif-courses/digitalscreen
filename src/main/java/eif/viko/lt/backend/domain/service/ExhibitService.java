package eif.viko.lt.backend.domain.service;

import eif.viko.lt.backend.domain.enums.Languages;
import eif.viko.lt.backend.domain.model.Exhibit;
import eif.viko.lt.backend.domain.repository.ExhibitRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.*;

@ApplicationScoped
@Transactional
public class ExhibitService {
  @Inject
  ExhibitRepository repository;

  public void create(Exhibit exhibit){
    repository.persist(exhibit);
  }
  public void delete(long id){
    repository.deleteById(id);
  }

  public List<Exhibit> findAll(){
   return repository.listAll();
  }

  public Optional<Exhibit> findById(long id){
    return repository.findByIdOptional(id);
  }

  public Optional<Exhibit> findByTitle(String title){
    return repository.findByTitleOptional(title);
  }
  public void update(long id, Exhibit exhibit){

    repository.update(
        "update from Exhibit set title = ?1, language = ?2, description = ?3, imageUrl = ?4, modelUrl = ?5, audioUrl = ?6 where id = ?7",
        exhibit.getTitle(),
        exhibit.getLanguage(),
        exhibit.getDescription(),
        exhibit.getImageUrl(),
        exhibit.getModelUrl(),
        exhibit.getAudioUrl(),
        id);
  }

}
