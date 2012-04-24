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
    }
    
    public void startThread(Integer i){
        System.out.println(i);
        this.threadSet[i].run();
    }
    
    public void stopThread(int i){
        this.threadSet[i].interrupt();
    }
    
    public ExecController() {
        ProjectConfig pConf = new ProjectConfig();
        ExecClass[] tmpClasses = pConf.getConfig();
        System.out.println(tmpClasses.length);
        this.setThreadSet(tmpClasses);
        Integer len = this.getSize();
        for (Integer i=0; i<len; i++){
            this.startThread(i);
        }
    }
}
