package dama;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Component extends JPanel{
    private int velikostJPanelu=60;
    public int rozmerJPanelu=8;
    public static CustomJPanel [][] pole;
    int polee[][]=new int[8][8];
    private Border grayBorder = BorderFactory.createLineBorder(Color.YELLOW);
    int lastclickx;
    int lastclicky;
    int lastfigure;
    int bodyplayer1=0;
    int bodyplayer2=0;
    int brrbrr=0;
    ArrayList<Skok> killmoves=new ArrayList<Skok>(); 
        int firstturn;
    
       public Component(){
        pole=new CustomJPanel[rozmerJPanelu][rozmerJPanelu];
        this.setSize((rozmerJPanelu*velikostJPanelu), (rozmerJPanelu*velikostJPanelu));
         this.setLayout(new GridLayout(0, rozmerJPanelu));
         this.setMinimumSize(new Dimension(340,340));
         this.setFocusable(true);
         firstturn = (int) (Math.random()*2+1);
        AddJPanel();
        napln();
        prekresli();
        //Okno.setTxt1(""+firstturn);
    }
     public void player1turn(CustomJPanel parent){
               if(!killmoves.isEmpty()){
                   if(parent.getBackground()==Color.RED){
                       noyellow();
                   for(int i=0;i<killmoves.size();i++){
                       if(killmoves.get(i).getSkokando()==parent){
                           pole[killmoves.get(i).getSkokx()][killmoves.get(i).getSkoky()].setBackground(Color.yellow);
                           
                       }
                   }
                   
                   }
                   if(parent.getBackground()==Color.YELLOW){
                     for(int i=0;i<killmoves.size();i++){
                         if(killmoves.get(i).getSkokx()==parent.getPozicex()&&killmoves.get(i).getSkoky()==parent.getPozicey()){
                        pole[killmoves.get(i).getSkokx()][killmoves.get(i).getSkoky()].setFigurka(pole[killmoves.get(i).skokando.getPozicex()][killmoves.get(i).skokando.getPozicey()].getFigurka());
                        pole[killmoves.get(i).skokando.getPozicex()][killmoves.get(i).skokando.getPozicey()].setFigurka(0); 
                        pole[killmoves.get(i).getNepritelx()][killmoves.get(i).getNepritely()].setFigurka(0);
                        bodyplayer1++;
                        killmoves.clear();
                        nored();
                        
                        firstturn++;
                        noyellow();
                        killmovesplayer2();
                        Povyseni(parent);
                        prekresli();
                        win();
                        Okno.setTxt1("2");
                         }
                   }
                       
                   }
               }else{
               if(parent.getBackground()==Color.YELLOW){
                    parent.setFigurka(lastfigure);
                    pole[lastclickx][lastclicky].setFigurka(0);
                    noyellow();
                    firstturn++;
                    killmovesplayer2();
                    Povyseni(parent);
                    prekresli();
                    win();
                    Okno.setTxt1("2");
                }else{
                 noyellow();
                if(parent.getFigurka()==1||parent.getFigurka()==3){
                            try {
                            if(pole[parent.getPozicex()+1][parent.getPozicey()+1].getFigurka()==0){
                                pole[parent.getPozicex()+1][parent.getPozicey()+1].setBackground(Color.yellow);
                            }
                            }
                            catch(Exception e) {
                            
                            }
                            try {
                            if(pole[parent.getPozicex()+1][parent.getPozicey()-1].getFigurka()==0){
                                pole[parent.getPozicex()+1][parent.getPozicey()-1].setBackground(Color.yellow);
                            }
                            }
                            catch(Exception e) {
                            
                            }
                            if(parent.getFigurka()==3){
                           try {
                            if(pole[parent.getPozicex()-1][parent.getPozicey()-1].getFigurka()==0){
                                pole[parent.getPozicex()-1][parent.getPozicey()-1].setBackground(Color.yellow);
                            }
                            }
                            catch(Exception e) {
                            
                            }
                            try {
                            if(pole[parent.getPozicex()-1][parent.getPozicey()+1].getFigurka()==0){
                                pole[parent.getPozicex()-1][parent.getPozicey()+1].setBackground(Color.yellow);
                            }
                            }
                            catch(Exception e) {
                            
                            }
                            }
 
                }
               }

               }
     }
     public void player2turn(CustomJPanel parent){
         if(!killmoves.isEmpty()){
                   
                   if(parent.getBackground()==Color.RED){
                       noyellow();
                   for(int i=0;i<killmoves.size();i++){
                       if(killmoves.get(i).getSkokando()==parent){
                           pole[killmoves.get(i).getSkokx()][killmoves.get(i).getSkoky()].setBackground(Color.yellow);
                           
                       }
                   }
                   
                   }
                   if(parent.getBackground()==Color.YELLOW){
                     for(int i=0;i<killmoves.size();i++){
                         System.out.println(killmoves.get(i).getSkokx()+" "+parent.getPozicex());
                         if(killmoves.get(i).getSkokx()==parent.getPozicex()&&killmoves.get(i).getSkoky()==parent.getPozicey()){
                        pole[killmoves.get(i).getSkokx()][killmoves.get(i).getSkoky()].setFigurka(pole[killmoves.get(i).skokando.getPozicex()][killmoves.get(i).skokando.getPozicey()].getFigurka());
                        pole[killmoves.get(i).skokando.getPozicex()][killmoves.get(i).skokando.getPozicey()].setFigurka(0); 
                        pole[killmoves.get(i).getNepritelx()][killmoves.get(i).getNepritely()].setFigurka(0);
                        bodyplayer2++;
                        killmoves.clear();
                        nored();
                        noyellow();
                   firstturn++;
                        Povyseni(parent);
                        prekresli();
                        win();
                        Okno.setTxt1("1");
                         }
                   }
                    
                    killmovesplayer1();   
                   }
               }else{
               if(parent.getBackground()==Color.YELLOW){
                    parent.setFigurka(lastfigure);
                    pole[lastclickx][lastclicky].setFigurka(0);
                    noyellow();
                    firstturn++;
                    killmovesplayer1();
                    Povyseni(parent);
                    prekresli();
                    win();
                    Okno.setTxt1("1");
                }else{
                 noyellow();
                if(parent.getFigurka()==2||parent.getFigurka()==4){

                            try {

                            if(pole[parent.getPozicex()-1][parent.getPozicey()-1].getFigurka()==0){
                                pole[parent.getPozicex()-1][parent.getPozicey()-1].setBackground(Color.yellow);
                            }
                            }
                            catch(Exception e) {
                            
                            }
                            try {
                            if(pole[parent.getPozicex()-1][parent.getPozicey()+1].getFigurka()==0){
                                pole[parent.getPozicex()-1][parent.getPozicey()+1].setBackground(Color.yellow);
                            }
                            }
                            catch(Exception e) {
                            
                            }
                          if(parent.getFigurka()==4){
                            try {
                            if(pole[parent.getPozicex()+1][parent.getPozicey()+1].getFigurka()==0){
                                pole[parent.getPozicex()+1][parent.getPozicey()+1].setBackground(Color.yellow);
                            }
                            }
                            catch(Exception e) {
                            
                            }
                            try {
                            if(pole[parent.getPozicex()+1][parent.getPozicey()-1].getFigurka()==0){
                                pole[parent.getPozicex()+1][parent.getPozicey()-1].setBackground(Color.yellow);
                            }
                            }
                            catch(Exception e) {
                            
                            }
                          }
                }
               }
               }

               VypisKillmoves();
     }
     public void noyellow(){
                  for(int i=0;i<pole.length;i++){
                    for(int j=0;j<pole.length;j++){
                        if(pole[i][j].getBackground()==Color.yellow){
                            pole[i][j].setBackground(Color.DARK_GRAY);
                        }
                    }
                }         
     }
     public void nored(){
                  for(int i=0;i<pole.length;i++){
                    for(int j=0;j<pole.length;j++){
                        if(pole[i][j].getBackground()==Color.red){
                            pole[i][j].setBackground(Color.DARK_GRAY);
                        }
                    }
                }         
     }
     public void AddJPanel(){
        for(int i=0;i<rozmerJPanelu;i++){
            for(int j=0;j<rozmerJPanelu;j++){
                
                pole[i][j]=new CustomJPanel(velikostJPanelu,i*60,j*60);
                this.add(pole[i][j]);
                pole[i][j].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {

                CustomJPanel parent = (CustomJPanel)me.getSource();
                    if(firstturn%2 == 0)
                    {
                        player1turn(parent);
                        
                    }
                    if(firstturn%2 == 1)
                    {            
                       player2turn(parent);
                    }
                    
                
                lastclickx=parent.getPozicex();
                lastclicky=parent.getPozicey();
                lastfigure=parent.getFigurka();
                Okno.setTxt2(""+bodyplayer1);
                Okno.setTxt3(""+bodyplayer2);
                UkazBoard();
                

            }

            @Override
            public void mousePressed(MouseEvent me) {
                
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                  brrbrr=0;  
                  System.out.println(firstturn);
                    JPanel parent = (JPanel)me.getSource();
                    parent.setBorder(grayBorder);
                    parent.revalidate();
                if(brrbrr==0){
                    if(firstturn%2 == 0)
                    {
                        Okno.setTxt1("1");
                        
                    }
                    if(firstturn%2 == 1)
                    {            
                       Okno.setTxt1("2");
                    }
                    brrbrr++;
                }
            }

            @Override
            public void mouseExited(MouseEvent me) {
                    JPanel parent = (JPanel)me.getSource();
                    parent.setBorder(null);
                    parent.revalidate();
            }
        });
            }
        }
        for(int i=0;i<pole.length;i+=2){
            for(int j=0;j<pole.length;j+=2){
                if(polee[i][j]==1){
                    //vykresli icon
                    
                }
                pole[i][j].setPozicex(i);
                pole[i][j].setPozicey(j);
                pole[i][j].setBackground(Color.darkGray);
            }
        }
        for(int i=1;i<pole.length;i+=2){
            for(int j=1;j<pole.length;j+=2){
                pole[i][j].setBackground(Color.darkGray);
                pole[i][j].setPozicex(i);
                pole[i][j].setPozicey(j);
            }
        }
       
    }
     public void prekresli(){
         for(int i=0;i<pole.length;i++){
             for(int j=0;j<pole.length;j++){
                 if(pole[i][j].getFigurka()==1){
                  try {                
                    pole[i][j].getPicLabel().setIcon((new ImageIcon(ImageIO.read(new File("figures/men2.png")))));
                 } catch (IOException ex) {
                      
                 } 
                 }
                 if(pole[i][j].getFigurka()==2){
                  try {                
                    pole[i][j].getPicLabel().setIcon(new ImageIcon(ImageIO.read(new File("figures/men.png"))));
                 } catch (IOException ex) {
                      
                 }
                 }
                 if(pole[i][j].getFigurka()==3){
                   try {                
                    pole[i][j].getPicLabel().setIcon((new ImageIcon(ImageIO.read(new File("figures/king2.png")))));
                 } catch (IOException ex) {
                      
                 } 
                 }
                if(pole[i][j].getFigurka()==4){
                   try {                
                    pole[i][j].getPicLabel().setIcon((new ImageIcon(ImageIO.read(new File("figures/king.png")))));
                 } catch (IOException ex) {
                      
                 } 
                 }
                if(pole[i][j].getFigurka()==0){
               
                    pole[i][j].getPicLabel().setIcon(null);

                }
             }
         }
     }
     public void napln(){
         for(int i = 0;i <pole.length;i++){
             for(int j = 0 ;j < pole.length; j++){

                 pole[i][j].setFigurka(0);
             }
         }
         for(int i = 0 ; i < 1; i++){
             for(int j = 0;j <pole.length;j+=2){
                 pole[i][j].setFigurka(1);

             }
         }
         for(int i = 1 ; i < 2; i++){
             for(int j = 1;j <pole.length;j+=2){
                 polee[i][j]=1;
                 pole[i][j].setFigurka(1);

             }
         }
         for(int i = 6 ; i < 7; i++){
             for(int j = 0;j <pole.length;j+=2){
                 pole[i][j].setFigurka(2);

             }
         }
         for(int i = 7 ; i < 8; i++){
             for(int j = 1;j <pole.length;j+=2){
                 pole[i][j].setFigurka(2);

             }
         }
         UkazBoard();
         
     }
     public void NakresliBoard(){
         for(int i=0;i<pole.length;i++){
             for(int j=0;j<pole.length;j++){
                 
             }
         }
     }
     public void Povyseni(CustomJPanel figur){
         if(figur.getFigurka()==1){
             if(figur.getPozicex()==pole.length-1){
                 figur.setFigurka(3);
             }
         }
         if(figur.getFigurka()==2){
              if(figur.getPozicex()==0){
                 figur.setFigurka(4);
             }
         }
     }
     public void killmovesplayer1(){
            killmoves.clear();
            for(int k=0;k<pole.length;k++){
                   for(int p=0;p<pole.length;p++){
                       if(pole[k][p].getFigurka()==1||pole[k][p].getFigurka()==3){
                           System.out.println(("jsem figurka"));
                         try { 
                         if((pole[k+1][p+1].getFigurka()==2&&pole[k+2][p+2].getFigurka()==0)||(pole[k+1][p+1].getFigurka()==4&&pole[k+2][p+2].getFigurka()==0)){
                                Skok skok=new Skok(pole[k][p],k+1,p+1,k+2,p+2);
                                killmoves.add(skok);
                                System.out.println("jsem tu");
                            }
                         }catch(Exception e) {
                            
                            }
                         try { 
                         if((pole[k+1][p-1].getFigurka()==2&&pole[k+2][p-2].getFigurka()==0)||(pole[k+1][p-1].getFigurka()==4&&pole[k+2][p-2].getFigurka()==0)){
                                Skok skok=new Skok(pole[k][p],k+1,p-1,k+2,p-2);
                                killmoves.add(skok);
                                System.out.println("jsem tu");
                            }
                         }catch(Exception e) {
                            
                            }
                         if(pole[k][p].getFigurka()==3){
                         try { 
                         if((pole[k-1][p-1].getFigurka()==2&&pole[k-2][p-2].getFigurka()==0)||(pole[k-1][p-1].getFigurka()==4&&pole[k-2][p-2].getFigurka()==0)){
                                Skok skok=new Skok(pole[k][p],k-1,p-1,k-2,p-2);
                                killmoves.add(skok);
                            }
                         }catch(Exception e) {
                            
                            }
                         try { 
                         if((pole[k-1][p+1].getFigurka()==2&&pole[k-2][p+2].getFigurka()==0)||(pole[k-1][p+1].getFigurka()==4&&pole[k-2][p+2].getFigurka()==0)){
                                Skok skok=new Skok(pole[k][p],k-1,p+1,k-2,p+2);
                                killmoves.add(skok);
                            }
                         }catch(Exception e) {
                            
                            }
                         }
                       }
                   }
               }
               if(!killmoves.isEmpty()){
                   for(int i=0;i<killmoves.size();i++){
                       killmoves.get(i).getSkokando().setBackground(Color.RED);
                   }
               }
     }
     public void win(){
         int bila=0;
         int cerna=0;
         for(int i=0;i<pole.length;i++){
             for(int j=0;j<pole.length;j++){
                 if(pole[i][j].getFigurka()==1||pole[i][j].getFigurka()==3){
                     bila++;
                 }
                 if(pole[i][j].getFigurka()==2||pole[i][j].getFigurka()==4){
                     cerna++;
                 }
             }
         }
         if(cerna==0){
             JOptionPane.showMessageDialog(this, "Vyhrává bílá", "Vyhrává bílá",1 );
         }
         if(bila==0){
             JOptionPane.showMessageDialog(this, "Vyhrává černá", "Vyhrává černá",1 );
         }
     }
     public void killmovesplayer2(){
                        killmoves.clear();
               for(int k=0;k<pole.length;k++){
                   for(int p=0;p<pole.length;p++){
                       if(pole[k][p].getFigurka()==2||pole[k][p].getFigurka()==4){
                           System.out.println(("jsem figurka"));
                         try { 
                         if((pole[k-1][p-1].getFigurka()==1&&pole[k-2][p-2].getFigurka()==0)||(pole[k-1][p-1].getFigurka()==3&&pole[k-2][p-2].getFigurka()==0)){
                                Skok skok=new Skok(pole[k][p],k-1,p-1,k-2,p-2);
                                killmoves.add(skok);
                            }
                         }catch(Exception e) {
                            
                            }
                         try { 
                         if((pole[k-1][p+1].getFigurka()==1&&pole[k-2][p+2].getFigurka()==0)||(pole[k-1][p+1].getFigurka()==3&&pole[k-2][p+2].getFigurka()==0)){
                                Skok skok=new Skok(pole[k][p],k-1,p+1,k-2,p+2);
                                killmoves.add(skok);
                            }
                         }catch(Exception e) {
                            
                            }
                         if(pole[k][p].getFigurka()==4){
                         try { 
                         if((pole[k+1][p+1].getFigurka()==1&&pole[k+2][p+2].getFigurka()==0)||(pole[k+1][p+1].getFigurka()==3&&pole[k+2][p+2].getFigurka()==0)){
                                Skok skok=new Skok(pole[k][p],k+1,p+1,k+2,p+2);
                                killmoves.add(skok);
                                System.out.println("jsem tu");
                            }
                         }catch(Exception e) {
                            
                            }
                         try { 
                         if((pole[k+1][p-1].getFigurka()==1&&pole[k+2][p-2].getFigurka()==0)||(pole[k+1][p-1].getFigurka()==3&&pole[k+2][p-2].getFigurka()==0)){
                                Skok skok=new Skok(pole[k][p],k+1,p-1,k+2,p-2);
                                killmoves.add(skok);
                                System.out.println("jsem tu");
                            }
                         }catch(Exception e) {
                            
                            }
                         }
                       }
                   }
               }
                 if(!killmoves.isEmpty()){
                   for(int i=0;i<killmoves.size();i++){
                       killmoves.get(i).getSkokando().setBackground(Color.RED);
                   }
               }
                 VypisKillmoves();
     }
     public void RestartGame(){
        int bodyplayer1=0;
        int bodyplayer2=0;
        int firstturn = (int) (Math.random()*2);
        Okno.setTxt1(""+firstturn);
        Okno.setTxt2("0");
        Okno.setTxt3("0");
        napln();
        prekresli();
        nored();
        noyellow();

     }
     public void VypisKillmoves(){
         for(int i=0;i<killmoves.size();i++){
             System.out.println(" x- "+killmoves.get(i).skokando.getPozicex()+" y- "+killmoves.get(i).skokando.getPozicey());
         }
     }
     public void UkazBoard(){
         for(int i = 0;i <pole.length;i++){
             for(int j = 0 ;j < pole.length; j++){
                 System.out.print(pole[i][j].figurka);
             }
               System.out.println();
         }
     }
 @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // paint the background image and scale it to fill the entire space
        
    }
}
