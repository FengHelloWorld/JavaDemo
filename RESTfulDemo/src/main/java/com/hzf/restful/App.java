package com.hzf.restful;

/**
 * Created by zf.huang on 2018.8.3
 */
public class App {


    public static void main(String[] args) {
        new ServiceThread().run();
    }

    // StopService 和 StartService
    // 发布成服务的时候使用
    // 但弄成服务时，需要注释掉main函数

    private static ServiceThread service = null;

    /**
     * 退出服务方法(该方法必须有参数 String [] args)
     */
    public static void StopService(String[] args) {
        System.out.println(service.getLocalTime() + "停止服务");
        service.setRunFlag(false);
    }

    /**
     * 启动服务方法(该方法必须有参数 String [] args)
     */
    public static void StartService(String[] args) {
        // 产生服务线程
        service = new ServiceThread();
        Thread thread = new Thread(service);
        System.out.println("\r\n" + service.getLocalTime() + "-----------启动服务-----------");
        try {
            // 将服务线程设定为用户线程，以避免StartService方法结束后线程退出
            thread.setDaemon(false);
            if (!thread.isDaemon()) {
                System.out.println(service.getLocalTime() + "成功设定线程为用户线程！");
            }
            // 启动服务线程
            thread.start();
        } catch (SecurityException se) {
            System.out.println(service.getLocalTime() + "线程类型设定失败！");
        }
    }


}
