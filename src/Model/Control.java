package Model;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.ArrayList;

public class Control {
    public Control()
    {

    }
    public ArrayList<Class> ShowAllClasses() throws IOException, ParserConfigurationException, SAXException {
        IO_for_Class io =new IO_for_Class();
        return io.ShowAllClasses();
    }
    public ArrayList<Live> ShowAllLives() throws IOException, ParserConfigurationException, SAXException {
        IO_for_Live io = new IO_for_Live();
        return io.ShowAllLives();
    }
    public Client ReadClient(String id) throws XPathExpressionException, ParserConfigurationException, IOException, SAXException {
        IO_for_Client io = new IO_for_Client();
        return io.Read(id);
    }
    public int AddClass(String userid, String id) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        IO_for_Client io1 = new IO_for_Client();
        Client user = io1.Read(userid);
        IO_for_Class io2 =new IO_for_Class();
        user.addClasses(io2.Read(id));
        return io1.Update(userid,user);
    }
}
