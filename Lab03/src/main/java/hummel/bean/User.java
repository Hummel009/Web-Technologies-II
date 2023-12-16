package hummel.bean;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "birthDate")
	private LocalDate birthDate;

	@Column(name = "registrationDate")
	private LocalDate registrationDate;

	@Column(name = "balance")
	private double balance;

	@Column(name = "password")
	private String password;

	@Column(name = "address")
	private String address;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	@Column(name = "banned")
	private int banned;

	@Transient
	private List<Order> orders;

	@Transient
	private List<Role> roles;

	@Transient
	private int ordersQuantity;

	@Transient
	private int booksQuantity;

	@Transient
	private String favouriteAuthor;

	public static Builder builder() {
		return new Builder();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		var other = (User) obj;
		return Objects.equals(id, other.id);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getBanned() {
		return banned;
	}

	public void setBanned(int banned) {
		this.banned = banned;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthDateFormatted() {
		var formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", new java.util.Locale("ru"));
		return birthDate.format(formatter);
	}

	public int getBooksQuantity() {
		return booksQuantity;
	}

	public void setBooksQuantity(int booksQuantity) {
		this.booksQuantity = booksQuantity;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFavouriteAuthor() {
		return favouriteAuthor;
	}

	public void setFavouriteAuthor(String favouriteAuthor) {
		this.favouriteAuthor = favouriteAuthor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public int getOrdersQuantity() {
		return ordersQuantity;
	}

	public void setOrdersQuantity(int ordersQuantity) {
		this.ordersQuantity = ordersQuantity;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRegisterDateFormatted() {
		var formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", new java.util.Locale("ru"));
		return registrationDate.format(formatter);
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	public boolean hasRole(String role) {
		for (var r : roles) {
			if (r.getName().equals(role)) {
				return true;
			}
		}
		return false;
	}

	public static class Builder {
		private User instance = new User();

		public Builder address(String address) {
			instance.address = address;
			return this;
		}

		public Builder balance(double balance) {
			instance.balance = balance;
			return this;
		}

		public Builder favouriteAuthor(String favouriteAuthor) {
			instance.favouriteAuthor = favouriteAuthor;
			return this;
		}

		public Builder ordersQuantity(int ordersQuantity) {
			instance.ordersQuantity = ordersQuantity;
			return this;
		}

		public Builder booksQuantity(int booksQuantity) {
			instance.booksQuantity = booksQuantity;
			return this;
		}

		public Builder banned(int banned) {
			instance.banned = banned;
			return this;
		}

		public Builder birthDate(LocalDate birthDate) {
			instance.birthDate = birthDate;
			return this;
		}

		public User build() {
			return instance;
		}

		public Builder email(String email) {
			instance.email = email;
			return this;
		}

		public Builder id(int id) {
			instance.id = id;
			return this;
		}

		public Builder lastName(String lastName) {
			instance.lastName = lastName;
			return this;
		}

		public Builder name(String name) {
			instance.name = name;
			return this;
		}

		public Builder orders(List<Order> orders) {
			instance.orders = orders;
			return this;
		}

		public Builder password(String password) {
			instance.password = password;
			return this;
		}

		public Builder phoneNumber(String phoneNumber) {
			instance.phoneNumber = phoneNumber;
			return this;
		}

		public Builder registrationDate(LocalDate registrationDate) {
			instance.registrationDate = registrationDate;
			return this;
		}

		public Builder roles(List<Role> roles) {
			instance.roles = roles;
			return this;
		}
	}
}