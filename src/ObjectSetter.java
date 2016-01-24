import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by YB on 24.01.2016.
 */
public class ObjectSetter<T> {

    public T setPrivates (Class<T> c, Map<String, Object> map) {
        T obj = null;
        try {
            obj = c.newInstance();
            Field[] fs = obj.getClass().getDeclaredFields();
            for (String key : map.keySet()) {
                for (Field f : fs) {
                    if (f.isAccessible() == false && f.getName().equals(key)) {
                        System.out.println("YES!");
                        f.setAccessible(true);
                        f.set(obj, map.get(key));
                    }
                }
            }
            return obj;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }

}
