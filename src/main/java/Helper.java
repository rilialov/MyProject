import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Helper {

    private static Form form;
    private final String USER_DIR = System.getProperty("user.dir");
    private static final Logger logger = LoggerFactory.getLogger(Helper.class);

    public Helper() {
    }

    public Form getForm() {
        return form;
    }

    public String getUSER_DIR() {
        return USER_DIR;
    }

    public void saveToXML(Form form, String path) {
        try {
            JAXBContext context = JAXBContext.newInstance(Form.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File outFile = new File(path);
            m.marshal(form, outFile);
        } catch (Exception e) {
            logger.error("Failed to write xml file.");
        }
    }

    public void readFromXML(File path) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Form.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            form = (Form) un.unmarshal(path);
        } catch (JAXBException e) {
            logger.error("Failed to read xml file.");
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
        try (BufferedWriter bufWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "Cp1251"))) {
            bufWriter.write(tmp);
        } catch (IOException e) {
            logger.error("Failed to write csv file.");
        }
    }
}
