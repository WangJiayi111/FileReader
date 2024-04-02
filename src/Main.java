import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class Main {
    public static void main(String[] args) throws Exception {
        String filePath ="C:\\Users\\PC\\Downloads\\Groceries.txt";
        String fileToWrite="C:\\学校\\大一下\\Java\\作业\\GroceriesFormatted.txt";


        String [] array=new String[4];
        String id;
        String itemName;
        String quantity;
        double price;
        String separator=",";
        double total=0;
        String heading;

        FileReader fileReader=new FileReader(filePath);
        FileWriter fileWriter=new FileWriter(fileToWrite);

        BufferedReader reader =new BufferedReader(fileReader);
        BufferedWriter writer=new BufferedWriter(fileWriter);

       
        writer.write("****************************************************");
        writer.newLine();
        heading="ID#"+"\t"+"Item"+"\t\t"+"Quantity"+"\t"+"Price(:€)"+".";
        System.out.println(heading);
       // writer.newLine();
        writer.write(heading);
        writer.newLine();



        String line;


        while((line=reader.readLine())!=null){
            array =line.split(separator);
            id=array[0];
            itemName=array[1];
            quantity=array[2];
            price=Double.parseDouble(array[3]);

            total+=price;

            if(quantity.length()<4){
                line=id+"\t"+itemName+"\t\t"+quantity+"\t\t\t"+price+".";
            }
            else if(quantity.length()>4){
                line=id+"\t"+itemName+"\t\t"+quantity+"\t\t"+price+".";
            }
            

            
    
            System.out.println(line);
            writer.write(line);
            writer.newLine();

        }

        
        System.out.println("\n"+ "Total price of groceries: " + Math.round(total));
        writer.write("****************************************************");
        writer.newLine();
        writer.write("The grocery shopping total is:"+Math.round(total));
        writer.newLine();
        writer.write("****************************************************");
        writer.newLine();
        reader.close();
        writer.flush();
        writer.close();

    }
}
