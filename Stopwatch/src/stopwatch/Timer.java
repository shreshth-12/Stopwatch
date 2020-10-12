package stopwatch;
/**
 *
 * @author SHRESHTH
 */
public class Timer implements Runnable {
    Stopwatch mysw;
    public Timer(Stopwatch sw){
        mysw=sw;
    }
    
    public volatile boolean status=true;
    @Override
    public void run(){
        int hr=0;
        int min=0;
        int sec=0;
        
       try{ 
        while(status){
            Thread.sleep(1000);
            sec++;
            if(sec==60){
            min++;
            sec=0;}
            if(min==60){
                hr++;min=0;
            }
            //UI display code. 
            mysw.setTimer(hr, min, sec);
            
        }
    }
       catch(Exception e){
           System.out.println(e.getMessage());
       }
    
}
    public void stop(){
        status=false;
    }
}

