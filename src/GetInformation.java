
import com.google.gson.FieldNamingPolicy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Data;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class GetInformation {



    public double getValue(String in,String out,double value){


        try {
            URI uri = URI.create("https://v6.exchangerate-api.com/v6/ee1779962d048bab2ded04e8/latest/"+in);

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();

            HttpResponse<String> reponse = client.send(request, HttpResponse.BodyHandlers.ofString());



            Gson gson= new GsonBuilder()

                    .create();
            Data data=gson.fromJson(reponse.body(),Data.class);


            double factor= data.conversion_rates().get(out);

            double result=factor*value;

            System.out.println("El valor de "+value + " "+in + " a "+out+" es: "+result);






        } catch (Exception e) {

            System.out.println("erorr in request");
            throw new RuntimeException(e);
        }



        return 0.0;

    }

}
