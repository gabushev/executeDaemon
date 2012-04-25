/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package executedaemon;

/**
 *
 * @author darthvader
 */
public class ExecController{
    private ExecClass[] threadSet = null;
    
    public Integer getSize(){
        return this.threadSet.length;
    }
    
    public void setThreadSet (ExecClass[] threads){
        this.threadSet = threads;
    }
    
    public ExecClass getThread (Integer i){
        return this.threadSet[i];
    }
    
    public ExecClass getThread (int i){
        return this.threadSet[i];
    }
    
    public void startThread(int i){
        this.threadSet[i].run();
        System.out.println("\tThread "+this.threadSet[i].getName()+ " started.");
    }
    
    public void startThread(Integer i){
        this.threadSet[i].start();
        System.out.println("\tThread "+this.threadSet[i].getName()+ " started.");
    }
    
    public void stopThread(int i){
        this.threadSet[i].interrupt();
    }
    
    public ExecController() {
        ProjectConfig pConf = new ProjectConfig();
        this.setThreadSet(pConf.getConfig());
        Integer len = this.getSize();
        for (Integer i=0; i<len; i++){
            this.startThread(i);
        }
    }
}
