package com.javarush.task.task22.task2201;

/* 
Строки нитей или строковые нити? Вот в чем вопрос
*/

/* protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) { return (e.getClass().getSimpleName() + " : " + e.getCause() + " : " + t.getName()); } protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) { return (e.getCause() + " : " + e.getClass().getSimpleName() + " : " + t.getName()); } protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) { return (t.getName() +" : "+ e.getClass().getSimpleName()+" : " + e.getCause()); }
*
*
* */
public class Solution {
    public static void main(String[] args) throws Exception {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new ThisUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) {
        String result;
        try {
            result = string.substring(string.indexOf("\t") + 1, string.lastIndexOf("\t"));
        } catch (StringIndexOutOfBoundsException e) {
            switch (threadName) {
                case FIRST_THREAD_NAME:
                    throw new TooShortStringFirstThreadException();
                case SECOND_THREAD_NAME:
                    throw new TooShortStringSecondThreadException();
                default:
                    throw new RuntimeException(e);
            }
        }
        return result;
    }

    class RuntimeExe extends RuntimeException {
    }
}