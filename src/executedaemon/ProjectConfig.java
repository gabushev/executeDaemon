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
    }
    
    public ExecClass[] getConfig(){
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
            File file = new File(tmpDir+"/cfg/edConfig.xml");
            Document document = builder.parse(
                new FileInputStream(file));
                NodeList nodes = document.getElementsByTagName("php").item(0).getChildNodes();
                result = new ExecClass[document.getElementsByTagName("php").getLength()];
                for(int i=0; i<nodes.getLength(); i++){
                    System.out.println(nodes.getLength());
                Node node = nodes.item(i);
                    if(node instanceof Element){
                        Element child = (Element) node;
                        String attributeFile = child.getAttribute("file");
                        String attributeInterpreter = child.getAttribute("interpreter");
                        String attributeDelay = child.getAttribute("delay");
                        String attributeInterrupt = child.getAttribute("interrupt");
                        String attributeLogging = child.getAttribute("logging");
                        result[i] = new ExecClass(attributeFile, attributeInterpreter, Integer.parseInt(attributeDelay), Boolean.parseBoolean(attributeLogging), Boolean.parseBoolean(attributeInterrupt));
                    }
                }
                
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    
}
