package root.utils;

public class Keyboard {
   private static boolean[] keys = new boolean[512];

   public static void setKeys(int keyCode, boolean value){
       keys[keyCode] = value;
   }

   public static boolean getKey(int keyCode){
       return keys[keyCode];
   }



}
