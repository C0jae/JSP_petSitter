package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
	private int idx;
	private String pet;
	private String p_name;
	private String p_gender;
	private double p_weight;
	private String p_birth;
	private String p_neu;
}
