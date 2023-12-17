package hummel.service.impl;

import hummel.bean.User;
import hummel.dao.FileDao;
import hummel.factory.DaoFactory;
import hummel.service.XmlService;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import java.util.ArrayList;
import java.util.List;

public class StaxServiceImpl implements XmlService {
	public FileDao fileDao = DaoFactory.INSTANCE.getFileDao();

	@Override
	public List<User> getUsers() {
		List<User> listUsers = new ArrayList<>();
		try {
			XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
			var fileInputStream = fileDao.getFileInputStream("data.xml");
			var xmlStreamReader = xmlInputFactory.createXMLStreamReader(fileInputStream);

			String currentElement = null;
			var temp = new User();

			while (xmlStreamReader.hasNext()) {
				int event = xmlStreamReader.next();
				switch (event) {
					case XMLStreamConstants.START_ELEMENT -> currentElement = xmlStreamReader.getLocalName();
					case XMLStreamConstants.CHARACTERS -> {
						var text = xmlStreamReader.getText().trim();
						if (currentElement != null) {
							if ("name".equals(currentElement)) {
								if (temp.getName().length() < 2) {
									temp.setName(text);
								}
							} else if ("age".equals(currentElement)) {
								if (temp.getAge().length() < 2) {
									temp.setAge(text);
								}
							}
						}
						if (!(temp.getName().length() < 2) && !(temp.getAge().length() < 2)) {
							listUsers.add(temp);
							temp = new User();
						}
					}
					default -> {
					}
				}
			}

			xmlStreamReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listUsers;
	}
}