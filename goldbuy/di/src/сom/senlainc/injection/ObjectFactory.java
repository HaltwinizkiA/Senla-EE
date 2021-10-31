package сom.senlainc.injection;

import сom.senlainc.injection.exception.InjectionException;

public class ObjectFactory {

    public <T> T createInterfaceObject(String impl) {
        try {
            return (T) Class.forName(impl).newInstance();
        } catch (ReflectiveOperationException e) {
            throw new InjectionException(this.getClass(), e);
        }

    }

    public <T> T createObject(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (ReflectiveOperationException e) {
            throw new InjectionException(this.getClass(), e);
        }

    }
}
