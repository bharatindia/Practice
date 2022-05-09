package design_patterns;

class SingletonEager {
    private static final SingletonEager mInstance = new SingletonEager();

    private SingletonEager() {

    }

    public static SingletonEager getInstance() {
        return mInstance;
    }
}

class Singleton {
    private static Singleton mInstance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (mInstance == null) {
            mInstance = new Singleton();
        }
        return mInstance;
    }
}

class SingletonSynchronizedMethod {
    private static SingletonSynchronizedMethod mInstance;

    private SingletonSynchronizedMethod() {

    }

    public static synchronized SingletonSynchronizedMethod getInstance() {
        if (mInstance == null) {
            mInstance = new SingletonSynchronizedMethod();
        }
        return mInstance;
    }
}

class SingletonSynchronizedBlock {
    private static SingletonSynchronizedBlock mInstance;

    private SingletonSynchronizedBlock() {

    }

    public static SingletonSynchronizedBlock getInstance() {
        if (mInstance == null) {
            synchronized (SingletonSynchronizedMethod.class) {
                mInstance = new SingletonSynchronizedBlock();
            }
        }
        return mInstance;
    }
}

public class SingletonExample {
    public static void main(String[] args) {
        //Singleton Eager
        System.out.println(SingletonEager.getInstance());
        System.out.println(SingletonEager.getInstance());

        //Normal Singleton
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance()
        );

        //Singleton Synchronized Method
        System.out.println(SingletonSynchronizedMethod.getInstance());
        System.out.println(SingletonSynchronizedMethod.getInstance());

        //Singleton Synchronized Method
        System.out.println(SingletonSynchronizedBlock.getInstance());
        System.out.println(SingletonSynchronizedBlock.getInstance());
    }
}
