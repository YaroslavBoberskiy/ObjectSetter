import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YB on 24.01.2016.
 */
public class Demo {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{

        ObjectSetter objectCreator = new ObjectSetter();
        Map<String,Object> hm = new HashMap<String, Object>();

        hm.put("VIN", "VIN11909");
        hm.put("color", Color.black);
        hm.put("price", 12900);

        Car car = (Car) objectCreator.setPrivates(Car.class, hm);

        System.out.println(car.getVIN());
        System.out.println(car.getColor());
        System.out.println(car.getPrice());

    }

}
