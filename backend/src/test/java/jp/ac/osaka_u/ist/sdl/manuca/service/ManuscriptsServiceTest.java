package jp.ac.osaka_u.ist.sdl.manuca.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;
import java.util.ArrayList;
import java.util.List;
import jp.ac.osaka_u.ist.sdl.manuca.DBTestBase;
import jp.ac.osaka_u.ist.sdl.manuca.entity.ManuscriptEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;

@DBRider
@DataSet(cleanBefore = true)
@AutoConfigureMockMvc
@ActiveProfiles("test") // To use test db
public class ManuscriptsServiceTest extends DBTestBase {

  @Autowired private ManuscriptService manuscriptService;

  @Test
  @DataSet(value = "ManuscriptService/normalFindAll/before.yaml")
  public void testFindAll() {
    List<ManuscriptEntity> manuscripts = manuscriptService.findAll();
    List<ManuscriptEntity> expected = new ArrayList<>();
    expected.add(new ManuscriptEntity("私は理系の大学院生であり情報工学を専攻しています．"));
    expected.add(new ManuscriptEntity("研究は楽しい部分もあればしんどい部分もあります．"));
    assertEquals(manuscripts.get(0).getManuscript(), expected.get(0).getManuscript());
    assertEquals(manuscripts.get(1).getManuscript(), expected.get(1).getManuscript());
  }
}
