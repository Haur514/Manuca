package jp.ac.osaka_u.ist.sdl.manuca.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE) // for JPA
@Table(name = "manuscript")
public class ManuscriptEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Setter(AccessLevel.NONE)
  private int id;

  @NonNull
  @Column(columnDefinition="TEXT")
  private String manuscript;

  public ManuscriptEntity(String manuscript) {
    this.manuscript = manuscript;
  }
}
