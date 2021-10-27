package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionDto {

	private int idx;
	private String name;
//	private String password;
	private String nick;
	private String tel;
	private String m_addr;
	private String s_addr;
	private int point;
	private String p_auth;
	private int admin;
}
