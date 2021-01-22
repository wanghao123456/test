package com.wh.demo.spring.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class VipUser extends User {

    private Short level;
}
