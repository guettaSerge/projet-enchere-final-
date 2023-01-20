package com.example.enchere.dao;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author P14A-Serge
 */
public class Useful {
    ////////////////////////////reflect///////////////////////////
      //fonction permettant d'avoir les attributs ayant des annotations
	public static Field[] getFieldAnnoted(Object obj) {
		Field[] field=obj.getClass().getDeclaredFields();
		ArrayList<Field> fields=new ArrayList<Field>();
		for(Field f : field) if(f.isAnnotationPresent(Attribute.class)) fields.add(f);
		return fields.toArray(new Field[fields.size()]);
	}
	
	///fonction permettant d'avoir les attributs non null sur celui qui est annot�
	public static Field[] getNonNullAnnotedField(Object obj,Field[] field) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ArrayList<Field> notnullField=new ArrayList<Field>();
		for(Field f:field) {
			Object attrVal=Useful.getAttributeValue(obj,f.getName());
			if(attrVal!=null)notnullField.add(f);
		}
		return notnullField.toArray(new Field[notnullField.size()]);
	}
	
	public static Field[] getNonNullAnnotedField(Object obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Field[] field=Useful.getFieldAnnoted(obj);
		return Useful.getNonNullAnnotedField(obj,field);
	}
	
	//fonction permettant de recuperer la valeur d'un attribur
		public static Object getAttributeValue(Object obj,String attributeName) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			Method getter=Useful.getGetter(attributeName,obj.getClass());
			return getter.invoke(obj);	
		}
		//permet d'avoir le type de notre arguments
		public static Class getClassArg(Object args) {
			if(new String("").getClass().isInstance(args))
				return new String("").getClass();
			if(new Integer(0).getClass().isInstance(args)) 
				return new Integer(0).getClass();
			if(new Double(0).getClass().isInstance(args))
				return new Double(0).getClass();
			if(new Float(0).getClass().isInstance(args)) 
				return new Float(0).getClass();
			if(new Long(0).getClass().isInstance(args)) 
				return new Long(0).getClass();
			if(Date.class.isInstance(args)) 
				return Date.class;
			else return null;
		}
		
		//fonction permettant de transformer le string en objet
		public static Object getObjetArg(Field f,String arg) {
			if(new String("").getClass().equals(f.getType()))
				return 	arg;
			if(new Integer(0).getClass().equals(f.getType())) 
				return Integer.parseInt(arg);
			if(new Double(0).getClass().equals(f.getType()))
				return Double.parseDouble(arg);
			if(new Float(0).getClass().equals(f.getType())) 
				return Float.parseFloat(arg);
			if(new Long(0).getClass().equals(f.getType())) 
				return Long.parseLong(arg);
			if(Date.class.equals(f.getType())) 
				return Date.valueOf(arg);
			else return null;
		}
	//Nb le premier Libellee sera toujours l'idn dans notre libelles
		public static Method  getSetter(String libellee,Class cla,Object arg) throws NoSuchMethodException, SecurityException {
			String getterName=Useful.getSetterName(libellee);
			Class[] args= {Useful.getClassArg(arg)};
			return cla.getMethod(getterName,args);
	 	}
		
		public static String getSetterName(String libellee) {
			String deb=libellee.substring(0,1);
			String tohiny=libellee.substring(1);
			return "set"+deb.toUpperCase()+tohiny;
			
		}
		public static  String[] getTypeAttr(Field[]fields) {
			ArrayList<String> rep=new ArrayList<String>();
			for(Field f:fields) {
				Attribute attr=(Attribute)f.getAnnotation(Attribute.class);
				rep.add(attr.attrType());
			}
			return rep.toArray(new String[rep.size()]);
		}
		public static  Field getPrimaryKey(Field[]fields) {
			for(Field f:fields) {
				String id=Useful.IsIdAttribute(f) ;
				if(id!=null&&id!="") {
					return f;
				}
			}
			return null;
		}
		public static  String getAttrName(Field f) {
				Attribute attr=(Attribute)f.getAnnotation(Attribute.class);
				return attr.attrName();
		}
		public static  String IsIdAttribute(Field f) {
			Attribute attr=(Attribute)f.getAnnotation(Attribute.class);
			return attr.idPrimaryKey();
		}
			
		public static String getTableName(Object obj) {
			TableName table=(TableName)obj.getClass().getAnnotation(TableName.class);
			return table.table();
		}
		
		
		public static Method  getGetter(String libellee,Class cla) throws NoSuchMethodException, SecurityException {
			String getterName=Useful.getGetterName(libellee);
			return cla.getMethod(getterName);
	 	}
		public static String getGetterName(String libellee) {
 			String deb=libellee.substring(0,1);
			String tohiny=libellee.substring(1);
			return "get"+deb.toUpperCase()+tohiny;
			
		}
		
                public static void  chargeObject(Object base,String arguments,Field libellee) throws Exception {
                        Object argimentsReel=Useful.getObjetArg(libellee,arguments);
                        Method setter= Useful.getSetter(libellee.getName(),base.getClass(), argimentsReel);
			Object[] args= {argimentsReel};
			setter.invoke(base,args);
                }
               
    
    /////////////////////////////////////////////////////////////////////////////////////
    public static String[] split(String s,String operator){
        return s.split(operator);
    }
    //fonction permettant d'avoir le do part de l'url
    public static String getPartWithDo(String url){
        String[] urls=Useful.split(url,"/");
        urls=Useful.split(urls[urls.length-1],".do");
        return urls[0];
    }
    ///fonction permettant de recuperer les classes dans une classpath
    public static Class[] findAllClassesUsingClassLoaderb(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
          .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        Set<Class> rep=    reader.lines().filter(line -> line.endsWith(".class"))
          .map(line -> Useful.getClass(line, packageName))
          .collect(Collectors.toSet());
        return rep.toArray(new Class[rep.size()]);
    }
    public static Class[] findAllClassesUsingClassLoader(String path) throws ClassNotFoundException{
        File file=new File(path);
        return Useful.findAllClassesUsingClassLoader(file,"");
    }
     public static Class[] findAllClassesUsingClassLoader(File file,String pack) throws ClassNotFoundException{
        ArrayList<Class> rep=new ArrayList<Class>();
        File[] filles=file.listFiles();
        for(File f : filles){   
            if(f.isDirectory()){
               String newPack="";
               if(pack.length()>0)newPack+=".";
               newPack=pack+Useful.getFile(f)+".";
               Class[] repfille=findAllClassesUsingClassLoader(f,newPack);
               addArraylistToArraylist(rep,repfille);
            }
            else{
                try{
                    String str=f.toString();
                    String[] path=null;
                    System.out.println(str);
                    str=str.replace('\\','.');
                    str=str.replace(".","b.b");
                    path = str.split("b.b");
                    String classe=path[path.length-2]; 
                    System.out.println("a "+pack+classe+" a");
                    Class cla= Useful.getCLassFromFile(f,pack+classe);
                    rep.add(cla);  
                   
                }
                catch(Exception e){
                }
            }      
        }
      return rep.toArray(new Class[rep.size()]);
     }
     
     public static String getFile(File f){
         String str=f.toString();
          str=str.replace('\\','.');
         str=str.replace(".","b.b");
         System.out.println(str);
         String[] path;
         path = str.split("b.b");
         return path[path.length-1];
     }
     public static Class getCLassFromFile(File f,String classe) throws ClassNotFoundException{
            
        return Class.forName(classe);
     }
   
     public static void  addArraylistToArraylist(ArrayList a,Object[] b){
     for(int i=0;i<b.length;i++)a.add(b[i]);
     }
    private static Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
              + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }
   

    //////////////////////traitement date data ////////////////
	public static Date stringToDate(String sdate) throws Exception {
		 SimpleDateFormat formatter= new SimpleDateFormat ("yyyy/MM/dd");
		 java.util.Date rep=formatter.parse(sdate);
		 return new Date(rep.getTime());
	}
	public static Date stringToDateLong(String sdate) throws Exception {
		 SimpleDateFormat formatter= new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss");
		 java.util.Date rep=formatter.parse(sdate);
		 return new Date(rep.getTime());
	}
        public static Date toDate(String date,String erreur) throws Exception{
             Useful.notNullString(date,erreur);
                try{
                    return Date.valueOf(date);
                }
                catch(Exception e){
                    throw new Exception(erreur);
                }
        }
        ///////////////////////verification if null data////////////////////////
	public static boolean isNull(Object obj) {
		if(obj==null)return true;
		return false;
	}
	public static boolean isNullString(String obj) {
		return Useful.isNull(obj)||(obj=="");
	}
	//////////////////////////traitement numeric data //////////////////////////////
	public static boolean isNumeric(Object obj) {
		if(Useful.isNull(obj))return false;
		if(Number.class.isAssignableFrom(obj.getClass())) return true;
		return false;
	}
	public static boolean isNumericable(String obj) {
		try {
			Double a=new Double(obj);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public static boolean ifPositifNumber(String obj) {
		return Useful.isNumericable(obj)&&(Double.parseDouble(obj)>=0);
	}
	 ///gettion d'exception
        
        public static void notNull(Object obj,String message) throws Exception{
            
            if(Useful.isNull(obj))
                throw new Exception(message);
        }
        public static void notNullString(String obj,String message) throws Exception{
            if(Useful.isNullString(obj))
                throw new Exception(message);
        }
        public static void  isNumericable(String obj,String message) throws Exception{
            if(!Useful.isNumericable(obj))
                throw new Exception(message);
        }
     public static void ifPositif(String moyenne, String le_moyenne_doit_etre_positif) throws Exception {
         if(Double.parseDouble(moyenne)<0)throw new Exception(le_moyenne_doit_etre_positif); //To change body of generated methods, choose Tools | Templates.
    }

    public static void isNumericable(Integer idMatiere, String lidmariere_doit_etre_un_chiffre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public static void isValidDate(String date, String message) throws Exception {
        try {
            Date.valueOf(date);
        }
        catch (Exception e) {
            throw new Exception(message);
        }
    }
	public static Time setStringToTime(String heure)throws Exception{
		try{
			String[] splt=Useful.split(heure,":");
			Time rep=new Time(Integer.parseInt(splt[0]),Integer.parseInt(splt[1]),Integer.parseInt(splt[2]));
			return rep;
		}
		catch(Exception e){
			throw new Exception("Time invalide");
		}

	}


    
    public static void main(String[] a) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception{
        //Useful.isValidDate(date, );
    }
}
