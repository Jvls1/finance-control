//package com.jojo.financialcontrol.validator;
//
//import com.jojo.financialcontrol.entity.BaseEntity;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//import java.util.List;
//
//public class GenericValidator {
//
//    public <T extends BaseEntity> void validateRequireFiels(T entity, List<String> fields) {
//
//        Class<? extends BaseEntity> clzz = entity.getClass();
//
//        try {
//            for (String field : fields) {
//                Field clzzField = clzz.getDeclaredField(field);
//                clzzField.setAccessible(true);
//                Object o1 = clzzField.getType().getDeclaredConstructor().newInstance();
//                Object value = clzzField.get(o1);
//                if(value != null) {
//                    throw new RuntimeException("null value");
//                }
//                System.out.println(clzzField);
//            }
//        } catch(NoSuchFieldException e) {
//            System.out.println(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        } catch (InstantiationException e) {
//            throw new RuntimeException(e);
//        } catch (NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//}
