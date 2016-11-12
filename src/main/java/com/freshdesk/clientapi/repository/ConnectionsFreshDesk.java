package com.freshdesk.clientapi.repository;

import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by Marcus on 29/03/2016.
 */
public class ConnectionsFreshDesk {
    private String login = "";//put your login Ex.: viny.md@hotmail.com
    private String senha = "";//put password
    private String domain = "";//put your url Ex.: https://marcus2vinicius.freshdesk.com
    //region comments
    //se usar este deve add .json nas urls
    //HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("bnTWo3ATuIPZIsIg2i","X");
    //endregion comments


    //region post
    /*
        @objectJson object format json
        @path resource
     */
    public String post(String objectJson, String path){
        Client client = ClientBuilder.newClient();
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(login, senha);
        client.property(ClientProperties.CONNECT_TIMEOUT, 100000);
        client.property(ClientProperties.READ_TIMEOUT,    100000);
        client.register(feature);
        Entity<String> entity = Entity.entity(objectJson, MediaType.APPLICATION_JSON_TYPE);

        WebTarget target = client.target(domain);
            String fdRes = target.path(path)
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .build("POST", entity).invoke(String.class);
        client.close();
        return fdRes;
    }
    /*
        @objectJson object format json
        @path resource parent
        @id id resource
        @path2 resource children
     */
    public String post(String objectJson, String path, Long id, String path2){
        Client client = ClientBuilder.newClient();
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(login, senha);
        client.property(ClientProperties.CONNECT_TIMEOUT, 100000);
        client.property(ClientProperties.READ_TIMEOUT,    100000);
        client.register(feature);
        Entity<String> entity = Entity.entity(objectJson, MediaType.APPLICATION_JSON_TYPE);

        WebTarget target = client.target(domain);
        String fdRes = target.path(path).path(id.toString()).path(path2)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .build("POST", entity).invoke(String.class);
        client.close();
        return fdRes;
    }
    //endregion post

    //region get
    public String get(String id, String path){
        Client client = ClientBuilder.newClient();
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(login, senha);
        client.property(ClientProperties.CONNECT_TIMEOUT, 100000);
        client.property(ClientProperties.READ_TIMEOUT,    100000);
        client.register(feature);

        WebTarget target = client.target(domain);
        String fdRes = target.path(path).path(id)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .build("GET").invoke(String.class);
        client.close();
        return fdRes;
    }

    public String get(String  id, String path, Map<String,Object> params){
        Client client = ClientBuilder.newClient();
        client.property(ClientProperties.CONNECT_TIMEOUT, 100000);
        client.property(ClientProperties.READ_TIMEOUT,    100000);
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(login, senha);
        client.register(feature);
        WebTarget target = client.target(domain);

        //add params
        for (Map.Entry<String, Object> entry  : params.entrySet()){
            target = target.queryParam(entry.getKey(),entry.getValue());
        }

        String fdRes = target.path(path).path(id)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .build("GET").invoke(String.class);
        client.close();
        return fdRes;
    }

    public String get(String path){
        Client client = ClientBuilder.newClient();
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(login, senha);
        client.property(ClientProperties.CONNECT_TIMEOUT, 100000);
        client.property(ClientProperties.READ_TIMEOUT,    100000);
        client.register(feature);

        WebTarget target = client.target(domain);
        String fdRes = target.path(path)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .build("GET").invoke(String.class);
        client.close();
        return fdRes;
    }

    public String get(String path, Map<String,Object> params){
        Client client = ClientBuilder.newClient();
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(login, senha);
        client.property(ClientProperties.CONNECT_TIMEOUT, 10000);
        client.property(ClientProperties.READ_TIMEOUT,    10000);
        client.register(feature);
        WebTarget target = client.target(domain);
        target = target.path(path);

        //add params
        for (Map.Entry<String, Object> entry  : params.entrySet()){
            target = target.queryParam(entry.getKey(),entry.getValue());
        }

        String fdRes = target.request(MediaType.APPLICATION_JSON_TYPE)
                .build("GET").invoke(String.class);
        client.close();
        feature = null;
        target = null;
        client = null;
        return fdRes;
    }
    //endregion get

    //region put
    public String put(String objectJson,Long id, String path){
        Client client = ClientBuilder.newClient();
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(login, senha);
        client.property(ClientProperties.CONNECT_TIMEOUT, 100000);
        client.property(ClientProperties.READ_TIMEOUT,    100000);
        client.register(feature);
        Entity<String> entity = Entity.entity(objectJson, MediaType.APPLICATION_JSON_TYPE);

        WebTarget target = client.target(domain);

        Response response = target.path(path).path(id.toString())
                .request(MediaType.APPLICATION_JSON_TYPE).put(entity);
        client.close();
        if(response.getStatus()==200){
            Object a = response.readEntity(String.class);
            return objectJson;
        }

        else return null;
    }
    /*
        @objectJson object format json
        @path resource parent
        @id id resource
        @path2 resource children
     */
    public String put(String objectJson, String path, Long id, String path2, Type clazz){
        Client client = ClientBuilder.newClient();
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(login, senha);
        client.property(ClientProperties.CONNECT_TIMEOUT, 100000);
        client.property(ClientProperties.READ_TIMEOUT,    100000);
        client.register(feature);
        Entity<String> entity = Entity.entity(objectJson, MediaType.APPLICATION_JSON_TYPE);
        client.property(ClientProperties.SUPPRESS_HTTP_COMPLIANCE_VALIDATION, true);
        WebTarget target = client.target(domain);

        Response response = target.path(path).path(id.toString()).path(path2)
                .request(MediaType.APPLICATION_JSON_TYPE).put(entity);
        client.close();
        if(response.getStatus()==200){
            String a = response.readEntity(String.class);
            if(clazz!=null && a!=null && !"".equals(a))
                return a;
            return objectJson;
        }
        else return null;
    }

    /*
        @objectJson object format json
        @path resource parent
        @id id resource
        @path2 resource children
        @param resource parameter Value
        @param resource parameter Name
     */
    public String put(String objectJson, String path, Long id, String path2, Type clazz, String paramName, String paramValue){
        Client client = ClientBuilder.newClient();
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(login, senha);
        client.property(ClientProperties.CONNECT_TIMEOUT, 100000);
        client.property(ClientProperties.READ_TIMEOUT,    100000);
        client.register(feature);
        Entity<String> entity = Entity.entity(objectJson, MediaType.APPLICATION_JSON_TYPE);
        client.property(ClientProperties.SUPPRESS_HTTP_COMPLIANCE_VALIDATION, true);
        WebTarget target = client.target(domain);

        Response response = target.path(path).path(id.toString()).path(path2).queryParam(paramName, paramValue)
                .request(MediaType.APPLICATION_JSON_TYPE).put(entity);
        client.close();
        if(response.getStatus()==200){
            String a = response.readEntity(String.class);
            if(clazz!=null && a!=null && !"".equals(a))
                return a;
            return objectJson;
        }
        else return null;
    }
    //endregion put

}
