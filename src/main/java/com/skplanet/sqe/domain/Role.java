package com.skplanet.sqe.domain;

public enum Role {

	Admin("Admin", null), Seller("Seller", Admin), Buyer("Buyer", Seller);

	private final String value;

	private Role nextLevel;

	Role(String value, Role nextLevel) {
		this.value = value;
		this.nextLevel = nextLevel;
	}

	public String getValue() {
		return this.value;
	}

	public Role nextLevel() {
		return this.nextLevel;
	}

	public static Role fromString(String value) {
		if (value != null) {
			for (Role r : Role.values()) {
				if (value.equalsIgnoreCase(r.value)) {
					return r;
				}
			}
		}
		return null;
	}

}
