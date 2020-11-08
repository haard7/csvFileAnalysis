
/**
 * Write a description of GroupOfFood here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class GroupOfFood {
    public void listOfFoods(CSVParser parser, String foodOfInterest){
        System.out.println("Sorting the data and abstracting only the food belong to specific group (Herbs here): ");
           for(CSVRecord record : parser){
               String group = record.get("GROUP");
               if(group.contains(foodOfInterest)){
                   String foodName = record.get("FOOD NAME");
                   System.out.println(foodName);
               }
               /* else{
                   System.out.println("Entered Group name or food of Interest is not there in given csv file:  ");
               } */
           }
    }
    
    public void foodInfo(CSVParser parser, String foodName){
        System.out.println("\n\nInformation of given/entered food is:  ");
        for(CSVRecord  record : parser){
            String fn = record.get("FOOD NAME");
            if(fn.contains(foodName)){
                String group = record.get("GROUP");
                String subGroup = record.get("SUB GROUP");
                String scientificNm = record.get("SCIENTIFIC NAME");
                System.out.println("Food: " + fn + "\nScientific name: " + scientificNm + "\nGroup:  " + group + "\nSub Group: " + subGroup);
            }
        }
    }
    
    public void listOfBerries(CSVParser parser,String group,String subGroup){
        System.out.println("\n\nHow many Foods out of given Fruits(Group) are berries(Sub Group):  ");
        int count = 0;
        int c = 0;
        for(CSVRecord record :  parser){
            String gp = record.get("GROUP");
            
            if(gp.contains(group)){
                String subgp = record.get("SUB GROUP");
                c++;
                if(subgp.contains(subGroup)){
                    String foodName = record.get("FOOD NAME");
                    System.out.println(foodName);
                    count++;
                }
            }
        }
        System.out.println("\nTotal number of Berries are " + count +  " out of " + c +" fruits :");
    }
    
    
    
    public void FindGroup(){
     
     FileResource fr = new FileResource();
     CSVParser parser =  fr.getCSVParser();
     GroupOfFood gf = new GroupOfFood();
     gf.listOfFoods(parser,"Herbs");
     
     
     FileResource fr1 = new FileResource();
     CSVParser parser1 =  fr1.getCSVParser();
     GroupOfFood gf1 = new GroupOfFood();
     gf1.foodInfo(parser1,"Guava"); 
     
     
     FileResource fr2 = new FileResource();
     CSVParser parser2 =  fr2.getCSVParser();
     GroupOfFood gf2 = new GroupOfFood();
     gf2.listOfBerries(parser2,"Fruits","Berries");
     
    }
    
    
}

 

