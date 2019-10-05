package com.game.src.main;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.swing.*;

public class Game extends Canvas implements Runnable {


    static final int WIDTH = 320;
    static final int HEIGHT = WIDTH/12*9;
    static final int SCALE = 2;
    static int SCORE = 0;
    int time = 15;

    private final String TITLE = "CLICK ME";

    private Thread thread;

    private boolean running = false;

    private Menu menu;
    private HighScoreMenu h_menu;
    private Enemy enemy;
    private Random r = new Random();
    private Timer timer;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private BufferedImage background;

    public static enum STATE {
        MENU,
        GAME,
        GAMEOVER,
    };

    static STATE State = STATE.MENU;

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            time--;
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {



    /*
        AudioPlayer AP = AudioPlayer.player;
        AudioStream AS;
        AudioData AD;
        ContinuousAudioDataStream loop = null;

        try{
            AS = new AudioStream(new FileInputStream(new File(String.valueOf(Game.class.getResourceAsStream("/thefog.wav")))));
            AD = AS.getData();
            loop = new ContinuousAudioDataStream(AD);
        }catch(IOException error){
            System.out.println(error);
        }
        AP.start(loop);*/

      /*  AudioSystem output = new AudioSystem.getAudioInputStream(new FileInputStream(String.valueOf(Game.class.getResourceAsStream("/thefog.wav"))));
        AudioInputStream soundIn = AudioSystem.getAudioInputStream(new BufferedInputStream(output) );
        AudioFormat format = soundIn.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);

        Clip clip = (Clip) AudioSystem.getLine(info);
        clip.open(soundIn);
        clip.start();
*/
        /*Clip crit = AudioSystem.getClip();
        AudioStream inputStream1 = new AudioStream(Game.class.getResourceAsStream("/thefog.wav"));

        Clip audioClipfog = (Clip) new AudioStream(inputStream1);
        audioClipfog.open(audioStreamfog);
        audioClipfog.loop(audioClipfog.LOOP_CONTINUOUSLY);
        crit.open();
        crit.loop(Clip.LOOP_CONTINUOUSLY);
        crit.start();
        System.out.println("defaultSound " + inputStream1);  // check the URL!*/



    /*    AudioStream next = new AudioStream(Game.class.getResourceAsStream("/thefog.wav"));
        AudioData data = new AudioData(next);
        ContinuousAudioDataStream audiostream = new ContinuousAudioDataStream(data);
        AudioPlayer.player.start(audiostream);
*/


        /*Clip clip = AudioSystem.getClip();
        AudioStream inputStream = new AudioStream(new URL(Game.class.getResourceAsStream("/thefog.wav"));
        System.out.println("defaultSound " + inputStream);  // check the URL!
        clip.open(inputStream);
        clip.start();

*/


       /* AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM = null;
       AudioData MD = null;
       ContinuousAudioDataStream loop = null;
        try {
            BGM = new AudioStream(Game.class.getResourceAsStream("/thefog.wav"));
            MD = BGM.getData();
            loop = new ContinuousAudioDataStream(MD);
        }

 catch (IOException ex) {
            }
            AudioPlayer.player.start(loop);

*/









/*

        Clip clip = null;
        try {
            InputStream in = new BufferedInputStream(Game.class.getResourceAsStream("/thefog.wav"));
            clip = AudioSystem.getClip();
            System.out.println(in);
            clip.open(AudioSystem.getAudioInputStream(in));
            if (Game.loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }


        } catch (Exception e) {
            System.err.println(e);
        }

        clip.start();
*/





        Thread sound;
        sound = new Thread(() -> {


            AudioStream BGM = null;
            AudioData MD;

            for(;;){

                try{
                    BGM = new AudioStream(Game.class.getResourceAsStream("/thefog.wav"));//enter the sound directory and name here
                    MD=BGM.getData();//not necessary
                    ContinuousAudioDataStream loop = new ContinuousAudioDataStream(MD);//not necessarry

                }catch(Exception e){
                    System.out.println(BGM);
                    AudioPlayer.player.start(BGM);
                    try {
                        Thread.sleep(120000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }


                // It does nothing.I was trying to use this but no success.
            }
        });
        sound.start();




        /*AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;
        ContinuousAudioDataStream loop = null;


            BGM = new AudioStream (new FileInputStream("res/thefog.wav"));
            MD = BGM.getData();
            loop = new ContinuousAudioDataStream(MD);

            MGP.start(loop);
*/




     /*   File soundFile = new File("res/thefog.wav");

        AudioInputStream audioStreamfog = AudioSystem.getAudioInputStream(soundFile);
        AudioFormat formatfog = audioStreamfog.getFormat();
        DataLine.Info infofog = new DataLine.Info(Clip.class, formatfog);
        Clip audioClipfog = (Clip) AudioSystem.getLine(infofog);
        audioClipfog.open(audioStreamfog);
        audioClipfog.loop(audioClipfog.LOOP_CONTINUOUSLY);
*/


        /*AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile);
        // load the sound into memory (a Clip)
        DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
        Clip clip = (Clip) AudioSystem.getLine(info);
        clip.open(sound);
        System.out.println("defaultSound " + soundFile);  // check the URL!*/

        //java.io.File file = new java.io.File("/thefog.wav");
      /*  AudioStream file = new AudioStream(Game.class.getResourceAsStream("/thefog.wav"));
        AudioClip sound = Applet.newAudioClip(file);
        sound.play();
        sound.loop();
        System.out.println(file);
*/
        /*AudioStream output = new AudioStream(Game.class.getResourceAsStream("/thefog.wav"));*/
        /* AudioPlayer.player.start(output);*/
        AudioStream next = new AudioStream(Game.class.getResourceAsStream("/thefog.wav"));


        AudioStream output1 = new AudioStream(Game.class.getResourceAsStream("/beat.wav"));
        AudioPlayer.player.start(output1);



        /*Clip clip = AudioSystem.getClip();
        AudioStream output1 = new AudioStream(Game.class.getResourceAsStream("/beat.wav"));
        clip.open(output1);
        clip.start();*/








       /* AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;
        AudioClip output = new AudioClip(Game.class.getResourceAsStream("/thefog.wav")) {
            @Override
            public void play() {
                try {
                    BGM = new AudioStream(new AudioStream(output));
                    MD = BGM.getData();
                    output = new AudioStream(MD);
                } catch(IOException error)  {
                    System.out.println("Error!!!");
                }
                MGP.start(output
            }

            @Override
            public void loop() {

            }

            @Override
            public void stop() {

            }
        };
        );*/





      /*  URL urlfog = Game.class.getClassLoader().getResource("./thefog.wav");
        AudioInputStream audioStreamfog = AudioSystem.getAudioInputStream(urlfog);
        AudioFormat formatfog = audioStreamfog.getFormat();
        DataLine.Info infofog = new DataLine.Info(Clip.class, formatfog);
        Clip audioClipfog = (Clip) AudioSystem.getLine(infofog);
        audioClipfog.open(audioStreamfog);
        audioClipfog.loop(audioClipfog.LOOP_CONTINUOUSLY);

        System.out.println("defaultSound " + urlfog);  // check the URL!*/

	/*	URL url = Game.class.getClassLoader().getResource("creepy.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
		AudioFormat format = audioStream.getFormat();
		DataLine.Info info = new DataLine.Info(Clip.class, format);
		Clip audioClip = (Clip) AudioSystem.getLine(info);
		audioClip.open(audioStream);
		audioClip.start();

		Thread.sleep(3333);

		URL url1 = Game.class.getClassLoader().getResource("beat.wav");

		AudioInputStream audioStream1 = AudioSystem.getAudioInputStream(url1);
		AudioFormat format1 = audioStream1.getFormat();
		DataLine.Info info1 = new DataLine.Info(Clip.class, format1);
		Clip audioClip1 = (Clip) AudioSystem.getLine(info1);
		audioClip1.open(audioStream1);
		audioClip1.start();
*/




/*
		URL url = Game.class.getClassLoader().getResource("/thefog.wav");
		AudioInputStream audiofog = AudioSystem.getAudioInputStream(url);
		AudioFormat formatfog = audiofog.getFormat();
		DataLine.Info infofog = new DataLine.Info(Clip.class, formatfog);
		Clip audioClipfog = (Clip) AudioSystem.getLine(infofog);
		AudioInputStream sound = AudioSystem.getAudioInputStream(new BufferedInputStream(audiofog));
		Clip clip = AudioSystem.getClip();
		clip.open(audiofog);*/



        /*URL urlfog = Game.class.getClassLoader().getResource("/thefog.wav");
        Clip audioClipfog;
        try (AudioInputStream audioStreamfog = AudioSystem.getAudioInputStream(urlfog)) {
            AudioFormat formatfog = audioStreamfog.getFormat();
            DataLine.Info infofog = new DataLine.Info(Clip.class, formatfog);
            audioClipfog = (Clip) AudioSystem.getLine(infofog);
            audioClipfog.open(audioStreamfog);
        }
        audioClipfog.loop(audioClipfog.LOOP_CONTINUOUSLY);
        System.out.println("defaultSound " + urlfog);  // check the URL!
*/


/*
		Clip clip = AudioSystem.getClip();
		AudioInputStream inputStream = AudioSystem.getAudioInputStream(Game.class.getResourceAsStream("thefog.wav" ));

		Clip audioClipfog = (Clip) AudioSystem.getAudioInputStream(inputStream);
		clip.open((AudioInputStream) audioClipfog);
		clip.start();*/

       /* InputStream inputStream = Game.class.getClassLoader().getResourceAsStream("thefog.wav");


        URL defaultSound = Game.class.getClassLoader().getResource("./res/thefog.wav");

		System.out.println("defaultSound " + inputStream);  // check the URL!
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(defaultSound);
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start( );*/


        /*ImageIcon icon1 = new ImageIcon (("/fogicon.jpg"));*/


        BufferedImageLoader loader = new BufferedImageLoader();
        BufferedImage icon1 = loader.loadImage("/fogicon.jpg");

        ImageIcon fogicon = new ImageIcon(icon1);



		/*try {
			BufferedImageLoader loader = new BufferedImageLoader();
			icon1 = loader.loadImage("/fogicon.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}*/


        /*ImageIcon icon1 = new ImageIcon((Game.class.getResource("fogicon.jpg"));*/

        String name;


        do {
            name = (String) JOptionPane.showInputDialog(null, "Hello what is your name?", "The Fog", JOptionPane.INFORMATION_MESSAGE, fogicon, null, "");
            if ((name == null)) {

                System.exit(0);
            }
        }
        while (name.equalsIgnoreCase(""));


        Game game = new Game();

        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        game.isDoubleBuffered();


        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.setAlwaysOnTop(true);
        frame.isAlwaysOnTopSupported();
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.isDoubleBuffered();
        game.start();



        do {
            Thread.sleep(333);

        }
        while (!(Game.State == null));


            game.stop();
            frame.dispose();
            frame.dispose();
            frame.dispose();
            frame.dispose();
            frame.dispose();
            frame.dispose();






            String name1;


            do {
                name1 = (String) JOptionPane.showInputDialog(null, "Hello what is your name?", "The Fog", JOptionPane.INFORMATION_MESSAGE, fogicon, null, "");
                if ((name1 == null)) {

                    System.exit(0);
                }
            }
            while (name1.equalsIgnoreCase(""));




        Game.State = STATE.MENU;

        Game game2 = new Game();
        game2.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game2.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game2.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));


        JFrame frame2 = new JFrame(game2.TITLE);
        frame2.add(game2);
        frame2.pack();
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setResizable(false);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);

        game2.start();


        do {
            Thread.sleep(333);
        }
        while (!(Game.State == null));



            frame2.dispose();
            frame2.dispose();
            frame2.dispose();
            game2.stop();
            frame2.dispose();
            frame2.dispose();
            frame2.dispose();
            frame2.dispose();
            frame2.dispose();
            frame2.dispose();




        Thread.sleep(333);


            String name11;


            do {
                name11 = (String) JOptionPane.showInputDialog(null, "Hello what is your name?", "The Fog", JOptionPane.INFORMATION_MESSAGE, fogicon, null, "");
                if ((name11 == null)) {

                    System.exit(0);
                }
            }
            while (name11.equalsIgnoreCase(""));






            Game.State = STATE.MENU;

            Game game3 = new Game();
            game3.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
            game3.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
            game3.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));


            JFrame frame3 = new JFrame(game3.TITLE);
            frame3.add(game3);
            frame3.pack();
            frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame3.setResizable(false);
            frame3.setLocationRelativeTo(null);
            frame3.setVisible(true);

            game3.start();


            do {
                Thread.sleep(333);
            }
            while (!(Game.State == null));



                game3.stop();
                frame3.dispose();
                frame3.dispose();
                frame3.dispose();
                frame3.dispose();
                frame3.dispose();
                frame3.dispose();





            String name2;
            do {
                name2 = (String) JOptionPane.showInputDialog(null, "Hello what is your name?", "The Fog", JOptionPane.INFORMATION_MESSAGE, fogicon, null, "");
                if ((name2 == null)) {

                    System.exit(0);
                }
            }
            while (name2.equalsIgnoreCase(""));







    }

    private static void State(STATE menu) {
    }

    private void init() {
        requestFocus();
        try {
            BufferedImageLoader loader = new BufferedImageLoader();
            background = loader.loadImage("/forest.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }

        enemy = new Enemy((double)r.nextInt(WIDTH*SCALE-50), (double)r.nextInt(HEIGHT*SCALE-50), this);
        menu = new Menu();
        h_menu = new HighScoreMenu(this);
        timer = new Timer(1000, new TimerListener());

        this.addMouseListener(new MouseInput(this, enemy));
    }

    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while (running ) {
            // this would be the game loop
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                tick();
                final int i = updates++;
                delta--;
            }

            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
//				System.out.println(updates + " Ticks, FPS " + frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    private synchronized void start() {
        if (running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();

    }

    private void stop() {
        if (!running)
            return;

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void tick() {
        enemy.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(2000);
            createBufferStrategy(2);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        Font fnt_score = new Font("arial", Font.BOLD, 20);
        //////////////////

        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(background, 0, 0, null);

        if (State == STATE.GAME) {
            timer.start();
            enemy.render(g);
            // for score rendering
            g.setFont(fnt_score);
            g.setColor(Color.BLACK);
            g.drawString("Score: " + (SCORE), 5, 20);
            // for timer rendering
            g.drawString("Time Left: " + (time), WIDTH*SCALE-170, 20);

            if (time == 0) {
                timer.stop();
                State = STATE.GAMEOVER;
            }
        } else if (State == STATE.MENU) {
            menu.render(g);
        } else if (State == STATE.GAMEOVER) {
            h_menu.render(g);
        }

        //////////////////

        g.dispose();
        bs.show();


    }

}