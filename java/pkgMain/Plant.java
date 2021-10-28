package pkgMain;

import javafx.scene.image.ImageView;

import java.util.Date;

public class Plant {

	public int x;
	public int y;
	
	public String name;


	private  String light;

	private  String water;

	private  String bloomTime;
	private  String hight;

	private  String bloomColor;



	private  String  soilMoisture;

	private  String caCO3Tolerance;

	private  String droughtTolerance;

	private  String templateImg;

	private int gardenWidth;
	private int gardenHeight;

	public String getTemplateImg() {
		return templateImg;
	}

	public void setTemplateImg(String templateImg) {
		this.templateImg = templateImg;
	}

	public String getLight() {
		return light;
	}

	public void setLight(String light) {
		this.light = light;
	}

	public String getWater() {
		return water;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public String getBloomTime() {
		return bloomTime;
	}

	public void setBloomTime(String bloomTime) {
		this.bloomTime = bloomTime;
	}

	public String getHight() {
		return hight;
	}

	public void setHight(String hight) {
		this.hight = hight;
	}

	public String getBloomColor() {
		return bloomColor;
	}

	public void setBloomColor(String bloomColor) {
		this.bloomColor = bloomColor;
	}

	public String getSoilMoisture() {
		return soilMoisture;
	}

	public void setSoilMoisture(String soilMoisture) {
		this.soilMoisture = soilMoisture;
	}

	public String getCaCO3Tolerance() {
		return caCO3Tolerance;
	}

	public void setCaCO3Tolerance(String caCO3Tolerance) {
		this.caCO3Tolerance = caCO3Tolerance;
	}

	public String getDroughtTolerance() {
		return droughtTolerance;
	}

	public void setDroughtTolerance(String droughtTolerance) {
		this.droughtTolerance = droughtTolerance;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}

	private String width;

	private ImageView imageView;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

//	@Override
//	public String toString() {
//		return "Plant{" +
//				"x=" + x +
//				", y=" + y +
//				", name='" + name + '\'' +
//				", light='" + light + '\'' +
//				", water='" + water + '\'' +
//				", bloomTime='" + bloomTime + '\'' +
//				", hight='" + hight + '\'' +
//				", bloomColor='" + bloomColor + '\'' +
//				", soilMoisture='" + soilMoisture + '\'' +
//				", caCO3Tolerance='" + caCO3Tolerance + '\'' +
//				", droughtTolerance='" + droughtTolerance + '\'' +
//				", width='" + width + '\'' +
//				", imageView=" + imageView +
//				'}';
//	}


	@Override
	public String toString() {
		return "Plant{" +
				"x=" + x +
				", y=" + y +
				", name='" + name + '\'' +
				", light='" + light + '\'' +
				", water='" + water + '\'' +
				", bloomTime='" + bloomTime + '\'' +
				", hight='" + hight + '\'' +
				", bloomColor='" + bloomColor + '\'' +
				", soilMoisture='" + soilMoisture + '\'' +
				", caCO3Tolerance='" + caCO3Tolerance + '\'' +
				", droughtTolerance='" + droughtTolerance + '\'' +
				", templateImg='" + templateImg + '\'' +
				", width='" + width + '\'' +
				", imageView=" + imageView +
				'}';
	}

	public int getGardenWidth() {
		return gardenWidth;
	}

	public void setGardenWidth(int gardenWidth) {
		this.gardenWidth = gardenWidth;
	}

	public int getGardenHeight() {
		return gardenHeight;
	}

	public void setGardenHeight(int gardenHeight) {
		this.gardenHeight = gardenHeight;
	}
}
