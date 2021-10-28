package pkgMain;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @version alpha version
 * @author Weitong Sun, Chen Dai, Zhenghan Wang, Xinyi Sun, Ruoxi Jin
 * This is model class. 
 * The model represents the data in the application
 * it is the bridge between the control and the view.
 */

public class Model implements Serializable{
	
	
	public View view;
	
	private List<Plant> plants = new ArrayList<>();
	private List<Garden> gardens = new ArrayList<Garden>();
	
	private Garden garden;
	
	private int size = 0;
	private int num = 0;
	
	public Model(int w, int h) {
		garden = new Garden(w, h, View.gardenName);
		
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public List<Plant> getPlants() {
		return plants;
	}

	public void setPlants(List<Plant> plants) {
		this.plants = plants;
	}

	public List<Garden> getGardens() {
		return gardens;
	}

	public void setGardens(List<Garden> gardens) {
		this.gardens = gardens;
	}

	public Garden getGarden() {
		return garden;
	}

	public void setGarden(Garden garden) {
		this.garden = garden;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
		
}
	
	
	


