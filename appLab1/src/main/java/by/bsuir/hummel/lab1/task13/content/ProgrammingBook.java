package by.bsuir.hummel.lab1.task13.content;

import java.util.Objects;

public class ProgrammingBook extends Book {
	private String language;
	private int level;

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), language, level);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		if (!super.equals(obj)) {
			return false;
		}
		var programmingBook = (ProgrammingBook) obj;
		return level == programmingBook.level && Objects.equals(language, programmingBook.language);
	}

	@Override
	public String toString() {
		return "ProgrammingBook{" + "language='" + language + '\'' + ", level=" + level + '}';
	}
}
