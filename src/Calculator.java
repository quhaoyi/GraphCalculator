//Author: Haoyi Qu
//Date: 2016/12/17

import java.util.*;
import javax.swing.*;
import java.awt.*;

//this calculator will prompt user for exponent and draw the corresponding graph
public class Calculator extends JFrame {
	//this represents how many pixels each unit length is
	public static final int OFFSET = 40;
	//this is the length of the bar
	public static final int BARLENGTH = 10;
	public Calculator() {
		//name the frame
		super("Graphing Calculator");
		setSize(1600, 1600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
	}
	
	//prompt the user for input
	public static void main(String[] args) {
		System.out.println("Welcome to the Graphing Calculator!");
		Scanner console = new Scanner(System.in);
		System.out.println("Please select function: ");
		System.out.println("1.Polynomial Function 2.Exponential Function 3.Trigonometric Function 4.Logarithmic Function");
		int mode = console.nextInt();
		double[] coefficient = {0.0};
		
		if(mode == 1){
			coefficient = polyMode(console);
		}else if(mode == 2){
			coefficient = expoMode(console);
		}else if(mode == 3){
			//Not finished
			//coefficient = trigMode(console);
		}else{
			//Not finished
			//coefficient = logaMode(console);
		}
		Graph graph = new Graph(coefficient, OFFSET, BARLENGTH, mode);
		graph.setSize(1600, 1600);
		graph.setVisible(true);
		//Alternate way to draw the graph, old version
		//DrawingPanel p = new DrawingPanel(1600, 1600);
		//initialize(p);
		//drawGraph(p, coefficient);
	}
	
	public static double[] polyMode(Scanner console){
		System.out.println("Polynomial function form: f(x)");
		System.out.println("What is the highest exponent you need for f(x)?");
		int highest = console.nextInt();
		double[] coefficient = new double[highest + 1];
		return fill(console, coefficient, highest);
	}
	
	public static double[] expoMode(Scanner console){
		System.out.println("Exponential function form: k*a^f(x)");
		System.out.println("What is the highest exponent you need for f(x)?");
		int highest = console.nextInt();
		double[] coefficient = new double[highest + 3];
		coefficient = fill(console, coefficient, highest);
		System.out.println("Please enter the value for k");
		coefficient[highest + 1] = console.nextDouble();
		System.out.println("Please enter the value for a");
		coefficient[highest + 2] = console.nextDouble();
		return coefficient;
	} 
	/*
	 * Not finished
	public static double[] trigMode(Scanner console){
		System.out.println("Please choose the trigonometric function: 1.sin(x) 2.cos(x) 3.tan(x)");
		int mode = console.nextInt();
		if(mode == 1){
			
		}
	}*/
	
	private static double[] fill(Scanner console, double[] coefficient, int highest){
		for (int i = highest; i >=0; i--){
			if(i == 0){
				System.out.println("Enter the coefficient for constant");
			}else if(i == 1){
				System.out.println("Enter the coefficient for x");
			}else{
				System.out.println("Enter the coefficient for x^" + i);
			}
			coefficient[i] = console.nextDouble();
		}
		return coefficient;
	}
	/* public static void drawGraph(DrawingPanel p, int[] coefficient){
		Graphics g = p.getGraphics();
		int posx = 800;
		int posy = 800 - coefficient[0] * OFFSET;
		int negx = 800;
		int negy = 800 - coefficient[0] * OFFSET;
		for(double dx = 1; dx <= 20; dx++){
			int dy = 0;
			dy -= coefficient[1];
			g.drawLine(negx, negy, negx - OFFSET, negy - dy*OFFSET);
 			g.drawLine(posx, posy, posx + OFFSET, posy + dy * OFFSET );
			posx += OFFSET;
			posy += dy * OFFSET;
			negx -= OFFSET;
			negy -= dy * OFFSET;
		}
		
	}
	public static void initialize(DrawingPanel p){
		Graphics g = p.getGraphics();
		g.drawLine(0, 800, 1600, 800);
		g.drawLine(800, 0, 800, 1600);
		for(int i = 0; i <= 1600 / OFFSET; i++){
			g.drawLine(i*OFFSET, 800, i*OFFSET, 800 - BARLENGTH);
			g.drawLine(800, i*OFFSET, 800 + BARLENGTH, i*OFFSET);
			g.drawString("0", 800, 800);
			if(i % 2 ==0 && i != 0){
				g.drawString(i/2 + "", 800 + i*OFFSET/2, 800);
				g.drawString("-" + i/2 + "", 800 - i*OFFSET/2, 800);
				g.drawString("-" + i/2 + "", 800, 800 + i*OFFSET/2);
				g.drawString(i/2 + "", 800, 800 - i*OFFSET/2);
			}
		}
	} */

}
