package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Matheus on 23/11/17.
 */

public class GameInit  extends ApplicationAdapter {

    SpriteBatch batch;
    Texture img;
    Sprite board;
    int count,i=0;
    OrthographicCamera camera;
    int[] boardEntry;
    int flag;


    boolean flagcross1=false,flagcross2=false,flagcross3=false,flagcross4=false,flagcross5=false;
    boolean flagcircle1=false,flagcircle2=false,flagcircle3=false,flagcircle4=false;

    Texture imgcross1,imgcross2,imgcross3,imgcross4,imgcross5;
    Texture imgcircle1,imgcircle2,imgcircle3,imgcircle4;
    Sprite cross1,cross2,cross3,cross4,cross5;
    Sprite circle1,circle2,circle3,circle4;

    Texture imgwon,imglost,imgover;
    Sprite gamewon,gamelost,gameover;

    Map<Integer, CenterPosition> centerPos = new HashMap<Integer, CenterPosition>();

    Map<Integer, Mark> marks = new HashMap<Integer, Mark>();

    @Override
    public void create () {

        batch = new SpriteBatch();
        img = new Texture("tictactoe.jpg");
        board=new Sprite(img);
        board.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        imgcross1=new Texture("cross.png");
        imgcross2=new Texture("cross.png");
        imgcross3=new Texture("cross.png");
        imgcross4=new Texture("cross.png");
        imgcross5=new Texture("cross.png");

        imgcircle1=new Texture("circle.png");
        imgcircle2=new Texture("circle.png");
        imgcircle3=new Texture("circle.png");
        imgcircle4=new Texture("circle.png");

        imgwon=new Texture("gamewon.jpg");
        imglost=new Texture("lostgame.jpg");
        imgover=new Texture("gameover.png");

        cross1=new Sprite(imgcross1);
        cross2=new Sprite(imgcross2);
        cross3=new Sprite(imgcross3);
        cross4=new Sprite(imgcross4);
        cross5=new Sprite(imgcross5);

        circle1=new Sprite(imgcircle1);
        circle2=new Sprite(imgcircle2);
        circle3=new Sprite(imgcircle3);
        circle4=new Sprite(imgcircle4);

        gamewon=new Sprite(imgwon);
        gamelost=new Sprite(imglost);
        gameover=new Sprite(imgover);


        camera=new OrthographicCamera();
        camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        boardEntry=new int[9];

        for(int i=0;i<9;i++){
            boardEntry[i]=-1;
        }
        count=0;
        flag=0;

        setCenterPos();
        initMarks();

    }

    @Override
    public void render () {
        Gdx.graphics.setContinuousRendering(false);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        board.draw(batch);
        batch.end();


        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
            int Ypos=Gdx.graphics.getHeight()-Gdx.input.getY();
            int Xpos=Gdx.input.getX();

            setPosition(Ypos, Xpos);
            CenterPosition center = centerPos.get(i);

            if (marks.get(i).getPlay() != -1){
                return;
            }

            if(count==0){
                flagcross1=true;
                setMark(i, "cross", count);
                cross1.setPosition(center.getX(), center.getY());
                count++;
            }
            else if(count==1){
                flagcircle1=true;
                setMark(i, "circle", count);
                circle1.setPosition(center.getX(), center.getY());
                count++;
            }
            else if(count==2){
                flagcross2=true;
                setMark(i, "cross", count);
                cross2.setPosition(center.getX(), center.getY());
                count++;
            }
            else if(count==3){
                flagcircle2=true;
                setMark(i, "circle", count);
                circle2.setPosition(center.getX(), center.getY());
                count++;
            }
            else if(count==4){
                flagcross3=true;
                setMark(i, "cross", count);
                cross3.setPosition(center.getX(), center.getY());
                count++;
            }
            else if(count==5){
                flagcircle3=true;
                setMark(i, "circle", count);
                circle3.setPosition(center.getX(), center.getY());
                count++;
            }
            else if(count==6){
                flagcross4=true;
                setMark(i, "cross", count);
                cross4.setPosition(center.getX(), center.getY());
                count++;
            }
            else if(count==7){
                flagcircle4=true;
                setMark(i, "circle", count);
                circle4.setPosition(center.getX(), center.getY());
                count++;
            }
            else if(count==8) {
                flagcross5 = true;
                setMark(i, "cross", count);
                cross5.setPosition(center.getX(), center.getY());
                count++;
            }

            //TODO fazer um else, para nao marcar quando sair das dimensões

//            System.out.println("x="+Xpos);
  //          System.out.println("y="+Ypos);

        }

        //drawing elements cross and circle
        batch.begin();

        if(flagcross1){
            cross1.draw(batch);
            camera.update();
        }
        if(flagcircle1){
            circle1.draw(batch);
            camera.update();
        }
        if(flagcross2){
            cross2.draw(batch);
            camera.update();
        }
        if(flagcircle2){
            circle2.draw(batch);
            camera.update();
        }
        if(flagcross3){
            cross3.draw(batch);
            camera.update();
        }
        if(flagcircle3){
            circle3.draw(batch);
            camera.update();
            boardEntry[i]=0;
        }
        if(flagcross4){
            cross4.draw(batch);
            camera.update();
        }
        if(flagcircle4){
            circle4.draw(batch);
            camera.update();
        }
        if(flagcross5){
            cross5.draw(batch);
            camera.update();
        }

        winstatus();
        batch.end();


    }

    private void setPosition(int ypos, int xpos) {
        if((xpos >0)&&(xpos <200)&&(ypos >0)&&(ypos <200)){
            System.out.println("Quadrante 7");
            i=6;
        }
        else if((xpos >0)&&(xpos <200)&&(ypos >200)&&(ypos <400)){
            System.out.println("Quadrante 4");
            i=3;
        }
        else if((xpos >0)&&(xpos <200)&&(ypos >400)&&(ypos <600)){
            System.out.println("Quadrante 1");
            i=0;
        }
        else if((xpos >200)&&(xpos <400)&&(ypos >0)&&(ypos <200)){
            System.out.println("Quadrante 8");
            i=7;
        }
        else if((xpos >200)&&(xpos <400)&&(ypos >200)&&(ypos <400)){
            System.out.println("Quadrante 5");
            i=4;
        }
        else if((xpos >200)&&(xpos <400)&&(ypos >400)&&(ypos <600)){
            System.out.println("Quadrante 2");
            i=1;
        }
        else if((xpos >400)&&(xpos <600)&&(ypos >0)&&(ypos <200)){
            System.out.println("Quadrante 9");
            i=8;
        }
        else if((xpos >400)&&(xpos <600)&&(ypos >200)&&(ypos <400)){
            System.out.println("Quadrante 6");
            i=5;
        }
        else if((xpos >400)&&(xpos <600)&&(ypos >400)&&(ypos <600)){
            System.out.println("Quadrante 3");
            i=2;
        }
    }


    private void winstatus(){

        boolean wincross=false;
        boolean wincircle=false;

        if((this.marks.get(0).getMark().equalsIgnoreCase(this.marks.get(1).getMark())) && (this.marks.get(0).getMark().equalsIgnoreCase(this.marks.get(2).getMark()))) {
            printWinner();
        }

        if((this.marks.get(0).getMark().equalsIgnoreCase(this.marks.get(3).getMark())) && (this.marks.get(0).getMark().equalsIgnoreCase(this.marks.get(6).getMark()))) {
            printWinner();
        }

        if((this.marks.get(1).getMark().equalsIgnoreCase(this.marks.get(4).getMark())) && (this.marks.get(1).getMark().equalsIgnoreCase(this.marks.get(7).getMark()))) {
            printWinner();
        }

        if((this.marks.get(2).getMark().equalsIgnoreCase(this.marks.get(5).getMark())) && (this.marks.get(2).getMark().equalsIgnoreCase(this.marks.get(8).getMark()))) {
            printWinner();
        }

        if((this.marks.get(3).getMark().equalsIgnoreCase(this.marks.get(4).getMark())) && (this.marks.get(3).getMark().equalsIgnoreCase(this.marks.get(5).getMark()))) {
            printWinner();
        }

        if((this.marks.get(6).getMark().equalsIgnoreCase(this.marks.get(7).getMark())) && (this.marks.get(6).getMark().equalsIgnoreCase(this.marks.get(8).getMark()))) {
            printWinner();
        }

    }

    private void printWinner() {
        boolean wincross;
        wincross=true;
        System.out.println("player1 wins");
        System.out.println("game over");
        gamewon.setSize(600, 200);
        gamewon.setPosition(0, 0);
        gameover.setSize(600, 400);
        gameover.setPosition(0, 200);
        gamewon.draw(batch);
        gameover.draw(batch);
    }

    @Override
    public void dispose(){
        img.dispose();
        imgcross1.dispose();
        imgcross2.dispose();
        imgcross3.dispose();
        imgcross4.dispose();
        imgcross5.dispose();
        imgcircle1.dispose();
        imgcircle2.dispose();
        imgcircle3.dispose();
        imgcircle4.dispose();
        imgwon.dispose();
        imglost.dispose();
        imgover.dispose();
        batch.dispose();
    }


    private void setCenterPos() {

        this.centerPos.put(0,populaObjeto(65,465));
        this.centerPos.put(1,populaObjeto(265,465));
        this.centerPos.put(2,populaObjeto(465,465));
        this.centerPos.put(3,populaObjeto(65,265));
        this.centerPos.put(4,populaObjeto(265,265));
        this.centerPos.put(5,populaObjeto(465,265));
        this.centerPos.put(6,populaObjeto(65,65));
        this.centerPos.put(7,populaObjeto(265,65));
        this.centerPos.put(8,populaObjeto(465,65));

    }

    private CenterPosition populaObjeto(Integer x, Integer y) {
        CenterPosition pos = new CenterPosition();
        pos.setX(x);
        pos.setY(y);

        return pos;
    }

    private void setMark (int quadrant, String type, int played) {
        this.marks.put(quadrant, populateMark(quadrant, type, played));
    }

    private Mark populateMark (int quadrant, String type, int played) {
        Mark mark = new Mark(quadrant, type, played, -1);
        return mark;
    }

    private void initMarks () {
        for (int x = 0 ; x < 9; x++) {
            this.marks.put(x, new Mark(i, String.valueOf(x), -1, -1));
        }
    }
}
