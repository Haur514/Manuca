package jp.ac.osaka_u.ist.sdl.manuca.controller.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jp.ac.osaka_u.ist.sdl.manuca.controller.purchase.requestbody.ManuscriptAddRequestBody;
import jp.ac.osaka_u.ist.sdl.manuca.controller.purchase.responsebody.ManuscriptResponseBody;
import jp.ac.osaka_u.ist.sdl.manuca.entity.ManuscriptEntity;
import jp.ac.osaka_u.ist.sdl.manuca.kuromoji.KuromojiAnalysis;
import jp.ac.osaka_u.ist.sdl.manuca.service.ManuscriptService;

@RestController
@RequestMapping("/manuscripts")
public class ManuscriptController {


  final private static int PHRASE_MAX_LENGTH = 3;
  @Autowired private ManuscriptService manuscriptService;

  @GetMapping
  public List<ManuscriptResponseBody> getTokenizedManuscript(){
    List<ManuscriptEntity> result = manuscriptService.findAll();
    return result.stream().map(ManuscriptController::convert).toList();
  }

  @GetMapping("{id}")
  public List<String> getTokenizedManuscriptById(@PathVariable int id){
    ManuscriptEntity manuscript = manuscriptService.findById(id);
    return KuromojiAnalysis.phrase(manuscript.getManuscript(),PHRASE_MAX_LENGTH);
  }
  
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ManuscriptResponseBody addMember(@RequestBody ManuscriptAddRequestBody manuscript) {
    ManuscriptEntity result;
    result = manuscriptService.addManuscript(manuscript.manuscript());
    return convert(result);
  }

  private static ManuscriptResponseBody convert(ManuscriptEntity origin){
    return new ManuscriptResponseBody(origin.getId(), KuromojiAnalysis.phrase(origin.getManuscript(),PHRASE_MAX_LENGTH));
  }
}
