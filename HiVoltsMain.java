import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class HiVoltsMain extends Canvas implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		Canvas canvas = new HiVoltsMain();
		canvas.setSize(1000,1000);
		frame.getContentPane().add(canvas);
		frame.pack();
		frame.setVisible(true);
		
		File save = new File("game-field.txt");
		String path = save.getAbsolutePath();
	//	File gameField = new File("C:\\Users\\Ivo\\workspace\\Hivolts\\game-field.txt");
		File gameField = new File(path);
		Iterator<String> fieldLinesIt = Files.lines(gameField.toPath()).iterator();
		while (fieldLinesIt.hasNext()) {
			String fieldLine = fieldLinesIt.next();
			// initialize game matrix
			System.out.println(fieldLine);
		}
//		[][] Matrix; 
	}
	

	public HiVoltsMain() {
		init();	
	}
	
	
	public void init() {
		setBackground(Color.white);
		repaint();
	}
	
	public BufferedImage imageMaker(String fileName){
		//Name of the file in workspace
		File image = new File(fileName);
		String path = image.getAbsolutePath();
		BufferedImage img = null;
		 try {
             img = ImageIO.read(new File(path));
         } catch (IOException e) {
        	 System.out.println("Oops! There was an error: " + e);
         }
		 return img; 
	}
	
	public void Grid(Graphics g){
		//Paint a grid
		
			int lineX = getWidth()/12;
			int lineY = getHeight()/12;
			
			int xmod = lineX;
			for(int i = 1; i <= 12; i++){
				g.drawLine(xmod, 0, xmod, getHeight());
				xmod += lineX; 
			}
			
			int ymod = lineY;
			for(int i = 1; i <= 12; i++){
				g.drawLine(0, ymod, getWidth(), ymod);
				ymod += lineY; 
			}
			
	}
	
	int keyBla;
	/** Paint Method
	 * @param g - object of the graphics package
	 */
	public void paint(Graphics g) {
		//Draw an image
		g.drawImage(imageMaker("sad.png"), 500, 500, null);
		g.clearRect(500, 500, 500, 500);
		
		//Paint a grid
		Grid(g);
		
		this.addKeyListener(this);
		//System.out.println(keyBla);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		keyBla=arg0.getKeyCode();
//		System.out.println("keyPressed:" + arg0.getKeyCode());
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keyBla=0;
//		System.out.println("keyReleased:" + e.toString());
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("keyTyped:" + e.toString());
	}
	
}
