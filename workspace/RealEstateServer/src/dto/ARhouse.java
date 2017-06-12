package dto;

public class ARhouse {
	//varchar : house_div, house_item, house_addr, agency, agency_phoneNum
	//int : house_id, area, price, floor
	//float : item_x, item_y
	
	private String house_div;
	private String house_item;
	private String house_addr;
	private String agency;
	private int house_id;
	private int area;
	private int price;
	private int floor;
	private float item_x;
	private float item_y;
	private String agency_phoneNum;
	
	public ARhouse(){	}

	public ARhouse(String house_div, String house_item, String house_addr, String agency, int house_id, int area,
			int price, int floor, float item_x, float item_y, String agency_phoneNum) {
		super();
		this.house_div = house_div;
		this.house_item = house_item;
		this.house_addr = house_addr;
		this.agency = agency;
		this.house_id = house_id;
		this.area = area;
		this.price = price;
		this.floor = floor;
		this.item_x = item_x;
		this.item_y = item_y;
		this.agency_phoneNum = agency_phoneNum;
	}

	public String getHouse_div() {
		return house_div;
	}

	public void setHouse_div(String house_div) {
		this.house_div = house_div;
	}

	public String getHouse_item() {
		return house_item;
	}

	public void setHouse_item(String house_item) {
		this.house_item = house_item;
	}

	public String getHouse_addr() {
		return house_addr;
	}

	public void setHouse_addr(String house_addr) {
		this.house_addr = house_addr;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public int getHouse_id() {
		return house_id;
	}

	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public float getItem_x() {
		return item_x;
	}

	public void setItem_x(float item_x) {
		this.item_x = item_x;
	}

	public float getItem_y() {
		return item_y;
	}

	public void setItem_y(float item_y) {
		this.item_y = item_y;
	}

	public String getAgency_phoneNum() {
		return agency_phoneNum;
	}

	public void setAgency_phoneNum(String agency_phoneNum) {
		this.agency_phoneNum = agency_phoneNum;
	}	
		
}