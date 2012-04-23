/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package executedaemon;

import java.io.File;

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
    }

    @Override
    public void run() {
        
        super.run();
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
