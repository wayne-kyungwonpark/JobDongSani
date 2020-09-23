package test.rest;

import org.json.JSONObject;

public class Main{
    public static void main(String[] args) {
        Connection con = Connection.getInstance();
        JSONObject jsonObject = con.getTest("/get", "application/json");
        toJson(jsonObject, 0);
        System.out.println(jsonObject);
        JSONObject jsonObject2 = con.getTest("/response-headers?freeform=", "application/json");
        toJson(jsonObject2, 0);
        System.out.println(jsonObject2);
    }

    private static void toJson(JSONObject jsonObject, int level){
        for(String key : jsonObject.keySet()){
            Object value = jsonObject.get(key);
            if(value instanceof JSONObject){
                System.out.println(key + ": ");
                toJson((JSONObject) value, level + 1);
            }else{
                for (int i = 0; i < level; i++) {
                    System.out.print("    ");
                }
                System.out.println(key + ": " + value);
            }
        }
    }
}
