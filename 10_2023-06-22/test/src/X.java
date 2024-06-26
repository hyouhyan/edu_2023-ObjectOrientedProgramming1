public class X implements AutoCloseable {
    public void doIt() throws Exception {
        System.out.println("X.doIt");
        throw new Exception();
    }
    public void close() throws Exception {
        System.out.println("closing X");
    }
}