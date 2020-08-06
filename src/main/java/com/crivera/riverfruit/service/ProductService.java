package com.crivera.riverfruit.service;

import java.io.BufferedReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.crivera.riverfruit.dao.ProductDao;
import com.crivera.riverfruit.model.GroupProduct;
import com.crivera.riverfruit.model.Product;
import com.crivera.riverfruit.model.ProductSaleOrder;
import com.crivera.riverfruit.model.ResponseProduct;
import com.crivera.riverfruit.model.ResponseProductList;
import com.crivera.riverfruit.model.ResponseProductListOrdered;
import com.crivera.riverfruit.model.Status;
import com.crivera.riverfruit.model.VentaProductos;
import com.crivera.riverfruit.util.FileUtil;
import com.crivera.riverfruit.util.ResponseProductUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ProductService {
	// solo estan los servicos
	//trea lista Ordenada 
	
	//tarea 22 de julio 
	public List<GroupProduct> getListProduct(List<Product> listProductEntrada){
		//instancias 
		//convertir listProductEntrada en mapProduct
		Map<String,Product> mapProduct = new HashMap<>();	
		for (Product product : listProductEntrada) {
			mapProduct.put(product.getCode(), product);
			}
		List<Product> listProductMap = new ArrayList<>(mapProduct.values());
		Map<String,List<Product>> groupProductMap = new HashMap<>();
		//logica 
		for (Product product : listProductMap) {
			String codeInitial = product.getCode().substring(0, 1);
			List<Product> listProduct = groupProductMap.get(codeInitial);
			if(listProduct != null) {
				listProduct.add(product);
				groupProductMap.remove(codeInitial);
				groupProductMap.put(codeInitial, listProduct);
				
			}else {
				List<Product> listProductNew = new ArrayList<>();
				listProductNew.add(product);
				groupProductMap.put(codeInitial, listProductNew);
			}
		}
		List<GroupProduct> listGroupProduct = new ArrayList<>();
		Set<String> keysMap = groupProductMap.keySet();
		for (String value : keysMap) {
		GroupProduct groupProduct = new GroupProduct();
		groupProduct.setCode(value);
		groupProduct.setProducts(groupProductMap.get(value));
		listGroupProduct.add(groupProduct);
		}
		return listGroupProduct;
	}
	
	public List<GroupProduct> getListProduct25(Map<String,Product> mapProduct){
		//instancias 
		//convertir listProductEntrada en mapProduct
		List<Product> listProductMap = new ArrayList<>(mapProduct.values());
		Map<String,List<Product>> groupProductMap = new HashMap<>();	
		
		for (Product product : listProductMap) {
			String codeInitial = product.getCode().substring(0, 1);
			List<Product> listProduct = groupProductMap.get(codeInitial);
			if(listProduct != null) {
				listProduct.add(product);
				groupProductMap.remove(codeInitial);
				groupProductMap.put(codeInitial, listProduct);
				
			}else {
				List<Product> listProductNew = new ArrayList<>();
				listProductNew.add(product);
				groupProductMap.put(codeInitial, listProductNew);
			}
		}
		List<GroupProduct> listGroupProduct = new ArrayList<>();
		Set<String> keysMap = groupProductMap.keySet();
		for (String value : keysMap) {
			
			GroupProduct groupProduct = new GroupProduct();
			groupProduct.setCode(value);
			groupProduct.setProducts(groupProductMap.get(value));
			listGroupProduct.add(groupProduct);
		
		}
		return listGroupProduct;
	}
	
	//tarea anterior 
	public ResponseProductList getProductListaBuscarFInal(List<Product> listProduct) {
		Product productoModificarListaOrdenada = new Product();
		//List<Product> listProductOrganizada = new List<Product>();
		//System.out.println("consultar fruta con id;" + code);
				List<Product> buscaProduct = new ArrayList<>();
				
				Collections.sort(listProduct);
				for (Product producto : listProduct) {
					char primeraLetra = producto.getCode().charAt(0);
				if(producto.getCode().charAt(0)==producto.getCode().charAt(0)) {
					//esta ordenada la lista de acendentemente
					productoModificarListaOrdenada = producto;
					buscaProduct.add(productoModificarListaOrdenada);
					//otra lista para ir comparando posicion por posicion 
				}
				}
				 listProduct.remove(productoModificarListaOrdenada);
				Status status = new Status();
				status.setCode(200);
				status.setDescripcion("consulta exitosa");
			
				ResponseProductList responseProductList = new ResponseProductList();
				responseProductList.setStatus(status);
				responseProductList.setLista(listProduct);
				return responseProductList;

	}
	public ResponseProductList getProductListaBuscar(List<Product> listProduct) {

		//System.out.println("consultar fruta con id;" + code);
		List<Product> buscaProduct = new ArrayList<>();
		for (Product producto : listProduct) {
		

		}
		Status status = new Status();
		status.setCode(200);
		status.setDescripcion("consulta exitosa");
		ResponseProductList responseProductList = new ResponseProductList();
		responseProductList.setStatus(status);
		responseProductList.setLista(buscaProduct);
		return responseProductList;

	}

	public ResponseProduct getProduct(List<Product> listProduct, String code) {

		System.out.println("consultar fruta con id;" + code);
		for (Product producto : listProduct) {
			if (producto.getCode().equals(code)) {
				//Status status = new Status();
			//	status.setCode(200);
				//status.setDescripcion("consulta exitosa");
				//ResponseProduct responseProduct = new ResponseProduct();
				//responseProduct.setStatus(status);
				//responseProduct.setProduct(producto);
              ResponseProductUtil responseProductUtil = new ResponseProductUtil();
               ResponseProduct responseProduct = responseProductUtil.buildProduct(200,"Consulta exitosa", producto);
               
				return responseProduct;
			}
		}
		System.out.println("la fruta con id " + code + " no existe");
		Status estatus = new Status();
		estatus.setCode(400);
		estatus.setDescripcion("el producto no existe ");
		ResponseProduct responseProduct = new ResponseProduct(estatus);
		 //ResponseProductUtil responseProductUtil = new ResponseProductUtil();
         //ResponseProduct responseProduct = responseProductUtil.buildProduct(200,"Consulta exitosa", producto);

		return responseProduct;

	}

	public ResponseProductList getProductBuscar(List<Product> listProduct, String code) {

		System.out.println("consultar fruta con id;" + code);
		List<Product> buscaProduct = new ArrayList<>();
		for (Product producto : listProduct) {
			if (producto.getCode().contains(code)) {
				buscaProduct.add(producto);
			}
        }
		Status status = new Status();
		status.setCode(200);
		status.setDescripcion("consulta exitosa");
		ResponseProductList responseProductList = new ResponseProductList();
		responseProductList.setStatus(status);
		responseProductList.setLista(buscaProduct);
		return responseProductList;

	}


	// code.length(
	// String buscar = produ.getCode();//2 M2
	// vamos a ver el tamaño que tiene buscar
// post 
	public ResponseProductList postProduct(List<Product> listProduct, Product product) {
		for (Product producto : listProduct) {
			if (producto.getCode().equals(product.getCode())) {
				Status status = new Status();
				status.setCode(200);
				status.setDescripcion("producto ya existe ");
				// instancias un response product list
				ResponseProductList responseProductList = new ResponseProductList();
				responseProductList.setStatus(status);
				responseProductList.setLista(listProduct);
				// Gson jsonConverter = new GsonBuilder().create();//clase json
				return responseProductList;
			}
		}
		listProduct.add(product);
		Status estatus = new Status();
		estatus.setCode(400);
		estatus.setDescripcion("creacion exitosa ");
		// instanciar un response product list
		ResponseProductList responseProductList = new ResponseProductList();
		responseProductList.setStatus(estatus);
		responseProductList.setLista(listProduct);
		// Gson jsonConverter = new GsonBuilder().create();//clase json

		return responseProductList;

	}
	//file
	public Status postProductFile( Product product,Map<String, String> 	mapProduct) {
		 System.out.println("01");

		//recorrer el mapa 
		 String code = product.getCode().toUpperCase().trim();
		if(mapProduct.containsKey(code)) {
			//lo contiene
			 System.out.println("02");
		    Status status = new Status();
						status.setCode(400);
						status.setDescripcion("producto ya existe ");
						return status;
						 
		}else {
			 System.out.println("03");
			//se valida si ya existe el producto 
			FileUtil file = new FileUtil();
			file.writeFile(product);
			//no lo contiene
			  Status status = new Status();
				status.setCode(200);
				status.setDescripcion("Nuevo producto");
				return status;
		}
	}
	//mirar esta funcion 1 agosto 
	public Status postProductFileVendidos( Product product,Map<String, String> 	mapProduct) {
	
		//recorrer el mapa 
		 String code = product.getCode().toUpperCase().trim();
		if(mapProduct.containsKey(code)) {
			//lo contiene
			FileUtil file = new FileUtil(); 
	     	List<VentaProductos> listProduct=FileUtil.readFileVendidos();
	     	ProductService servicePost = new ProductService();
	     	//ProductSaleOrder productSale = servicePost.getCountProductPrice(listProduct, product.getCode(),product.getName());
		    Status status = new Status();
						status.setCode(400);
						status.setDescripcion("producto ya existe ");
						return status;
		}else {
			
			//se valida si ya existe el producto 
			FileUtil file = new FileUtil();
			file.writeFile(product);
			//no lo contiene
			  Status status = new Status();
				status.setCode(200);
				status.setDescripcion("Nuevo producto");
				return status;
		}
	}
	public Map<String,ProductSaleOrder>  postProductFileVendidos( Product product,List<VentaProductos> listProduct,Map<String, String> 	mapProduct) {
		 System.out.println("01");
		 
	        Map<String,ProductSaleOrder> mapProductSaLE = new HashMap<>();

		//recorrer el mapa 
		 String code = product.getCode().toUpperCase().trim();
		if(mapProduct.containsKey(code)) {
			//lo contiene
			 System.out.println("02");
			// listProduct.
			 ProductSaleOrder productSaleOrder = new ProductSaleOrder();
			 productSaleOrder.setCode(product.getCode());//codigo 
			 productSaleOrder.setProduct(product.getName());//nombre
			 productSaleOrder.getSalesQuantity();//cantidad
			 //productSaleOrder.setTotal(total);//el total de la ganancia 
			 
		
						return mapProductSaLE ;
						 
		}else {
			 System.out.println("03");
			//se valida si ya existe el producto 
			FileUtil file = new FileUtil();
			file.writeFile(product);
		
			 
				return mapProductSaLE ;
		}
	}
	//servicio contar gannacias de un producto 
	//QUE RETORNE UN ProductSaleOrder
	public Status getCountProductPrice(List<VentaProductos> listaProduct,String codeVerified,String nameProduct) {
		long priceSum = 0;
		int contador = 0;
		for(int i=0; i<listaProduct.size(); i++) {
			String code = listaProduct.get(i).getcodigo();
			if(code.equals(codeVerified)) {			
				contador ++;
				 priceSum =Long.valueOf(listaProduct.get(i).getValor())+priceSum;
				 System.out.println("priceSum: " + priceSum);
			}
		}
		
		ProductSaleOrder product = new ProductSaleOrder();
		product.setSalesQuantity(contador);
		product.setTotal(priceSum);
		product.setCode(codeVerified);//el codifo del producto
		product.setProduct(nameProduct);//el nombre del producto
		//crear un mapa 
	
		// mapProductExistentes.put(product.getCode(), product);
	    //si el producto ya esta escrito en el archivo no se escribe 
		
		//error en crear el archivo 
		FileUtil file = new FileUtil();
		System.out.println("escribe producto ");
		
		 Map<String, String> 	mapProductExistentes =file.readFileVentas();
		
		if(mapProductExistentes.get(product.getCode())==null) {
		file.writeFileVentaProductos(product);
		}
		//status
		Status status = new Status();
		status.setCode(200);
		status.setDescripcion("Valor Ganancia producto calculado");
		return status;
	}
	


	public ResponseProductList modificarProduct1(List<Product> listProduct, Product product) {
		for (Product producto : listProduct) {
			if (producto.getCode().equals(product.getCode())) {
				Status status = new Status();
				status.setCode(200);
				status.setDescripcion("producto ya existe ");

				// instancias un response product list
				ResponseProductList responseProductList = new ResponseProductList();
				responseProductList.setStatus(status);
				responseProductList.setLista(listProduct);

				return responseProductList;
			}
		}
		// el elmento buscado no existe
		Status estatus = new Status();
		estatus.setCode(400);
		estatus.setDescripcion(" ");
		// instanciar un response product list
		ResponseProductList responseProductList = new ResponseProductList();
		responseProductList.setStatus(estatus);
		responseProductList.setLista(listProduct);

		return responseProductList;

	}

	/**
	 * Metodo para eliminar un producto
	 * 
	 * @author CRIVERA
	 * @param listProduct lista sw productos
	 * @param code        identificador del codigo del producto a eliminar
	 * @return
	 */
	public ResponseProduct deleteProduct(List<Product> listProduct, String code) {
		System.out.println("infreso a ");
		System.out.println("lissta " + listProduct + "" + code);
		Product productoEliminar = new Product();
		boolean isPrductExist = false;
		for (Product producto : listProduct) {
			System.out.println("infreso a " + producto.getCode());
			if (producto.getCode().equals(code)) {

				// ADICIONAR A LA LISTA A REMOVER
				productoEliminar = producto;
				isPrductExist = true;
				break;
			}
		}
		if (isPrductExist == false) {
			ResponseProduct responseProduct = new ResponseProduct();
			Status status = new Status();
			status.setCode(400);
			status.setDescripcion("producto a eliminar no existe ");
			responseProduct.setStatus(status);
			// responseProduct.setProduct(producto);
			return responseProduct;
		}
		listProduct.remove(productoEliminar);
		System.out.println("imprimir lista de productos ");
		System.out.println(listProduct);
		Status status = new Status();
		status.setCode(200);
		status.setDescripcion("producto eliminado ");
		ResponseProduct responseProduct = new ResponseProduct();
		responseProduct.setStatus(status);

		return responseProduct;

	}

	/*
	 * 
	 * 
	 * public void buscar valor(){ double valor int indice System valor =
	 * teclado.nextDouble( indice = listaNumero.indexof(valor) if(indice != -1)
	 * 
	 */
	public ResponseProduct modificarProducyFinal(List<Product> listProduct, String code, Product product) {

		Product productoModificar = new Product();
		boolean isPrductExist = false;
		for (Product producto : listProduct) {
			System.out.println("infreso a " + producto.getCode());
			if (producto.getCode().equals(code)) {
				// ADICIONAR A LA LISTA A REMOVER
				productoModificar = producto;
				isPrductExist = true;
				break;
			}
		}
		if (isPrductExist == false) {
			ResponseProduct responseProduct = new ResponseProduct();
			Status status = new Status();
			status.setCode(400);
			status.setDescripcion("producto a modificar no existe ");
			responseProduct.setStatus(status);
			// responseProduct.setProduct(producto);
			return responseProduct;
		}

		listProduct.remove(productoModificar);
		product.setCode(code);
		listProduct.add(product);
		System.out.println("imprimir lista de productos ");
		System.out.println(listProduct);
		Status status = new Status();
		status.setCode(200);
		status.setDescripcion("producto Modificado ");
		ResponseProduct responseProduct = new ResponseProduct();
		responseProduct.setStatus(status);
		return responseProduct;

	}

	// version anterior

	public ResponseProductList modificarProduct(List<Product> listProduct, String code, Product product) {
		ArrayList<Product> listaEliminar = new ArrayList<>();

		if (listProduct.isEmpty()) {
			Status status = new Status();
			status.setCode(1200);
			status.setDescripcion("la lista esta vacia ");
			ResponseProductList responseProductList = new ResponseProductList();
			responseProductList.setStatus(status);
			return responseProductList;
		}

		// PARA DEBUG
		System.out.println("Codigo a Buscar :" + code);
		System.out.println("Productos existentes :");
		for (Product producto : listProduct) {
			System.out.println(producto.toString());
		}

		// crear lista prodcutoseLIMINAR
		for (Product producto : listProduct) {
			if (producto.getCode().equals(code)) {
				// ADICIONAR A LA LISTA A REMOVER
				listaEliminar.add(producto);
			}
		}
		listProduct.add(product);
		Status estatus = new Status();
		estatus.setCode(400);
		estatus.setDescripcion("Modificacion  exitosa ");
		// instanciar un response product list
		ResponseProductList responseProductList = new ResponseProductList();
		responseProductList.setStatus(estatus);
		responseProductList.setLista(listProduct);

		// REMOVER TODA LA LISTA, EN CASO DE QUE NO ESTE VACIA
		for (Product eliminar : listaEliminar) {
			System.out.println("PRODUCTO A ELIMINAR :" + eliminar.toString());
		}
		listaEliminar.removeAll(listProduct);
		// agregar la info del nuevo producto //return responseProductList;
		// listProduct.add(product);

		return responseProductList;
	}
	/*
	 * ublic void agregarElemnto() { listProduct.add(product); Status estatus = new
	 * Status(); estatus.setCode(400); estatus.setDescripcion("creacion exitosa ");
	 * //instanciar un response product list ResponseProductList responseProductList
	 * = new ResponseProductList(); responseProductList.setStatus(estatus);
	 * responseProductList.setLista(listProduct); }
	 */
	
	public int restaNumero (int num1 , int num2) {
		return num1 - num2;
		
	}
	public List<Product> getProductsBD() {
		
		//lllamar a la clase product dao 
		ProductDao productDao = new ProductDao();
		List<Product> listProduct = new  ArrayList<>();
		try {
	
			listProduct = productDao.getProducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listProduct;
	}
}
