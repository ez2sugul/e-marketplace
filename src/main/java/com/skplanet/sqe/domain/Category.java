package com.skplanet.sqe.domain;

public enum Category {

	Fashion("Fashion"), Beauty("Beauty"), Electronics("Electronics"), Foods("Foods"), Furniture("Funiture"), Books(
			"Books"), Tickets("Tickets"), Tour("Tour"), Etc("Etc");

	private final String value;

	Category(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static Category fromString(String value) {
		if (value != null) {
			for (Category c : Category.values()) {
				if (value.equalsIgnoreCase(c.value)) {
					return c;
				}
			}
		}
		return null;
	}

}
