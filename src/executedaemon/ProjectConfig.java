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

import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author darthvader
 */
public class ProjectConfig {

    public ProjectConfig() {
    }
    
    public ExecClass[] getConfig(){
        String attributeFile = null;
        String attributeInterpreter = null;
        String attributeDelay = null;
        String attributeInterrupt = null;
        String attributeLogging = null;
        String interruptTime = null;
        ExecClass[] result = null;
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();  
        }
        try {
            String tmpDir = (new File("").getAbsolutePath());
            System.out.println(tmpDir+"/cfg/edConfig.xml");
            File file = new File(tmpDir+"/cfg/edConfig.xml");
            Document document = builder.parse(
                new FileInputStream(file));
                NodeList nodes = document.getElementsByTagName("php");
                result = new ExecClass[document.getElementsByTagName("php").getLength()];
                for(int i=0; i<document.getElementsByTagName("php").getLength(); i++){
                    //System.out.println(nodes.getLength());
                Element node = (Element) nodes.item(i);
                    if(node instanceof Element){
                        interruptTime = "0";
                        Element child = (Element) node;
                        attributeFile = child.getAttribute("file");
                        attributeInterpreter = child.getAttribute("interpreter");
                        attributeDelay = child.getAttribute("delay");
                        attributeInterrupt = child.getAttribute("interrupt");
                        attributeLogging = child.getAttribute("logging");
                        try{
                            interruptTime = Integer.toString(Integer.parseInt(interruptTime)+Integer.parseInt(child.getAttribute("interruptTime")));
                        } catch (NumberFormatException ex){
                            interruptTime = "0";
                        }
                        result[i] = new ExecClass(attributeFile, attributeInterpreter, Integer.parseInt(attributeDelay), Boolean.parseBoolean(attributeLogging), Boolean.parseBoolean(attributeInterrupt),Integer.parseInt(interruptTime));
                    }
                }
                
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DOMException ex){
            ex.printStackTrace();
        }
        
        return result;
    }
    
}
