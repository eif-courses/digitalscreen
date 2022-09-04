package eif.viko.lt.backend.domain.repository;

import eif.viko.lt.backend.domain.enums.Languages;
import eif.viko.lt.backend.domain.model.Exhibit;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ExhibitRepository implements PanacheRepository<Exhibit> {
  public Optional<Exhibit> findByTitleOptional(String title){
    return find("title", title).firstResultOptional();
  }

  public List<Exhibit> findLT(){
    return list("language", Languages.LT);
  }
  public List<Exhibit> findEN(){
    return list("language", Languages.EN);
  }
  public List<Exhibit> findRU(){
    return list("language", Languages.RU);
  }
}
