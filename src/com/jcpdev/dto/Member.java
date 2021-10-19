package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private int idx;
	private String name;
	private String id;
	private String password;
	private String nick;
	private String gender;
	private String birth;
	private String tel;
	private String m_addr;
	private String s_addr;
	private int point;
	private String p_auth;
	private String license;
	private int work_date;
	private String home;
}
