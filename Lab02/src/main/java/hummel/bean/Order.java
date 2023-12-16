package hummel.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Order {
	private int id;
	private LocalDate date;
	private List<Book> books;
	private int userId;
	private double price;

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
		var other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDateFormatted() {
		var formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("ru"));
		return date.format(formatter);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	public static class Builder {
		private Order instance = new Order();

		public Builder books(List<Book> books) {
			instance.books = books;
			return this;
		}

		public Order build() {
			return instance;
		}

		public Builder date(LocalDate date) {
			instance.date = date;
			return this;
		}

		public Builder id(int id) {
			instance.id = id;
			return this;
		}

		public Builder price(double price) {
			instance.price = price;
			return this;
		}

		public Builder userId(int userId) {
			instance.userId = userId;
			return this;
		}
	}
}