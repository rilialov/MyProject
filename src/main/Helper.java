package main;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class Helper {

    private static Form form;

    private static final String XML_OUT = "C:\\Java\\form.xml";
    private static final String XML_IN = "C:\\Java\\info.xml";

    public Helper() {
    }

    public Form getForm() {
        return form;
    }

    public void saveToXML(Form form) {
        try {
            JAXBContext context = JAXBContext.newInstance(Form.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File outFile = new File(XML_OUT);
            m.marshal(form, outFile);
        } catch (Exception e) {
            System.err.println("Error: problems in saveToXML()");
        }
    }

    public void readFromXML() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Form.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            form = (Form) un.unmarshal(new File(XML_IN));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
