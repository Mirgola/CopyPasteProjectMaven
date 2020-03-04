import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyPaste {
    private static PathAddress pathAddress = new PathAddress();

    public static void main(String[] args) throws Exception {
        pathAddress.newPath();

        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            public void configure() throws Exception {
                from("file:" + pathAddress.getPathNameIn() + "?noop=true").to("file:" + pathAddress.getPathNameOut());
            }
        });
        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}
