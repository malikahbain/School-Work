import java.util.Queue;
import java.util.LinkedList;

import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;
import javax.swing.plaf.basic.BasicSliderUI.TrackListener;

public class A4Q2 {
    

    public int calcTimeReqToBuyBurgers(int[] burgers, int p)
    {
        Queue<Integer> queue = new LinkedList<Integer>();
        int timeCount = 0;
        int tracker = p;

        for(int i = 0; i< burgers.length; i++ ){
            queue.add(burgers[i]);
        }

        final int FIXED_SIZE = queue.size();

        while(true && queue.peek() != null && p < FIXED_SIZE){

            int head = queue.peek(); 
            int tmp = head - 1;   
             
            timeCount++;

            if(tmp == 0 && tracker == 0 ){
                queue.remove(head);
                break;
            } else if (tmp == 0){
                queue.remove(head);  
            } else{
                queue.remove(head);
                queue.add(tmp); 
            }

            
            tracker--;

            if(tracker == -1){
                tracker = queue.size() - 1;
            }
 

       }

        return timeCount;
    } 
    
    
}
