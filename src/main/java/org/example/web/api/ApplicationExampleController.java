package org.example.web.api;

import org.example.config.HibernateSessionFactoryConfiguration;
import org.example.domain.Currency;
import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

@RestController
public class ApplicationExampleController {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/api/v1/get-weather")
    String weather() throws IOException {

        // from file
        String JSON_FILE="./src/main/resources/my_weather.txt";
        InputStream fis = new FileInputStream(JSON_FILE);

        // from url
        // ?

        //create JsonReader object
        JsonReader jsonReader = Json.createReader(fis);

        /**
         * We can create JsonReader from Factory also
         JsonReaderFactory factory = Json.createReaderFactory(null);
         jsonReader = factory.createReader(fis);
         */

        //get JsonObject from JsonReader
        JsonObject jsonObject = jsonReader.readObject();
        System.out.println(jsonObject.toString());

        //we can close IO resource and JsonReader now
        jsonReader.close();
        fis.close();

        ////////////
        //Retrieve data from JsonObject and create Employee bean
        /*Employee emp = new Employee();

        emp.setId(jsonObject.getInt("id"));
        emp.setName(jsonObject.getString("name"));
        emp.setPermanent(jsonObject.getBoolean("permanent"));
        emp.setRole(jsonObject.getString("role"));

        //reading arrays from json
        JsonArray jsonArray = jsonObject.getJsonArray("phoneNumbers");
        long[] numbers = new long[jsonArray.size()];
        int index = 0;
        for(JsonValue value : jsonArray){
            numbers[index++] = Long.parseLong(value.toString());
        }
        emp.setPhoneNumbers(numbers);

        //reading inner object from json object
        JsonObject innerJsonObject = jsonObject.getJsonObject("address");
        Address address = new Address();
        address.setStreet(innerJsonObject.getString("street"));
        address.setCity(innerJsonObject.getString("city"));
        address.setZipcode(innerJsonObject.getInt("zipcode"));
        emp.setAddress(address);

        //print employee bean information
        System.out.println(emp);*/

        JSONObject json = new JSONObject();
        json.put("name", "jon doe");
        json.put("age", "22");
        json.put("city", "chicago");

        // file name is File.json
        /*Object o = new JSONParser().parse(new FileReader(File.json));
        JSONObject j = (JSONObject) o;
        String Name = (String) j.get("Name");
        String College = (String ) j.get("College");
        System.out.println("Name :" + Name);
        System.out.println("College :" +College);*/

        // from proxy
        //System.setProperty("http.proxyHost", "3.182.12.1");
        //System.setProperty("http.proxyPort", "1111");
        System.setProperty("http.agent", "Chrome"); // "User-Agent", "Mozilla/5.0"
        //System.setProperty("Accept-Language", "en-US,en;q=0.5");
        //System.setProperty("Accept", "text/html");
        System.setProperty("content-type", "application/json");
        System.setProperty("Accept", "application/json");
        //InputStream url = null;
        try {
            /*in = new URL("https://api.openweathermap.org/data/3.0/onecall?lat=33.44&lon=-94.04&" +
                    "appid=846c65d093f75314c3d35e30a36c57e2").openStream();*/
            URL url = new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?date=20240105&json");
            System.out.println("Protocol: " + url.getProtocol());// Using getProtocol() method of the URL class
            System.out.println("Host Name: " + url.getHost()); // Using getHost() method
            System.out.println("Port Number: " + url.getPort());  // Using getPort() method
            System.out.println("File Name: " + url.getFile());    //Using getFile() method

            InputStreamReader urlInR = new InputStreamReader(url.openStream());
            BufferedReader buf = new BufferedReader(urlInR);

            /*Object o = new JSONParser(urlInR).parse();
            JSONObject obj = (JSONObject) o;
            org.json.JSONArray jsonArray = obj.getJSONArray("");
            for(int i=0;i<jsonArray.length();i++){
                System.out.println("array is " + jsonArray.get(i));
            }*/

            //System.out.println(buf.lines().toArray());
            //JSONObject json = new JSONObject();
            //json.put()
            String line;

            //--- Hibernate --------------
            System.out.println("Hibernate tutorial");
            Session session = HibernateSessionFactoryConfiguration.getSessionFactory().openSession();
            session.beginTransaction();
            /*for (Object row : buf.lines().toArray()) {
                //for (Object item : row) {
                System.out.println( row.toString() );
            }*/

            Currency currencyEntity = new Currency();
            currencyEntity.setR030("124");
            currencyEntity.setTxt("Канадський долар");
            currencyEntity.setRate("22.3224");
            currencyEntity.setCc("CAD");
            LocalDate date = LocalDate.of(2024, 05, 02);
            currencyEntity.setExchangedate(date);
            System.out.println( currencyEntity.toString() );
            session.save(currencyEntity);

            StringBuilder b = new StringBuilder();
            while ((line = buf.readLine()) != null) {
                b.append(line);
            }

            //JSONObject j = new JSONObject(b.toString());
            JSONArray j = new JSONArray(b.toString());
            //JSONObject single_response = (JSONObject) j.get(0); //for single element
            System.out.println("Length: " + j.length() + " List: " + j.toList());
            for (int i=0; i < j.length(); i++) {     // OR iterate
                JSONObject item = (JSONObject) j.get(i);

                if (item.has("r030")) {
                    Integer r030 = (Integer) item.get("r030"); // <-- here !
                    String txt  = (String) item.get("txt"); // <-- here !
                    System.out.println("------------------");
                    System.out.println("r030 :" + r030);
                    System.out.println("txt :" + txt);
                    System.out.println("------------------");

                    Currency cur = new Currency();
                    cur.setR030(item.get("r030").toString());
                    cur.setTxt(item.get("txt").toString());
                    cur.setRate(item.get("rate").toString());
                    cur.setCc(item.get("cc").toString());
                    LocalDate date1 = LocalDate.of(2024, 05, 02); // item.get("exchangedate").toString()
                    cur.setExchangedate(date1);
                    //cur.setExchangedate((LocalDate) item.get("exchangedate"));

                    System.out.println( cur.toString() );
                    session.save(cur);
                }
            }

            //JSONArray jj = new JSONArray(j.toString());
            //System.out.println(jj.toList());

            session.getTransaction().commit();
            session.close();
            //--- END Hibernate ----------
        } catch (Exception e) {
            System.out.println( "Exception! Error message: " + e.getMessage() );
        }

        return json.toString();
    }

    @RequestMapping("/contacts")
    String contacts() {
        return "TechMatrix18 \r\nSpain \r\nBarcelona ";
    }
}

