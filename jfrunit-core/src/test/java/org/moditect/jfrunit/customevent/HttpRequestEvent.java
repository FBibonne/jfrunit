package org.moditect.jfrunit.customevent;

import jdk.jfr.Category;
import jdk.jfr.Description;
import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.Name;
import jdk.jfr.StackTrace;

@Name("test.HttpRequestEvent")
@Label("HTTP Request")
@Category({"HTTP"})
@Description("Événement capturant les informations d'une requête HTTP")
@StackTrace(false)
public class HttpRequestEvent extends Event {

    @Label("HTTP Method")
    @Description("Verbe HTTP de la requête (GET, POST, PUT, DELETE, etc.)")
    private final String method;

    @Label("Request Path")
    @Description("Chemin de la requête HTTP")
    private final String path;

    @Label("Principal")
    @Description("Principal associé à la requête (utilisateur authentifié)")
    private final String principal;

    @Label("Response Size")
    @Description("Taille de la réponse en octets")
    private long responseSize;

    @Label("HTTP Status")
    @Description("Code de statut HTTP de la réponse")
    private int httpStatus;

    public HttpRequestEvent(String method, String path, String principal) {
        this.method = method;
        this.path = path;
        this.principal = principal;
    }

    public void recordResponse(int httpStatus, long responseSize) {
        this.httpStatus = httpStatus;
        this.responseSize = responseSize;
    }

    public String method() {
        return method;
    }

    public String path() {
        return path;
    }

    public String principal() {
        return principal;
    }

    public long responseSize() {
        return responseSize;
    }

    public int httpStatus() {
        return httpStatus;
    }
}