package com.hzf.restful;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by zf.huang on 2018.8.3
 */
public interface ProductService {

    @GET
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    List<Product> retrieveAllProducts();

    @GET
    @Path("/product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Product retrieveProductById(@PathParam("id") long id);

    @POST
    @Path("/products")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    List<Product> retrieveProductsByName(@FormParam("name") String name);

    @POST
    @Path("/product")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    List<Product> createProduct(String obj, String id) throws ParseException;

    @PUT
    @Path("/product/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Product updateProductById(@PathParam("id") long id, Map<String, Object> fieldMap);

    @DELETE
    @Path("/product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Product deleteProductById(@PathParam("id") long id);

}
