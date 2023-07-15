
package helper;

public class SobreHelper {
    
    private static SobreHelper instance;

    public SobreHelper() {
        
    }
    

    public static SobreHelper getInstance() {
         if(instance == null){
            instance = new SobreHelper();
        }
        return instance;
    }

    public static void setInstance(SobreHelper instance) {
        SobreHelper.instance = instance;
    }
    
    
}
