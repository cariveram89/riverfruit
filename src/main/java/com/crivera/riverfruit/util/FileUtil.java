package com.crivera.riverfruit.util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crivera.riverfruit.model.Product;
import com.crivera.riverfruit.model.ProductSaleOrder;
import com.crivera.riverfruit.model.ResponseProductList;
import com.crivera.riverfruit.model.Status;
import com.crivera.riverfruit.model.VentaProductos;
public class FileUtil {

  
   public static void main(String[] args) {
List<VentaProductos> listProduct = new ArrayList<>();
    	//Map<String,String> ResultMapProduct = new HashMap<>();
       // String value =   writeFile();
       // System.out.println(value);
listProduct = readFileVendidos();
System.out.println("productos Vendidos"+listProduct); 
    	//ResultMapProduct =  	readFile();
      //System.out.println("productos"+ResultMapProduct); 
  //  String[] arrayLastMap =  datArchivoLeido.split("%%");
    //  String code = arrayLastMap[0];
     // System.out.println("prueba"); 
      //System.out.println("&"+code); 
      
    }

    //throws

    //try catch
   

    public  void writeFile(Product product ) {

       

/*
        try {
           // String test = null;
         //   System.out.println(test.toString());
            int numeroProducto = 1;
            int valorTotal = 10000;
            if (numeroProducto > 0) {
                int valorUnidad = valorTotal / numeroProducto;
                System.out.println("valorUnidad" + valorUnidad);
             //   String valorUni = String.valueOf(valorUnidad);

                String content = "CarlosRivera";
                Files.write(Paths.get("C:\\Users\\CRIVERA\\Documents\\Carlos\\carlos.txt"), content.getBytes());
                value = "existoso";
            /*} else {
                value = "Valor recibido en numero producto es cero, revisar";
            }*/

   //     }

//} catch (IOException e) {
            //printException(e, "fallo controlado");
          //  value = "fallo";
        //} catch (Exception e) {
          //  printException(e, "Excepción controlado, gravisisimo revisar urgente!!!!");
        //} finally {
         //   value = "finally";
       // }
///*

    
        BufferedWriter bw = null;
        //concatenar dos string
       
        String productSave = (product.getCode() +"%%"+ product.getName());
        try {
            FileWriter fw = new FileWriter("C:\\\\Users\\\\CRIVERA\\\\Documents\\\\Carlos\\\\producto.txt", true);
            System.out.println("entra a write 1");
            bw = new BufferedWriter(fw);
            System.out.println("entra a write 2");
            bw.write(productSave);//escribe en el archivo 
            
          //  Status status = new Status();
		//	status.setCode(200);
			//status.setDescripcion("Nuevo producto");
    
            System.out.println("entra a write");
            bw.newLine();//nueva linea 
           

        } catch (IOException e) {
            System.out.println("Ruta no encontrada");
        } finally {
            try {
                bw.close();
            } catch (IOException exception) {
                System.out.println("No se pudo cerrar el buffer");
            }
        }
	
       
    }
    

    
    
    
    public  void writeFileVentaProductos(ProductSaleOrder product ) {

        BufferedWriter bw = null;
        //concatenar dos string
       
        String productSave = (product.getCode() +"%%"+ product.getProduct()+"%%"+ product.getSalesQuantity()+"%%"+ product.getTotal());
        try {
            FileWriter fw = new FileWriter("C:\\\\\\\\Users\\\\\\\\CRIVERA\\\\\\\\Documents\\\\\\\\Carlos\\\\\\\\venta.txt", true);
            System.out.println("entra a write 1");
            bw = new BufferedWriter(fw);
            System.out.println("entra a write 2");
            bw.write(productSave);//escribe en el archivo 
            
          //  Status status = new Status();
		//	status.setCode(200);
			//status.setDescripcion("Nuevo producto");
    
            System.out.println("entra a write");
            bw.newLine();//nueva linea 
           

        } catch (IOException e) {
            System.out.println("Ruta no encontrada");
        } finally {
            try {
                bw.close();
            } catch (IOException exception) {
                System.out.println("No se pudo cerrar el buffer");
            }
        }
	
       
    }
    /// metodo validar 
    public boolean validar() {
    	
    	return true ;
    }

    public Map<String,String>  readFile()  {
      //  String value = "existoso";
        BufferedReader reader = null;
        Map<String,String> mapProduct = new HashMap<>();
        try {

            reader = new BufferedReader(new FileReader("C:\\\\Users\\\\CRIVERA\\\\Documents\\\\Carlos\\\\producto.txt"));

         String line ;
        // line = line.trim();
         //line = line.toUpperCase();
         
            while ((line = reader.readLine()) != null) {
            	
                //guardar en mapao enlista 
            	 line = line.trim().toUpperCase();
                String[] arrayLastMap =  line.split("%%");
                System.out.println(line);
                System.out.println("entra a read");
                mapProduct.put(arrayLastMap[0], arrayLastMap[1]);
                System.out.println(".-."+mapProduct);
            }
            


        } catch (IOException e) {
            System.out.println("Ruta no encontrada");
        } finally {
            try {
                reader.close();
            } catch (IOException exception) {
                System.out.println("No se pudo cerrar el buffer");
            }
        }
        return mapProduct;
    }
    
    /**
     * Lee el archivo de ventas
     * @return mapa de productSale
     */
    public Map<String,String>  readFileVentas()  {
        //  String value = "existoso";
          BufferedReader reader = null;
          Map<String,String> mapProduct = new HashMap<>();
          try {

              reader = new BufferedReader(new FileReader("C:\\\\Users\\\\CRIVERA\\\\Documents\\\\Carlos\\\\venta.txt"));

           String line ;
         
           
              while ((line = reader.readLine()) != null) {
              	
                  //guardar en mapao enlista 
              	 line = line.trim().toUpperCase();
                  String[] arrayLastMap =  line.split("%%");
                  System.out.println(line);
                  System.out.println("entra a read");
                  mapProduct.put(arrayLastMap[0], arrayLastMap[1]);
                  System.out.println(".-."+mapProduct);
              }
              


          } catch (IOException e) {
              System.out.println("Ruta no encontrada");
          } finally {
              try {
                  reader.close();
              } catch (IOException exception) {
                  System.out.println("No se pudo cerrar el buffer");
              }
          }
          return mapProduct;
      }
    public static   List<VentaProductos> readFileVendidos()  {
    	List<VentaProductos> listProductVendidos = new ArrayList<>();
        //  String value = "existoso";
          BufferedReader reader = null;
         
          try {

              reader = new BufferedReader(new FileReader("C:\\\\Users\\\\CRIVERA\\\\Documents\\\\Carlos\\\\ventaProducto.txt"));

           String line ;
           while ((line = reader.readLine()) != null) {
                  String[] arrayLastMap =  line.split("%%");
                  System.out.println("1"+line);
                  System.out.println("entra a read");
                  System.out.println("2.-."+arrayLastMap[0] + " " +arrayLastMap[1]);
                  VentaProductos producto = new VentaProductos();
                  producto.setName(arrayLastMap[0]);
                  producto.setValor(arrayLastMap[1]);
                  listProductVendidos.add(producto);
                  System.out.println("2.-."+listProductVendidos);
              }
 
          } catch (IOException e) {
              System.out.println("Ruta no encontrada");
          } finally {
              try {
                  reader.close();
              } catch (IOException exception) {
                  System.out.println("No se pudo cerrar el buffer");
              }
          }
          return listProductVendidos ;
      }

    
    private static void printException(Exception e, String log) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String sStackTrace = sw.toString(); // stack trace as a string
        System.out.println(log + " - " + sStackTrace);
    }

}


