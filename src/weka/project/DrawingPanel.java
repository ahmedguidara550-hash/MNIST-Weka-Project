package weka.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

import data.PixelVector;

public class DrawingPanel extends JPanel {
    
    private static final int GRID_SIZE = 28;
    private int[][] grid = new int[GRID_SIZE][GRID_SIZE]; 
    private int cellSize = 12; 

    public DrawingPanel() {
        
        setPreferredSize(new Dimension(GRID_SIZE * cellSize, GRID_SIZE * cellSize));
        setBackground(Color.WHITE);
        
        
        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                draw(e.getX(), e.getY());
            }
            @Override
            public void mousePressed(MouseEvent e) {
                draw(e.getX(), e.getY());
            }
        };
        addMouseListener(ma);
        addMouseMotionListener(ma);
    }

    
    private void draw(int x, int y) {
        int col = x / cellSize;
        int row = y / cellSize;
        
        
        if (row >= 0 && row < GRID_SIZE && col >= 0 && col < GRID_SIZE) {
            grid[row][col] = 255; 
            
            
            if(row > 0) grid[row-1][col] = Math.max(grid[row-1][col], 128);
            if(row < GRID_SIZE-1) grid[row+1][col] = Math.max(grid[row+1][col], 128);
            if(col > 0) grid[row][col-1] = Math.max(grid[row][col-1], 128);
            if(col < GRID_SIZE-1) grid[row][col+1] = Math.max(grid[row][col+1], 128);
            
            repaint(); 
        }
    }

    
    public void clear() {
        grid = new int[GRID_SIZE][GRID_SIZE];
        repaint();
    }

    
    public PixelVector getPixelVector() {
        int[] pixels = new int[784];
        int index = 0;
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                pixels[index++] = grid[row][col];
            }
        }
        return new PixelVector(pixels);
    }

   
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                int intensity = grid[row][col];
                g.setColor(new Color(255 - intensity, 255 - intensity, 255 - intensity));
                g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
                g.setColor(new Color(230, 230, 230)); 
                g.drawRect(col * cellSize, row * cellSize, cellSize, cellSize); 
            }
        }
    }
}