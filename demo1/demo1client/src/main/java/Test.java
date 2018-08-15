import org.tempuri.Entrance;
import org.tempuri.GetAllConfiguration;

import javax.xml.bind.JAXBElement;

public class Test {

	public static void main(String[] args) {
		Entrance entrance = new Entrance();
		JAXBElement<String> value = entrance.getValue();
		System.out.println(value);


		GetAllConfiguration getAllConfiguration = new GetAllConfiguration();
		System.out.println(getAllConfiguration.getDbPath());
	}
}
