package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Rate {
	private int idx;
	private double rate_total;
	private int freq;
	private double rate;
}
