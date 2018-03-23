package com.ayl.gupao.homework.proxy_pattern.custom;


import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author AYL    3/21/2018 1:18 AM
 */
public class MyProxy {
    private static final String ln = "\r\n";

    public static Object newProxyInstance(MyClassLoader myClassLoader,
                                   Class<?>[] interfaces,
                                   MyInvocationHandler h){

        try {
            //1、动态生成源代码.java文件
            String src = generateSrc(interfaces);

            //2、Java文件输出磁盘
            String filepath = MyProxy.class.getResource("").getPath();
            filepath += File.separator +"$Proxy0.java";
            System.out.println("filepath:" + filepath  );
            File file = new File(filepath);

            FileOutputStream fos  = new FileOutputStream(file);
            fos.write(src.getBytes());
            fos.flush();
            fos.close();

            //3、把生成的.java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);
            Iterable iterable = manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager,null,null,null, iterable);
            task.call();
            System.out.println(".class called");
            //4、编译生成的.class文件加载到JVM中来
            Class proxyClass = myClassLoader.findClass("$Proxy0");
            Constructor constructor = proxyClass.getConstructor(MyInvocationHandler.class);

            //5、返回字节码重组以后的新的代理对象
            return constructor.newInstance(h);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces){
        StringBuilder sb = new StringBuilder();
        sb.append("package com.ayl.gupao.homework.proxy_pattern.custom;" + ln);
        sb.append("import com.ayl.gupao.homework.proxy_pattern.custom.MyInvocationHandler;" + ln);
        sb.append("import java.lang.reflect.Method;" + ln);
        sb.append("public class $Proxy0 implements "+ interfaces[0].getName() +"{" + ln);

        sb.append("private MyInvocationHandler h;"+ ln);

        sb.append("public $Proxy0(MyInvocationHandler h){" + ln);
        sb.append("this.h = h;" + ln);
        sb.append("}" + ln);

        for(Method m : interfaces[0].getMethods()){
            //考虑：如果方法有参数情况如何处理？
            sb.append("public " + m.getReturnType() + " " + m.getName() + "("+ getMethodargs(m) +") {" + ln);
            sb.append("try {" + ln);
            sb.append("Method m = " + interfaces[0].getName() +".class.getMethod(\"" + m.getName() + "\"," + getMethodArgsClasss(m) + ");" +ln);

            String args = "args";
            sb.append(getMethodArgsObjects(m,args));
            sb.append("h.invoke(this,m," + args + ");" + ln);
            sb.append("} catch (Throwable throwable) {\n" +
                    "        throwable.printStackTrace();\n" +
                    "    }"+ ln);
            sb.append("}" + ln);
        }

        sb.append("}" + ln);

        return sb.toString();
    }

    private static String getMethodargs(Method m){
        StringBuilder builder = new StringBuilder();
        Parameter[] parameters = m.getParameters();
        for (int i = 0; i < parameters.length; i++){
            builder.append(parameters[i].getType() + " " + parameters[i].getName() );
            if(i < parameters.length-1){
                builder.append(",");
            }
        }
        return builder.toString();
    }

    private static String getMethodArgsObjects(Method m, String argsObjectName){
        StringBuilder builder = new StringBuilder();
        builder.append("Object[] " + argsObjectName + " = {");

        Parameter[] parameters = m.getParameters();
        for (int i = 0; i < parameters.length; i++){
            builder.append(parameters[i].getName());
            if(i < parameters.length-1){
                builder.append(",");
            }
        }
        builder.append("};");
        return builder.toString();
    }

    private static String getMethodArgsClasss(Method m){
        StringBuilder builder = new StringBuilder();
        builder.append("new Class[]{");

        Parameter[] parameters = m.getParameters();
        for (int i = 0; i < parameters.length; i++){
            builder.append(parameters[i].getType() +".class");
            if(i < parameters.length-1){
                builder.append(",");
            }
        }
        builder.append("}");
        return builder.toString();
    }
}
