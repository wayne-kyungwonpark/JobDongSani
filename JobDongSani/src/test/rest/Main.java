package test.rest;

import org.json.JSONArray;
import org.json.JSONObject;
//import org.json.

public class Main{
    public static void main(String[] args) {
        Connection con = Connection.getInstance();
//        JSONObject jsonObject = con.getTest("/get", "application/json");
//        changeEasierToSee(jsonObject, 0);
//        System.out.println(jsonObject);
//        JSONObject jsonObject2 = con.getTest("/response-headers?freeform=", "application/json");
//        changeEasierToSee(jsonObject2, 0);
//        System.out.println(jsonObject2);
//        JSONObject jsonObject3 = con.postTest("/post", "application/json", new JSONArray());
//        changeEasierToSee(jsonObject3, 0);
//        System.out.println(jsonObject3);
        JSONObject jsonObject4 = con.postTest("/post", "application/json", new JSONArray());
        JSONObject headers = jsonObject4.getJSONObject("headers");
        changeEasierToSee(headers, 0);
        System.out.println(jsonObject4);
    }

    private static void changeEasierToSee(JSONObject jsonObject, int level){
        for(String key : jsonObject.keySet()){
            Object value = jsonObject.get(key);
            if(value instanceof JSONObject){
                System.out.println(key + ": ");
                changeEasierToSee((JSONObject) value, level + 1);
            }else{
                for (int i = 0; i < level; i++) {
                    System.out.print("    ");
                }
                System.out.println(key + ": " + value);
            }
        }
    }
}
