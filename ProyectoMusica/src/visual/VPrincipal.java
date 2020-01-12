package visual;

import javax.swing.JFrame;
import javax.swing.JButton;

public class VPrincipal extends JFrame{
	
    public String playState;
    public String playImageEntered;
    
    
    public VPrincipal(){
    	getContentPane().setLayout(null);
    	
    	JButton btnReproducir = new JButton("Reproducir");
    	btnReproducir.setBounds(173, 199, 115, 29);
    	getContentPane().add(btnReproducir);
    	
    	btnReproducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playClicked(evt);
            }
        });

   	 
   	 private void playClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playClicked

   	        //switch can be used
   	        
			String playImageExited;
			if(playState.equals("PLAYING")){
   	            playImageEntered="images/play_h.png";
   	            playImageExited="images/play.png";
   	           // changeImage(playImageExited, btnReproducir);
   	           // controller.pause();
   	            playState = "PAUSED";
   	            return;
   	        }
   	        
   	        if(playState.equals("SELECTED")){
   	            playImageEntered="images/pause_h.png";
   	            playImageExited="images/pause.png";
   	          //  changeImage(playImageExited, btnReproducir);
   	          //  controller.play(selectedIndex);
   	            playState = "PLAYING";
   	            return;
   	        }
   	        
   	        if(playState.equals("PAUSED")){
   	            playImageEntered="images/pause_h.png";
   	            playImageExited="images/pause.png";
   	           // changeImage(playImageExited, btnReproducir);
   	           // controller.resume();
   	            playState = "PLAYING";
   	            return;
   	        }
   	    }
    }
}
