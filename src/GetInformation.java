
import com.google.gson.*;

import models.Data;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class GetInformation {



    public double getValue(String in,String out,double value){


        try {

            LocalDateTime date = LocalDateTime.now();
            String formatedDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));


            URI uri = URI.create("https://v6.exchangerate-api.com/v6/ee1779962d048bab2ded04e8/latest/"+in);

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();

            HttpResponse<String> reponse = client.send(request, HttpResponse.BodyHandlers.ofString());



            Gson gson= new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            Data data=gson.fromJson(reponse.body(),Data.class);


            double factor= data.conversion_rates().get(out);

            double result=factor*value;

            System.out.println("El valor de "+value + " "+in + " a "+out+" es: "+result);

            JsonObject nuevoDato = new JsonObject();
            nuevoDato.addProperty("in", value);
            nuevoDato.addProperty("out", result);
            nuevoDato.addProperty("type", in+" to "+out);
            nuevoDato.addProperty("date", formatedDate);

            File archivo = new File("logs.json");
            JsonArray dataPrev = new JsonArray();


            if (archivo.exists()) {
                try (FileReader reader = new FileReader(archivo)) {
                    dataPrev = gson.fromJson(reader, JsonArray.class);
                    if (dataPrev == null) {
                        dataPrev = new JsonArray();
                    }
                } catch (IOException e) {
                    System.out.println("Error al leer el archivo: " + e.getMessage());
                }
            }


            dataPrev.add(nuevoDato);


            try (FileWriter writer = new FileWriter("logs.json")) {
                gson.toJson(dataPrev, writer);
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo: " + e.getMessage());
            }





        } catch (Exception e) {

            System.out.println("erorr in request");
            throw new RuntimeException(e);
        }



        return 0.0;

    }

}
