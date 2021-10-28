package pkgMain;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The public data class stores all public data
 */
public class Data {

    public  static List<Plant> plants = new ArrayList<>();

    public  static List<Plant> filters = new ArrayList<>();


    public  static  Integer clickId = 0;

    public  static Integer curPage = 1;

    public  static Integer size  = 9;

    public  static  List<Integer> plants_select =  new ArrayList<>();



    static {
//        plants = getPlants();
        try {
            plants = readPlantDatafromCsv();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * Load each row of data to set each attribute of the plant
     * @param p
     * @param data
     */
    private static void setPlantVal(Plant p, String data) {
        String[] ds = data.split(":");
        if (ds.length < 2) {
            p.setName(data.trim());
        } else {
            String d = ds[1].trim();
            if (ds[0].equalsIgnoreCase("imgPath")) {
                ImageView imageView = new ImageView();
               // System.out.println(d);
//                String path = "file:img/plants/p1.png";
//                String path = "file:"+d;
                // set imagepath
                imageView.setImage(new Image(d));
                p.setImageView(imageView);
                  p.setTemplateImg(d);

            } else if (ds[0].equalsIgnoreCase("Light")) {
                p.setLight(d);
            } else if (ds[0].equalsIgnoreCase("Water")) {
                p.setWater(d);
            } else if (ds[0].equalsIgnoreCase("Bloom Time")) {
                p.setBloomTime(d);
            } else if (ds[0].equalsIgnoreCase("Hight")) {
                p.setHight(d);
            } else if (ds[0].equalsIgnoreCase("Bloom Color")) {
                p.setBloomColor(d);
            } else if (ds[0].equalsIgnoreCase("Soil Moisture")) {
                p.setSoilMoisture(d);
            } else if (ds[0].equalsIgnoreCase("CaCO3 Tolerance")) {
                p.setCaCO3Tolerance(d);
            } else if (ds[0].equalsIgnoreCase("Drought Tolerance")) {
                p.setDroughtTolerance(d);
            }
        }
    }

    /**
     * Refresh plant data again
     */
    public  static void  reload(){
        plants = getPlants();
    }

    /**
     * Load data from the fxml file
     * @return
     */
    public static List<Plant> getPlants() {
        List<String> datas = Streams.lines(Data.class.getResource("/fxml/s4_datas.txt").getPath());
        Plant p = null;
        List<Plant> allPlants = new ArrayList<>();
        int j = 1;
        for (String data : datas) {
            j++;
            if (data.trim().equals("")) {
                if (p != null) {
                    allPlants.add(p);
                    p = null;
                }
            } else {
                if (p == null) {
                    p = new Plant();
                    setPlantVal(p, data);
                } else {
                    setPlantVal(p, data);
                }
            }
            if (j == datas.size() && p != null) {
                allPlants.add(p);
            }
        }
        return allPlants;
    }


    /**
     * Load the data in the plant selection box
     * @return
     */
    public static Map<String, String[]> getSelectMap() {
        Map<String, String[]> map = new HashMap<>();
        map.put("Light", new String[]{"Sun", "Part", ""});
        List<String> lines = Streams.lines(Data.class.getResource("/fxml/s4_select.txt").getPath());
        for (String line : lines) {
            String[] datas = line.split(":");
            String selectName = datas[0];
            String[] d2s = datas[1].split("/");
            map.put(selectName, d2s);
        }
        return map;
    }


    public static void main(String[] args) throws IOException {
//        transformCsv();
//        readPlantDatafromCsv();









    }

    /**
     * Read the plant data from the CSV file
     * @return
     * @throws IOException
     */
    public static List<Plant> readPlantDatafromCsv() throws IOException {
        String path = Data.class.getResource("/fxml/s4_data.csv").getPath();
        BufferedReader br = Streams.getBufferedReader(path);
        Plant p = null;
        List<Plant> allPlants = new ArrayList<>();
        String line = null;
        boolean isFrist = true;
        while((line=br.readLine())!=null){
            if(isFrist){
                isFrist = false;
                continue;
            }
            String[] datas = line.split(",");
            if(datas.length <10){
                String[] n_data = new String[10];
                System.arraycopy(datas,0,n_data,0,datas.length);
                datas = n_data;
            }
            p = new Plant();
            ImageView imageView = new ImageView();
            imageView.setImage(new Image(datas[0]));
            p.setImageView(imageView);
            p.setTemplateImg(datas[0]);
            p.setName(datas[1]);
            p.setLight(datas[2]);
            p.setWater(datas[3]);
            p.setBloomTime(datas[4]);
            p.setHight(datas[5]);
            p.setBloomColor(datas[6]);
            p.setSoilMoisture(datas[7]);
            p.setCaCO3Tolerance(datas[8]);
            p.setDroughtTolerance(datas[9]);
            p.setGardenWidth(Integer.parseInt(datas[10]));
            p.setGardenHeight(Integer.parseInt(datas[11]));
            allPlants.add(p);
        }
        return  allPlants;
    }

    /**
     * Convert TXT file data to CSV data
     * @throws IOException
     */
    private static void transformCsv() throws IOException {
        String path = Data.class.getResource("/fxml/s4_data.csv").getPath();
        List<Plant> plants = getPlants();
        BufferedWriter bw = Streams.getBufferedWriter(path);
        String header = "imgPath,name,Light,Water,Bloom Time,Hight,Bloom Color,Soil Moisture,CaCO3 Tolerance,Drought Tolerance\n";
        String line  = "";
        for(Plant p :plants){
            line+=p.getTemplateImg()+","+p.getName()+","+p.getLight()+","+p.getWater()+","+p.getBloomTime()+","+p.getHight()
            +","+p.getBloomColor()+","+p.getSoilMoisture()+","+p.getCaCO3Tolerance()+","+p.getDroughtTolerance()+"\n"
            ;
        }

        header += line;
        bw.write(header);
        bw.flush();
        bw.close();
        System.out.println("write success");
    }
    
    //Imagedata in csv ---xinyi 
    public static List<ImageData> readImageDatafromCsv(String fileName) throws IOException {
        String path = Data.class.getResource("/fxml/"+fileName).getPath();
        BufferedReader br = Streams.getBufferedReader(path);
        List<ImageData> list = new ArrayList<>();
        boolean isFrist = true;
        ImageData imageData = null;
        String line = null;
        while((line=br.readLine())!=null){
            if(isFrist){
                isFrist = false;
                continue;
            }
            String[] datas = line.split(",");
            if(datas.length <10){
                String[] n_data = new String[10];
                System.arraycopy(datas,0,n_data,0,datas.length);
                datas = n_data;
            }
            imageData = new ImageData(datas[0],Integer.parseInt(datas[1]));
            list.add(imageData);
        }
        return list;
    }


}
