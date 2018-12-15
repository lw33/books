package lw.learning.dp.pattern.creational.singleton;

public enum EnumInstance {
    INSTANCE{
        public void java() {
            System.out.println("EnumInstance.java");
        }
    };
    private Object data;

    //public abstract void java();
    public Object getData() {
        return data;
    }

    public void test() {
        System.out.println("EnumInstance.test");
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumInstance getInstance() {
        return INSTANCE;
    }
}
