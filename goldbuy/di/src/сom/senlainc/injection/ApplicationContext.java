package сom.senlainc.injection;

import logger.Logger;
import сom.senlainc.configuration.PropertyConfiguration;
import сom.senlainc.injection.annotation.Autowired;
import сom.senlainc.injection.annotation.Value;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ApplicationContext {
    private final Map<Class<?>, Object> context;
    private Set<Class<?>> classSet;
    private ObjectFactory factory;
    private PropertyConfiguration propertyConfiguration;

    public void setPropertyConfiguration(PropertyConfiguration propertyConfiguration) {
        this.propertyConfiguration = propertyConfiguration;
    }

    public ApplicationContext() {
        this.context = new HashMap<>();
        factory = new ObjectFactory();

    }

    public void setClassSet(Set<Class<?>> classSet) {
        this.classSet = classSet;
    }

    public <T> T get(Class<?> clazz) {
        return (T) context.get(clazz);
    }

    private boolean checkOfExist(Class clazz) {
        return context.get(clazz) != null;
    }

    private void injectDependencies(Class clazz, Object obj) throws InstantiationException, IllegalAccessException {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Autowired.class)) {
                Object value;
                if (checkOfExist(field.getType())) {
                    value = context.get(field.getType());
                } else {
                    value = createIObject(field.getType());
                }
                injectDependencies(value.getClass(), value);
                field.setAccessible(true);
                field.set(obj, value);
            }
            if (field.isAnnotationPresent(Value.class)) {
                String key = field.getAnnotation(Value.class).value();
                Object value;
                if (checkOfExist(field.getType())) {
                    value = context.get(field.getType());
                } else {
                    value = propertyConfiguration.getProperty(key);
                }
                field.setAccessible(true);
                field.set(obj, value);
            }

        }
    }

    private Object createIObject(Class<?> clazz) throws IllegalAccessException, InstantiationException {
        Object object=factory.createInterfaceObject(propertyConfiguration.getProperty(clazz.getName()));
        injectDependencies(clazz,object);
        return object;
    }

    private Object createObject(Class<?> clazz) throws IllegalAccessException, InstantiationException {
        Object object = factory.createObject(clazz);
        injectDependencies(clazz, object);
        return object;
    }

    public void createContext() {
        for (Class clazz : classSet) {
            if (checkOfExist(clazz)) {
                continue;
            }
            try {
                Object obj = createObject(clazz);
                context.put(clazz, obj);
            } catch (ReflectiveOperationException e) {
                new Logger().log(this.getClass(), e);
            }


        }
    }


}
