	package br.pro.hashi.ensino.desagil.tequilada;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

// Estrutura básica de um componente Swing.
public class View extends JPanel {
	// Estrutura básica de um componente Swing.
	private static final long serialVersionUID = 1L;


	// Constante que define o tamanho de cada célula do tabuleiro.
	private static final int CELL_SIZE = 50;


	private Model model;
	private Image cpuPlayerImage;
	private Image humanPlayerImage;


	public View(Model model) {
		this.model = model;

		cpuPlayerImage = loadImage("cpuPlayer");
		humanPlayerImage = loadImage("humanPlayer");

		// Define o tamanho da componente, em pixels.
		setPreferredSize(new Dimension(model.getBoard().getNumCols() * CELL_SIZE, model.getBoard().getNumRows() * CELL_SIZE));
	}


	// Método para carregar uma imagem a partir de um nome de arquivo.
	// Não é necessário entender todos os detalhes nesse momento.
	private Image loadImage(String filename) {
		URL url = getClass().getResource("/" + filename + ".png");
		ImageIcon icon = new ImageIcon(url);
		return icon.getImage();
	}


	// Método para desenhar uma imagem a partir da posição de um jogador.
	// Não é necessário entender todos os detalhes nesse momento.
	private void drawImage(Graphics g, Image image, Player player) {
		g.drawImage(image, player.getCol() * CELL_SIZE, player.getRow() * CELL_SIZE, CELL_SIZE, CELL_SIZE, null);
	}


	// Método para desenhar a interface gráfica do jogo. A ideia é
	// que o parâmetro g pode ser usado como o pincel de desenho.
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0,0,model.getBoard().getNumCols() * CELL_SIZE,model.getBoard().getNumRows() *CELL_SIZE);

		for(int i=0;i<model.getBoard().getNumRows();i++) {
			for(int j=0;j<model.getBoard().getNumCols();j++) {
				if(model.getBoard().isWall(i, j) == true) {
					g.setColor(Color.BLACK);
					g.fillRect(j*CELL_SIZE, i*CELL_SIZE, CELL_SIZE, CELL_SIZE);
				}
				
				// o coment�rio abaixo � de uma tentativa de 
				// c�digo que quero revisar depois.
				
				//else if(model.getBoard().isWall(i, j) == false) {
					//g.setColor(Color.WHITE);
					//g.fillRect(i*CELL_SIZE, j*CELL_SIZE, CELL_SIZE, CELL_SIZE);
				//}
			}
		}
		
		drawImage(g, cpuPlayerImage, model.getCpuPlayer());
		drawImage(g, humanPlayerImage, model.getHumanPlayer());
		// Evita bugs visuais em alguns sistemas operacionais.
		getToolkit().sync();
    }
}
