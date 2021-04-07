package Model;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class IO_for_Client {
    private final Element root;


    public IO_for_Client(String url) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File f = new File(url);
        Document doc = builder.parse(f);
        root = doc.getDocumentElement();
    }
    public int Create(Client client)
    {

        return 0;
    }
    public int Delete(String name)
    {
        return 0;
    }
    public Client Read(String name)
    {
        Client client = new Client();
        NodeList children = root.getChildNodes();
        for(int i=0;i<children.getLength();i++)
        {
            Node child = children.item(i);
            if(child instanceof Element)
            {
                var childElement = (Element) child;


                switch (childElement.getTagName().trim())
                {
                    case "Name":    {
                        var textNode = (Text)child.getFirstChild();
                        String text =textNode.getData().trim();
                        client.setName(text);
                    }
                    case "Phone_Number":
                    {
                        var textNode = (Text)child.getFirstChild();
                        String text =textNode.getData().trim();
                        client.setPhone_number(text);
                    }
                    case "E_mail":
                    {
                        var textNode = (Text)child.getFirstChild();
                        String text =textNode.getData().trim();
                        client.setEmail(text);
                    }
                    case "Height":
                    {
                        var textNode = (Text)child.getFirstChild();
                        String text =textNode.getData().trim();
                        client.setHeight(Integer.parseInt(text));
                    }
                    case "Weight":
                    {
                        var textNode = (Text)child.getFirstChild();
                        String text =textNode.getData().trim();
                        client.setWeight(Integer.parseInt(text));
                    }
                    case "BMI":
                    {
                        var textNode = (Text)child.getFirstChild();
                        String text =textNode.getData().trim();
                        client.setBMI(Integer.parseInt(text));
                    }
                    case "Phone_Number":
                    {
                        var textNode = (Text)child.getFirstChild();
                        String text =textNode.getData().trim();
                        client.setPhone_number(text);
                    }
                    case "Phone_Number":
                    {
                        var textNode = (Text)child.getFirstChild();
                        String text =textNode.getData().trim();
                        client.setPhone_number(text);
                    }
                    case "Phone_Number":
                    {
                        var textNode = (Text)child.getFirstChild();
                        String text =textNode.getData().trim();
                        client.setPhone_number(text);
                    }
                    case "Phone_Number":
                    {
                        var textNode = (Text)child.getFirstChild();
                        String text =textNode.getData().trim();
                        client.setPhone_number(text);
                    }
                    case "Phone_Number":
                    {
                        var textNode = (Text)child.getFirstChild();
                        String text =textNode.getData().trim();
                        client.setPhone_number(text);
                    }
                    case "Rank_Start_Time":
                    {


                    }
                    case "Rank_End_Time":
                    {

                    }
                    case "My_Classes" :
                    {

                    }
                }
            }

        }

        return client;
    }
    public int Update(String name,String tag, String text)
    {
        return 0;
    }
}
