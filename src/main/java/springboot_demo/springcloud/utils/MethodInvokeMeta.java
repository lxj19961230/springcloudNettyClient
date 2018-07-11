package springboot_demo.springcloud.utils;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 记录调用方法的元信息
 * Created by 叶云轩 on 2017/6/7-15:41
 * Concat tdg_yyx@foxmail.com
 */
@Component
public class MethodInvokeMeta implements Serializable {

	private static final long serialVersionUID = 8379109667714148890L;
    //接口
    private Class<?> interfaceClass;
    //方法名
    private String methodName;
    //参数
    private Object[] args;
    //返回值类型
    private Class<?> returnType;
    //参数类型
    private Class<?>[] parameterTypes;

    public MethodInvokeMeta(Object obj) {
    	this.interfaceClass = obj.getClass();
    	this.methodName = obj.getClass().getName();
	}

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public Class<?> getInterfaceClass() {
        return interfaceClass;
    }

    public void setInterfaceClass(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Class getReturnType() {
        return returnType;
    }

    public void setReturnType(Class returnType) {
        this.returnType = returnType;
    }
    
    public MethodInvokeMeta(Class<?> interfaceClass, String methodName, Object[] args, Class<?> returnType,
			Class<?>[] parameterTypes) {
		super();
		this.interfaceClass = interfaceClass;
		this.methodName = methodName;
		this.args = args;
		this.returnType = returnType;
		this.parameterTypes = parameterTypes;
	}

	public MethodInvokeMeta() {
		super();
	}

}
