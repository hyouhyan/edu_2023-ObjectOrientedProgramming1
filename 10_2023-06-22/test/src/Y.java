public class Y implements AutoCloseable {
    public void doIt() {
        System.out.println("Y.doIt()");
    }
    public void close() throws Exception {
        System.out.println("closing Y");
    }
}