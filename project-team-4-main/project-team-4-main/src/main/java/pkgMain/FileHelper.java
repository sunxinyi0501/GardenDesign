package pkgMain;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
 

 
public class FileHelper {
	private String fileName;
	
	public FileHelper(){
		
	}
	
	public FileHelper(String fileName){
		this.fileName=fileName;
	}
	/**
	 * to save garden object as file
	 * @param m a garden object
	 */
	public void saveObjToFile(Garden m){
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fileName));
			
			oos.writeObject(m);                 
			
			oos.close();  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	/**
	 * to get the garden object from file
	 * @return m
	 */
	public Garden getObjFromFile(){
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
			
			Garden m = (Garden)ois.readObject(); // read object
			
			//Person person=(Person)ois.readObject();  
			return m;          //return object
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}