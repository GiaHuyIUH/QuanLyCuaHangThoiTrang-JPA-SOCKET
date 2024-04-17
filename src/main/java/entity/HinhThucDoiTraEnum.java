package entity;

public enum HinhThucDoiTraEnum {
	HOANTRA("Hoan Tra"), DOIMOI("Doi Moi");

	private String name;

	private HinhThucDoiTraEnum(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
