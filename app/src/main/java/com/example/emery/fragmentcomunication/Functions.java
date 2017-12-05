package com.example.emery.fragmentcomunication;

import java.util.HashMap;

/**
 * Created by emery on 2017/12/5.
 */

public class Functions {
    private HashMap<String, FunctionNoParamAndResult> mFunctionNoParamAndResultHashMap;
    private HashMap<String, FunctionNoParamWithResult> mFunctionNoParamWithResultHashMap;
    private HashMap<String, FunctionWithParamNoResult> mFunctionWithParamNoResultHashMap;
    private static volatile Functions mFunctions;

    private Functions() {

    }

    public static Functions getInstance() {
        if (mFunctions == null) {
            synchronized (Functions.class) {
                if (mFunctions == null) {
                    mFunctions = new Functions();
                }
            }
        }
        return mFunctions;
    }

    public static abstract class Function {
        public String mFunctionName;

        public Function(String functionName) {
            this.mFunctionName = functionName;
        }
    }

    public void addFunction(FunctionNoParamAndResult function) {
        if (mFunctionNoParamAndResultHashMap == null) {
            mFunctionNoParamAndResultHashMap = new HashMap<>();
        }
        mFunctionNoParamAndResultHashMap.put(function.mFunctionName, function);
    }


    public void invokeFunction(String functionName) throws Exception {
        FunctionNoParamAndResult f = null;
        if (mFunctionNoParamAndResultHashMap != null) {
            f = mFunctionNoParamAndResultHashMap.get(functionName);
            if (f != null) {
                f.function();
            }

            if (f == null) {
                throw new Exception("can not execute:" + functionName);
            }
        }
    }

    public void addFunctionNPWR(FunctionNoParamWithResult function) {
        if (mFunctionNoParamWithResultHashMap == null) {
            mFunctionNoParamWithResultHashMap = new HashMap<>();
        }
        mFunctionNoParamWithResultHashMap.put(function.mFunctionName, function);
    }


    public <Result> Result invokeFunction(String functionName, Class<Result> clazz) throws
            Exception {
        FunctionNoParamWithResult f = null;
        if (mFunctionNoParamWithResultHashMap != null) {
            f = mFunctionNoParamWithResultHashMap.get(functionName);
            if (f != null) {
                if (clazz != null) {
                    return clazz.cast(f.function());
                }
                return (Result) f.function();
            }

            if (f == null) {
                throw new Exception("can not execute:" + functionName);
            }
        }
        return null;
    }


    public void addFunctionWPNR(FunctionWithParamNoResult function) {
        if (mFunctionWithParamNoResultHashMap == null) {
            mFunctionWithParamNoResultHashMap = new HashMap<>();
        }
        mFunctionWithParamNoResultHashMap.put(function.mFunctionName, function);
    }


    public <Param> void  invokeFunction(String functionName,Param parma) throws Exception {
        FunctionWithParamNoResult f = null;
        if (mFunctionWithParamNoResultHashMap != null) {
            f = mFunctionWithParamNoResultHashMap.get(functionName);
            if (f != null) {
                f.function(parma);
            }

            if (f == null) {
                throw new Exception("can not execute:" + functionName);
            }
        }
    }

    //没有参数没有返回值
    public static abstract class FunctionNoParamAndResult extends Function {

        public FunctionNoParamAndResult(String functionName) {
            super(functionName);
        }

        public abstract void function();
    }
    // 没有参数有返回值

    public static abstract class FunctionNoParamWithResult<Result> extends Function {
        public FunctionNoParamWithResult(String functionName) {
            super(functionName);
        }

        public abstract Result function();
    }

    // 有参数没有返回值

    public static abstract class FunctionWithParamNoResult<Params> extends Function{

        public FunctionWithParamNoResult(String functionName) {
            super(functionName);
        }
        public abstract void function(Params params);
    }
    // 有参数有返回值
}
