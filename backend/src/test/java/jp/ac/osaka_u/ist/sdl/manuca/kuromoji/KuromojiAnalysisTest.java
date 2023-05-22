package jp.ac.osaka_u.ist.sdl.manuca.kuromoji;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class KuromojiAnalysisTest {

  @Test
  public void testKuromojiTokenize() {
    List<String> actual = new ArrayList<>();
    List<String> expected = new ArrayList<>();
    expected.add("私は");
    expected.add("理系の");
    expected.add("大学院生であり");
    expected.add("ソフトウェア");
    expected.add("工学を");
    expected.add("選考");
    expected.add("して");
    expected.add("います");
    expected.add("．");
    try {
      actual = KuromojiAnalysis.tokenize("私は理系の大学院生でありソフトウェア工学を選考しています．");
    } catch (Exception e) {
      fail();
    }
    assertEquals(expected, actual);
  }

  @Test
  public void testKuromojiPhrase() {
    List<String> actual = KuromojiAnalysis.phrase("私は理系の大学院生でありソフトウェア工学を選考しています．", 8);
    List<String> expected = new ArrayList<>();
    expected.add("私は理系の大学院生であり");
    expected.add("ソフトウェア工学を");
    expected.add("選考しています．");
    assertEquals(expected, actual);
  }
}
