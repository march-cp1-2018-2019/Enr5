import javax.sound.midi.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;


 



 


public class MiniMusicPlayer3{
	static JFrame f = new JFrame("My First Music Video"); // JFrame
	static MyDrawPanel ml;


 
public static void main(String[] args){
MiniMusicPlayer3 mini = new MiniMusicPlayer3(); 
 mini.go(); // run app


 
  }


 



 
  public  void setUpGui(){
	  ml = new MyDrawPanel(); // a new panel is formed
  }

f.setContentPane(ml); 
 f.setBounds(30,30, 300,300);
f.setVisible(true); // show the window


 
  }


 



 
  public void go(){
setUpGui(); // the Gui is set up

try{


 
      //  make a sequence and track


 



 
      Sequencer sequencer = MidiSystem.getSequencer(); // gets midi sequencer
      Sequencer.open();
sequencer.addControllerEventListener(ml, new int[]{127}); // sets controller
 Sequencer seq = new Sequence(Sequence.PPQ, 4);
 Track track = seq.createTrack();   


 



 
      // 2 midis


 int r = 0;


 
      for (int i = 0; i < 60; i+= 4){ //tones


 
        r = (int) ((Math.random() * 50) + 1);


 



 
        track.add(makeEvent(144,1,r,100,i));


 



 
        track.add(makeEvent(176,1,127,0,i));


 



 
        track.add(makeEvent(128,1,r,100,i + 2));


 
      }


 



 
      // add tracks     


 
      


 



 
      sequencer.setSequence(seq);


 



 
      sequencer.start();


 
      sequencer.setTempoInBPM(120);


 
    }catch(Exception ex){ex.printStackTrace();}


 
  } 


 



 
  public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){


 
    MidiEvent event = null;


 
    try{


 
      ShortMessage a = new ShortMessage();


 
      a.setMessage(comd, chan, one, two); //  message


 
      event = new MidiEvent(a, tick); // makes event


 
    }catch(Exception e){}


 



 
    return event;


 
  }


 



 
  class MyDrawPanel extends JPanel implements ControllerEventListener{


 
  


 
    boolean msg = false;


 



 
    public void controlChange(ShortMessage event){


 
      msg = true;     


 
      repaint();     


 
    }


 



 
    public void paintComponent(Graphics g){


 
      if(msg){


 
        Graphics2D g2 = (Graphics2D) g;


 



 
        // create random color


 
        int r = (int) (Math.random() * 250);


 
        int gr = (int) (Math.random() * 250);


 
        int b = (int) (Math.random() * 250);


 



 
        g.setColor(new Color(r,gr,b)); 


 



 
        // create random width and height


 
        int ht = (int) ((Math.random() * 120) + 10);


 
        int width = (int) ((Math.random() * 120) + 10);


 



 
        


 
        int x = (int) ((Math.random() * 40) + 10);


 
        int y = (int) ((Math.random() * 40) + 10);


 



 
        g.fillRect(x,y,ht, width); 


 
        msg = false;
