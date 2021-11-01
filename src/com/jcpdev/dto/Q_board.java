package dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Q_board {

	private int q_idx;
	private int idx;
	private String nick;
	private String password;
	private String title;
	private String content;
	private int q_cnt;
	private Timestamp q_date;				//Date 타입은 날짜만 가져오고 시간을 못가져옵니다.
	private String ip;
	private int qc_cnt;
}
