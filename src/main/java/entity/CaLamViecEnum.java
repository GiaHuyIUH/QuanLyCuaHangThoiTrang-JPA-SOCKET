package entity;

public enum CaLamViecEnum {
	CA_1("Ca 1"), CA_2("Ca 2");

	private String name;

	private CaLamViecEnum(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
