package pkgMain;

import javafx.scene.image.ImageView;

public class MyImageView extends ImageView {
    private double offsetX = 0;
    private double offsetY = 0;
    private double originMinX = 0;
    private double originMinY = 0;
    private int idObject = 0;
    private boolean isPlant = false;
    //line13-line14 xinyi 
    private int expandWidth = 0;
    private int expandHeight = 0;
    
    //ruoxi jin
    private Plant plant;
    
    public Plant getPlant() {
        return plant;
    }
    
    public MyImageView(int expandWidth, int expandHeight, Plant plant) {
        this.expandWidth = expandWidth;
        this.expandHeight = expandHeight;
        this.plant = plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }
    
    //line16-25
    public MyImageView() {

    }
    
    
    public MyImageView(int expandWidth, int expandHeight) {
        this.expandWidth = expandWidth;
        this.expandHeight = expandHeight;
    }

    public int getObject() {
		return idObject;
	}

	public void setIdObject(int id) {
		this.idObject = id;
	}

	public boolean isPlant() {
		return isPlant;
	}

	public void setPlant(boolean isPlant) {
		this.isPlant = isPlant;
	}
    public double getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(double offsetX) {
        this.offsetX = offsetX;
    }

    public double getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(double offsetY) {
        this.offsetY = offsetY;
    }

    public double getOriginMinX() {
        return originMinX;
    }

    public void setOriginMinX(double originMinX) {
        this.originMinX = originMinX;
    }

    public double getOriginMinY() {
        return originMinY;
    }

    public void setOriginMinY(double originMinY) {
        this.originMinY = originMinY;
    }
    
    //line75-line89
    public int getExpandHeight() {
        return expandHeight;
    }

    public void setExpandHeight(int expandHeight) {
        this.expandHeight = expandHeight;
    }

    public int getExpandWidth() {
        return expandWidth;
    }

    public void setExpandWidth(int expandWidth) {
        this.expandWidth = expandWidth;
    }
}
