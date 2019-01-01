package books.zeroD.chapter2.serialize;

/**
 * @Author lw
 * @Date 2019-01-01 14:59:25
 **/
public class Test {

    public static void main(String[] args) {
        DefaultJavaSerializer defaultJavaSerializer = new DefaultJavaSerializer();
        User user = new User("java", 23, "man");
        System.out.println("\n[Original] =========================================================\n");
        System.out.println(user);
        test(user, new DefaultJavaSerializer());
        test(user, new XmlSerializer());
        test(user, new XML2Serializer());
        test(user, new JsonSerializer());
        test(user, new HessianSerializer());
    }

    public static void test(User user, ISerializer serializer) {
        String name = serializer.getClass().getSimpleName();
        System.out.println("\n[" + name + "] =========================================================\n");
        byte[] serialize = serializer.serialize(user);
        User deserialize = serializer.deserialize(serialize, User.class);
        System.out.println(deserialize);
    }

     /* public static void main(String[] args) {

        DefaultJavaSerializer defaultJavaSerializer = new DefaultJavaSerializer();
        User user = new User("java", 23, "man");
        System.out.println("\nOriginal =========================================================\n");
        System.out.println(user);
        System.out.println("\nJava Default =========================================================\n");
        byte[] serialize = defaultJavaSerializer.serialize(user);
        User deserialize = defaultJavaSerializer.deserialize(serialize, User.class);
        System.out.println(deserialize);
        System.out.println("\nXML =========================================================\n");

        XmlSerializer xmlSerializer = new XmlSerializer();
        byte[] xmlData = xmlSerializer.serialize(user);
        User xmlUser = xmlSerializer.deserialize(xmlData, User.class);
        System.out.println(xmlUser);
        System.out.println("\nXML2 =========================================================\n");
        XML2Serializer xml2Serializer = new XML2Serializer();
        byte[] xml2Data = xml2Serializer.serialize(user);
        User xml2User = xml2Serializer.deserialize(xml2Data, User.class);
        System.out.println(xml2User);
    }
*/
}
