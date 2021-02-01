/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.cloudsquare.java.CaaS;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

/**
 *
 * @author inaba
 */
public class HttpRequestProcessHandler implements HttpRequestHandler {
    public HttpRequestProcessHandler() {
        super();
    }

    @Override
    public void handle(final HttpRequest request, final HttpResponse response, final HttpContext context) throws HttpException, IOException {
        System.out.println("Request : " + request);
        System.out.println("Response : " + response);
        System.out.println("Context : " + context);
        String method = request.getRequestLine().getMethod().toUpperCase(Locale.ENGLISH);
        switch(method) {
            case "GET":
                processGet(request, response, context);
                break;
            case "POST":
                processPost(request, response, context);
                break;
            case "PUT":
                processPut(request, response, context);
                break;
            case "DELETE":
                processDelete(request, response, context);
                break;
            case "HEAD":
                processHead(request, response, context);
                break;
            default:
                throw new MethodNotSupportedException(method + " method not supported");
        }
        /* 他にはOPTIONS、TRACE、CONNECTがある */

        String target = request.getRequestLine().getUri();

        response.setStatusCode(HttpStatus.SC_OK);
        StringEntity stringEntity = new StringEntity("OK", ContentType.create("text/html", (Charset) null));
        response.setEntity(stringEntity);

        System.out.println("Process after Response : " + response);
        System.out.println("Process after Response : " + response.getEntity());

        /* ファイル読込応答サンプル(普通のhtml的応答)
        if(request instanceof HttpEntityEnclosingRequest) {
            HttpEntity entity = ((HttpEntityEnclosingRequest) request).getEntity();
            byte[] entityContent = EntityUtils.toByteArray(entity);
            System.out.println("Incoming entity content (bytes): " + entityContent.length);
        }

        final File file = new File(root, URLDecoder.decode(target, "UTF-8"));
        if(!file.exists()) {
            response.setStatusCode(HttpStatus.SC_NOT_FOUND);
            StringEntity entity = new StringEntity("<html><body><h1>File" + file.getPath() +
                                                   " not found</h1></body></html>",
                                                   ContentType.create("text/html", "UTF-8"));
            response.setEntity(entity);
            System.out.println("File " + file.getPath() + " not found");
        }
        else if(!file.canRead() || file.isDirectory()) {
            response.setStatusCode(HttpStatus.SC_FORBIDDEN);
            StringEntity entity = new StringEntity("<html><body><h1>Access denied</h1></body></html>",
                                                   ContentType.create("text/html", "UTF-8"));
            response.setEntity(entity);
            System.out.println("Cannot read file " + file.getPath());
        }
        else {
            response.setStatusCode(HttpStatus.SC_OK);
            FileEntity body = new FileEntity(file, ContentType.create("text/html", (Charset) null));
            response.setEntity(body);
            System.out.println("Serving file " + file.getPath());
        }
        */

    }

    void processGet(final HttpRequest request, final HttpResponse response, final HttpContext context) {
        System.out.println("Process Get");
    }

    void processPost(final HttpRequest request, final HttpResponse response, final HttpContext context) {
        System.out.println("Process Post");
    }

    void processPut(final HttpRequest request, final HttpResponse response, final HttpContext context) {
        System.out.println("Process Put");
    }

    void processDelete(final HttpRequest request, final HttpResponse response, final HttpContext context) {
        System.out.println("Process Delete");
    }

    void processHead(final HttpRequest request, final HttpResponse response, final HttpContext context) {
        System.out.println("Process Head");
    }
    
}
