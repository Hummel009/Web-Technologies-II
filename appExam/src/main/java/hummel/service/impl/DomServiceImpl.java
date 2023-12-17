package hummel.service.impl;

import hummel.bean.User;
import hummel.dao.FileDao;
import hummel.factory.DaoFactory;
import hummel.service.XmlService;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class DomServiceImpl implements XmlService {
	public FileDao fileDao = DaoFactory.INSTANCE.getFileDao();

	@Override
	public List<User> getUsers() {
		List<User> listUsers = new ArrayList<>();
		try {
			var factory = DocumentBuilderFactory.newInstance();
			var builder = factory.newDocumentBuilder();
			var document = builder.parse(fileDao.getFileInputStream("data.xml"));

			var root = document.getDocumentElement();
			var personList = root.getElementsByTagName("person");

			for (var i = 0; i < personList.getLength(); i++) {
				var personElement = (Element) personList.item(i);

				var nameElement = personElement.getElementsByTagName("name").item(0);
				var name = nameElement.getTextContent();

				var ageElement = personElement.getElementsByTagName("age").item(0);
				var age = ageElement.getTextContent();

				var user = new User();
				user.setName(name);
				user.setAge(age);

				listUsers.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listUsers;
	}
}