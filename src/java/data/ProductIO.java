
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import bussiness.Product;
import java.io.*;
import java.util.*;


public class ProductIO {
    
    private static List<Product> products = null; 
    private static String filePath = null;
    
    // Called once from the controller based on servlet context 
    public static void init(String filePath) {
           ProductIO.filePath = filePath;
    }

    public static List<Product> selectProducts() { 
        products = new ArrayList<Product>();
        File file = new File(filePath);
        try {
            BufferedReader in
                    = new BufferedReader(
                            new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                if (t.countTokens() >= 3) {
                    String code = t.nextToken();
                    String description = t.nextToken();
                    String priceAsString = t.nextToken();
                    double price = Double.parseDouble(priceAsString);

                    Product p = new Product();
                    p.setCode(code);
                    p.setDescription(description);
                    p.setPrice(price);
                    in.close();
                    
                    products.add(p);
                }
                line = in.readLine();
            }
            in.close();
            return products;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }
    
    public static Product selectProduct(String productCode) { 
        products = selectProducts();
        for (Product p : products) {
            if (productCode != null
                && productCode.equalsIgnoreCase(p.getCode())) {
            return p;
            }
        }
        return null;
    }
    
    public static boolean exists(String productCode) { 
        Product p = selectProduct(productCode);
        if (p != null) return true;
        else return false;
    }
    private static void saveProducts(List<Product> products) { 
        try {
            File file = new File(filePath); 
            PrintWriter out
                    = new PrintWriter(
                        new FileWriter(file));
            
            for (Product p : products) {
                out.println(p.getCode() + "|"
                    + p.getDescription() + "|"
                    + p.getPrice());
            }
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public static void insertProduct(Product product) { 
        products = selectProducts(); 
        products.add(product);
        saveProducts(products);
    }

    public static void updateProduct(Product product) { 
        products = selectProducts();
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i); 
            if (product.getCode() != null
                && product.getCode().equalsIgnoreCase(p.getCode())) { 
                products.set(i, product);
            } 
        }
        saveProducts(products); 
    }

    public static void deleteProduct(Product product) { 
        products = selectProducts();
        for (int i = 0; i < products.size(); i++) { 
            Product p = products.get(i);
            if (product != null
                && product.getCode().equalsIgnoreCase(p.getCode())) { 
                products.remove(i);
            } 
        }
        saveProducts(products); 
    }

   /* 
    ** Old Product IO class method
    public static ArrayList<Product> getProducts(String filepath) {
        ArrayList<Product> products = new ArrayList<Product>();
        File file = new File(filepath);
        try {
            BufferedReader in
                    = new BufferedReader(
                            new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String code = t.nextToken();
                String description = t.nextToken();
                String priceAsString = t.nextToken();
                double price = Double.parseDouble(priceAsString);
                Product p = new Product();
                p.setCode(code);
                p.setDescription(description);
                p.setPrice(price);
                products.add(p);
                line = in.readLine();
            }
            in.close();
            return products;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }
*/
}