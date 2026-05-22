package org.example.DPK16;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Mosquito {
    private String name;
    private boolean isAlive = true;
    private int position = 0;
}
