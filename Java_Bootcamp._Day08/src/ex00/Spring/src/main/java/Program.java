import display.Printer;
import display.PrinterWithPrefixImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        PrinterWithPrefixImpl printer = context.getBean("printerWithPrefix", PrinterWithPrefixImpl.class);

        printer.setPrefix("Aynur, ");
        printer.print("Hello!");

    }
}
