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
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}
		ProgrammingBook that = (ProgrammingBook) o;
		return level == that.level && Objects.equals(language, that.language);
	}

	@Override
	public String toString() {
		return "ProgrammingBook{" + "language='" + language + '\'' + ", level=" + level + '}';
	}
}
