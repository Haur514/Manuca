package jp.ac.osaka_u.ist.sdl.manuca.kuromoji;

import java.util.ArrayList;
import java.util.List;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;

public class KuromojiAnalysis {
    public static List<Token> analyze(String input) throws Exception{
        Tokenizer tokenizer = new Tokenizer();
        List<Token> tokens = tokenizer.tokenize(input);
        return tokens;
    }

    public static List<String> tokenize(String input){
        List<Token> analyzed;
        List<String> ret = new ArrayList<>();
        try {
            analyzed = analyze(input);
        } catch (Exception e) {
            return null;
        }
        String tmpString = "";
        for(int i = 0; i < analyzed.size();i++){
            if((analyzed.get(i).getPartOfSpeechLevel1().equals("助詞") 
            || analyzed.get(i).getPartOfSpeechLevel1().equals("助動詞"))){
                tmpString += analyzed.get(i).getSurface();
            }else{
                if(!tmpString.isEmpty()){
                    ret.add(tmpString);
                }
                tmpString = analyzed.get(i).getSurface();
            }
        }
        if(tmpString != ""){
            ret.add(tmpString);
        }
        return ret;
    }

    public static List<String> phrase(String input,int maxSize){
        List<String> tokenized = tokenize(input);
        List<String> ret = new ArrayList<>();
        String tmpToken = "";
        for(String token : tokenized){
            tmpToken += token;
            if(tmpToken.length() > maxSize){
                ret.add(tmpToken);
                tmpToken = "";
            }
        }
        if(!tmpToken.isEmpty()){
            ret.add(tmpToken);
        }
        return ret;
    }
}
