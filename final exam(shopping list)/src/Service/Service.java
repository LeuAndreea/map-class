package Service;

import DOMAIN.Product;

import java.io.*;
import java.util.ArrayList;

public class Service {
    private ArrayList<Product> products;

    public Service() {
        this.products = new ArrayList<Product>();

        this.readFromFile();
    }

    void readFromFile(){

            BufferedReader buff=null;

            try{
                buff= new BufferedReader(new FileReader("products.txt"));
                String line=null;
                while((line=buff.readLine())!= null){
                    String[] data= line.split("[,]");
                   Product p= new Product(data[0].strip(),data[1].strip(),data[2].strip(),Double.parseDouble(data[3].strip()), Integer.parseInt(data[4].strip()));
                   this.products.add(p);
                }
            } catch(FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if (buff != null)
                    try {
                        buff.close();
                    }
                    catch (IOException e)
                    {
                        System.out.println("Error while closing the file " + e);
                    }
            }

        }

    public void writeToFile() {

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("out.out"));
            for (Product p : products) {
                bw.write(p.toString());
                bw.newLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


        public ArrayList<Product> getProducts() {
        return products;
    }
}


