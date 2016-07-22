import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
public class UserInput 
{
   public static void main(String[] args)
   {
      try 
      {	
         File inputFile = new File("input.txt");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("\nRoot element: " + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("patient");
         System.out.println("-------------------");
             
         String n;
    	 Scanner in = new Scanner(System.in);
    	 System.out.println("Patient First Name \n(First letter should be upper case): ");
    	 n = in.nextLine();
    	 
    	 boolean foundEntry = false;
         for (int temp = 0; temp < nList.getLength(); temp++) 
         {
           Node nNode = nList.item(temp);
           Element eElement = (Element) nNode; 
           String xmlFirstname = eElement.getElementsByTagName("firstname").item(0).getTextContent();
      	   if  (n.equals(xmlFirstname))
           {
      		 System.out.println(n + "'s  medical record:");
      		 eElement.getAttribute("patient");
             System.out.println("ID: " + eElement.getElementsByTagName("identifier").item(0).getTextContent());
             System.out.println("First Name: " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
             System.out.println("Last Name: " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
             System.out.println("Telecom: " + eElement.getElementsByTagName("phone").item(0).getTextContent());
             System.out.println("Gender: " + eElement.getElementsByTagName("gender").item(0).getTextContent());
             foundEntry = true; 
           }
         }
           if(foundEntry == false)
           { 
        	   System.out.println(n + " is an invalid patient.");
           }
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}

