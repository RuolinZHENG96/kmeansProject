package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import clustering.ExcelReader;

public class Window {
public JFrame frame;
private  String text ="";


public Window () {
	initialize();
}

private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 536);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JMenuBar menuBar = new JMenuBar();
	frame.setJMenuBar(menuBar);
	

	JMenuItem menuOpen = new JMenuItem("Import Data");
	menuOpen.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg) {
			String path = getFile();
			System.out.println(path);
			try {
				 operateFile(path);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		public String getFile() {
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("."));
			
			int retour = chooser.showOpenDialog(null);
			return chooser.getSelectedFile().getAbsolutePath();
		}
	});
	menuBar.add(menuOpen);
}

	private void operateFile(String path) throws InterruptedException {
		if (path.isEmpty()) {
			text += "Fichier pas bon";
			System.out.println(text);
		}else{
			ExcelReader data = new ExcelReader();
			data.getdata(path);
			System.out.println("done");
		}
	}
}
