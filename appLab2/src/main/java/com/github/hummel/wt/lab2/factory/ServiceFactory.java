package com.github.hummel.wt.lab2.factory;

import com.github.hummel.wt.lab2.service.*;
import com.github.hummel.wt.lab2.service.impl.*;

public final class ServiceFactory {
	public static final ServiceFactory INSTANCE = new ServiceFactory();

	private final AdminService adminService = new AdminServiceImpl();
	private final CartService cartService = new CartServiceImpl();
	private final AuthorService authorService = new AuthorServiceImpl();
	private final IndexService indexService = new IndexServiceImpl();
	private final LoginService loginService = new LoginServiceImpl();
	private final BookService bookService = new BookServiceImpl();
	private final ProfileService profileService = new ProfileServiceImpl();
	private final RegistrationService registrationService = new RegistrationServiceImpl();

	private ServiceFactory() {
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public AuthorService getAuthorService() {
		return authorService;
	}

	public BookService getBookService() {
		return bookService;
	}

	public CartService getCartService() {
		return cartService;
	}

	public IndexService getIndexService() {
		return indexService;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public RegistrationService getRegistrationService() {
		return registrationService;
	}
}