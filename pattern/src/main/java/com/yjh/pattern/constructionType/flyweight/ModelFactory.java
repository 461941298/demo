package com.yjh.pattern.constructionType.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ModelFactory {

    private static Map<String, Model> professonalModel = new HashMap<>();
    private static Map<String, Model> trampModel = new HashMap<>();

    public static Model getModel(String name) {
        Model profession = professonalModel.get(name);
        Model tramp = professonalModel.get(name);
        if (null != profession) {
            return profession;
        } else if (null != tramp) {
            return tramp;
        } else {
            return getProfessonalModel(name);
        }
    }

    public static Model getProfessonalModel(String name) {
        if (null == professonalModel.get(name)) {
            professonalModel.put(name, new ProfessionalModel(name));
        }
        return professonalModel.get(name);
    }

    public static Model getTramp(String name) {
        if (null == trampModel.get(name)) {
            trampModel.put(name, new ProfessionalModel(name));
        }
        return trampModel.get(name);
    }
}
