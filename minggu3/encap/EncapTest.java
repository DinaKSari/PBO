package encap;
public class EncapTest {
    public static void main(String[] args) {
        EncapDemo encap = new EncapDemo();
        encap.setName("James");
        encap.setAge(35);
        encap.setAge(17);
        encap.setAge(25);
        System.out.println("Name : "+ encap.getName());
        System.out.println("Age : "+ encap.getAge());
    }
}
