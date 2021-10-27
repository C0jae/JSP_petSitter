package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class R_SessionDto {
	private int idx;
	private String id;
	private String name;
	private String nick;
	private String password;
	
}
