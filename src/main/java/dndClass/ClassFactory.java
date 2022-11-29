package dndClass;

public class ClassFactory {
       public static CharacterClass getClass(String str){
        if(str.equalsIgnoreCase("Druid")){
            return new Druid();
        } else if (str.equalsIgnoreCase("Fighter")) {
            return new Fighter();
        }
        return null;
       }
}
