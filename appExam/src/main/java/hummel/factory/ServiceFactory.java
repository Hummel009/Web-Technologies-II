package hummel.factory;

import hummel.service.XmlService;
import hummel.service.impl.DomServiceImpl;
import hummel.service.impl.SaxServiceImpl;
import hummel.service.impl.StaxServiceImpl;

public final class ServiceFactory {
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
