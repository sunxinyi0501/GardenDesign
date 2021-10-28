package pkgMain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Garden implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3814291098181587537L;
	
	View view;
	public int length; //长
	public int width; //宽
	//TODO add to UML
	public String name;
	
	public List<Plant> plants = new ArrayList<Plant>();
	
	/**
	 * init a garden object
	 * 
	 * @param length which is the width of a garden
	 * @param width which is a height of a garden
	 * @param name which is the name of the garden
	 */
	public Garden (int length, int width, String name) {
		this.length = length;
		this.width = width;
		this.name = name;
		//this.location = location;
	}
	
	
//	public Garden createGarden(double length,double width,String name,String location) {
//		Garden garden = new Garden();
//		garden.length = length;
//		garden.width = width;
//		garden.name = name;
//		garden.location = location;
//		return garden;
//	}
	
	/**
	 * Update the garden with new width, height and name.
	 * 
	 * @param length
	 * @param width
	 * @param name
	 */
	public void updateGarden(int length,int width,String name) {
		this.length = length;
		this.width = width;
		this.name = name;
		//this.location = location;
	}

	@Override
	public String toString() {
		return "Garden [name=" +  name + ", length=" + length + ", width=" + width + "]";
	}
	
	//getter setter
	public double getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
