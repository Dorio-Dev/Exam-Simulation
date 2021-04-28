package com.daradat.exam.cm.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Exam {
    private List<ExamObject> originList;
    private List<ExamObject> examList;

    private int[] answer;
    private int[] correct;
    private int[] inCorrect;

    public Exam() {
        ClassPathResource examResource = new ClassPathResource("exam.xml");
        try {
            File examFile = examResource.getFile();

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(examFile);

            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("exam");
            this.examList = new ArrayList<ExamObject>();

            for(int i=0; i< nodeList.getLength(); i++){
                Node node = nodeList.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE){
                    ExamObject examObject = new ExamObject();

                    Element element = (Element) node;

                    examObject.setQuestion(element.getElementsByTagName("question").item(0).getTextContent());
                    examObject.setAnswer(Arrays.asList(element.getElementsByTagName("correctAnswers").item(0).getTextContent().split(",")));


                    NodeList choiceNodeList = ((Element)element.getElementsByTagName("choices").item(0)).getElementsByTagName("choice");
                    examObject.setCntOfChoices(choiceNodeList.getLength());
                    List<String> choiceList = new ArrayList<>();
                    for(int j=0; j<choiceNodeList.getLength(); j++){
                        choiceList.add(choiceNodeList.item(j).getTextContent());
                    }
                    examObject.setChoices(choiceList);

                    examList.add(examObject);
                }
            }
            originList = new ArrayList<>();
            originList.addAll(examList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public void shuffle(){
        Collections.shuffle(examList);
    }
}
