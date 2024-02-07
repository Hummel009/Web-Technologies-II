package com.github.hummel.wt.exam.service.impl;

import com.github.hummel.wt.exam.bean.User;
import com.github.hummel.wt.exam.dao.FileDao;
import com.github.hummel.wt.exam.factory.DaoFactory;
import com.github.hummel.wt.exam.service.XmlService;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class DomServiceImpl implements XmlService {
	private final FileDao fileDao = DaoFactory.INSTANCE.getFileDao();

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

				var user = new User(name, age);

				listUsers.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listUsers;
	}
}