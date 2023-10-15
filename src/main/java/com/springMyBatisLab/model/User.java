package com.springMyBatisLab.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class User {
    String bossId;
    String password;
    String name;
    String phoneNumber;
}
