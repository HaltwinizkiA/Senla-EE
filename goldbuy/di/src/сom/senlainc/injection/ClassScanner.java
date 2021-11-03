package сom.senlainc.injection;

import org.reflections.Reflections;


import сom.senlainc.injection.annotation.Component;

import java.util.Set;

public class ClassScanner {
   private String classpath;

    public ClassScanner(String classpath) {
        this.classpath = classpath;
    }

    public  Set<Class<?>> getClassSet(){
        Reflections reflections = new Reflections(classpath);
        return reflections.getTypesAnnotatedWith(Component.class);
        }
    }

