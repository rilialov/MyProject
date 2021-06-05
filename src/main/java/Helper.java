import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class Helper {

    private static Form form;

    public Helper() {
    }

    public Form getForm() {
        return form;
    }

    public void saveToXML(Form form, String path) {
        try {
            JAXBContext context = JAXBContext.newInstance(Form.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File outFile = new File(path);
            m.marshal(form, outFile);
        } catch (Exception e) {
            System.err.println("Error: problems in saveToXML()");
        }
    }

    public void readFromXML(File path) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Form.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            form = (Form) un.unmarshal(path);
        } catch (JAXBException e) {
            System.err.println("Error: problems in readFromXML()");
        }
    }

    public void saveToCSV (AppController controller, String path) {
        File file = new File(path);
        String string1 = "Course;Trainer;Date;First name;Last name;Phone;E-mail";
        String string2 = controller.getCourse() + ";" +
                controller.getTrainer() + ";" +
                controller.getDate() + ";" +
                controller.getFirstName() + ";" +
                controller.getLastName() + ";" +
                controller.getPhone() + ";" +
                controller.getEmail() + ";";
        String tmp = string1 + "\n" + string2;
        try {
            BufferedWriter bufWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "Cp1251"));
            bufWriter.write(tmp);
            bufWriter.close();
        } catch (IOException e) {
            System.err.println("Error: problems in saveToCSV()");
        }
    }
}
