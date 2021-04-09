package Model;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;

public class IO_for_Client {
    private final Element root;
    private final Document doc;

    public IO_for_Client() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        String url = "src\\Data\\Client.xml";
        File f = new File(url);
        doc = builder.parse(f);
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
    public  Client Read(String id) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
        Client client = new Client();
        NodeList children = root.getChildNodes();
        for(int i=0;i<children.getLength();i++)
        {
            Node child = children.item(i);


            if(child instanceof Element)
            {
                var childElement = (Element) child;
                String ID = childElement.getAttribute("id");
                if (!ID.equals(id))
                    continue;
                client.setId(id);
                NodeList grandchildren =child.getChildNodes();
                for(int j=0;j<grandchildren.getLength();j++)
                {
                    Node grandchild = grandchildren.item(j);
                    if(grandchild instanceof Element)
                    {
                        var grandchildElement = (Element) grandchild;


                        switch (grandchildElement.getTagName().trim())
                        {
                            case "Name"->    {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setName(text);
                            }
                            case "Phone_Number"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setPhone_number(text);
                            }
                            case "E_mail"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setEmail(text);
                            }
                            case "Height"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setHeight(Integer.parseInt(text));
                            }
                            case "Weight"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setWeight(Integer.parseInt(text));
                            }
                            case "BMI"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setBMI(Integer.parseInt(text));
                            }
                            case "Fatty_Lipase"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setFatty_Lipase(Integer.parseInt(text));
                            }
                            case "sex"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setSex(text);
                            }
                            case "Age"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setAge(Integer.parseInt(text));
                            }
                            case "Rank"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setRank(Integer.parseInt(text));
                            }
                            case "State"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setState(text);
                            }
                            case "Rank_Start_Time"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setRank_Start_Time(Long.parseLong(text));
                            }
                            case "Rank_End_Time"->
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setRank_End_Time(Long.parseLong(text));
                            }
                            case "My_Classes" ->
                            {
                                NodeList great_grandchildren = grandchild.getChildNodes();
                                for(int k=0;j<great_grandchildren.getLength();k++)
                                {
                                    Node great_grandchild = great_grandchildren.item(j);
                                    if( great_grandchild instanceof Element)
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text = textNode.getData().trim();
                                        IO_for_Class io = new IO_for_Class();
                                        client.addClasses(io.Read(text));
                                    }
                                }
                            }
                            case "My_Live"  ->
                            {
                                NodeList great_grandchildren = grandchild.getChildNodes();
                                for(int k=0;j<great_grandchildren.getLength();j++)
                                {
                                    Node great_grandchild = great_grandchildren.item(j);
                                    if( great_grandchild instanceof Element)
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text = textNode.getData().trim();
                                        IO_for_Live io = new IO_for_Live();
                                        client.addLives(io.Read(text));
                                    }
                                }
                            }
                            case "Generic_Plan" ->
                            {
                                NodeList great_grandchildren = grandchild.getChildNodes();
                                for(int k=0;k<great_grandchildren.getLength();k++)
                                {
                                    Node great_grandchild = great_grandchildren.item(j);
                                    if( great_grandchild instanceof Element)
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text = textNode.getData().trim();
                                        IO_for_Generic_Plan io = new IO_for_Generic_Plan();
                                        client.addGeneric_Plan(io.Read(text));
                                    }
                                }
                            }
                        }
                    }
                }

            }


        }

        return client;
    }
    public int Update(String id,Client client) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        NodeList children = root.getChildNodes();
        for(int i=0;i<children.getLength();i++)
        {
            Node child = children.item(i);


            if(child instanceof Element)
            {
                var childElement = (Element) child;
                String ID = childElement.getAttribute("id");
                if (!ID.equals(id))
                    continue;
                NodeList grandchildren =child.getChildNodes();
                for(int j=0;j<grandchildren.getLength();j++)
                {
                    Node grandchild = grandchildren.item(j);
                    if(grandchild instanceof Element)
                    {
                        var grandchildElement = (Element) grandchild;


                        switch (grandchildElement.getTagName().trim())
                        {
                            case "Name"->    {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setName(text);
                            }
                            case "Phone_Number"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setPhone_number(text);
                                    }
                            case "E_mail"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setEmail(text);
                                    }
                            case "Height"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setHeight(Integer.parseInt(text));
                                    }
                            case "Weight"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setWeight(Integer.parseInt(text));
                                    }
                            case "BMI"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setBMI(Integer.parseInt(text));
                                    }
                            case "Fatty_Lipase"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setFatty_Lipase(Integer.parseInt(text));
                                    }
                            case "sex"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setSex(text);
                                    }
                            case "Age"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setAge(Integer.parseInt(text));
                                    }
                            case "Rank"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setRank(Integer.parseInt(text));
                                    }
                            case "State"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setState(text);
                                    }
                            case "Rank_Start_Time"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setRank_Start_Time(Long.parseLong(text));
                                    }
                            case "Rank_End_Time"->
                                    {
                                        var textNode = (Text)grandchild.getFirstChild();
                                        String text =textNode.getData().trim();
                                        client.setRank_End_Time(Long.parseLong(text));
                                    }
                            case "My_Classes" ->
                                    {
                                        /*NodeList great_grandchildren = grandchild.getChildNodes();
                                        for(int k=0;j<great_grandchildren.getLength();k++)
                                        {
                                            Node great_grandchild = great_grandchildren.item(j);
                                            if( great_grandchild instanceof Element)
                                            {
                                                var textNode = (Text)grandchild.getFirstChild();
                                                String text = textNode.getData().trim();
                                                IO_for_Class io = new IO_for_Class();
                                                client.addClasses(io.Read(text));

                                            }
                                        }*/
                                        IO_for_Client io1 = new IO_for_Client();
                                        Client client1 = new Client();
                                        client1 = io1.Read(client1.getId());
                                        for(int k=0;k<client.My_Classes.size();k++)
                                        {
                                            if(!client1.My_Classes.contains(client.getAClass(k)))
                                            {
                                                Text textnode = doc.createTextNode(client.getAClass(k).id);
                                                Node great_grandchild = grandchildElement.appendChild(textnode);
                                                var great_grandchildELement = (Element) great_grandchild;
                                                great_grandchildELement.setAttribute("id",client.getAClass(k).id);
                                            }
                                        }
                                    }
                            case "My_Live"  ->
                                    {
                                        IO_for_Client io1 = new IO_for_Client();
                                        Client client1 = new Client();
                                        client1 = io1.Read(client1.getId());
                                        for(int k=0;k<client.My_Lives.size();k++)
                                        {
                                            if(!client1.My_Lives.contains(client.getALive(k)))
                                            {
                                                Text textnode = doc.createTextNode(client.getALive(k).id);
                                                Node great_grandchild = grandchildElement.appendChild(textnode);
                                                var great_grandchildELement = (Element) great_grandchild;
                                                great_grandchildELement.setAttribute("id",client.getAClass(k).id);
                                            }
                                        }
                                    }
                            case "Generic_Plan" ->
                                    {
                                        NodeList great_grandchildren = grandchild.getChildNodes();
                                        for(int k=0;k<great_grandchildren.getLength();k++)
                                        {
                                            Node great_grandchild = great_grandchildren.item(j);
                                            if( great_grandchild instanceof Element)
                                            {
                                                var textNode = (Text)grandchild.getFirstChild();
                                                String text = textNode.getData().trim();
                                                IO_for_Generic_Plan io = new IO_for_Generic_Plan();
                                                client.addGeneric_Plan(io.Read(text));
                                            }
                                        }
                                    }
                        }
                    }
                }

            }


        }
        return 0;
    }
}
