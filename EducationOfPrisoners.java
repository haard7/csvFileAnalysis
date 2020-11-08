
/**
 * Write a description of EducationOfPrisoners here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class EducationOfPrisoners {
    public static void main(String[] args){
     FileResource fr = new FileResource();
     CSVParser parser = fr.getCSVParser();
     Convicts cv = new Convicts();
     cv.totalConvicts(parser);
     
     
     FileResource fr1 = new FileResource();
     CSVParser parser1 = fr1.getCSVParser();
     Convicts cv1 = new Convicts();
     cv1.genderAnalaysis(parser1);
     
     FileResource fr2 = new FileResource();
     CSVParser parser2 = fr2.getCSVParser();
     Education ed = new Education();
     ed.EducationAnalysis(parser2); 
     
     FileResource fr3 = new FileResource();
     CSVParser parser3 = fr.getCSVParser();
     Convicts cv2 = new Convicts();
     cv2.undertrialRatio(parser3);
     
    }
     
}

class Convicts{  
    public void totalConvicts(CSVParser parser){
        int count = 0;
        for(CSVRecord record : parser){
           String ConvictsNo = record.get("convicts");
           int noOfConvicts = Integer.parseInt(ConvictsNo);
           count = count + noOfConvicts;
        }
        System.out.println(".........................................................................\n");
        System.out.println("Total number of convicted prisoners in India from 2001 to 2013 : " + count);
    }
    
    public void genderAnalaysis(CSVParser parser){
        int m=2,f=2;
        for(CSVRecord record : parser){
            String g = record.get("gender");
            if(g.contains("Male")){
                String mConvictsNo = record.get("convicts");
                int noOfMaleConvicts = Integer.parseInt(mConvictsNo);
                m = m + noOfMaleConvicts;
                
            }
            if(g.contains("Female")){
                String fConvictsNo = record.get("convicts");
                int noOfFemaleConvicts = Integer.parseInt(fConvictsNo);
                f = f + noOfFemaleConvicts;
              
            }
            
        }
        System.out.println(".........................................................................\n");
        System.out.println("Male convicts: " + m + " Female Convicts: " + f);
        float mpercent,fpercent;
        mpercent =(float)(m*100)/(m+f);
        fpercent = (float)(f*100)/(m+f);
        System.out.println("Percentage of Male Convicts: " + mpercent + "\nPercentage of Female convicts: " + fpercent);
    }
    public void undertrialRatio(CSVParser parser){
        int convictsCount = 0;
        int UnderTrialCount = 0;
        for(CSVRecord record : parser){
           String ConvictsNo = record.get("convicts");
           int noOfConvicts = Integer.parseInt(ConvictsNo);
           convictsCount = convictsCount + noOfConvicts;
           
           String underTrialNo = record.get("under_trial");
           int NoofUnderTrial = Integer.parseInt(underTrialNo);
           UnderTrialCount = UnderTrialCount + NoofUnderTrial;
        }
        
        
        System.out.println(".........................................................................\n");
        System.out.println("Total number of Undertrial prisoners in India from 2001 to 2013 : " +  UnderTrialCount);
        
        //float convictsRatio = (convictsCount  / (convictsCount +  UnderTrialCount)) * 100;
        double tot = convictsCount +  UnderTrialCount;
        System.out.println(tot);
        double underTrialRatio = ((UnderTrialCount / tot) * 100);
        System.out.println("Percentage of convicts in undertrial in compare to that of undertrial is: " + underTrialRatio);
        System.out.println("This Depicts the degraded Judiciary System of india");
        
    }
}


class Education{
    public void EducationAnalysis(CSVParser parser){
        int BCX = 0,xPass = 0,grad = 0 , tDeg = 0, ill = 0, PG = 0;
        for(CSVRecord record : parser){
            String edu = record.get("education");
            if(edu.contains("Below Class X")){
                String noOfConvicts = record.get("convicts");
                int convictsNo = Integer.parseInt(noOfConvicts);
                BCX = BCX + convictsNo;
            }
            
            if(edu.contains("Class X and above but below graduate")){
                String noOfConvicts = record.get("convicts");
                int convictsNo = Integer.parseInt(noOfConvicts);
                xPass = xPass + convictsNo;
            }
            
            if(edu.contains("Graduate")){
                String noOfConvicts = record.get("convicts");
                int convictsNo = Integer.parseInt(noOfConvicts);
                grad = grad + convictsNo;
            }
            
            if(edu.contains("Holding technical degree/diploma etc")){
                String noOfConvicts = record.get("convicts");
                int convictsNo = Integer.parseInt(noOfConvicts);
                tDeg = tDeg + convictsNo;
            }
            
            if(edu.contains("Illiterate")){
                String noOfConvicts = record.get("convicts");
                int convictsNo = Integer.parseInt(noOfConvicts);
                ill = ill + convictsNo;
             
            }
            
            if(edu.contains("Post-Graduate")){
                String noOfConvicts = record.get("convicts");
                int convictsNo = Integer.parseInt(noOfConvicts);
                PG = PG + convictsNo;
            }
            
            
        }
        //System.out.println("Total Number of Convicts are : " + );
        int tot = BCX + xPass + grad + tDeg + ill + PG ;
        System.out.println(".........................................................................\n");
        System.out.println("Below Class X : " + BCX  + " with " + (float)((BCX * 100)/tot) + " %");
        System.out.println("Class X and above but below graduate : " + xPass + " with " + (float)((xPass *100)/tot) + " %");
        System.out.println("Graduate : " + grad + " with " + (float)((grad * 100)/tot) + " %");
        System.out.println("Holding technical degree/diploma etc : " + tDeg + " with " + (float)((tDeg *100)/tot) + " %");
        System.out.println("Illiterate : " + ill + " with " + (float)((ill * 100)/tot) + " %");
        System.out.println("Post-Graduate : " + PG + " with " + (float)((PG *100)/ tot) + " %") ;
        
    }
}



