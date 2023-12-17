package hummel.service.impl;

import hummel.bean.User;
import hummel.dao.FileDao;
import hummel.factory.DaoFactory;
import hummel.service.XmlService;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SaxServiceImpl implements XmlService {
	public FileDao fileDao = DaoFactory.INSTANCE.getFileDao();

	@Override
	public List<User> getUsers() {
		try {
			List<User> listUsers = new ArrayList<>();
			var factory = SAXParserFactory.newInstance();
			var saxParser = factory.newSAXParser();
			var file = fileDao.getFile("data.xml");
			var handler = new HummelSaxHandler(listUsers);
			saxParser.parse(file, handler);
			return listUsers;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static class HummelSaxHandler extends DefaultHandler {
		private List<User> listUsers;
		private User temp = new User();
		private Type type = Type.NULL;

		public HummelSaxHandler(List<User> listUsers) {
			this.listUsers = listUsers;
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) {
			type = switch (qName.toLowerCase(Locale.ROOT)) {
				case "name" -> Type.NAME;
				case "age" -> Type.AGE;
				default -> Type.NULL;
			};
		}

		@Override
		public void characters(char[] ch, int start, int length) {
			switch (type) {
				case NAME -> {
					if (temp.getName().length() < 2) {
						temp.setName(new String(ch, start, length));
					}
					type = Type.NULL;
				}
				case AGE -> {
					if (temp.getAge().length() < 2) {
						temp.setAge(new String(ch, start, length));
					}
					type = Type.NULL;
				}
				case NULL -> {
				}
			}
			if (!(temp.getName().length() < 2) && !(temp.getAge().length() < 2)) {
				listUsers.add(temp);
				temp = new User();
			}
		}
	}

	public enum Type {
		NAME, AGE, NULL
	}
}