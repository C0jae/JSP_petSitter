package dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rboard {
	private int r_idx;
	private int idx;
	private String name;
	private String nick;
	private String title;
	private String content;
	private String pet;
	private int p_num;
	private String ps_nick;
	private int rate;
	private Timestamp r_date;
	private int r_cnt;
}
