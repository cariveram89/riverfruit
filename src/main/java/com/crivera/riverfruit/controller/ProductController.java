package com.crivera.riverfruit.controller;

import com.crivera.riverfruit.model.GroupProduct;
import com.crivera.riverfruit.model.Product;
import com.crivera.riverfruit.model.ProductSaleOrder;
import com.crivera.riverfruit.model.ResponseProduct;
import com.crivera.riverfruit.model.ResponseProductList;
import com.crivera.riverfruit.model.Status;
import com.crivera.riverfruit.model.VentaProductos;
import com.crivera.riverfruit.service.ProductService;
import com.crivera.riverfruit.util.FileUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//en la clase cotrolcer , solo estan las anotaciones , por dodne entran los serviico , y por deonde salen los servicios 
//
import java.util.Map;
import java.util.stream.Collectors;

@Path("/product")


public class ProductController {
	
	private static List<Product> listProduct = new ArrayList<>();
 private static Map<String, String> 	mapProduct =  new  HashMap<>();
	
	//private static List<ResponseProduct> listResponseProduct new ArrayList<>();
/*>
 * mapProduct.put(product.getCode(), product);
Product product = mapProduct.get(code);
Product product = mapProduct.get(code);

sintaxis map ==facil 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/products/{id}")
    public Response getProduct(@PathParam("id")  String code) {

        Product product = new Product();

        for(Product productDb : listProduct) {
            if(productDb.getCode().equals(code)) {
                product = productDb;
                break;
            }
        }

        Gson jsonConverter = new GsonBuilder().create();
        return Response.status(200).entity(jsonConverter.toJson(product)).type(MediaType.APPLICATION_JSON).build();

    }  Gson jsonConverter = new GsonBuilder().create();//clase json 
         return Response.status(200).entity(jsonConverter.toJson(listProduct)).type(MediaType.APPLICATION_JSON).build();
      
    
    */
	//
	//clase groupProduct es la respuesta del servicio 
	   @GET
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/products/filterFinal/")
		public Response AlimentoTareaBuscarOrdenadamente22(){
			
		//System.out.println("consultar fruta con id;"+ code);	
		 //  mapProduct.put(product.getCode(),  new Product());
	    	ProductService serviceGetOrganizado = new ProductService();
	    	//el metodo devuelve una listade List<GroupProduct>  
	    	Map<String, Product> 	mapProduct =  cambiarDeListaAMap();
	    	List<GroupProduct> listaOrdenada = serviceGetOrganizado.getListProduct25(mapProduct);
	    	//List<GroupProduct> listProductMap = serviceGet.getListProduct(mapProduct);
	    	//ResponseProductList luzMarina	= serviceGet.getListProduct(mapProduct);
		 //crear variable para que guarde la variable 
		 Gson jsonConverter = new GsonBuilder().create();//clase json 
			    
	 return Response.status(200).entity(jsonConverter.toJson(listaOrdenada)).type(MediaType.APPLICATION_JSON).build();
		
		}
	   public Map<String, Product> cambiarDeListaAMap(){
		   Map<String,Product> mapProduct = new HashMap<>();
		   listProduct.stream().forEach(produto->{
			   mapProduct.put(produto.getCode(), produto);
		   });
			
		  // listProduct.stream().collect(Collectors.groupingBy(Product::getCode));
		   return  mapProduct;                                        //porque lo quiero agrupar 
	   }
	   
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/products/filter1/")
	public Response AlimentoTareaBuscarOrdenadamente(){
		
	//System.out.println("consultar fruta con id;"+ code);	
    	
    	ProductService serviceGet = new ProductService();
    	ResponseProductList luzMarina	= serviceGet.getProductListaBuscarFInal(listProduct);
	 //crear variable para que guarde la variable 
	 Gson jsonConverter = new GsonBuilder().create();//clase json 
		    
 return Response.status(200).entity(jsonConverter.toJson(luzMarina)).type(MediaType.APPLICATION_JSON).build();
	
	}
	
	
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/productsPost")
    public Response saveProduct(Product product) {

        System.out.println(product.toString());
        listProduct.add(product);
        Gson jsonConverter = new GsonBuilder().create();

        return Response.status(200).entity(jsonConverter.toJson(listProduct)).type(MediaType.APPLICATION_JSON).build();

    }
    //tarea GET 
	//SI ES EXITOSO RETORNA 200 
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/productsGet/{code}")
	public Response AlimentoTarea1(@PathParam("code")  String code){
		
	//System.out.println("consultar fruta con id;"+ code);	
    	
    	ProductService serviceGet = new ProductService();
    	ResponseProduct luzMarina	= serviceGet.getProduct(listProduct, code);
	 //crear variable para que guarde la variable 
	 Gson jsonConverter = new GsonBuilder().create();//clase json 
		    
return Response.status(200).entity(jsonConverter.toJson(luzMarina)).build();
	
	}
    //tarea GET buscar
	//SI ES EXITOSO RETORNA 200 
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/products/filter/{code}")
	public Response AlimentoTareaBuscar(@PathParam("code")  String code){
		
	//System.out.println("consultar fruta con id;"+ code);	
    	
    	ProductService serviceGet = new ProductService();
    	ResponseProductList luzMarina	= serviceGet.getProductBuscar(listProduct, code);
	 //crear variable para que guarde la variable 
	 Gson jsonConverter = new GsonBuilder().create();//clase json 
		    
return Response.status(200).entity(jsonConverter.toJson(luzMarina)).build();
	
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    //TAREA POST
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/productsPostT")
	public Response AlimentoTarea2(Product product){
	
    	ProductService servicePost = new ProductService();
    	ResponseProductList listaServicioPost = servicePost.postProduct(listProduct, product);
		     Gson jsonConverter = new GsonBuilder().create();//clase json 
		    return Response.status(200).entity(jsonConverter.toJson(listaServicioPost)).type(MediaType.APPLICATION_JSON).build();
		 }
	// }

	//} 
    
  //TAREA POST
    //archivo 
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/productsPostFile")
	public Response AlimentoTarea27(Product product){
    
    	//consultar mapa del archivo 
    	FileUtil file = new FileUtil();   
    	mapProduct=	file.readFile();
    	ProductService servicePost = new ProductService();
    	Status status = servicePost.postProductFile(product,mapProduct);
		     Gson jsonConverter = new GsonBuilder().create();//clase json 
		    return Response.status(200).entity(jsonConverter.toJson(status)).type(MediaType.APPLICATION_JSON).build();
		 }
    
  //TAREA POST
    //archivo 
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/productsPostFileVender")
	public Response AlimentoTarea29Vender(Product product){
    	//primera parte 
    	FileUtil file = new FileUtil();   
    mapProduct=	file.readFile();
    	ProductService servicePost = new ProductService();
    	// Status status = servicePost.postProductFile(product,mapProduct);
    	//1.leer el archivo de productos vendidos 
    	List<VentaProductos> listProduct=FileUtil.readFileVendidos();
    	listProduct.forEach(producto->{
   		System.out.println("producto" + producto.getcodigo());
   	});
    	//llamar funcion que devielve la informaion de productos vendidos 
    	  Map<String,ProductSaleOrder> mapProductSaLE = new HashMap<>();
    	  Status status = servicePost.getCountProductPrice(listProduct, product.getCode(),product.getName());
    	  mapProductSaLE =servicePost.postProductFileVendidos(product, listProduct, mapProduct);
    	   //llamar la funcion write para que escriba la informacion en un archivo getCountProductPrice
    	 // file.writeFileVentaProductos(productSale);
    	  //status//
    	//  Status status = servicePost.postProductFile(product,mapProduct);
      	//System.out.println(status);
		   Gson jsonConverter = new GsonBuilder().create();//clase json 
		   return Response.status(200).entity(jsonConverter.toJson(status)).type(MediaType.APPLICATION_JSON).build();
    	
    	//segunda parte 
    	
    	
    	//Map<String,ProductSaleOrder> mapafinal = new  HashMap<>();
    	// private static Map<String, String> 	mapProduct =  new  HashMap<>();
    	//consultar mapa del archivo 
    	//FileUtil file = new FileUtil();   
    //	listProduct=	FileUtil.readFileVendidos();
    //	ProductService servicePost = new ProductService();
    	//mapafinal = servicePost.postProductFileVendidos(product,listProduct,mapProduct );
    	
		  //   Gson jsonConverter = new GsonBuilder().create();//clase json 
		    //return Response.status(200).entity(jsonConverter.toJson(mapafinal)).type(MediaType.APPLICATION_JSON).build();
		 }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/productsPostFileVender1")
	public Response AlimentoTareaAgostoVender(Product product){
    
    	//primera parte 
    	//se lee el archivo para agregar productos 
    	//FileUtil file = new FileUtil(); 
     	List<VentaProductos> listProduct=FileUtil.readFileVendidos();// , valor 

    	ProductService servicePost = new ProductService();
    	Status status  = servicePost.getCountProductPrice(listProduct, product.getCode(),product.getName());
    	  
    	 
		   Gson jsonConverter = new GsonBuilder().create();//clase json 
		   return Response.status(200).entity(jsonConverter.toJson(listProduct)).type(MediaType.APPLICATION_JSON).build();
    	
    	
		 }
    
    /**
     * metodo para almacenar en un archivo el valor de un producto 
     * @param product
     * @return
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/productsPostFileVender2")
	public Response AlimentoTareaAgostoVender1(Product product){
    	ProductService servicePost = new ProductService();
    	
    	FileUtil file = new FileUtil();   
    	mapProduct=	file.readFile();
    	Status status =servicePost.postProductFile(product,mapProduct);
    	//primera parte 
    	//se lee el archivo para agregar productos 
    	//FileUtil file = new FileUtil(); 
     	List<VentaProductos> listProduct=FileUtil.readFileVendidos();// , valor 
    	servicePost.getCountProductPrice(listProduct, product.getCode(),product.getName());
		Gson jsonConverter = new GsonBuilder().create();//clase json 
	    return Response.status(200).entity(jsonConverter.toJson(status)).type(MediaType.APPLICATION_JSON).build();
    	
    	
		 }
    
 // OBTENER TODOS LOS PRODUCTOS 
 	@GET
     @Produces(MediaType.APPLICATION_JSON)
     @Path("/productsGet1")
     public Response getProduct1(  ) {
 		
         Gson jsonConverter = new GsonBuilder().create();//clase json 
         return Response.status(200).entity(jsonConverter.toJson(listProduct)).type(MediaType.APPLICATION_JSON).build();
      
 	}
 	
 	//ACTUALIZA el post y elput son muy similares 
 	//parametro color 
 	//put actualizar el nombre y el coor apatir del parametro
 	//delete , eliminar el objeto de la lista apartir del codigo 
 	//agregar paquete servicee (logica) == ya 
 	//producto (4 , obtener todo , y estatus )==lista product 
 	
 	
 	//clase persona atributo  numero de documento , nombre , fecha de nacimineto (enbie en un string , yyyy-mm-dd)
 	//clase person controler
 	//esto se hace con map 
 	//clase personservice
 	
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/products/{id}")
    public Response updateProduct(@PathParam("id")  String code, Product product) {
        System.out.println("code" + code);
        System.out.println("code ELIMINAR:  " + code);
        
        //getProduct(listProduct, code);modificarProducyFinal(listProduct, code, product);
    	ProductService serviceModificar = new ProductService();
    	ResponseProduct responseProduct	= serviceModificar.modificarProducyFinal(listProduct, code, product);
	 //crear variable para que guarde la variable 
	 Gson jsonConverter = new GsonBuilder().create();//clase json 

        return Response.status(200).entity(jsonConverter.toJson(responseProduct)).build();
    }
    
    /**
     * Metodo para eliminar un producto por codigo
     * @param code
     * @return
     */
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/products/{id}")
    public Response deleteProduct(@PathParam("id")  String code) {
        System.out.println("code ELIMINAR:  " + code);
      
        //getProduct(listProduct, code);
    	ProductService serviceDelete = new ProductService();
    	ResponseProduct responseProduct	= serviceDelete.deleteProduct(listProduct, code);
	 //crear variable para que guarde la variable 
	 Gson jsonConverter = new GsonBuilder().create();//clase json 

        return Response.status(200).entity(jsonConverter.toJson(responseProduct)).build();

    }
    
 
	
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/products/filterLista/")
	public Response AlimentoListaTareaBuscar( ){
		
	//System.out.println("consultar fruta con id;"+ code);	
    	
    	ProductService serviceGet = new ProductService();
    	ResponseProductList luzMarina	= serviceGet.getProductListaBuscar(listProduct);
	 //crear variable para que guarde la variable 
	 Gson jsonConverter = new GsonBuilder().create();//clase json 
		    
return Response.status(200).entity(jsonConverter.toJson(luzMarina)).build();
	
	}



}
