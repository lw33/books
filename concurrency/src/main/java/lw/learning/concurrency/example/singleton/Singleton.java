package lw.learning.concurrency.example.singleton;

public class Singleton {

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE.getSingleton();
    }

    private void java() {
        System.out.println("Singleton.java");
    }

    private Singleton() {
    }

    private enum SingletonHolder {
        INSTANCE;
        private Singleton singleton;

        SingletonHolder() {
            singleton = new Singleton();
        }

        public Singleton getSingleton() {
            return singleton;
        }
    }

    class S extends Singleton{
        void java() {

        }
    }
}
