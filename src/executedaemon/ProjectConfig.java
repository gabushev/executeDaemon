/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package executedaemon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author darthvader
 */
public class ProjectConfig {

    public ProjectConfig() {
        ExecClass[] classes = this.getConfig();
    }
    
    public ExecClass[] getConfig(){
        
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();  
        }
        try {
        Document document = builder.parse(
                new FileInputStream((ExecuteDaemon.class.getResource("cfg/edConfig.xml").getFile())));
                document.getElementsByTagName("scripts");
                NodeList nodes = document.getChildNodes();
                for(int i=0; i<nodes.getLength(); i++){
                Node node = nodes.item(i);
                    if(node instanceof Element){
                        //a child element to process
                        Element child = (Element) node;
                        String attribute = child.getAttribute("file");
                        System.out.println(attribute);
                    }
                }
                
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        

        
        Integer num = 0;
        ExecClass[] reslist = new ExecClass[num];
        return reslist;
    }
    
    
}
