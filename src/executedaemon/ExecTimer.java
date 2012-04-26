/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package executedaemon;

/**
 *
 * @author darthvader
 */
public class ExecTimer extends Thread{
    private Integer timeOut = null;
    private ExecClass parent = null;
    private Boolean timeouted = true;

    public ExecTimer(Integer time, ExecClass execClass) {
        this.setTimeOut(time);
        this.parent = execClass;
    }

    /**
     * @return the integer timeOut in msecs
     */
    public Integer getTimeOut() {
        return timeOut;
    }

    /**
     * @param timeOut the integer timeOut to set in msecs
     */
    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }

    public void setFalseTimeout(){
        this.timeouted = false;
    }
    
    public Boolean getTimeoutExpired(){
        return this.timeouted;
    }
    
    @Override
    public void run() {
        if (timeOut==0){
            //may executed infinity time
            this.timeouted = false;
        }else{
            try {
                //wait
                sleep(timeOut);
                //if flag is true yet then kill process
                if (this.timeouted==true){
                    System.out.println("Process "+this.parent.getName()+" killed by execution timeout.\n");
                    this.parent.stopExec();
                }
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}