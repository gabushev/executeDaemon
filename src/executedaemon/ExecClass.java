/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package executedaemon;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author darthvader
 */
public class ExecClass extends Thread{
    
    private String filePath = null;
    private String interpreter = null;
    private Integer delay = null;
    private Boolean log = false;
    private Boolean interrupt = false;
    private String cmd = null;
    
    public Boolean blinker = false;//flag for interrupt
    public Date startTime = null;
    public Date endTime = null;
    public String processName = null;
    
    
    public ExecClass(String file, String interpreter, Integer delay, Boolean log, Boolean interrupt) {
        File tmpFile = new File(file);
        if (tmpFile.exists()){
            this.setFilePath(file);
        }
        tmpFile = null;
        tmpFile = new File(interpreter);
        if (tmpFile.exists()){
            this.setInterpreter(interpreter);
        }
        tmpFile = null;
        if (delay>0){
            this.setDelay(delay);
        }
        this.setLog(log);
        this.setInterrupt(interrupt);
        String[] name = file.split("\\/");
        this.processName = name[name.length-1];
        this.setName(processName);
    }

    @Override
    public void run() {
        this.cmd = this.getInterpreter() +" "+ this.getFilePath();
        while (this.blinker){
            try {
                try {
                    Process pExec = Runtime.getRuntime().exec(this.cmd);
                    pExec.waitFor();
                } catch (RuntimeException | IOException ex){
                    ExecLogger log = new ExecLogger(this.processName);
                    log.addRecord(ex.getMessage());
                    ex.printStackTrace();
                }
                wait(this.delay);
            } catch (InterruptedException ex) {
                Logger.getLogger(ExecClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @return the filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath the filePath to set
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return the interpreter
     */
    public String getInterpreter() {
        return interpreter;
    }

    /**
     * @param interpreter the interpreter to set
     */
    public void setInterpreter(String interpreter) {
        this.interpreter = interpreter;
    }

    /**
     * @return the delay
     */
    public Integer getDelay() {
        return delay;
    }

    /**
     * @param delay the delay to set
     */
    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    /**
     * @return the log
     */
    public Boolean getLog() {
        return log;
    }

    /**
     * @param log the log to set
     */
    public void setLog(Boolean log) {
        this.log = log;
    }

    /**
     * @return the interrupt
     */
    public Boolean getInterrupt() {
        return interrupt;
    }

    /**
     * @param interrupt the interrupt to set
     */
    public void setInterrupt(Boolean interrupt) {
        this.interrupt = interrupt;
    }
    
   
}
