package proje;

import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class sinav implements ActionListener{
	String [] Sorular = {
			"Bu anahtar sözcüklerden hangisi subclass'da superclass'ýn yapýcýsýný çaðýrmak için kullanýlabilir?",
			"Superclassta tanýmlanmýþ bir methodun ayný isim ve imza ile subclassda tekrar tanýmlanmasý iþlemine ne denir?",
			"Aþaðýdakilerden hangisi overriding etmeyi önlemek için kullanýlabilir?",
			"Aþaðýdakilerden hangisi Java'da overriding methodu tarafýndan desteklenir?",
			"Aþaðýdakilerden hangisi bütün classlarýn superclassýdýr?",
			"Aþaðýdakilerden hangisi classýn inheritance edilmesini önlemekte kullanýlabilir?"}; 
        String [][] Cevaplar = 
        	        {{"this","super","extend","extends"},
        			{"Overloading","Hiding","Overriding","Hicbiri"},
        			{"constant","static","protected","final"},
        			{"polymorphism","abstraction","encapsulation","Hiçbiri"},
        			{"String class","Object Class ", "Abstract class ", "ArrayList Class"},
        			{"final","class","super","constant"}}; 
        char[] sýklar = {'B','C','D','A','B','A'}; 
        JFrame frame = new JFrame(); 
        JTextArea textarea = new JTextArea(); 
        JTextField textfield = new JTextField(); 
        JButton buton1 = new JButton(); 
        JButton buton2 = new JButton(); 
        JButton buton3 = new JButton(); 
        JButton buton4 = new JButton();
        JButton buton5 = new JButton("Restart");
        JButton buton6 = new JButton("Bos Býrak");
        JTextArea bilgi = new JTextArea();
        JTextArea bilgi2 = new JTextArea();
        JTextArea bilgi3 = new JTextArea();
        JLabel kalansure = new JLabel();
        JLabel A = new JLabel(); 
        JLabel B = new JLabel(); 
        JLabel C = new JLabel(); 
        JLabel D = new JLabel(); 
        JTextField dogrusayi = new JTextField(); 
        JTextField yuzde = new JTextField();
        int bossayisi = 0 ;
        char cevap;
        int sorusayisi = Sorular.length;
        int dogru_sorusayisi = 0;
        int index = 0 ; 
	    int zaman = 15;
        int sonuc;
	Timer sayac = new Timer(900, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			zaman--;
                        kalansure.setText(String.valueOf(zaman));
			if(zaman<=0) {
				dogru();
				bossayisi++;
			}
			}
		});
	//Frame,buton tasarýmý 
	public void sinav()  {
            frame.setSize(650,640);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setVisible(true);
            frame.setLayout(null);
            frame.setTitle("Overriding testi");
            try {
                frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("arkaplan.jpg")))));
            } catch (IOException ex) {
                Logger.getLogger(sinav.class.getName()).log(Level.SEVERE, null, ex);
            }
               buton1.setBounds(0,100,100,100);
               buton1.setText("A");
		       buton1.setFont(new Font("Dialog",Font.BOLD,35));
		       buton1.setFocusable(false);
		       buton1.addActionListener(this);
                
               buton2.setBounds(0,200,100,100);
               buton2.setText("B");
		       buton2.setFont(new Font("Dialog",Font.BOLD,35));
		       buton2.setFocusable(false);
		       buton2.addActionListener(this);
                
                buton3.setBounds(0,300,100,100);
                buton3.setText("C");
		buton3.setFont(new Font("Dialog",Font.BOLD,35));
		buton3.setFocusable(false);
		buton3.addActionListener(this);
                
                buton4.setBounds(0,400,100,100);
                buton4.setText("D");
		buton4.setFont(new Font("Dialog",Font.BOLD,35));
		buton4.setFocusable(false);
		buton4.addActionListener(this);
                
                buton5.setBounds(300,400,100,100);
		buton5.setFont(new Font("MV Boli",Font.BOLD,15));
		buton5.setFocusable(false);
		buton5.addActionListener(this);
                buton5.setLocation(400,410);
                
                buton6.setBounds(300,400,75,75);
		buton6.setFont(new Font("Helvetica Neue",Font.BOLD,14));
		buton6.setFocusable(false);
		buton6.addActionListener(this);
                buton6.setLocation(300,490);
                
		textfield.setBounds(0,0,650,50);
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("MV Boli",Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		textarea.setBounds(0,50,650,50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(25,25,25));
		textarea.setForeground(new Color(25,255,0));
		textarea.setFont(new Font("Helvetica Neue",Font.BOLD,15));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
                
                bilgi.setBounds(300,350,100,100);
                bilgi.setLocation(50,400);
		bilgi.setForeground(new Color(25,255,0));
		        bilgi.setFont(new Font("Helvetica Neue",Font.BOLD,10));
		        bilgi.setEditable(false);
                bilgi.setWrapStyleWord(true);
                bilgi.setLineWrap(true);
                bilgi.setOpaque(false);
                

                JScrollPane scrollPane = new JScrollPane(bilgi);
                scrollPane.getViewport().setOpaque(false);
                scrollPane.setOpaque(false);
          
                bilgi2.setBounds(300,350,100,100);
                bilgi2.setLocation(50,800);
		bilgi2.setForeground(new Color(25,255,0));
		bilgi2.setFont(new Font("Helvetica Neue",Font.BOLD,15));
		bilgi2.setEditable(false);
                bilgi2.setWrapStyleWord(true);
                bilgi2.setLineWrap(true);
                bilgi2.setLocation(100,700);
                
                bilgi3.setBounds(300,250,200,200);
		bilgi3.setForeground(new Color(25,255,0));
                bilgi3.setBackground(new Color(50,50,50));
		bilgi3.setFont(new Font("MV Boli",Font.BOLD,20));
		bilgi3.setEditable(false);
                bilgi3.setWrapStyleWord(true);
                bilgi3.setLineWrap(true);
                
                kalansure.setBounds(125,100,500,100);
                kalansure.setLocation(400,400);
		kalansure.setBackground(new Color(50,50,50));
		kalansure.setForeground(new Color(25,255,0));
		kalansure.setFont(new Font("MV Boli",Font.PLAIN,35));
		
             frame.add(buton6);
             
	     frame.add(kalansure);
             frame.add(buton1);
             frame.add(buton2);
             frame.add(buton4);
             frame.add(buton3);
             frame.add(textfield);
             frame.add(textarea);
             frame.add(buton5);
             frame.add(bilgi);
             frame.add(bilgi2);
             buton5.setVisible(false);
             buton6.setVisible(true);
            
             
         A.setBounds(125,100,500,100);
		A.setBackground(new Color(50,50,50));
		A.setForeground(new Color(25,255,0));
		A.setFont(new Font("Helvetica Neue",Font.PLAIN,25));
		
		B.setBounds(125,200,500,100);
		B.setBackground(new Color(50,50,50));
		B.setForeground(new Color(25,255,0));
                B.setFont(new Font("Helvetica Neue",Font.PLAIN,25));
		
		C.setBounds(125,300,500,100);
		C.setBackground(new Color(50,50,50));
		C.setForeground(new Color(25,255,0));
		C.setFont(new Font("Helvetica Neue",Font.PLAIN,25));
		
		D.setBounds(125,400,500,100);
		D.setBackground(new Color(50,50,50));
		D.setForeground(new Color(25,255,0));
		D.setFont(new Font("Helvetica Neue",Font.PLAIN,25));
                frame.add(A);
                frame.add(B);
                frame.add(C);
                frame.add(D);
               yenisoru();
	}
        
     
        // yeni soruya geçmek için kullanýlan method 
	public void yenisoru() {
           if(index>=sorusayisi) {
			results();
		}
		else {
               sayac.start();
			textfield.setText("Soru "+(index+1));
			textarea.setText(Sorular[index]);
			A.setText(Cevaplar[index][0]);
			B.setText(Cevaplar[index][1]);
			C.setText(Cevaplar[index][2]);
			D.setText(Cevaplar[index][3]);
			
                       buton5.setVisible(false);
                       buton1.setVisible(true);
		               buton2.setVisible(true);
		               buton3.setVisible(true);
                       buton4.setVisible(true);
                       bilgi.setVisible(false);
                       
                          A.setVisible(true);
                          B.setVisible(true);
                          C.setVisible(true);
                          D.setVisible(true);
                        
           }
			
	}
	
        @Override
	public void actionPerformed(ActionEvent e) {
		buton1.setEnabled(false);
		buton2.setEnabled(false);
		buton3.setEnabled(false);
		buton4.setEnabled(false);
		buton6.setEnabled(false);
			
			if(e.getSource()==buton1) {
				cevap = 'A';
				if(cevap == sýklar[index]) {
					dogru_sorusayisi++;
                                        
				}
                               
                              
			}
			if(e.getSource()== buton2) {
				cevap= 'B';
				if(cevap == sýklar[index]) {
					dogru_sorusayisi++;
                                       
                                       
                                }
			}
                        if(e.getSource()== buton3) {
				cevap= 'C';
				if(cevap == sýklar[index]) {
					dogru_sorusayisi++;
				}
			}
                        if(e.getSource()== buton4) {
				cevap= 'D';
				if(cevap == sýklar[index]) {
					dogru_sorusayisi++;
				}
			}     
                        
                        if(e.getSource()== buton5) {
                           yenidenbaslat();
                           
			} 
                        if(e.getSource()== buton6) {
                            bossayisi++;
                            
 			} 
                       
			dogru();
                        
	}
	public void dogru() {
		
        sayac.stop();
		buton1.setEnabled(false);
		buton2.setEnabled(false);
		buton3.setEnabled(false);
		buton4.setEnabled(false);
		    if(sýklar[index] != 'A')
			A.setForeground(new Color(255,0,0));                 
		    if(sýklar[index] != 'B')
			B.setForeground(new Color(255,0,0));
            if(sýklar[index] != 'C')
			C.setForeground(new Color(255,0,0));
            if(sýklar[index] != 'D')
			D.setForeground(new Color(255,0,0));
               
                
                
        
       Timer pause = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				A.setForeground(new Color(25,255,0));
				B.setForeground(new Color(25,255,0));
				C.setForeground(new Color(25,255,0));
				D.setForeground(new Color(25,255,0));
				
				cevap = ' ';
				zaman = 15;
				
				buton1.setEnabled(true);
				buton2.setEnabled(true);
				buton3.setEnabled(true);
				buton4.setEnabled(true);
				buton6.setEnabled(true);
				index++;
                                yenisoru();
				
                                
                             
                             
                        }	           
});
                pause.setRepeats(false);
		pause.start();
              
        }
	
                   public void results(){
		
		buton1.setEnabled(false);
		buton2.setEnabled(false);
		buton3.setEnabled(false);
		buton4.setEnabled(false);
		
		sonuc = (int)((dogru_sorusayisi/(double)sorusayisi)*100);
		int yanlýs = sorusayisi-(dogru_sorusayisi+bossayisi);
		textfield.setText("SONUÇ!");
		textarea.setText("Aldýðýnýz Puan : "+sonuc);
		A.setLocation(50,100);
		B.setLocation(50,200);
		C.setLocation(50,300);
		D.setLocation(50,400);
		A.setText("Dogru Sayýnýz : "+dogru_sorusayisi);
		B.setText("Yanlýs Sayýnýz : "+(yanlýs));
		C.setText("Boþ Sayýnýz : "+(bossayisi));
		D.setText("");
                frame.add(bilgi);
                bilgi.setVisible(true);
                buton1.setVisible(false);
                buton2.setVisible(false);
                buton3.setVisible(false);
                buton4.setVisible(false);
                buton5.setVisible(true);
                buton6.setVisible(false);
                kalansure.setVisible(false);
                
                if(yanlýs == 3){
                    
                    bilgi.setText("Sorularýn yarýsýna dogru cevap verdiniz biraz daha çalýþmalýsýnýz");
                }
                else if(yanlýs == 6 ){
                    bilgi.setText("Sorularýn hepsine yanlýs veya bos cevap verdiniz,Daha fazla calýsmalýsýnýz");
                }
                else if(dogru_sorusayisi == 6 ){
                    bilgi.setText("Bravo! Sorularýn hepsine dogru cevap verdiniz");
                                        
                }
                     
}   
                   
                	    
                	
        
   void yenidenbaslat()  {
	   frame.dispose();
       sinav s = new sinav();
       s.sinav();
       index = 0 ;
   }
  

}



