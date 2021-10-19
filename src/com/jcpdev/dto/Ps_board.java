package dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ps_board {
	private int psb_idx;
	private int idx;
	private String nick;
	private String title;
	private String content;
	private Date ps_sdate;
	private Date ps_fdate;
	private String p_size;
}
//스트링으로 하고  값을 가져온걸필요하념ㄴ 배열로 변환해야해요. 테이블 컬럼이랑 스트링 배열이랑 매핑할 수 없어요 