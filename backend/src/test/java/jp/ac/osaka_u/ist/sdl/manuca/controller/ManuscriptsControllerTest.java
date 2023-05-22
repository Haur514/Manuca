package jp.ac.osaka_u.ist.sdl.manuca.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;

import jp.ac.osaka_u.ist.sdl.manuca.DBTestBase;
import jp.ac.osaka_u.ist.sdl.manuca.controller.purchase.ManuscriptController;
import jp.ac.osaka_u.ist.sdl.manuca.controller.purchase.responsebody.ManuscriptResponseBody;
import jp.ac.osaka_u.ist.sdl.manuca.kuromoji.KuromojiAnalysis;

@DBRider
@DataSet(cleanBefore = true)
@AutoConfigureMockMvc
@ActiveProfiles("test") // To use test db
public class ManuscriptsControllerTest extends DBTestBase {
    @Autowired private ManuscriptController manuscriptController;
    @Test
  @DataSet(value = "ManuscriptController/getTokenizedManuscript/before.yaml")
  public void testGetTokenizedManuscript() throws Exception {
    ManuscriptResponseBody expected = new ManuscriptResponseBody(1,KuromojiAnalysis.phrase("私は理系の大学院生であり情報工学を専攻しています．",8));
    assertEquals(expected,manuscriptController.getTokenizedManuscript().get(0));
  }
}
