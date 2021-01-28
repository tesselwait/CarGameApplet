import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CarGame extends Applet implements KeyListener
{
	int t= 2466;//car loop length
	int a= 0;//road loop position left/right
	int k = 100;//user car position left/right
	int z= -616;//car2 position left/right
	int w = -1232;//car3 position left/right
	int v = -1848;//car4 position left/right
	int h = 0;//car1 position left/right
	int m = 240;//user car height
	int n =1;//end graphics variable
	int crash=0;
	int l = 0;//debris
	int lFinal;//final debris
	int bs=5;//body speed--higher number=slower speed


	Random gen = new Random();
	int randomx1=gen.nextInt(61)+45;
	int randomx2=gen.nextInt(61)+45;
	int randomx3=gen.nextInt(61)+45;
	int randomx4=gen.nextInt(61)+45;
	int randomx5=gen.nextInt(61)+45;
	int randomx6=gen.nextInt(61)+45;
	int randomx7=gen.nextInt(61)+45;
	int randomx8=gen.nextInt(61)+45;
	int randomx9=gen.nextInt(61)+45;
	int randomx10=gen.nextInt(61)+45;
	int randomx11=gen.nextInt(61)+45;
	int randomx12=gen.nextInt(61)+45;
	int randomx13=gen.nextInt(61)+45;
	int randomx14=gen.nextInt(61)+45;
	int randomx15=gen.nextInt(61)+45;
	int randomy1=gen.nextInt(81);
	int randomy2=gen.nextInt(81);
	int randomy3=gen.nextInt(81);
	int randomy4=gen.nextInt(81);
	int randomy5=gen.nextInt(81);
	int randomy6=gen.nextInt(81);
	int randomy7=gen.nextInt(81);
	int randomy8=gen.nextInt(81);
	int randomy9=gen.nextInt(81);
	int randomy10=gen.nextInt(81);
	int randomy11=gen.nextInt(81);
	int randomy12=gen.nextInt(81);
	int randomy13=gen.nextInt(81);
	int randomy14=gen.nextInt(81);
	int randomy15=gen.nextInt(81);
	int b = gen.nextInt(345)+50;//car1 height
	int c = gen.nextInt(345)+50;//car2 height
	int d = gen.nextInt(345)+50;//car3 height
	int e = gen.nextInt(345)+50;//car4 height
	int cs = 1;//car speed --higher number lower speed
	int rs = 2;//road speed -- higher number lower speed
	int s = 0;//score
	
	int red = gen.nextInt(255)+1;
	int green =  gen.nextInt(255)+1;
	int blue =  gen.nextInt(255)+1;
	Color RANDOM = new Color(red, green, blue);//car1 color
	Color RANDOM2 = new Color(red, green, blue);//car2 color
	Color RANDOM3 = new Color(red, green, blue);//car3 color 
	Color RANDOM4 = new Color(red, green, blue);//car4 color
	
	SolidObject myCar = new SolidObject();
	SolidObject car1 = new SolidObject();
	SolidObject car2 = new SolidObject();
	SolidObject car3 = new SolidObject();
	SolidObject car4 = new SolidObject();
	SolidObject topSidewalk = new SolidObject();
	SolidObject bottomSidewalk = new SolidObject();
	
	public void init()
	{
		addKeyListener(this);
	}
	public void paint(Graphics rob)
	{
	
		setSize(750,500);
		setBackground(Color.darkGray);
		rob.setColor(Color.lightGray);
		//--------sidewalk//
		rob.fillRect(0-a/rs, 0, 150, 50);
		rob.fillRect(155-a/rs, 0, 150, 50);
		rob.fillRect(310-a/rs, 0, 150, 50);
		rob.fillRect(465-a/rs, 0, 150, 50);
		rob.fillRect(620-a/rs, 0, 150, 50);
		rob.fillRect(775-a/rs, 0, 150, 50);
		rob.fillRect(930-a/rs, 0, 150, 50);	
		rob.fillRect(1085-a/rs, 0, 150, 50);	
		rob.fillRect(1240-a/rs, 0, 150, 50);		
		rob.fillRect(1395-a/rs, 0, 150, 50);
		rob.fillRect(1550-a/rs, 0, 150, 50);
		rob.fillRect(1705-a/rs, 0, 150, 50);
		rob.fillRect(1860-a/rs, 0, 150, 50);
		rob.fillRect(2015-a/rs, 0, 150, 50);
		//<<top/bottom>>
		rob.fillRect(0-a/rs, 450, 150, 50);
		rob.fillRect(155-a/rs, 450, 150, 50);
		rob.fillRect(310-a/rs, 450, 150, 50);
		rob.fillRect(465-a/rs, 450, 150, 50);
		rob.fillRect(620-a/rs, 450, 150, 50);
		rob.fillRect(775-a/rs, 450, 150, 50);
		rob.fillRect(930-a/rs, 450, 150, 50);
		rob.fillRect(1085-a/rs, 450, 150, 50);
		rob.fillRect(1240-a/rs, 450, 150, 50);
		rob.fillRect(1395-a/rs, 450, 150, 50);
		rob.fillRect(1550-a/rs, 450, 150, 50);
		rob.fillRect(1705-a/rs, 450, 150, 50);
		rob.fillRect(1860-a/rs, 450, 150, 50);
		rob.fillRect(2015-a/rs, 450, 150, 50);
		//sidewalk---------//
		rob.setColor(Color.yellow);
		//-----------lane lines//
		rob.fillRect(100-a/rs, 170, 150, 10);
		rob.fillRect(410-a/rs, 170, 150, 10);
		rob.fillRect(720-a/rs, 170, 150, 10);
		rob.fillRect(1030-a/rs, 170, 150, 10);
		rob.fillRect(1340-a/rs, 170, 150, 10);
		rob.fillRect(1750-a/rs, 170, 150, 10);
		//<<<top/bottom>>>
		rob.fillRect(100-a/rs, 320, 150, 10);
		rob.fillRect(410-a/rs, 320, 150, 10);
		rob.fillRect(720-a/rs, 320, 150, 10);
		rob.fillRect(1030-a/rs, 320, 150, 10);
		rob.fillRect(1340-a/rs, 320, 150, 10);
		rob.fillRect(1750-a/rs, 320, 150, 10);
		//lane line----------------//
		
		if (h==0)//car1 color generator
		{
			red = gen.nextInt(255)+1;
			green =  gen.nextInt(255)+1;
			blue =  gen.nextInt(255)+1;
			RANDOM = new Color(red, green, blue);
		}
		rob.setColor(RANDOM);
		//----------obstacle car1--------//
		car1.makeSolidObject(775-h*cs, b,80, 50);
		rob.fillRoundRect(775-h*cs, b,80, 50, 10, 10);
		rob.setColor(Color.lightGray);
		rob.fillRoundRect(815-h*cs, b+7, 17, 38, 3, 3);//car1 windows front
		rob.fillRect(785-h*cs, b+7, 10, 38);//car1windows back
		rob.setColor(Color.black);
		rob.fillRect(785-h*cs, b-2, 10, 2);//car1 wheels---
		rob.fillRect(825-h*cs, b-2, 10, 2);//--
		rob.fillRect(785-h*cs, b+50, 10, 2);//--
		rob.fillRect(825-h*cs, b+50, 10, 2);//---car1 wheels
		rob.setColor(Color.black);
		rob.drawRoundRect(775-h*cs, b,80, 50, 10, 10);//outline
		rob.drawRoundRect(815-h*cs, b+7, 17, 38, 3, 3);//car1 windows front outline
		rob.drawRect(785-h*cs, b+7, 10, 38);//car1windows back outline
		//---------obstacle car1
		
		if (z==0)//car2 color generator
		{
			red = gen.nextInt(255)+1;
			green =  gen.nextInt(255)+1;
			blue =  gen.nextInt(255)+1;
			RANDOM2 = new Color(red, green, blue);
		}
		rob.setColor(RANDOM2);	
		//------obstacle car2---------//
		car2.makeSolidObject(775-z*cs, c, 80, 50);
		rob.fillRoundRect(775-z*cs, c, 80, 50, 10, 10);
		rob.setColor(Color.lightGray);
		rob.fillRoundRect(815-z*cs, c+7, 17, 38, 3, 3);//car2 window front
		rob.fillRect(785-z*cs, c+7, 10, 38);//car2 window back
		rob.setColor(Color.black);
		rob.fillRect(785-z*cs, c-2, 10, 2);//car2 wheels-----
		rob.fillRect(825-z*cs, c-2, 10, 2);//--
		rob.fillRect(785-z*cs, c+50, 10, 2);//--
		rob.fillRect(825-z*cs, c+50, 10, 2);//----car2 wheels
		rob.drawRoundRect(775-z*cs, c,80, 50, 10, 10);//outline
		rob.drawRoundRect(815-z*cs, c+7, 17, 38, 3, 3);//car1 windows front outline
		rob.drawRect(785-z*cs, c+7, 10, 38);//car1windows back outline
		//----------obstacle car2-------------//
		if (w==0)//car3 color generator
		{
			red = gen.nextInt(255)+1;
			green =  gen.nextInt(255)+1;
			blue =  gen.nextInt(255)+1;
			RANDOM3 = new Color(red, green, blue);
		}
		rob.setColor(RANDOM3);
	
		//------obstacle car3---------//
		car3.makeSolidObject(775-w*cs, d, 80, 50);
		rob.fillRoundRect(775-w*cs, d, 80, 50, 10, 10);
		rob.setColor(Color.lightGray);
		rob.fillRoundRect(815-w*cs, d+7, 17, 38, 3, 3);//car3 window front
		rob.fillRect(785-w*cs, d+7, 10, 38);//car3 window back
		rob.setColor(Color.black);
		rob.fillRect(785-w*cs, d-2, 10, 2);//car3 wheels-----
		rob.fillRect(825-w*cs, d-2, 10, 2);//--
		rob.fillRect(785-w*cs, d+50, 10, 2);//--
		rob.fillRect(825-w*cs, d+50, 10, 2);//----car3 wheels
		rob.drawRoundRect(775-w*cs, d,80, 50, 10, 10);//outline
		rob.drawRoundRect(815-w*cs, d+7, 17, 38, 3, 3);//car1 windows front outline
		rob.drawRect(785-w*cs, d+7, 10, 38);//car1windows back outline
		//----------obstacle car3-------------//
		if (v==0)//car4 color generator
		{
			red = gen.nextInt(255)+1;
			green =  gen.nextInt(255)+1;
		 	blue =  gen.nextInt(255)+1;
		 	RANDOM4 = new Color(red, green, blue);
		}
		rob.setColor(RANDOM4);
		
		//------obstacle car4---------//
		car4.makeSolidObject(775-v*cs, e, 80, 50);
		rob.fillRoundRect(775-v*cs, e, 80, 50, 10, 10);
		rob.setColor(Color.lightGray);
		rob.fillRoundRect(815-v*cs, e+7, 17, 38, 3, 3);//car4 window front
		rob.fillRect(785-v*cs, e+7, 10, 38);//car4 window back
		rob.setColor(Color.black);
		rob.fillRect(785-v*cs, e-2, 10, 2);//car4 wheels-----
		rob.fillRect(825-v*cs, e-2, 10, 2);//--
		rob.fillRect(785-v*cs, e+50, 10, 2);//--
		rob.fillRect(825-v*cs, e+50, 10, 2);//----car4 wheels
		rob.drawRoundRect(775-v*cs, e,80, 50, 10, 10);//outline
		rob.drawRoundRect(815-v*cs, e+7, 17, 38, 3, 3);//car1 windows front outline
		rob.drawRect(785-v*cs, e+7, 10, 38);//car1windows back outline
		//----------obstacle car4-------------//
					//--------road perimeter//
		rob.fillRect(0, 50, 750, 4);
		topSidewalk.makeSolidObject(0, 50, 750, 4);
		rob.fillRect(0, 448, 750, 4);
		bottomSidewalk.makeSolidObject(0, 448, 750, 4);
		//road perimeter----------//
		if(!(myCar.isCollidingWith(car1)) && !(myCar.isCollidingWith(car2)) && !(myCar.isCollidingWith(car3)) && !(myCar.isCollidingWith(car4)))//if car isn't hitting another car run variables
		{
			a++;
			h++;
			z++;
			w++;
			v++;
			s++;
		}
		else//end graphics     explosion/damage
		{
			if(n<750 &&n>0)//crash effects
			{
				if(crash<1)
				{
					k = k+10;
					crash=crash+1;
				}
				n++;
				l++;
				l++;
				if(n>400)
				{
					l--;
				}
				rob.setColor(Color.black);
				rob.fillRect(k+32+l/bs, m+10, 24, 3);//main body
				rob.fillRoundRect(k+51+l/bs, m+8, 8, 8, 6, 6);//body head
				rob.fillRect(k+20+l/bs, m+8, 14, 2);//body leg
				rob.fillRect(k+20+l/bs, m+13, 14, 2);//body leg
				rob.fillRect(k+45+l/bs, m+7, 2, 4);//body arm
				rob.fillRect(k+45+l/bs, m+13, 2, 4);//body arm
				rob.fillRect(k+45+l/bs, m+5, 7, 2);//body arm
				rob.fillRect(k+45+l/bs, m+17, 7, 2);//body arm
				rob.fillRoundRect(k+38, m+11, 8, 10, 2, 2);//window break
				rob.fillRect(k+(gen.nextInt(61)+50), m-20+(gen.nextInt(91)), 3, 3);//---debris
				rob.fillRect(k+(gen.nextInt(61)+50), m-20+(gen.nextInt(91)), 3, 3);//--
				rob.fillRect(k+(gen.nextInt(61)+50), m-20+(gen.nextInt(91)), 3, 3);//-
				rob.fillRect(k+(gen.nextInt(61)+50), m-20+(gen.nextInt(91)), 3, 3);//--
				rob.fillRect(k+(gen.nextInt(61)+50), m-20+(gen.nextInt(91)), 3, 3);//---
				rob.fillRect(k+(gen.nextInt(61)+50), m-20+(gen.nextInt(91)), 3, 3);//----
				rob.fillRect(k+(gen.nextInt(61)+50), m-20+(gen.nextInt(91)), 3, 3);//---
				rob.fillRect(k+(gen.nextInt(61)+50), m-20+(gen.nextInt(91)), 3, 3);//--
				rob.fillRect(k+(gen.nextInt(61)+50), m-20+(gen.nextInt(91)), 3, 3);//-
				rob.fillRect(k+(gen.nextInt(61)+50), m-20+(gen.nextInt(91)), 3, 3);//--
				rob.fillRect(k+(gen.nextInt(61)+50), m-20+(gen.nextInt(91)), 3, 3);//---
				rob.fillRect(k+(gen.nextInt(61)+50), m-20+(gen.nextInt(91)), 3, 3);//----
				rob.fillRect(k+(gen.nextInt(61)+50), m-20+(gen.nextInt(91)), 3, 3);//---
				rob.fillRect(k+(gen.nextInt(61)+50), m-20+(gen.nextInt(91)), 3, 3);//--
				rob.fillRect(k+(gen.nextInt(61)+50), m-20+(gen.nextInt(91)), 3, 3);//-debris
				if(n==745)
				{
					lFinal = l;
				}
			}
			else//end crash effects
			{
				n = 0;
				rob.setColor(Color.red);
				rob.fillRoundRect(k+15+l/bs, m+2, 50, 20, 40, 40);//blood
				rob.setColor(Color.black);
				rob.fillRect(k+32+lFinal/bs, m+10, 24, 3);//end main body
				rob.fillRoundRect(k+51+lFinal/bs, m+8, 8, 8, 6, 6);//end body head
				rob.fillRect(k+20+l/bs, m+8, 14, 2);//end body leg
				rob.fillRect(k+20+l/bs, m+13, 14, 2);//end body leg
				rob.fillRect(k+45+l/bs, m+7, 2, 4);//end body arm
				rob.fillRect(k+45+l/bs, m+13, 2, 4);//end body arm
				rob.fillRect(k+45+l/bs, m+5, 7, 2);//end body arm
				rob.fillRect(k+45+l/bs, m+17, 7, 2);//end body arm
				rob.fillRoundRect(k+38, m+11, 8, 10, 2, 2);//end window break
			}
			rob.fillRect(k+randomx1, m-15+randomy1, 3, 3);//--end debris
			rob.fillRect(k+randomx2, m-15+randomy2, 3, 3);//--
			rob.fillRect(k+randomx3, m-15+randomy3, 3, 3);//--
			rob.fillRect(k+randomx4, m-15+randomy4, 3, 3);//--
			rob.fillRect(k+randomx5, m-15+randomy5, 3, 3);//--
			rob.fillRect(k+randomx6, m-15+randomy6, 3, 3);//--
			rob.fillRect(k+randomx7, m-15+randomy7, 3, 3);//--
			rob.fillRect(k+randomx8, m-15+randomy8, 3, 3);//--
			rob.fillRect(k+randomx9, m-15+randomy9, 3, 3);//--
			rob.fillRect(k+randomx10, m-15+randomy10, 3, 3);//--
			rob.fillRect(k+randomx11, m-15+randomy11, 3, 3);//--
			rob.fillRect(k+randomx12, m-15+randomy12, 3, 3);//--
			rob.fillRect(k+randomx13, m-15+randomy13, 3, 3);//--
			rob.fillRect(k+randomx14, m-15+randomy14, 3, 3);//--
			rob.fillRect(k+randomx15, m-15+randomy15, 3, 3);//end debris
			rob.fillRoundRect(k+73, m, 5, 50, 3, 3);
			rob.drawString("Game Over", 350, 250);
			rob.setColor(Color.orange);
			rob.fillOval(k+60-n/6, m+40-n/6, n/3, n/3);//explosion orange
			rob.setColor(Color.red);
			rob.fillOval(k+60-((n-300)/6), m+40-((n-300)/6), (n-300)/3, (n-300)/3);//explosion red
		}
		repaint();
		rob.setColor(Color.red);
		rob.drawString("Your score is "+ s, 10, 10);
		if(a>1233)//road loop
		{
			a = 0;
		}
		if(h>t)//car1 loop
		{
			h=0;
			b = gen.nextInt(345)+50;
		}
		if(z>t)//car2 loop
		{
			z = 0;
			c = gen.nextInt(345)+50;
		}
		if(w>t)//car3 loop
		{
			w = 0;
			d = gen.nextInt(345)+50;
		}
		if(v>t)//car4 loop
		{
			v = 0;
			e = gen.nextInt(345)+50;
		}
		//------------USER CAR//
		myCar.makeSolidObject(k, m, 80, 50);
		rob.setColor(Color.black);
		rob.fillRect(k+10, m-2, 13, 1);//---wheels
		rob.fillRect(k+60, m-2, 13, 1);//--
		rob.fillRect(k+10, m+50, 13, 2);//--
		rob.fillRect(k+60, m+50, 13, 2);//--- wheels
		rob.setColor(Color.red);
		rob.fillRoundRect(k, m, 80, 50, 10, 10);
		rob.setColor(Color.black);
		rob.fillRect(k+47, m+7, 27, 1);//front accent top
		rob.fillRect(k+47, m+42, 27, 1);//front accent bottom
		rob.setColor(Color.white);
		rob.fillRect(k, m+18, 80, 6);//racing stripes
		rob.fillRect(k, m+28, 80, 6);//racing stripes
		rob.setColor(Color.red);
		rob.fillRect(k+4, m+8, 6, 36);//---tail fin
		rob.setColor(Color.black);//--
		rob.fillRect(k+4, m+6, 12, 2);//--
		rob.fillRect(k+4, m+42, 12, 2);//--
		rob.fillRect(k+3, m+7, 1, 36);//--
		rob.fillRect(k+10, m+7, 1, 36);//---tail fin
		rob.setColor(Color.lightGray);
		rob.fillRoundRect(k+35, m+8, 12, 34, 3, 3);// window front
		rob.fillRect(k+20, m+8, 7, 34);//window back
		rob.fillRoundRect(k+66, m+1, 13, 6, 8, 8);//head light top
		rob.fillRoundRect(k+66, m+43, 13, 6, 8, 8);//head light bottom
		rob.setColor(Color.black);//outlines
		rob.fillRect(k+27, m+8, 10, 1);//roof accent top
		rob.fillRect(k+27, m+42, 10, 1);//roof accent bottom
		rob.drawRoundRect(k+66, m+1, 13, 6, 8, 8);
		rob.drawRoundRect(k+66, m+43, 13, 6, 8, 8);
		rob.drawRoundRect(k-1, m-1, 81, 51, 10, 10);
		rob.drawRoundRect(k+35, m+8, 12, 34, 3, 3);
		rob.drawRect(k+20, m+8, 7, 34);
		//USER CAR------------------//
	}
	
	public void keyPressed(KeyEvent event)//---------CAR CONTROLS-------------//
	{
		int keyCode = event.getKeyCode();
	
		if(keyCode == event. VK_UP )
			{
				if(m>62&&n==1)
				{
					m=m-25;
				}
			}
		if(keyCode == event. VK_DOWN)
		{
			if(m<390&&n==1)
			{
			m=m+25;
			}
		}
		if(keyCode == event. VK_RIGHT)
		{
				if(k<620&&n==1)
				{
					k=k+25;
				}
		}
		if(keyCode == event. VK_LEFT)
		{
			if(k>30&&n==1)
			{
				k=k-25;
			}
		}
	//	if(keyCode == event.VK_1)
	//	{
	//		t = t/2;
	//		rs = rs/2;
	//		cs = cs/2;
	//	}
	//	if(keyCode == event. VK_2)
	//	{
	//		t = t *2;
	//		rs = rs*2;
	//		cs = cs*2;
	//	}
		//-----------CAR CONTROLS-----------//
	}
