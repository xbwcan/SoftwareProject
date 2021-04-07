package Model;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class IO_for_Client {
    private final Element root;
    private final Document doc;

    public IO_for_Client() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        String url = ".\\Data\\Client\\Client.xml";
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
    public Client Read(String name) throws XPathExpressionException {
        Client client = new Client();
        NodeList children = root.getChildNodes();
        for(int i=0;i<children.getLength();i++)
        {
            Node child = children.item(i);
            XPathFactory xpathfactory = XPathFactory.newInstance();
            XPath path = xpathfactory.newXPath();
            String flg = path.evaluate("/Client["+i+"]/Phone_Number/text()",doc);
            if(!flg.equals(name))
            {
                break;
            }
            else
            {
                NodeList grandchildren =child.getChildNodes();
                for(int j=0;j<grandchildren.getLength();j++)
                {
                    Node grandchild = grandchildren.item(j);
                    if(child instanceof Element)
                    {
                        var childElement = (Element) grandchild;


                        switch (childElement.getTagName().trim())
                        {
                            case "Name":    {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setName(text);
                            }
                            case "Phone_Number":
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setPhone_number(text);
                            }
                            case "E_mail":
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setEmail(text);
                            }
                            case "Height":
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setHeight(Integer.parseInt(text));
                            }
                            case "Weight":
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setWeight(Integer.parseInt(text));
                            }
                            case "BMI":
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setBMI(Integer.parseInt(text));
                            }
                            case "Fatty_Lipase":
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setFatty_Lipase(Integer.parseInt(text));
                            }
                            case "sex":
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setSex(text);
                            }
                            case "Age":
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setAge(Integer.parseInt(text));
                            }
                            case "Rank":
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setRank(Integer.parseInt(text));
                            }
                            case "State":
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setState(text);
                            }
                            case "Rank_Start_Time":
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setRank_Start_Time(Long.parseLong(text));
                            }
                            case "Rank_End_Time":
                            {
                                var textNode = (Text)grandchild.getFirstChild();
                                String text =textNode.getData().trim();
                                client.setRank_End_Time(Long.parseLong(text));
                            }
                            case "My_Classes" :
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
                                        client.addClasses(io.read(text));
                                    }
                                }
                            }
                            case "My_Live" :
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
                                        client.addClasses(io.read(text));
                                    }
                                }
                            }
                            case "Generic_Plan" :
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
                                        client.addClasses(io.read(text));
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
    public int Update(String name,String tag, String text)
    {
        return 0;
    }
}
