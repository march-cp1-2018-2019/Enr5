/**
 * Jeremiah's umm comments 
 * I don't totally know what
 * Im doing but I hope this works...
 * 
 * 
 * 
 * 
 */

package ihavenocluewhatimdoing;
import javax.sound.midi.*; //import stuffs
import java.io.*;
import javax.swing.*;
import java.awt.*;

  // this one plays random music with it, but only because there is a listener.

public class MiniMusicPlayer3 {

    static JFrame f = new JFrame("My First Music Video"); //Creating a JFrame
    static MyDrawPanel ml; //making a Draw Panel

    public static void main(String[] args) { //public static void
           MiniMusicPlayer3 mini = new MiniMusicPlayer3(); //creating "mini" which is a MiniMusicPlayer3
           mini.go(); //run the method go()
     }
   
 
     public  void setUpGui() { //this is setUpGui()
       ml = new MyDrawPanel();//finish making Draw Panel
       f.setContentPane(ml); //Set a content pane
       f.setBounds(30,30, 300,300); //set size?
       f.setVisible(true); //make it visible
    }
 

    public void go() { //this is the method go()
       setUpGui(); //run setUpGui()

       try {

         // make (and open) a sequencer, make a sequence and track

         Sequencer sequencer = MidiSystem.getSequencer(); //making a new Sequencer        
         sequencer.open(); //opening that Sequencer 
        
         sequencer.addControllerEventListener(ml, new int[] {127}); //adding an event to that sequencer
         Sequence seq = new Sequence(Sequence.PPQ, 4);//making a sequnece
         Track track = seq.createTrack();     //making a track for the sequences?

         // now make two midi events (containing a midi message)

      int r = 0; //creating a variable called "r"
      for (int i = 0; i < 60; i+= 4) { //set up a for loop

          r = (int) ((Math.random() * 50) + 1); //setting r to a random number 1-50 
         
          track.add(makeEvent(144,1,r,100,i)); //no clue ??
        
          track.add(makeEvent(176,1,127,0,i)); //no clue ?
         
          track.add(makeEvent(128,1,r,100,i + 2)); //no clue ??? ?
       } // end loop
        
          // add the events to the track            
          // add the sequence to the sequencer, set timing, and start

          sequencer.setSequence(seq); //setting the sequnecer's sequence to the sequence "seq"
 
          sequencer.start(); //starting the sequencer 
          sequencer.setTempoInBPM(120); //setting the seqencer's Tempo in BPM to 120
      } catch (Exception ex) {ex.printStackTrace();} //if all that failed do this
  } // close go


   public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) { //create a event
          MidiEvent event = null; //set this event to null
          try { //try to do this stuffs
            ShortMessage a = new ShortMessage(); //create a new short message
            a.setMessage(comd, chan, one, two); //set the message to the weird stuffs
            event = new MidiEvent(a, tick); //set up the event?
            
          }catch(Exception e) { } //if all fails
          return event; //return event can't really say much more about this
       }



 class MyDrawPanel extends JPanel implements ControllerEventListener { //create a new ControllerEventListener called MyDrawPanel
      
      // only if we got an event do we want to paint
      boolean msg = false; //create a boolean call "msg" and set it to false

      public void controlChange(ShortMessage event) { //this is an method...
         msg = true; //set the boolean "msg" to true
         repaint();         //...
      }

      public void paintComponent(Graphics g) {
       if (msg) { //if true or false
            
         Graphics2D g2 = (Graphics2D) g;

         int r = (int) (Math.random() * 250);//random numbers...
         int gr = (int) (Math.random() * 250);//random numbers...
         int b = (int) (Math.random() * 250);//random numbers...

         g.setColor(new Color(r,gr,b));//random Color...

         int ht = (int) ((Math.random() * 120) + 10);//random numbers...
         int width = (int) ((Math.random() * 120) + 10);//random numbers...

         int x = (int) ((Math.random() * 40) + 10);//random numbers...
         int y = (int) ((Math.random() * 40) + 10); //random numbers...
         
         g.fillRect(x,y,ht, width); //fill with that stuff
         msg = false; //set "msg" to false//random numbers...

       } // close if
     } // close method
   }  // close inner class

} // close class