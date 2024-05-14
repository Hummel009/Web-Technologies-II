package com.github.hummel.wt.exam.factory;

import com.github.hummel.wt.exam.service.XmlService;
import com.github.hummel.wt.exam.service.impl.DomServiceImpl;
import com.github.hummel.wt.exam.service.impl.SaxServiceImpl;
import com.github.hummel.wt.exam.service.impl.StaxServiceImpl;

public class ServiceFactory {
	public static final ServiceFactory INSTANCE = new ServiceFactory();

	private final XmlService saxService = new SaxServiceImpl();
	private final XmlService staxService = new StaxServiceImpl();
	private final XmlService domService = new DomServiceImpl();

	private ServiceFactory() {
	}

	public XmlService getSaxService() {
		return saxService;
	}

	public XmlService getStaxService() {
		return staxService;
	}

	public XmlService getDomService() {
		return domService;
	}
}
