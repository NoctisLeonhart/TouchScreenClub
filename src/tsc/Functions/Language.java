package tsc.Functions;

import javax.xml.parsers.*;
import org.w3c.dom.*;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Noctis on 24.07.14.
 */

public class Language {
    private List<String> LangugeList = new LinkedList<String>();
    public Language(int landID) {
        try {
            File file = new File("Lang\\"+getLanguageType(landID)+".xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeLst = doc.getElementsByTagName("Language");

            for (int s = 0; s < nodeLst.getLength(); s++) {
                Node fstNode = nodeLst.item(s);
                if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element fstElmnt = (Element) fstNode;
                    NodeList fstNmElmntLst;
                    Element fstNmElmnt;
                    NodeList fstNm;
                    for(int j = 1; j<22; j++) {
                        fstNmElmntLst = fstElmnt.getElementsByTagName("String"+ String.valueOf(j));
                        fstNmElmnt = (Element) fstNmElmntLst.item(0);
                        fstNm = fstNmElmnt.getChildNodes();
                        LangugeList.add((fstNm.item(0)).getNodeValue());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getLanguageType(int ID){
        switch (ID){
            case 0:return "English";
            case 1:return "עברית";
            case 2:return "GERMAN";
            case 3:return "FRENCH";
            case 4:return "ITALIAN";
            case 5:return "SPANISH";
            case 6:return "RUSSIAN";
            case 7:return "CHINEESE";
        }
        return "Language1";
    }

    public List<String> getLanguage(){
        return LangugeList;
    }
}


