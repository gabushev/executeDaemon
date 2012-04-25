/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package executedaemon;

import java.io.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author darthvader
 */
public class ExecLogger implements ExecLoggerInterface{
    private File logFile = null;
    private String processName = null;
    private Date dateCall = null;
    private String descr = null;
          
            
    public ExecLogger(String process) {
        this.processName = process;
        this.dateCall = new Date();
        
    }
    
    public void initLogger() {
        this.descr = "/var/log/executeDaemon/"+this.processName+"-"+this.dateCall.toString();
    }

    @Override
    public void addRecord(String message) {
            //System.out.println(this.descr);
            this.write(this.descr, message);
    }

    public boolean write(String filename, String text){
        String inText = "";
        inText = inText+text;
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filename));
            out.write(inText);
            out.close();
        } catch (IOException e) {
            Logger.getLogger(ExecLogger.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }
}
