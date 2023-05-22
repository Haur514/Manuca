package jp.ac.osaka_u.ist.sdl.manuca.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.ac.osaka_u.ist.sdl.manuca.entity.ManuscriptEntity;
import jp.ac.osaka_u.ist.sdl.manuca.repository.ManuscriptRepository;

@Service
@Transactional
public class ManuscriptService {
  @Autowired private ManuscriptRepository manuscriptRepository;

  public ManuscriptEntity findById(int id){
    return manuscriptRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  public List<ManuscriptEntity> findAll(){
    return manuscriptRepository.findAll();
  }

  public ManuscriptEntity addManuscript(String manuscript){
    ManuscriptEntity manuscriptEntity = new ManuscriptEntity(manuscript);
    return manuscriptRepository.save(manuscriptEntity);
  }
}
