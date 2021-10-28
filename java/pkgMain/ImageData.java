package pkgMain;

public class ImageData {
    private String path;
    private int num;
    private int translateX;
    private int translateY;
    private int expandWidth = 0;
    private int expandHeight = 0;
    private Plant plant;
    
    public ImageData(String path, int num) {
        this.path = path;
        this.num = num;
    }

    public ImageData(String path,int num, int expandWidth, int expandHeight) {
        this.path = path;
        this.num = num;
        this.expandWidth = expandWidth;
        this.expandHeight = expandHeight;
    }  
    //ruoxi jin
    public ImageData(String path,int num, int expandWidth, int expandHeight,Plant plant) {
        this.path = path;
        this.num = num;
        this.expandWidth = expandWidth;
        this.expandHeight = expandHeight;
        this.plant = plant;
    }
    
    
    public ImageData(String path, int translateX, int translateY) {
        this.path = path;
        this.translateX = translateX;
        this.translateY = translateY;
    }
    
    
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    public int getTranslateX() {
        return translateX;
    }

    public void setTranslateX(int translateX) {
        this.translateX = translateX;
    }

    public int getTranslateY() {
        return translateY;
    } 

    public void setTranslateY(int translateY) {
        this.translateY = translateY;
    }
    
    public int getExpandWidth() {
        return expandWidth;
    }

    public void setExpandWidth(int expandWidth) {
        this.expandWidth = expandWidth;
    }

    public int getExpandHeight() {
        return expandHeight;
    }
    
    //ruoxi jin
    public Plant getPlant() {
        return plant;
    }
    
    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public void setExpandHeight(int expandHeight) {
        this.expandHeight = expandHeight;
    }
}

