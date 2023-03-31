package com.xiwen.exer;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/15 -10:58
 * @Version: 1.0
 */
public class Doc4jTest {


    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read(Doc4jTest.class.getClassLoader().getResourceAsStream("animals.xml"));
        Element rootElement = document.getRootElement();
        System.out.println(rootElement);

        Element animal1 = rootElement.element("animal");
        Attribute id = animal1.attribute("id");
        Element name = animal1.element("name");
        String text = name.getText();
        System.out.println(text);

        System.out.println(id.getValue());
        List<Element> elements = rootElement.elements();

        elements.forEach(e -> {
            Element age1 = e.element("age");
            Element name1 = e.element("name");
            System.out.println(age1.getText() + " " + name1.getText());
        });

    }
}
