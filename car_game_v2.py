import pygame
import random
# Author: Robert Larson
# Pygame translation of Java Applet
pygame.init()

def makeCar(pos_x, pos_y, carspeed, color):
    pygame.draw.rect(screen, BLACK, (774-pos_x*carspeed, pos_y-1,82, 52), border_radius=8)
    pygame.draw.rect(screen, color, (775-pos_x*carspeed, pos_y, 80, 50), border_radius=8)
    #pygame.draw.rect(screen, BLACK, (814-pos_x*carspeed, pos_y+6, 19, 40), border_radius=3)
    pygame.draw.rect(screen, BLACK, (822-pos_x*carspeed, pos_y+7, 27, 1))#front accent top
    pygame.draw.rect(screen, BLACK, (822-pos_x*carspeed, pos_y+42, 27, 1))#front accent bottom
    #pygame.draw.rect(screen, WHITE, (775-pos_x*carspeed, pos_y+18, 80, 6))#racing stripes
    #pygame.draw.rect(screen, WHITE, (775-pos_x*carspeed, pos_y+28, 80, 6))#racing stripes
    pygame.draw.rect(screen, color, (780-pos_x*carspeed, pos_y+8, 6, 36))#---tail fin
    pygame.draw.rect(screen, BLACK, (779-pos_x*carspeed, pos_y+6, 12, 2))#--
    pygame.draw.rect(screen, BLACK, (779-pos_x*carspeed, pos_y+42, 12, 2))#//--
    pygame.draw.rect(screen, BLACK, (778-pos_x*carspeed, pos_y+7, 1, 36))#--
    pygame.draw.rect(screen, BLACK, (785-pos_x*carspeed, pos_y+7, 1, 36))#---tail fin
    #pygame.draw.rect(screen, light_grey, (815-pos_x*carspeed, pos_y+7, 17, 38), border_radius=3)#car1 windows front
    #pygame.draw.rect(screen, BLACK, (784-pos_x*carspeed, pos_y+6, 12, 40), border_radius=2)
    #pygame.draw.rect(screen, light_grey, (785-pos_x*carspeed, pos_y+7, 10, 38), border_radius=2)#car1windows back
    pygame.draw.rect(screen, light_grey, (810-pos_x*carspeed, pos_y+8, 12, 34), border_radius=3)# window front
    pygame.draw.rect(screen, light_grey, (795-pos_x*carspeed, pos_y+8, 7, 34))#window back
    pygame.draw.rect(screen, light_grey, (841-pos_x*carspeed, pos_y+1, 13, 6), border_radius=8)#head light top
    pygame.draw.rect(screen, light_grey, (841-pos_x*carspeed, pos_y+43, 13, 6), border_radius=8)#head light bottom
    pygame.draw.rect(screen, BLACK, (802-pos_x*carspeed, pos_y+8, 10, 1))#roof accent top
    pygame.draw.rect(screen, BLACK, (802-pos_x*carspeed, pos_y+42, 10, 1))#roof accent bottom
    pygame.draw.rect(screen, BLACK, (785-pos_x*carspeed, pos_y-2, 10, 2))#wheels--
    pygame.draw.rect(screen, BLACK, (825-pos_x*carspeed, pos_y-2, 10, 2))#--
    pygame.draw.rect(screen, BLACK, (785-pos_x*carspeed, pos_y+50, 10, 2))#--
    pygame.draw.rect(screen, BLACK, (825-pos_x*carspeed, pos_y+50, 10, 2))#--wheels
    pygame.draw.rect(screen, BLACK, (841-pos_x*carspeed, pos_y+1, 13, 6), 2, border_radius=8)
    pygame.draw.rect(screen, BLACK, (841-pos_x*carspeed, pos_y+43, 13, 6), 2, border_radius=8)
    pygame.draw.rect(screen, BLACK, (774-pos_x*carspeed, pos_y-1, 81, 51), 2, border_radius=10)
    pygame.draw.rect(screen, BLACK, (810-pos_x*carspeed, pos_y+8, 12, 34), 2, border_radius=3)
    pygame.draw.rect(screen, BLACK, (795-pos_x*carspeed, pos_y+8, 7, 34), 2)

screen = pygame.display.set_mode((750, 500))

bs = 7#body speed--higher number=slower speed
start_flag = True
cs = 1
rs = 0.5
s = 0
up = False
down = False

dark_grey = [40, 40, 40]
light_grey = [90, 90, 90]
WHITE = [255, 255, 255]
BLACK = [0, 0, 0]
LANE = [210, 210, 210]
RED = [255, 0, 0]
BLUE= [0, 0, 255]
GREEN=[0, 255, 0]
YELLOW=[255, 255, 0]
ORANGE = [255, 128, 0]

quitVar = True
while quitVar == True:
    if start_flag:
        difficulty = 1 # 0-Easy, 1-Medium, 2-Hard
        drive_mode = 0
        top_menu = True
        t = 2466#car loop length
        a = 0#road loop position left/right
        k = 100#user car position left/right
        z = -616#car2 position left/right
        w = -1232#car3 position left/right
        v = -1848#car4 position left/right
        h = 0#car1 position left/right
        m = 240#user car height
        n = 1#end graphics variable
        l = 0#debris
        crash=0
        rdstp = 0 #road stop
        b = random.randint(0, 345)+50
        c = random.randint(0, 345)+50
        d = random.randint(0, 345)+50
        e = random.randint(0, 345)+50
        color1 = [random.randint(0, 255), random.randint(0, 255), random.randint(0, 255)]
        color2 = [random.randint(0, 255), random.randint(0, 255), random.randint(0, 255)]
        color3 = [random.randint(0, 255), random.randint(0, 255), random.randint(0, 255)]
        color4 = [random.randint(0, 255), random.randint(0, 255), random.randint(0, 255)]
        end_debris = []
        for i in range(0, 8):
            end_debris.append((random.randint(50, 130), random.randint(0, 80)))
            end_debris.append((random.randint(45, 105), random.randint(0, 80)))
        start_flag=False
        titleScreen=True
        score = 0
    screen.fill(dark_grey)
    #sidewalk-----
    for i in range(0, 32):
        pygame.draw.rect(screen, light_grey, ((i*155)-a/rs, 0, 150, 50))
        #<<top/bottom>>
        pygame.draw.rect(screen, light_grey, (i*155-a/rs, 450, 150, 50))
	#------sidewalk
	#lane lines--------
    for i in range(0, 14): # three lane version
        pygame.draw.rect(screen, LANE, (100+(i*310)-a/rs, 170, 100, 6))
        pygame.draw.rect(screen, LANE, (100+(i*310)-a/rs, 320, 100, 6))
    #for i in range(0, 14):  # four lane version
        #pygame.draw.rect(screen, LANE, (100+(i*310)-a/rs, 142, 100, 7))
    #    pygame.draw.rect(screen, LANE, (100+(i*310)-a/rs, 246, 100, 7))
        #pygame.draw.rect(screen, LANE, (100+(i*310)-a/rs, 347, 100, 7))
    #for i in range(0, 14):  # five lane staggered lines version
    #    pygame.draw.rect(screen, LANE, (100+(i*310)-a/rs, 120, 80, 5))
    #    pygame.draw.rect(screen, LANE, (255+(i*310)-a/rs, 203, 80, 5))
    #    pygame.draw.rect(screen, LANE, (100+(i*310)-a/rs, 286, 80, 5))
    #    pygame.draw.rect(screen, LANE, (255+(i*310)-a/rs, 369, 80, 5))
    #for i in range(0, 14):  # five lane version
    #    pygame.draw.rect(screen, LANE, (100+(i*310)-a/rs, 120, 80, 5))
    #    pygame.draw.rect(screen, LANE, (100+(i*310)-a/rs, 203, 80, 5))
    #    pygame.draw.rect(screen, LANE, (100+(i*310)-a/rs, 286, 80, 5))
    #    pygame.draw.rect(screen, LANE, (100+(i*310)-a/rs, 369, 80, 5))
    #--------lane lines
    #car1
    car1 = pygame.Rect(775-h*cs, b, 80, 50)
    makeCar(h, b, cs, color1)
    #car2
    car2 = pygame.Rect(775-z*cs, c, 80, 50)
    makeCar(z, c, cs, color2)
    #car3
    car3 = pygame.Rect(775-w*cs, d, 80, 50)
    makeCar(w, d, cs, color3)
    #car4
    car4 = pygame.Rect(775-v*cs, e, 80, 50)
    makeCar(v, e, cs, color4)
    pygame.draw.rect(screen, BLACK, (0, 50, 750, 4))#road perimeter
    pygame.draw.rect(screen, BLACK, (0, 448, 750, 4))#road perimeter
    #user car
    user_car = pygame.Rect(k, m, 80, 50)
    pygame.draw.rect(screen, BLACK, (k+10, m-2, 13, 1))#---wheels
    pygame.draw.rect(screen, BLACK, (k+60, m-2, 13, 1))#--
    pygame.draw.rect(screen, BLACK, (k+10, m+49, 13, 2))#--
    pygame.draw.rect(screen, BLACK, (k+60, m+49, 13, 2))#--- wheels
    pygame.draw.rect(screen, RED, (k, m, 80, 50), border_radius=10)#
    pygame.draw.rect(screen, BLACK, (k+47, m+7, 27, 1))#front accent top
    pygame.draw.rect(screen, BLACK, (k+47, m+42, 27, 1))#front accent bottom
    pygame.draw.rect(screen, WHITE, (k, m+18, 80, 6))#racing stripes
    pygame.draw.rect(screen, WHITE, (k, m+28, 80, 6))#racing stripes
    pygame.draw.rect(screen, RED, (k+4, m+8, 6, 36))#---tail fin
    pygame.draw.rect(screen, BLACK, (k+4, m+6, 12, 2))#--
    pygame.draw.rect(screen, BLACK, (k+4, m+42, 12, 2))#//--
    pygame.draw.rect(screen, BLACK, (k+3, m+7, 1, 36))#--
    pygame.draw.rect(screen, BLACK, (k+10, m+7, 1, 36))#---tail fin
    pygame.draw.rect(screen, light_grey, (k+35, m+8, 12, 34), border_radius=3)# window front
    pygame.draw.rect(screen, light_grey, (k+20, m+8, 7, 34))#window back
    pygame.draw.rect(screen, light_grey, (k+66, m+1, 13, 6), border_radius=8)#head light top
    pygame.draw.rect(screen, light_grey, (k+66, m+43, 13, 6), border_radius=8)#head light bottom
    pygame.draw.rect(screen, BLACK, (k+27, m+8, 10, 1))#roof accent top
    pygame.draw.rect(screen, BLACK, (k+27, m+42, 10, 1))#roof accent bottom
    pygame.draw.rect(screen, BLACK, (k+66, m+1, 13, 6), 2, border_radius=8)
    pygame.draw.rect(screen, BLACK, (k+66, m+43, 13, 6), 2, border_radius=8)
    pygame.draw.rect(screen, BLACK, (k-1, m-1, 81, 51), 2, border_radius=10)
    pygame.draw.rect(screen, BLACK, (k+35, m+8, 12, 34), 2, border_radius=3)
    pygame.draw.rect(screen, BLACK, (k+20, m+8, 7, 34), 2)

    font = pygame.font.SysFont('impact', 15)
    if titleScreen:
        startText = font.render('Press Enter to Begin', True, RED)
        startTextRect = startText.get_rect(center = (350, 100))
        screen.blit(startText, startTextRect)
        pygame.draw.rect(screen, BLACK, (250+73*difficulty, 204, 54, 20))
        pygame.draw.rect(screen, WHITE, (256+73*difficulty, 213, 8, 1))
        pygame.draw.rect(screen, WHITE, (270+73*difficulty, 213, 8, 1))
        pygame.draw.rect(screen, WHITE, (284+73*difficulty, 213, 8, 1))
        pygame.draw.rect(screen, WHITE, (298+73*difficulty, 213, 6, 1))
        easy = font.render('EASY', True, RED)
        easyRect = easy.get_rect(center = (275, 200))
        screen.blit(easy, easyRect)
        inter = font.render('MEDIUM', True, RED)
        interRect = inter.get_rect(center = (350, 200))
        screen.blit(inter, interRect)
        hard = font.render('HARD', True, RED)
        hardRect = hard.get_rect(center = (425, 200))
        screen.blit(hard, hardRect)
        pygame.draw.rect(screen, BLACK, (260+100*drive_mode, 269, 80, 25), width = 2)
        pygame.draw.rect(screen, BLACK, (455, 184, 45, 116))
        pygame.draw.rect(screen, light_grey, (455, 184, 45, 116), width=2)
        pygame.draw.circle(screen, YELLOW, (477, 282-int(top_menu)*80), 10)
        pygame.draw.circle(screen, GREEN, (477, 242), 10)
        auto = font.render('Automatic', True, RED)
        autoRect = auto.get_rect(center = (300, 280))
        screen.blit(auto, autoRect)
        manual = font.render('Manual', True, RED)
        manualRect = manual.get_rect(center = (400, 280))
        screen.blit(manual, manualRect)
    elif not user_car.colliderect(car1) and not user_car.colliderect(car2) and not user_car.colliderect(car3) and not user_car.colliderect(car4):
        a+=1
        h+=1
        z+=1
        w+=1
        v+=1
        s+=1
        if up and m>52:
            m-=0.5
        if down and m<400:
            m+=0.5
    else:
        if rdstp < 500:
            a+=0.15
        if rdstp < 900:
            a+=0.15
        rdstp+=1
        pygame.draw.rect(screen, BLACK, (k+38, m+11, 8, 10), border_radius=2)#window break
        pygame.draw.rect(screen, BLACK, (k+72, m, 5, 50), border_radius=3)#crush bumper
        pygame.draw.circle(screen, ORANGE, (k+60, m+40), n/12)
        if n>500:
            pygame.draw.circle(screen, RED, (k+60, m+40), (n-300)/12)
        if n<1100 and n>0:
            if crash<1:
                k = k + 5
                crash=crash+1
            n+=1
            l+=2
            if n>700:
                l-=1
            pygame.draw.rect(screen, BLACK, (k+32+l/bs, m+10, 24, 3))#main body
            pygame.draw.rect(screen, BLACK, (k+51+l/bs, m+8, 8, 8), border_radius=6)#body head
            pygame.draw.rect(screen, BLACK, (k+20+l/bs, m+8, 14, 2))#body leg
            pygame.draw.rect(screen, BLACK, (k+20+l/bs, m+13, 14, 2))#body leg
            pygame.draw.rect(screen, BLACK, (k+45+l/bs, m+7, 2, 4))#body arm
            pygame.draw.rect(screen, BLACK, (k+45+l/bs, m+13, 2, 4))#body arm
            pygame.draw.rect(screen, BLACK, (k+45+l/bs, m+5, 7, 2))#body arm
            pygame.draw.rect(screen, BLACK, (k+45+l/bs, m+17, 7, 2))#body arm

            for i in range(0, 8):
                pygame.draw.rect(screen, BLACK, (k+random.randint(0, 61)+50, m-20+random.randint(0, 91), 3, 3))#---debris
                pygame.draw.rect(screen, BLACK, (k+random.randint(0, 81)+50, m+random.randint(0, 51), 3, 3))#---debris
        else:
            n=0
            pygame.draw.rect(screen, RED, (k+15+l/bs, m+2, 50, 20), border_radius=40)#blood
            pygame.draw.rect(screen, BLACK, (k+32+l/bs, m+10, 24, 3))#end main body
            pygame.draw.rect(screen, BLACK, (k+51+l/bs, m+8, 8, 8), border_radius=6)#end body head
            pygame.draw.rect(screen, BLACK, (k+20+l/bs, m+8, 14, 2))#end body leg
            pygame.draw.rect(screen, BLACK, (k+20+l/bs, m+13, 14, 2))#end body leg
            pygame.draw.rect(screen, BLACK, (k+45+l/bs, m+7, 2, 4))#end body arm
            pygame.draw.rect(screen, BLACK, (k+45+l/bs, m+13, 2, 4))#end body arm
            pygame.draw.rect(screen, BLACK, (k+45+l/bs, m+5, 7, 2))#end body arm
            pygame.draw.rect(screen, BLACK, (k+45+l/bs, m+17, 7, 2))#end body arm
            pygame.draw.rect(screen, BLACK, (k+38, m+11, 8, 10), border_radius=2)#end window break
            for i in end_debris:
                pygame.draw.rect(screen, BLACK, (k+i[0], m-20+i[1], 3, 3))#---debris
            restart_text = font.render('Press Enter to Play Again', True, WHITE)
            restartTextRect = end_text.get_rect(center = (350, 380))
            screen.blit(restart_text, restartTextRect)
        font = pygame.font.SysFont('impact', 30)
        end_text = font.render('GAME OVER', True, WHITE)
        endTextRect = end_text.get_rect(center = (350, 230))
        screen.blit(end_text, endTextRect)

    if(a>1240):
        a=0
    if(h>t):
        h=0
        color1 = [random.randint(0, 255), random.randint(0, 255), random.randint(0, 255)]
        b=random.randint(0,340)+55
    if(z>t):
        z=0;
        color2 = [random.randint(0, 255), random.randint(0, 255), random.randint(0, 255)]
        c=random.randint(0,340)+55
    if(w>t):
        w=0
        color3 = [random.randint(0, 255), random.randint(0, 255), random.randint(0, 255)]
        d=random.randint(0, 340)+55
    if(v>t):
        v=0
        color4 = [random.randint(0, 255), random.randint(0, 255), random.randint(0, 255)]
        e=random.randint(0, 340)+55

    if crash < 1:
        text = font.render('Your Score is: '+ str(score), True, RED)
        textRect = text.get_rect(center = (75, 10))
    screen.blit(text, textRect)
    if not titleScreen and crash==0:
        score+=1

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            quitVar = False
        if event.type == pygame.KEYDOWN:
            if not titleScreen:
                keys = pygame.key.get_pressed()
                if event.key == pygame.K_w or event.key == pygame.K_UP:
                    if m>52 and n==1:
                        if drive_mode==1:
                            if down:
                                down = False
                            else:
                                up = True
                        else:
                            down = False
                            up=True
                    #    m=m-25
                elif event.key == pygame.K_s or event.key == pygame.K_DOWN:
                    if m<400 and n==1:
                        if drive_mode==1:
                            if up:
                                up = False
                            else:
                                down = True
                        else:
                            up = False
                            down = True
                        #m=m+25
            #    elif event.key == pygame.K_d or event.key == pygame.K_RIGHT:
                    #up = False
                    #down = False
                #    if k<610 and n==1:
                #        k=k+25
                #elif event.key == pygame.K_a or event.key == pygame.K_LEFT:
                    #up = False
                    #down = False
                #    if k > 30 and n==1:
                #        k=k-25
                elif crash==1:
                    if event.key == pygame.K_RETURN:
                        start_flag=True
            else:
                if event.key == pygame.K_a or event.key == pygame.K_LEFT:
                    if top_menu:
                        if difficulty > 0:
                            difficulty-=1
                    else:
                        drive_mode = 0
                elif event.key == pygame.K_d or event.key == pygame.K_RIGHT:
                    if top_menu:
                        if difficulty < 2:
                            difficulty+=1
                    else:
                        drive_mode = 1
                elif event.key == pygame.K_s or event.key == pygame.K_DOWN:
                    top_menu = False
                elif event.key == pygame.K_w or event.key == pygame.K_UP:
                    top_menu = True
                cs = 0.75 + 0.25*difficulty

                if event.key == pygame.K_RETURN:
                    titleScreen = False

    pygame.display.update()
pygame.quit()
