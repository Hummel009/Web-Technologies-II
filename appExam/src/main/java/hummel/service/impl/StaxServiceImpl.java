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
	private final FileDao fileDao = DaoFactory.INSTANCE.getFileDao();

	@Override
	public List<User> getUsers() {
		List<User> listUsers = new ArrayList<>();
		try {
			var xmlInputFactory = XMLInputFactory.newInstance();
			var fileInputStream = fileDao.getFileInputStream("data.xml");
			var xmlStreamReader = xmlInputFactory.createXMLStreamReader(fileInputStream);

			String currentElement = null;
			var tempName = "";
			var tempAge = "";

			while (xmlStreamReader.hasNext()) {
				var event = xmlStreamReader.next();
				switch (event) {
					case XMLStreamConstants.START_ELEMENT -> currentElement = xmlStreamReader.getLocalName();
					case XMLStreamConstants.CHARACTERS -> {
						var text = xmlStreamReader.getText().trim();
						if (currentElement != null) {
							if ("name".equals(currentElement)) {
								if (tempName.length() < 2) {
									tempName = text;
								}
							} else if ("age".equals(currentElement)) {
								if (tempAge.length() < 2) {
									tempAge = text;
								}
							}
						}
						if (!(tempName.length() < 2) && !(tempAge.length() < 2)) {
							var user = new User(tempName, tempAge);
							tempName = "";
							tempAge = "";
							listUsers.add(user);
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