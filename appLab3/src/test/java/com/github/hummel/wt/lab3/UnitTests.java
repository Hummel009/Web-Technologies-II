package com.github.hummel.wt.lab3;

import com.github.hummel.wt.lab3.bean.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnitTests {
	@Test
	void testAuthor() {
		var author1 = new Author();
		author1.setId(1);
		author1.setName("1");
		author1.setImagePath("1");
		var author2 = Author.builder().id(1).name("1").imagePath("1").build();
		Assertions.assertEquals(author1, author2);
	}

	@Test
	void testBook() {
		var book1 = new Book();
		book1.setId(1);
		book1.setAuthor("1");
		book1.setName("1");
		book1.setImagePath("1");
		book1.setDescription("1");
		book1.setPrice(1);
		var book2 = Book.builder().id(1).author("1").name("1").imagePath("1").description("1").price(1).build();
		Assertions.assertEquals(book1, book2);
	}

	@Test
	void testOrder() {
		var order1 = new Order();
		order1.setId(1);
		order1.setPrice(1);
		order1.setUserId(1);
		order1.setBooks(null);
		order1.setDate(null);
		var order2 = Order.builder().id(1).price(1).userId(1).build();
		Assertions.assertEquals(order1, order2);
	}

	@Test
	void testRole() {
		var role1 = new Role();
		role1.setId(1);
		role1.setName("1");
		var role2 = Role.builder().id(1).name("1").build();
		Assertions.assertEquals(role1, role2);
	}

	@Test
	void testUser() {
		var user1 = new User();
		user1.setName("1");
		user1.setLastName("1");
		user1.setEmail("1");
		user1.setPassword("1");
		user1.setAddress("1");
		user1.setPhoneNumber("1");
		user1.setFavouriteAuthor("1");
		user1.setOrdersQuantity(1);
		user1.setBooksQuantity(1);
		user1.setBanned(1);
		user1.setId(1);
		user1.setBalance(1);
		user1.setBirthDate(null);
		user1.setRegistrationDate(null);
		user1.setOrders(null);
		user1.setRoles(null);
		var user2 = User.builder().id(1).name("1").lastName("1").email("1").password("1").address("1").phoneNumber("1").banned(1).balance(1).favouriteAuthor("1").ordersQuantity(1).booksQuantity(1).build();
		Assertions.assertEquals(user1, user2);
	}
}
