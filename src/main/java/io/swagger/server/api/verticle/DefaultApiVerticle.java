package io.swagger.server.api.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import io.swagger.server.api.model.Customer;

import java.util.List;
import java.util.Map;

public class DefaultApiVerticle extends AbstractVerticle {
    final static Logger LOGGER = LoggerFactory.getLogger(DefaultApiVerticle.class); 
    
    final static String DELETE_RHCUSTOMER_SERVICE_ID = "DELETE_rhcustomer";
    final static String GET_RHCUSTOMER_SERVICE_ID = "GET_rhcustomer";
    final static String POST_RHCUSTOMER_SERVICE_ID = "POST_rhcustomer";
    final static String PUT_RHCUSTOMER_SERVICE_ID = "PUT_rhcustomer";
    
    //TODO : create Implementation
    DefaultApi service = new DefaultApiImpl();

    @Override
    public void start() throws Exception {
        
        //Consumer for DELETE_rhcustomer
        vertx.eventBus().<JsonObject> consumer(DELETE_RHCUSTOMER_SERVICE_ID).handler(message -> {
            try {
                
                Customer result = service.rhcustomerDelete();
                message.reply(new JsonObject(Json.encode(result)).encodePrettily());
            } catch (Exception e) {
                //TODO : replace magic number (101)
                message.fail(101, e.getLocalizedMessage());
            }
        });
        
        //Consumer for GET_rhcustomer
        vertx.eventBus().<JsonObject> consumer(GET_RHCUSTOMER_SERVICE_ID).handler(message -> {
            try {
                
                Customer result = service.rhcustomerGet();
                message.reply(new JsonObject(Json.encode(result)).encodePrettily());
            } catch (Exception e) {
                //TODO : replace magic number (101)
                message.fail(101, e.getLocalizedMessage());
            }
        });
        
        //Consumer for POST_rhcustomer
        vertx.eventBus().<JsonObject> consumer(POST_RHCUSTOMER_SERVICE_ID).handler(message -> {
            try {
                Customer body = Json.mapper.readValue(message.body().getJsonObject("body").encode(), Customer.class);
                
                Customer result = service.rhcustomerPost(body);
                message.reply(new JsonObject(Json.encode(result)).encodePrettily());
            } catch (Exception e) {
                //TODO : replace magic number (101)
                message.fail(101, e.getLocalizedMessage());
            }
        });
        
        //Consumer for PUT_rhcustomer
        vertx.eventBus().<JsonObject> consumer(PUT_RHCUSTOMER_SERVICE_ID).handler(message -> {
            try {
                Customer body = Json.mapper.readValue(message.body().getJsonObject("body").encode(), Customer.class);
                
                Customer result = service.rhcustomerPut(body);
                message.reply(new JsonObject(Json.encode(result)).encodePrettily());
            } catch (Exception e) {
                //TODO : replace magic number (101)
                message.fail(101, e.getLocalizedMessage());
            }
        });
        
    }
}