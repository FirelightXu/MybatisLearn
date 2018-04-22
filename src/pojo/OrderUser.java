package pojo;

import java.sql.Date;

public class OrderUser{
	private Integer id;

    private Integer userId;

    private String number;

    private Date createtime;

    private String note;
	private String username;
	private String address;
	@Override
	public String toString() {
		return "OrderUser [id=" + id + ", userId=" + userId + ", number=" + number + ", createtime=" + createtime
				+ ", note=" + note + ", username=" + username + ", address=" + address + "]";
	}
}
